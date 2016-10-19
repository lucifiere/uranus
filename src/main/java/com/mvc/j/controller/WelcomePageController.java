package com.mvc.j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *  Created by Created by XD.Wang on 2016/10/18.
 *  欢迎页
 */
@Controller("javaWelcomePageController")
public class WelcomePageController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView welcome(){
        ModelAndView mv = new ModelAndView("index.ftl");
        mv.addObject("username", "王贤兑");
        mv.addObject("email", "lucifiere@126.com");
        return mv;
    }

}
