package com.mvc.admin.dao.mapper

import com.mvc.admin.pojo.Article
import com.mvc.admin.vo.ArticleVo
import com.mvc.admin.vo.PageInfo
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

/**
 *  Created by Tyler.Wang on 2016/10/23.
 */
interface ArticleMapper {

    @Select("""select a.id,a.title,u.user_name as user,c.name as categoryName from blog_article a
                left join admin_user user on a.author_id = user.id
                left join admin_user_info u on user.info = u.id
                left join blog_article_category c on a.category = c.id
                ORDER BY a.id
                limit #{pageBegin},#{pageSize}""")
    public List<ArticleVo> getArticleList4Page(PageInfo info)

    @Select("""select count(1) from blog_article""")
    public int getCountOfPage()

    @Select("""select a.title,a.digest,a.content,a.recover_url as recoverUrl,a.category,a.id,a.title,u.user_name as user,c.name as categoryName from blog_article a
                left join admin_user user on a.author_id = user.id
                left join admin_user_info u on user.info = u.id
                left join blog_article_category c on a.category = c.id
                where a.id = #{id} """)
    public ArticleVo getArticleById(int id)

    @Insert("""insert into blog_article (title, digest, content, recover_url, author_id, category) values
            (#{title},#{digest},#{content},#{recoverUrl},#{authorId},#{category})""")
    public void add(Article article)

    @Update("""update blog_article set
                title=#{title},
                digest=#{digest},
                content=#{content},
                recover_url=#{recoverUrl},
                author_id=#{authorId},
                category=#{category}
                where id = #{id}""")
    public void update(Article article)

}