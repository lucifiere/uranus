package com.mvc.admin.dao

import com.mvc.admin.dao.mapper.StaticsMapper
import com.mvc.admin.pojo.Statics
import org.apache.ibatis.session.SqlSession
import org.springframework.stereotype.Repository

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */
@Repository
class StaticsDao extends DaoBase{

    public Statics getStaticsByDate(String date){
        SqlSession session = factory.openSession()
        try {
            StaticsMapper staticsMapper = session.getMapper(StaticsMapper.class)
            Statics s = staticsMapper.getStaticsByDate(date)
            return s
        } finally {
            session.close()
        }
    }

}
