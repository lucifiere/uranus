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
 *  Created by Created by XD.Wang on 2016/10/9.
 */

@Controller("javaTestItController")
class TestItController {

    @Resource(name = "javaDemoServiceImpl")
    DemoService demoService;

    private static final Logger log = LoggerFactory.getLogger(TestItController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView("test.jsp");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("data1", "data1");
        map.put("data2", "data2");
        mv.addObject(map);
        return mv;
    }
}
