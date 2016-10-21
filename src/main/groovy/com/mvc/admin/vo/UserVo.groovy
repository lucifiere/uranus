package com.mvc.admin.vo

import com.mvc.admin.pojo.User

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */
class UserVo extends User{

    private String userName
    private String sex
    private String portraitUrl

    String getUserName() {
        return userName
    }

    void setUserName(String userName) {
        this.userName = userName
    }

    String getSex() {
        return sex
    }

    void setSex(String sex) {
        this.sex = sex
    }

    String getPortraitUrl() {
        return portraitUrl
    }

    void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl
    }
}
