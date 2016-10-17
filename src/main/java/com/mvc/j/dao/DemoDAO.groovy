package com.mvc.j.dao

import com.mvc.g.pojo.Demo

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */
interface DemoDAO {

    List getDemos()
    Demo getDemo(int id)
    void deleteDemo(int id)
    void updateDemo(Demo demo)
    void insertDemo(Demo demo)

}