package com.mvc.sqlgenerator.controller;

import com.mvc.sqlgenerator.service.Analyzer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 *  Created by XD.Wang on 2016/11/2.
 */

@Controller("tmp")
public class TestController {

    @Resource
    Analyzer analyzer;

    @RequestMapping("/doit")
    public String test(){
        InputStream inputStream = TestController.class.getResourceAsStream("/table-source.sql");
        analyzer.getTable(inputStream);
        return "success";
    }

}
