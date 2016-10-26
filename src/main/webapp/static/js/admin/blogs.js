/**
 *  Created by Tyler.Wang on 2016/10/23.
 */

function getPageInfo(begin) {
    window.location.href = "/admin/blogs?pageBegin=" + begin + "&pageSize=" + 10;
}

function toPage(isNext) {
    var pageSize = 10;
    var search = window.location.search;
    var begin = parseInt(search.substring(search.indexOf("n=") + 2, search.indexOf("&pageSize")));
    var counts = $('#counts').val();
    if(begin == counts && isNext)
        return;
    if(begin == 1 && !isNext)
        return;

    var pageBegin = (isNext ? begin + 1 : begin - 1);
    
    window.location.href = "/admin/blogs?pageBegin=" + pageBegin + "&pageSize=" + pageSize;
}

function setContent() {
    var content = $('#content').val();
    UE.getEditor('editor').setContent(content);
}