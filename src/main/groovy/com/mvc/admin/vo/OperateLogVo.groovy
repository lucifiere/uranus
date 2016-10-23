package com.mvc.admin.vo

import com.mvc.admin.pojo.OperateLog

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */
class OperateLogVo extends OperateLog{

    private String createTimeStr
    private String userName

    String getCreateTimeStr() {
        return createTimeStr
    }

    void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr
    }

    String getUserName() {
        return userName
    }

    void setUserName(String userName) {
        this.userName = userName
    }
}
