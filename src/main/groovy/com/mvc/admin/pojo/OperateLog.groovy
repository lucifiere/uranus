package com.mvc.admin.pojo

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */
class OperateLog {

    private int id
    private String operation
    private int user
    private Date createTime

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getOperation() {
        return operation
    }

    void setOperation(String operation) {
        this.operation = operation
    }

    int getUser() {
        return user
    }

    void setUser(int user) {
        this.user = user
    }

    Date getCreateTime() {
        return createTime
    }

    void setCreateTime(Date createTime) {
        this.createTime = createTime
    }
}
