package com.mvc.admin.service

import com.mvc.admin.dao.WordDao
import com.mvc.admin.pojo.Word
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */
@Service
class WordService {

    @Resource
    WordDao wordDao

    public Word getLeaveWord(){
        wordDao.getLeaveWord()
    }

}
