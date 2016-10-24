package com.mvc.admin.vo

import com.mvc.admin.pojo.Article

/**
 *  Created by Tyler.Wang on 2016/10/23.
 */
class ArticleVo extends Article{

    private String categoryName
    private String user

    String getCategoryName() {
        return categoryName
    }

    void setCategoryName(String categoryName) {
        this.categoryName = categoryName
    }

    String getUser() {
        return user
    }

    void setUser(String user) {
        this.user = user
    }
}
