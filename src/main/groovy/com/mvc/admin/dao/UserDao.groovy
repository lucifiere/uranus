package com.mvc.admin.dao

import com.mvc.admin.dao.mapper.UserMapper
import com.mvc.admin.pojo.User
import com.mvc.admin.vo.UserVo
import org.apache.ibatis.session.SqlSession
import org.springframework.stereotype.Repository

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */

@Repository
class UserDao extends DaoBase{

    public UserVo getUserById(int id){
        SqlSession session = factory.openSession()
        try {
            UserMapper userDAO = session.getMapper(UserMapper.class)
            UserVo user = userDAO.getUserById(id)
            return user
        } finally {
            session.close()
        }
    }

    public User getUserByAccount(String account){
        SqlSession session = factory.openSession()
        try {
            UserMapper userDAO = session.getMapper(UserMapper.class)
            User user = userDAO.getUserByAccount(account)
            return user
        } finally {
            session.close()
        }
    }

    public UserVo getUserByToken(String account){
        SqlSession session = factory.openSession()
        try {
            UserMapper userDAO = session.getMapper(UserMapper.class)
            UserVo user = userDAO.getUserByToken(account)
            return user
        } finally {
            session.close()
        }
    }

    public List<UserVo> getUser4Admin(){
        SqlSession session = factory.openSession()
        try {
            UserMapper userDAO = session.getMapper(UserMapper.class)
            List<UserVo> userList = userDAO.getUser4Admin()
            return userList
        } finally {
            session.close()
        }
    }



}
