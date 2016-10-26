package com.mvc.admin.service

import com.mvc.admin.dao.ArticleDao
import com.mvc.admin.pojo.Article
import com.mvc.admin.vo.ArticleVo
import com.mvc.admin.vo.PageInfo
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 *  Created by Tyler.Wang on 2016/10/23.
 */

@Service
class ArticleService {

    @Resource
    ArticleDao articleDao

    public List<ArticleVo> getArticleList4Page(PageInfo info){
        info.setPageBegin((info.getPageBegin() - 1) * 10)
        articleDao.getArticleList4Page(info)
    }

    public int getCountOfPage(){
        int all = articleDao.getCountOfPage()
        Math.floor(all / 10)
    }

    public ArticleVo getArticleById(int id){
        articleDao.getArticleById(id)
    }

    public void updateArticle(Article article){
        articleDao.updateArticle(article)
    }

    public void addArticle(Article article){
        articleDao.addArticle(article)
    }

}
