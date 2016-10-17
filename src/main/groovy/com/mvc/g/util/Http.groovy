package com.mvc.g.util

import org.apache.http.HttpEntity
import org.apache.http.client.ClientProtocolException
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.conn.ssl.SSLConnectionSocketFactory
import org.apache.http.conn.ssl.TrustSelfSignedStrategy
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.entity.mime.content.FileBody
import org.apache.http.entity.mime.content.StringBody
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.message.BasicNameValuePair
import org.apache.http.ssl.SSLContexts
import org.apache.http.util.EntityUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.net.ssl.SSLContext
import java.security.KeyManagementException
import java.security.KeyStore
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException
import java.text.ParseException

/**
 *  Created by Created by XD.Wang on 2016/9/5.
 */
class Http {

    private SequenceAnalysis(){}

    private static Logger log = LoggerFactory.getLogger(Http.class)

    /**
     * 发送GET请求
     * @param url GET请求的目标URL
     * @return 是否发送成功
     */
    public static boolean doGet(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault()
        HttpGet httpGet = new HttpGet(url)
        try {
            log.info('do get request with ' + url)
            CloseableHttpResponse resp = httpClient.execute(httpGet)
            try {
                HttpEntity entity = resp.getEntity()
                if (!entity) {
                    log.error("cant receive the response")
                    return false
                }
                log.info("""----------------------------------------
                            status : ${resp.getStatusLine()}
                            content length : ${entity.getContentLength()}
                            content : ${EntityUtils.toString(entity)}
                            ----------------------------------------""")
            } finally {
                resp.close()
            }
        }catch (ClientProtocolException e){
            log.error("protocol error", e)
            return false
        }catch (UnsupportedEncodingException e){
            log.error("wrong with encoding", e)
            return false
        }catch (IOException e){
            log.error("io exception occurred", e)
            return false
        }finally {
            try {
                httpClient.close()
            } catch (IOException e) {
                log.error('error occurred when io closing', e)
                return false
            }
        }
        true
    }

    /**
     * 发送POST请求
     * @param url POST请求的目标URL
     * @return 是否发送成功
     */
    public static boolean doPost(Map<String, String> params, String url){
        CloseableHttpClient httpClient = HttpClients.createDefault()
        HttpPost httpPost = new HttpPost(url)
        try{
            List paramsList = []
            for(key in params?.keySet()){
                def param = new BasicNameValuePair(key, params[key])
                paramsList << param
            }
            UrlEncodedFormEntity encoder
            encoder = new UrlEncodedFormEntity(paramsList, "UTF-8")
            httpPost.setEntity(encoder)
            log.info("do post request with " + url)
            CloseableHttpResponse resp = httpClient.execute(httpPost)
            try{
                HttpEntity entity = resp.getEntity()
                if(!entity){
                    log.error("cant receive the response")
                    return false
                }
                log.info("""----------------------------------------
                            status : ${resp.getStatusLine()}
                            content length : ${entity.getContentLength()}
                            content : ${EntityUtils.toString(entity)}
                            ----------------------------------------""")
            }finally {
                resp.close()
            }
        }catch (ClientProtocolException e){
            log.error("protocol error", e)
            return false
        }catch (UnsupportedEncodingException e){
            log.error("wrong with encoding", e)
            return false
        }catch (IOException e){
            log.error("io exception occurred", e)
            return false
        }finally {
            try {
                httpClient.close()
            } catch (IOException e) {
                log.error('error occurred when io closing', e)
                return false
            }
        }
        true
    }

    /**
     * 通过POST请求上传文件
     * @param url 目标URL
     * @param path 文件所在的路径
     * @return
     */
    public static boolean upload(String url, String path){
        if(!url || !path){
            throw new IllegalArgumentException('wrong path or url 4 upload')
        }
        CloseableHttpClient client = HttpClients.createDefault()
        try {
            HttpPost httpPost = new HttpPost(url)
            FileBody file = new FileBody(new File(path))
            StringBody comment = new StringBody('A binary file of some kind', ContentType.TEXT_PLAIN)
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart('file', file).addPart('comment', comment).build()
            httpPost.setEntity(reqEntity)
            log.info('do upload post request with ' + url)
            CloseableHttpResponse resp = client.execute(httpPost)
            try{
                HttpEntity entity = resp.getEntity()
                if(!entity){
                    log.error("cant receive the response")
                    return false
                }
                EntityUtils.consume(entity)
            }finally {
                resp.close()
            }
        }catch (ClientProtocolException e){
            log.error("protocol error", e)
            return false
        }catch (UnsupportedEncodingException e){
            log.error("wrong with encoding", e)
            return false
        }catch (IOException e){
            log.error("io exception occurred", e)
            return false
        }finally {
            try {
                client.close()
            } catch (IOException e) {
                log.error('error occurred when io closing', e)
                return false
            }
        }
        true
    }

    /**
     * 连接SSL
     * @param keyPath 秘钥位置
     * @param password 密码序列
     * @param url 请求的URL
     */
    public static void ssl(String keyPath, String password, String url){
        if(!keyPath || !password || !url){ throw new IllegalArgumentException('ssl method need key path, password and url')}
        CloseableHttpClient httpClient
        try{
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType())
            FileInputStream inputStream = new FileInputStream(new File(keyPath))
            try{
                ks.load(inputStream, password.toCharArray())
            } catch (CertificateException e){
                log.error('certificate failed', e)
            } finally {
                try{
                    inputStream.close()
                } catch (Exception e){
                    log.error('input stream close failed', e)
                }
            }
            String[] supportedProtocols = {'TLSv1'}
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(ks, new TrustSelfSignedStrategy()).build()
            SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslContext, supportedProtocols, null,
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER)
            httpClient = HttpClients.custom().setSSLSocketFactory(factory).build()

            HttpGet httpGet = new HttpGet(url)
            log.info('executing request' + httpGet.getRequestLine())
            CloseableHttpResponse response = httpClient.execute(httpGet)
            try {
                HttpEntity entity = response.getEntity()
                if (entity) {
                    log.info("""----------------------------------------
                            status : ${response.getStatusLine()}
                            content length : ${entity.getContentLength()}
                            content : ${EntityUtils.toString(entity)}
                            ----------------------------------------""")
                }
            } finally {
                response.close()
            }
        } catch (ParseException e) {
            log.error('parse failed ', e)
        } catch (IOException e) {
            log.error('io exception ', e)
        } catch (KeyManagementException e) {
            log.error('all operations dealing with key management ', e)
        } catch (NoSuchAlgorithmException e) {
            log.error('a particular cryptographic algorithm is requested but is not available', e)
        } catch (KeyStoreException e) {
            log.error('generic keyStore failed ', e)
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close()
                } catch (IOException e) {
                    log.error('io exception ', e)
                }
            }
        }
    }

}
