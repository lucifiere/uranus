package com.mvc.admin.pojo

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */
class User {

    private int id
    private String account
    private String cipher
    private int info

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getAccount() {
        return account
    }

    void setAccount(String account) {
        this.account = account
    }

    String getCipher() {
        return cipher
    }

    void setCipher(String cipher) {
        this.cipher = cipher
    }

    int getInfo() {
        return info
    }

    void setInfo(int info) {
        this.info = info
    }
}
