package com.mvc.j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 *  Created by Created by XD.Wang on 2016/10/18.
 *  欢迎页
 */
@Controller("javaWelcomePageController")
public class WelcomePageController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView welcome(){
        ModelAndView mv = new ModelAndView("welcome");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("username", "王贤兑");
        map.put("email", "启动成功");
        mv.addObject(map);
        return mv;
    }

}
