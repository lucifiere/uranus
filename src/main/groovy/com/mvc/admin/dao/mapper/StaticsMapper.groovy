package com.mvc.admin.dao.mapper

import com.mvc.admin.pojo.Statics
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */
interface StaticsMapper {

    @Insert('insert into admin_statics(date, visit) values(#{date}, #{visit})')
    public int add(Statics Statics)

    @Delete('delete from admin_statics where id = #{id}')
    public int deleteById(int id)

    @Update('update admin_statics set date = #{date}, visit = #{visit} where id = #{id}')
    public int update(Statics Statics)

    @Select('select * from admin_statics where id = #{id}')
    public Statics getStaticsById(int id)

    @Select('select * from admin_statics')
    public List<Statics> getAllStatics()

    @Select('select * from admin_statics where date = #{date}')
    public Statics getStaticsByDate(String date)

}
