package com.mvc.admin.dao.mapper

import com.mvc.admin.pojo.OperateLog
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */
interface OperateLogMapper {

    @Insert('insert into admin_operate_log(operation, user) values(#{operation}, #{user})')
    public int add(OperateLog OperateLog)

    @Delete('delete from admin_operate_log where id = #{id}')
    public int deleteById(int id)

    @Update('update admin_operate_log set operation = #{operation}, user = #{user} where id = #{id}')
    public int update(OperateLog OperateLog)

    @Select('select id, operation, user, create_time as createTime from admin_operate_log where id = #{id}')
    public OperateLog getOperateLogById(int id)

    @Select('select id, operation, user, create_time as createTime from admin_operate_log')
    public List<OperateLog> getAllOperateLog()

    @Select('select id, operation, user, create_time as createTime from admin_operate_log order by create_time desc limit 6')
    public List<OperateLog> getOperateLog4Admin()

}
