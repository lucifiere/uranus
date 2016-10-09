package com.microweb.dao.impl

import com.microweb.dao.BaseDAO
import com.microweb.dao.DemoDAO
import com.microweb.pojo.Demo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */

@Repository
class DemoDAOImpl extends BaseDAO implements DemoDAO{

    private static Logger log = LoggerFactory.getLogger(DemoDAOImpl.class)

    @Override
    List getDemos() {
        def session = factory.openSession()
        List demos = session.selectOne('com.microweb.dao.Demo.getDemos')
        session.close()
        demos
    }

    @Override
    Demo getDemo(int id) {
        def session = factory.openSession()
        Demo demo = session.selectOne('com.microweb.dao.Demo.getDemo', id)
        session.close()
        demo
    }

    @Override
    void deleteDemo(int id) {
        def session = factory.openSession()
        session.delete('com.microweb.dao.Demo.deleteUser')
        session.close()
    }

    @Override
    void updateDemo(Demo demo) {
        def session = factory.openSession()
        session.update('com.microweb.dao.Demo.updateDemo', demo)
        session.close()
    }

    @Override
    void insertDemo(Demo demo) {
        def session = factory.openSession()
        session.insert('com.microweb.dao.Demo.addDemo', demo)
        session.close()
    }
}
