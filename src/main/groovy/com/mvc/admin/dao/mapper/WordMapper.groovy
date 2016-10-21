package com.mvc.admin.dao.mapper

import com.mvc.admin.pojo.Word
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */
interface WordMapper {

    @Insert('insert into blog_word(title, content, recover_url, author_id, category) values(#{title}, #{content}, #{recoverUrl}, #{authorId}, #{category})')
    public int add(Word Word)

    @Delete('delete from blog_word where id = #{id}')
    public int deleteById(int id)

    @Update('update blog_word set title = #{title}, content = #{content}, recover_url = #{recoverUrl}, author_id = #{authorId}, category = #{category} where id = #{id}')
    public int update(Word Word)

    @Select('select *,recover_url as recoverUrl,create_time as createTime from blog_word where id = #{id}')
    public Word getWordById(int id)

    @Select('select *,recover_url as recoverUrl,create_time as createTime from blog_word')
    public List<Word> getAllWord()

    @Select('select *,recover_url as recoverUrl,create_time as createTime from blog_word where category=1 ORDER BY create_time desc limit 1 ')
    public Word getLeaveWord()

}