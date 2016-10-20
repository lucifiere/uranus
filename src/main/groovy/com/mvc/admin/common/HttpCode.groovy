package com.mvc.admin.common

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */
public enum HttpCode {

    SUCCESS(200),
    NOT_FOUND(404),
    AUTHORIZATION_FAILED(403)

    int code

    HttpCode(int code){
        this.code = code
    }

}