package com.mvc.admin.common

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */
class ResponseMsg {

    private int code
    private String des
    private Object data

    int getCode() {
        return code
    }

    void setCode(int code) {
        this.code = code
    }

    String getDes() {
        return des
    }

    void setDes(String des) {
        this.des = des
    }

    Object getData() {
        return data
    }

    void setData(Object data) {
        this.data = data
    }
}
