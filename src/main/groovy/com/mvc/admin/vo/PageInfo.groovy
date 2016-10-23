package com.mvc.admin.vo

/**
 *  Created by Tyler.Wang on 2016/10/23.
 */
class PageInfo {

    private int pageBegin
    private int pageSize

    int getPageBegin() {
        return pageBegin
    }

    void setPageBegin(int pageBegin) {
        this.pageBegin = pageBegin
    }

    int getPageSize() {
        return pageSize
    }

    void setPageSize(int pageSize) {
        this.pageSize = pageSize
    }
}
