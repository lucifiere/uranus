package com.mvc.admin.dao

import com.mvc.admin.dao.mapper.ArticleMapper
import com.mvc.admin.pojo.Article
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

    public ArticleVo getArticleById(int id){
        SqlSession session = factory.openSession()
        try {
            ArticleMapper mapper = session.getMapper(ArticleMapper.class)
            ArticleVo vo = mapper.getArticleById(id)
            return vo
        } finally {
            session.close()
        }
    }

    public void updateArticle(Article article){
        SqlSession session = factory.openSession()
        try {
            ArticleMapper mapper = session.getMapper(ArticleMapper.class)
            mapper.update(article)
        } finally {
            session.close()
        }
    }

    public void addArticle(Article article){
        SqlSession session = factory.openSession()
        try {
            ArticleMapper mapper = session.getMapper(ArticleMapper.class)
            mapper.add(article)
        } finally {
            session.close()
        }
    }

}
