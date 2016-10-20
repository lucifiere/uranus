package com.mvc.admin.pojo

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */
class UserInfo {

    private int id
    private String userName
    private short sex
    private String portraitUrl

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getUserName() {
        return userName
    }

    void setUserName(String userName) {
        this.userName = userName
    }

    short getSex() {
        return sex
    }

    void setSex(short sex) {
        this.sex = sex
    }

    String getPortraitUrl() {
        return portraitUrl
    }

    void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl
    }
}
