<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="utf-8">
        <title>登录</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="后台登录">
        <meta name="author" content="XD.Wang">
        <meta http-equiv="Cache-Control" content="max-age=7200">
        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="/static/css/login/reset.css">
        <link rel="stylesheet" href="/static/css/login/supersized.css">
        <link rel="stylesheet" href="/static/css/login/style.css">
    </head>

    <body>

        <div class="page-container">
            <h1>Login</h1>
            <form action="" method="post" id="login-form">
                <input type="text" name="account" class="username" placeholder="账号">
                <input type="password" name="cipher" class="password" placeholder="密码">
                <button type="button" onclick="check()">登录</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
                <p>联系我: lucifiere@126.com</p>
                <p></p>
            </div>
        </div>
        <div align="center"> <a href="" target="_blank" title="XD.Wang">Designed by -> XD.Wang</a></div>

        <!-- Javascript -->
        <script src="/static/js/login/jquery-1.8.2.min.js"></script>
        <script src="/static/js/login/supersized.3.2.7.min.js"></script>
        <script src="/static/js/login/supersized-init.js"></script>
        <script src="/static/js/login/scripts.js"></script>
        <script src="/static/js/login/login.js"></script>
    </body>

</html>

