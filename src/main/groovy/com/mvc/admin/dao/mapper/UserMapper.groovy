package com.mvc.admin.dao.mapper

import com.mvc.admin.pojo.User
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */
interface UserMapper {

    @Insert("insert into admin_user(account, cipher, info) values(#{account}, #{cipher}, #{info})")
    public int add(User user)

    @Delete("delete from admin_user where id = #{id}")
    public int deleteById(int id)

    @Update("update admin_user set account = #{account}, cipher = #{cipher}, info = #{info} where id = #{id}")
    public int update(User user)

    @Select("select * from admin_user where id = #{id}")
    public User getUserById(int id)

    @Select("select * from admin_user")
    public List getAllUser()

    @Select("select * from admin_user where account = #{account}")
    public User getUserByAccount(String account)

}