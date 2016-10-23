package com.mvc.admin.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 *  Created by Tyler.Wang on 2016/10/23.
 */

@Controller
class TestController {

    @RequestMapping("/todo")
    public ModelAndView test(){
        new ModelAndView('admin-blogs.ftl')
    }

}
