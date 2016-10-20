package com.mvc.admin.dao.mapper

import com.mvc.admin.pojo.UserInfo
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */
interface UserInfoMapper {

    @Insert("insert into admin_user_info (user_name, sex, portrait_url) values(#{userName}, #{sex}, #{portraitUrl})")
    public int add(UserInfo user)

    @Delete("delete from admin_user_info where id = #{id}")
    public int deleteById(int id)

    @Update("update admin_user_info set user_name = #{userName}, sex = #{sex}, portrait_url = #{portraitUrl} where id = #{id}")
    public int update(UserInfo user)

    @Select("select * from admin_user_info where id = #{id}")
    public UserInfo getUserInfoById(int id)

    @Select("select * from admin_user_info")
    public List getAllUserInfo()

}