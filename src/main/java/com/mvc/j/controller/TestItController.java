package com.mvc.j.controller;

import com.alibaba.fastjson.JSON;
import com.mvc.j.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */

@Controller
public class TestItController {

    @Autowired
    DemoService demoService;

    private static final Logger log = LoggerFactory.getLogger(TestItController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("data1", "data1");
        map.put("data2", "data2");
        return JSON.toJSONString(map);
    }

}
