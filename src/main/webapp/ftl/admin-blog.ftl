<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新建博文</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <link href="../static/css/admin/templatemo_style.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="../static/ue/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../static/ue/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="../static/ue/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" charset="utf-8" src="../static/js/admin/blogs.js"></script>
    <script type="text/javascript" charset="utf-8" src="../static/js/login/jquery-1.8.2.min.js"></script>
    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>

<body onload="setContent()">
    <div id="templatemo_container">

        <div id="templatemo_topsection">
            <div id="templatemo_title">I-Space Admin</div>
            <div class="templatemo_topmenu">
                Create your article here:
            </div>
        </div>

        <div id="templatemo_left_section">

        </div>

        <div id="templatemo_middle_section">
            <form action="/blog/edit" id="article">
                <div class="article_select">
                    <label>标题:&nbsp&nbsp&nbsp
                        <input type="text" id="title" name="title" value="<#if blog.title??>${blog.title}<#else></#if>">
                        <br/>
                    </label>
                    <label>摘要:&nbsp&nbsp&nbsp
                        <input type="text" id="digest" name="digest" value="<#if blog.digest??>${blog.digest}<#else></#if>">
                        <br/>
                    </label>
                    <label>图片:&nbsp&nbsp&nbsp
                        <input type="text" id="title" name="recoverUrl" value="<#if blog.recoverUrl??>${blog.recoverUrl}<#else></#if>">
                        <br/>
                    </label>
                    <label>类别:&nbsp&nbsp&nbsp
                        <select id="category" name="category">
                            <option value="1">心情随笔</option>
                            <option value="2">技术博客</option>
                            <option value="3">网上文摘</option>
                        </select>
                        <br/>
                    </label>
                    <input type="submit" id="submit">
                    <br/>
                    <input type="hidden" id="author" name="author" value="1">
                    <input type="hidden" id="content" name="content" value="<#if blog.content??>${blog.content}<#else></#if>">
                </div>
            </form>

            <script id="editor" type="text/plain" style="width:100%;height:800px;"></script>
        </div>

        <div id="templatemo_right_section">

        </div>

        <div id="templatemo_footer_section">

            <div class="templatemo_copyright">Copyright © XD.Wang <a title="" href="" target="_parent">回到主页</a></div>

            <div class="templatemo_contact_section">

                <p>
                    <br/>
                    <a href="http://validator.w3.org/check?uri=referer"><img height="31" alt="Valid XHTML 1.0 Transitional" src="../static/images/admin/valid-xhtml10.png" width="88" vspace="8" border="0" /></a><a href="http://jigsaw.w3.org/css-validator/check/referer"><img alt="Valid CSS!" src="../static/images/admin/vcss-blue.gif" vspace="8" border="0" /></a></p>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        UE.getEditor('editor');
    </script>
</body>
</html>