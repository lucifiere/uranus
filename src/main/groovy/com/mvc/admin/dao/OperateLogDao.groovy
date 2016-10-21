package com.mvc.admin.dao

import com.mvc.admin.dao.mapper.OperateLogMapper
import com.mvc.admin.pojo.OperateLog
import org.apache.ibatis.session.SqlSession
import org.springframework.stereotype.Repository

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */

@Repository
class OperateLogDao extends DaoBase{

    public List<OperateLog> getOperateLog4Admin(){
        SqlSession session = factory.openSession()
        try {
            OperateLogMapper operateLogMapper = session.getMapper(OperateLogMapper.class)
            List ol = operateLogMapper.getOperateLog4Admin()
            return ol
        } finally {
            session.close()
        }
    }

}
