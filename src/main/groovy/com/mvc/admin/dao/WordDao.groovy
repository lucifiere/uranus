package com.mvc.admin.dao

import com.mvc.admin.dao.mapper.WordMapper
import com.mvc.admin.pojo.Word
import org.apache.ibatis.session.SqlSession
import org.springframework.stereotype.Repository

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */

@Repository
class WordDao extends DaoBase{

    public Word getLeaveWord(){
        SqlSession session = factory.openSession()
        try {
            WordMapper wordMapper = session.getMapper(WordMapper.class)
            Word s = wordMapper.getLeaveWord()
            return s
        } finally {
            session.close()
        }
    }

}
