package com.mvc.sqlgenerator.controller;

import com.alibaba.fastjson.JSON;
import com.mvc.sqlgenerator.service.Analyzer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 *  Created by XD.Wang on 2016/11/3.
 */

@Controller
@RequestMapping("/tool")
public class GeneralController {

    @Resource
    Analyzer analyzer;

    private static LinkedHashMap<String, HashSet> tableInfo;

    @PostConstruct
    void init(){
        InputStream inputStream = TestController.class.getResourceAsStream("/table-source.sql");
        tableInfo = analyzer.getTable(inputStream);
    }

    @RequestMapping("/page")
    public ModelAndView homePage(){
        HashSet<String> tables = new HashSet<String>();
        for (String one : tableInfo.keySet()){
            tables.add(one);
        }
        ModelAndView mv = new ModelAndView("sql-generator.jsp");
        mv.addObject("tableName", tables);
        return mv;
    }

    @RequestMapping("/getCol")
    @ResponseBody
    public String getCol(String table){
        HashSet cols = tableInfo.get(table);
        String a = JSON.toJSONString(cols);
        return JSON.toJSONString(cols);
    }

}
