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
                window.location.href = data.url;
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