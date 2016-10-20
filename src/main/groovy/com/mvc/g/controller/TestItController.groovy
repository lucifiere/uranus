package com.mvc.g.controller

import com.mvc.g.service.DemoService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */

@Controller
class TestItController {

    @Autowired
    DemoService demoService

    private static final Logger log = LoggerFactory.getLogger(TestItController.class)

    @RequestMapping(value = '/test', method = RequestMethod.GET)
    public ModelAndView test(){
        new ModelAndView('login.ftl')
    }

}
