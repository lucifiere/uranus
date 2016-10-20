package com.mvc.admin.vo

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */
class LoginInfo {

    String cipher
    String account

    String getCipher() {
        return cipher
    }

    void setCipher(String cipher) {
        this.cipher = cipher
    }

    String getAccount() {
        return account
    }

    void setAccount(String account) {
        this.account = account
    }
}
