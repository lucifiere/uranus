package com.mvc.j.service;

import com.mvc.j.pojo.Demo;

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */
public interface DemoService {

    Demo getDemoById(int id);
    void insertDemo(Demo demo);

}