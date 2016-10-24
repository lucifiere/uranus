package com.mvc.admin.dao

import com.mvc.admin.dao.mapper.ArticleMapper
import com.mvc.admin.vo.ArticleVo
import com.mvc.admin.vo.PageInfo
import org.apache.ibatis.session.SqlSession
import org.springframework.stereotype.Repository

/**
 *  Created by Tyler.Wang on 2016/10/23.
 */

@Repository
class ArticleDao extends DaoBase {

    public List<ArticleVo> getArticleList4Page(PageInfo info){
        SqlSession session = factory.openSession()
        try {
            ArticleMapper mapper = session.getMapper(ArticleMapper.class)
            List<ArticleVo> ol = mapper.getArticleList4Page(info)
            return ol
        } finally {
            session.close()
        }
    }

    public int getCountOfPage(){
        SqlSession session = factory.openSession()
        try {
            ArticleMapper mapper = session.getMapper(ArticleMapper.class)
            int count = mapper.getCountOfPage()
            return count
        } finally {
            session.close()
        }
    }

}