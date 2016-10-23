package com.mvc.j.dao.impl;

import com.mvc.j.dao.DaoBase;
import com.mvc.j.dao.DemoDao;
import com.mvc.j.pojo.Demo;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */

@Repository("javaDemoDaoImpl")
public class DemoDaoImpl extends DaoBase implements DemoDao {

    private static Logger log = LoggerFactory.getLogger(DemoDaoImpl.class);

    public ArrayList getDemos() {
        SqlSession session = factory.openSession();
        ArrayList demos = (ArrayList) session.selectList("com.mvc.dao.Demo.getDemoList");
        session.close();
        return demos;
    }

    public Demo getDemo(int id) {
        SqlSession session = factory.openSession();
        Demo demo = session.selectOne("com.mvc.dao.Demo.getDemo", id);
        session.close();
        return demo;
    }

    public void deleteDemo(int id) {
        SqlSession session = factory.openSession();
        session.delete("com.mvc.dao.Demo.deleteUser");
        session.close();
    }

    public void updateDemo(Demo demo) {
        SqlSession session = factory.openSession();
        session.update("com.mvc.dao.Demo.updateDemo", demo);
        session.close();
    }

    public void insertDemo(Demo demo) {
        SqlSession session = factory.openSession();
        session.insert("com.mvc.dao.Demo.addDemo", demo);
        session.close();
    }
}
