package com.mvc.admin.service

import com.mvc.admin.dao.OperateLogDao
import com.mvc.admin.pojo.OperateLog
import com.mvc.admin.util.DateUtil
import com.mvc.admin.vo.OperateLogVo
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */

@Service
class OperateLogService {

    @Resource
    OperateLogDao operateLogDao
    @Resource
    UserService userService

    public List<OperateLogVo> getOperateLog4Admin(){
        List<OperateLogVo> voList = []
        for(one in operateLogDao.getOperateLog4Admin()){
            OperateLogVo vo = new OperateLogVo()
            vo.setOperation(one.getOperation())
            vo.setUserName(userService.getUserById(one.getUser()).getUserName())
            vo.setCreateTimeStr(one.getCreateTime().format(DateUtil.CHINESE_SIMPLE_PAT))
            voList << vo
        }
        voList
    }

    public void addOperateLog(OperateLog log){
        operateLogDao.addOperateLog(log)
    }


}
