package com.mvc.admin.service

import com.mvc.admin.dao.UserDao
import com.mvc.admin.pojo.User
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */

@Service
class UserService {

    @Resource(name = 'userDao')
    UserDao userDao

    public User getUserById(int id){
        userDao.getUserById(id)
    }

    public User getUserByAccount(String account){
        userDao.getUserByAccount(account)
    }

}
