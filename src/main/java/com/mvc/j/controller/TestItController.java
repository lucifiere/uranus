package com.mvc.j.controller;

import com.mvc.j.pojo.Demo;
import com.mvc.j.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */

@Controller("javaTestItController")
class TestItController {

    @Resource(name = "javaDemoServiceImpl")
    DemoService demoService;

    private static final Logger log = LoggerFactory.getLogger(TestItController.class);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView test(int id){
        ModelAndView mv = new ModelAndView("test.jsp");
        Demo demo = demoService.getDemoById(id);
        mv.addObject("des", demo.getDes());
        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(String des){
        ModelAndView mv = new ModelAndView("test.jsp");
        Demo demo = new Demo();
        demo.setDes(des);
        demoService.insertDemo(demo);
        mv.addObject("des", "添加成功");
        return mv;
    }
}
