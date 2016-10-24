<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>博客列表</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="../static/css/admin/templatemo_style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="../static/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../static/css/admin/theme.css">
    <link rel="stylesheet" href="../static/lib/font-awesome/css/font-awesome.css">
    <script src="../static/lib/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="../static/lib/jqplot/jquery.jqplot.min.js"></script>
    <script src="../static/lib/bootstrap/js/bootstrap.js" type=""></script>
    <script src="../static/js/admin/blogs.js" type=""></script>
</head>

<body>
<div id="templatemo_container">

    <div id="templatemo_topsection">
        <div id="templatemo_title">I-Space Admin</div>
        <div class="templatemo_topmenu">
            博客列表
        </div>
    </div>

    <div id="templatemo_left_section">

    </div>

    <form id="list-form">
        <input value="${counts}" type="hidden" id="counts">
    </form>

    <div id="templatemo_middle_section">
        <div class="well">
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>文章标题</th>
                    <th>文章分类</th>
                    <th>文章作者</th>
                    <th style="width: 26px;"></th>
                </tr>
                </thead>
                <tbody>
                <#list articleList as item>
                <tr>
                    <td>${item.id}</td>
                    <td>${item.title}</td>
                    <td>${item.categoryName}</td>
                    <td>${item.user}</td>
                    <td>
                        <a href=""><em class="icon-pencil"></em></a>
                        <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="pagination">
            <ul>
                <li><a href="#" onclick="toPage(false)" style="float: left; border: thin">Prev</a></li>
                <li>&nbsp</li>
                <#list pageCountList as item>
                    <li><input type="button" id="page_${item}" onclick="getPageInfo(${item})" value="${item}"></li>
                </#list>
                <li>&nbsp</li>
                <li><a href="#" onclick="toPage(true)" style="float: right; border: thin">Next</a></li>
            </ul>
        </div>
    </div>
    <div id="templatemo_right_section">

    </div>
    <div id="templatemo_footer_section">
        <div class="templatemo_copyright">Copyright © XD.Wang <a title="" href="" target="_parent">回到主页</a></div>
        <div class="templatemo_contact_section">
            <p>
                <br/>
                <a href="http://validator.w3.org/check?uri=referer"><img height="31" alt="Valid XHTML 1.0 Transitional"
                                                                         src="http://www.w3.org/Icons/valid-xhtml10"
                                                                         width="88" vspace="8" border="0"/></a><a
                    href="http://jigsaw.w3.org/css-validator/check/referer"><img alt="Valid CSS!"
                                                                                 src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
                                                                                 vspace="8" border="0"/></a></p>
        </div>
    </div>

    <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">请注意</h3>
        </div>
        <div class="modal-body">
            <p class="error-text"><i class="icon-warning-sign modal-icon"></i>你确定要删除此博文吗?</p>
        </div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
            <button class="btn btn-danger" data-dismiss="modal">删除</button>
        </div>
    </div>

</div>
</body>
</html>