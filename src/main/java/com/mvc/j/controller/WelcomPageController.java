package com.mvc.j.controller;

import com.mvc.j.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 *  Created by Created by XD.Wang on 2016/10/18.
 *  欢迎页
 */
@Controller
public class WelcomPageController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView("../html/index");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", "王贤兑");
        map.put("remark", "启动成功");
        mv.addObject(map);
        return mv;
    }

}
