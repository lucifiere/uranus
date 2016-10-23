/**
 * Created by Tyler.Wang on 2016/10/23.
 */

function getPageInfo(id) {
    var info = {};
    info.pageBegin = id * 10;
    info.pageEnd = id * 10 + 10;
    getArticleList(info)
}


function getArticleList(info) {
    $.ajax({
        type: "post",
        url: "/getArticleList",
        dataType: 'json',
        async: false,
        data:info.serialize(),
        success: function(data) {
            if(data.code == 200){
                window.opener = null;
                window.open('','_self');
                window.close();
            }
            else{
                alert("未知错误");
            }
        },
        error : function() {
            alert("未知错误 - 500");
        }
    });
}