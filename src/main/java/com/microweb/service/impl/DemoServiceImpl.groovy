package com.microweb.service.impl

import com.microweb.dao.DemoDAO
import com.microweb.pojo.Demo
import com.microweb.service.DemoService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */

@Service
class DemoServiceImpl implements DemoService{

    @Autowired
    DemoDAO demoDAO

    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class)

    @Override
    Demo getDemoById(int id) {
        log.info('test it')
        return demoDAO.getDemo(id)
    }
}