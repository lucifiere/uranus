/**
 *  Created by XD.Wang on 2016/10/20.
 */

function check() {
    $.ajax({
        type:"post",
        url:"/check",
        dataType:'json',
        async:false,
        data:$('#login-form').serialize(),
        success: function(data) {
            if(data.code == 200){
                post("/admin/index", {token: data.token});
                window.opener=null;
                window.open('','_self');
                window.close();
            }else if(data.code == 403){
                alert("您输入的账号名或密码有误");
            }else{
                alert("登录失败");
            }
        },
        error : function() {
            alert("登录失败 - 400");
        }
    });
}



function post(URL, PARAMS) {
    var temp = document.createElement("form");
    temp.action = URL;
    temp.method = "post";
    temp.style.display = "none";
    for (var x in PARAMS) {
        var opt = document.createElement("textarea");
        opt.name = x;
        opt.value = PARAMS[x];
        temp.appendChild(opt);
    }
    document.body.appendChild(temp);
    temp.submit();
    return temp;
}

