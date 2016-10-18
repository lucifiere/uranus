package com.mvc.j.service.impl;

import com.mvc.j.dao.DemoDAO;
import com.mvc.j.pojo.Demo;
import com.mvc.j.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */

@Service(("javaDemoServiceImpl"))
public class DemoServiceImpl implements DemoService {

    @Resource(name = "javaDemoDaoImpl")
    DemoDAO demoDAO;

    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public Demo getDemoById(int id) {
        log.info("test it");
        return demoDAO.getDemo(id);
    }
}
