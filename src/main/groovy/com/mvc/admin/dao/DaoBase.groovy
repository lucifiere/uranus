package com.mvc.admin.dao

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.annotation.PostConstruct

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */
abstract class DaoBase {

    protected static SqlSessionFactory factory
    private static Logger log = LoggerFactory.getLogger(com.mvc.j.dao.DaoBase.class)

    @PostConstruct
    public static void initial(){
        if(factory == null){
            try {
                def reader = Resources.getResourceAsReader("mybatis-config-g.xml")
                factory = new SqlSessionFactoryBuilder().build(reader)
            }catch (IOException e) {
                log.error("初始化MyBatis失败", e)
            }
        }
    }
}
