package com.mvc.g.controller

import com.alibaba.fastjson.JSON
import com.mvc.g.service.DemoService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */

@Controller
class TestItController {

    @Autowired
    DemoService demoService

    private static final Logger log = LoggerFactory.getLogger(TestItController.class)

    @RequestMapping(value = '/test', method = RequestMethod.GET)
    public String test(){
        Map map = [:]
        map.data1 = 'data1'
        map.data2 = 'data2'
        JSON.toJSONString(map)
    }

}
