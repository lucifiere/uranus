package com.mvc.admin.dao.mapper

import com.mvc.admin.vo.ArticleVo
import com.mvc.admin.vo.PageInfo
import org.apache.ibatis.annotations.Select

/**
 *  Created by Tyler.Wang on 2016/10/23.
 */
interface ArticleMapper {

    @Select("""select a.id,a.title,u.user_name as userName,c.name as categoryName from blog_article a
                left join admin_user user on a.author_id = user.id
                left join admin_user_info u on user.info = u.id
                left join blog_article_category c on a.category = c.id
                limit #{pageBegin},#{pageSize}""")
    public List<ArticleVo> getArticleList4Page(PageInfo info)

    @Select("""select count(1) from blog_article""")
    public int getCountOfPage()

}