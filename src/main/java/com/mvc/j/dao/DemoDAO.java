package com.mvc.j.dao;

import com.mvc.j.pojo.Demo;
import java.util.ArrayList;

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */
public interface DemoDAO {

    ArrayList getDemos();
    Demo getDemo(int id);
    void deleteDemo(int id);
    void updateDemo(Demo demo);
    void insertDemo(Demo demo);

}