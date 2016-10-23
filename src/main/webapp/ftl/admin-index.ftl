<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>管理后台</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="个人空间管理后台">
    <meta name="author" content="XD.Wang">

    <link rel="stylesheet" type="text/css" href="../static/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../static/css/admin/theme.css">
    <link rel="stylesheet" href="../static/lib/font-awesome/css/font-awesome.css">

    <script src="../static/lib/jquery-1.8.1.min.js" type="text/javascript"></script>
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 1em auto 0;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>
  </head>

  <body>
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid">
                <ul class="nav pull-right">
                    <li id="fat-menu" class="dropdown">
                        <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> ${userInfo.userName}
                            <i class="icon-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">个人设置</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" href="../html/sign-in.html">退出登录</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="admin-index.ftl"><span class="first">I-Space</span> <span class="second">&nbsp&nbsp管理后台</span></a>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span3">
                <div class="sidebar-nav">
                  <div class="nav-header" data-toggle="collapse" data-target="#dashboard-menu"><i class="icon-dashboard"></i>管理</div>
                    <ul id="dashboard-menu" class="nav nav-list collapse in">
                        <li><a href="admin-index.ftl">主页</a></li>
                        <li ><a href="../html/users.html">博客</a></li>
                        <li ><a href="../html/user.html">图库</a></li>
                        <li ><a href="../html/gallery.html">心情</a></li>
                        <li ><a href="../html/calendar.html">评论</a></li>
                        <li ><a href="faq.ftl">指南</a></li>
                        <li ><a href="../html/help.html">帮助</a></li>
                    </ul>
                <div class="nav-header" data-toggle="collapse" data-target="#accounts-menu"><i class="icon-briefcase"></i>账户<span class="label label-info">+10</span></div>
                <ul id="accounts-menu" class="nav nav-list collapse in">
                  <li ><a href="../html/sign-in.html">登录</a></li>
                  <li ><a href="../html/sign-up.html">注册</a></li>
                  <li ><a href="../html/reset-password.html">找回密码</a></li>
                </ul>

                <div class="nav-header" data-toggle="collapse" data-target="#settings-menu"><i class="icon-exclamation-sign"></i>应用</div>
                <ul id="settings-menu" class="nav nav-list collapse in">
                    <li ><a href="">待定</a></li>
                </ul>

                <div class="nav-header" data-toggle="collapse" data-target="#legal-menu"><i class="icon-legal"></i>待定</div>
                <ul id="legal-menu" class="nav nav-list collapse in">
                  <li ><a href="../html/privacy-policy.html">待定1</a></li>
                  <li ><a href="../html/terms-and-conditions.html">待定2</a></li>
                </ul>
            </div>
        </div>
    <div class="span9">
<script type="text/javascript" src="../static/lib/jqplot/jquery.jqplot.min.js"></script>

<div class="stats">
    <p class="stat"><span class="number">${statics.visit}</span>访问</p>
    <p class="stat"><span class="number">511</span>评论</p>
    <p class="stat"><span class="number">32</span>博客</p>
</div>

<h1 class="page-title">I-Space - Overview</h1>

<div class="row-fluid">
    <div class="block">
        <p class="block-heading" data-toggle="collapse" data-target="#chart-container">${userInfo.userName}，欢迎使用管理后台</p>
        <div id="chart-container" class="block-body collapse in">
            <div id="line-chart"></div>
        </div>
    </div>
</div>

<div class="row-fluid">
    <div class="block span6">
        <div class="block-heading" data-toggle="collapse" data-target="#tablewidget">用户</div>
        <div id="tablewidget" class="block-body collapse in">
            <table class="table">
              <thead>
                <tr>
                  <th>姓名</th>
                  <th>性别</th>
                  <th>Email</th>
                </tr>
              </thead>
              <tbody>
              <#list userList as item>
              <tr>
                  <td>${item.userName}</td>
                  <td>${item.sex}</td>
                  <td>lucifiere@126.com</td>
              </tr>
              </#list>
              </tbody>
            </table>
            <p><a href="../html/users.html">More...</a></p>
        </div>
    </div>
    <div class="block span6">
        <div class="block-heading" data-toggle="collapse" data-target="#widget1container">留言板 </div>
        <div id="widget1container" class="block-body collapse in">
            <h2> ${word.title} </h2>
            ${word.content}
            <br>
            <br>
            <br>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="block span6">
        <div class="block-heading" data-toggle="collapse" data-target="#widget2container">操作记录<span class="label label-warning">+10</span></div>
        <div id="widget2container" class="block-body collapse in">
            <table class="table">
              <tbody>
              <#list logList as item>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> ${item.userName}</p>
                      </td>
                      <td>
                          <p>${item.operation}</p>
                      </td>
                      <td>
                          <p>${item.createTimeStr}</p>
                          <a href="#">查看详细</a>
                      </td>
                  </tr>
              </#list>
              </tbody>
            </table>
        <#--</div>-->
    </div>
    <div class="block span6">
        <p class="block-heading">待定</p>
        <div class="block-body">
            <h2>FreeMarker怎么用</h2>
            <p>FreeMarker是一款模板引擎： 即一种基于模板和要改变的数据，用来生成输出文本（HTML网页、电子邮件、配置文件、源代码等）的通用工具。	它不是面向最终用户的，而是一个Java类库，是一款程序员可以嵌入他们所开发产品的组件。
                FreeMarker是免费的，基于Apache许可证2.0版本发布。其模板编写为FreeMarker Template Language（FTL），属于简单、专用的语言。需要准备数据在真实编程语言中来显示，比如数据库查询和业务运算，	之后模板显示已经准备好的数据。在模板中，主要用于如何展现数据，	而在模板之外注意于要展示什么数据。</p>
            <p><a class="btn btn-primary btn-large">按钮功能待定 &raquo;</a></p>
        </div>
    </div>
</div>

        </div>
    </div>

    <footer>
        <hr>
        <p class="pull-right">Designed By <a href="/welcome" title="" target="_blank"></a>XD.Wang</p>
        <p>&copy; 2016 <a href="#">XD.Wang</a></p>
    </footer>
    <script src="../static/lib/bootstrap/js/bootstrap.js"></script>
  </body>
</html>