package com.mvc.admin.dao

import com.mvc.admin.dao.mapper.UserMapper
import com.mvc.admin.pojo.User
import org.apache.ibatis.session.SqlSession
import org.springframework.stereotype.Repository

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */

@Repository
class UserDao extends DaoBase{



    public User getUserById(int id){
        SqlSession session = factory.openSession()
        try {
            UserMapper userDAO = session.getMapper(UserMapper.class)
            User user = userDAO.getUserById(id)
            return user
        } finally {
            session.close();
            null
        }
    }

    public User getUserByAccount(String account){
        SqlSession session = factory.openSession()
        try {
            UserMapper userDAO = session.getMapper(UserMapper.class)
            User user = userDAO.getUserByAccount(account)
            return user
        } finally {
            session.close();
            null
        }
    }

}
