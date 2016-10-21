package com.mvc.admin.service

import com.mvc.admin.dao.StaticsDao
import com.mvc.admin.pojo.Statics
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */

@Service
class StaticsService {

    @Resource
    StaticsDao staticsDao

    public Statics getStaticsByDate(String date){
        staticsDao.getStaticsByDate(date)
    }

}
