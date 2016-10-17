package com.mvc.j.dao

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

import javax.annotation.PostConstruct

/**
 *  Created by Created by XD.Wang on 2016/10/9.
 */

@Repository
public class DaoBase {

    protected static SqlSessionFactory factory
    private static Logger log = LoggerFactory.getLogger(DaoBase.class)

    @PostConstruct
    public static void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml")
            factory = new SqlSessionFactoryBuilder().build(reader)
        } catch (IOException e) {
            log.error("初始化MyBatis失败", e)
        }
    }

}
