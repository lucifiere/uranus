package com.mvc.j.dao.mapper;

import com.mvc.j.pojo.MyBatisDemo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 *  Created by Created by XD.Wang on 2016/10/19.
 */
public interface MyBatisDemoMapper {

    @Insert("insert into wd_mybatis_test (des, rank, status) values (#{des},#{rank},#{status}")
    public int addMyBatisDemo(MyBatisDemo myBatisDemo);

    @Select("select * from wd_mybatis_test where id = #{id}")
    public MyBatisDemo getMyBatisDemo(int id);

}
