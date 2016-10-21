package com.mvc.admin.dao.mapper

import com.mvc.admin.pojo.User
import com.mvc.admin.vo.UserVo
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */
interface UserMapper {

    @Insert('insert into admin_user(account, cipher, info, token) values(#{account}, #{cipher}, #{info}, #{token})')
    public int add(User user)

    @Delete('delete from admin_user where id = #{id}')
    public int deleteById(int id)

    @Update('update admin_user set account = #{account}, cipher = #{cipher}, info = #{info}, token = #{token} where id = #{id}')
    public int update(User user)

    @Select('''select
                    au.*,
                    au.create_time as createTime,
                    aui.user_name as userName,
                    aui.sex,
                    aui.portrait_url as portraitUrl
               from admin_user au
               left join admin_user_info aui on au.info = aui.id
               where au.id = #{id}
            ''')
    public UserVo getUserById(int id)

    @Select('select * from admin_user')
    public List getAllUser()

    @Select('''select
                    au.*,
                    au.create_time as createTime,
                    aui.user_name as userName,
                    aui.sex,
                    aui.portrait_url as portraitUrl
               from admin_user au
               left join admin_user_info aui on au.info = aui.id
               where au.token = #{token} ''')
    public UserVo getUserByToken(String token)

    @Select('select * from admin_user where account = #{account}')
    public User getUserByAccount(String account)

    @Select('''select
                    au.*,
                    au.create_time as createTime,
                    aui.user_name as userName,
                    aui.sex,
                    aui.portrait_url as portraitUrl
               from admin_user au
               left join admin_user_info aui on au.info = aui.id
               order by au.create_time desc limit 6''')
    public List<UserVo> getUser4Admin()

}