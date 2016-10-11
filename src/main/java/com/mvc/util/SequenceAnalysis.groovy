package com.mvc.util

/**
 *  Created by Created by XD.Wang on 2016/9/5.
 *  序列化解析工具
 */
class SequenceAnalysis {

    private SequenceAnalysis(){}

    // XML转Map
    public static Map xml2map(String str){
        if(!str)
            return null

        String tmp = str.replace('<xml>', '').replace('</xml>', '')
        Map r = [:]

        def pat = ~/<([^>]+)>(.+)<\/[^>]+>/
        def mat = tmp =~ pat

        if(mat){
            mat.each{it ->
                r[it[1]] = it[2].replace('<![CDATA[', '').replace(']]>', '')
            }
        }
        r
    }

}
