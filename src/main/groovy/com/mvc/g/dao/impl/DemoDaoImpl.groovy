package com.mvc.g.dao.impl

import com.mvc.g.dao.DaoBase
import com.mvc.g.dao.DemoDAO
import com.mvc.g.pojo.Demo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */

@Repository
class DemoDaoImpl extends DaoBase implements DemoDAO{

    private static Logger log = LoggerFactory.getLogger(DemoDaoImpl.class)

    @Override
    List getDemos() {
        def session = factory.openSession()
        List demos = session.selectOne('com.mvc.dao.Demo.getDemos')
        session.close()
        demos
    }

    @Override
    Demo getDemo(int id) {
        def session = factory.openSession()
        Demo demo = session.selectOne('com.mvc.dao.Demo.getDemo', id)
        session.close()
        demo
    }

    @Override
    void deleteDemo(int id) {
        def session = factory.openSession()
        session.delete('com.mvc.dao.Demo.deleteUser')
        session.close()
    }

    @Override
    void updateDemo(Demo demo) {
        def session = factory.openSession()
        session.update('com.mvc.dao.Demo.updateDemo', demo)
        session.close()
    }

    @Override
    void insertDemo(Demo demo) {
        def session = factory.openSession()
        session.insert('com.mvc.dao.Demo.addDemo', demo)
        session.close()
    }
}
