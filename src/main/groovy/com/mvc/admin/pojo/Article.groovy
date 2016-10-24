package com.mvc.admin.pojo

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */
class Article {

    private int id
    private String title
    private String digest
    private String content
    private String recoverUrl
    private int authorId
    private int visitCount
    private int category
    private Date createTime

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getTitle() {
        return title
    }

    void setTitle(String title) {
        this.title = title
    }

    String getDigest() {
        return digest
    }

    void setDigest(String digest) {
        this.digest = digest
    }

    String getContent() {
        return content
    }

    void setContent(String content) {
        this.content = content
    }

    String getRecoverUrl() {
        return recoverUrl
    }

    void setRecoverUrl(String recoverUrl) {
        this.recoverUrl = recoverUrl
    }

    int getAuthorId() {
        return authorId
    }

    void setAuthorId(int authorId) {
        this.authorId = authorId
    }

    int getVisitCount() {
        return visitCount
    }

    void setVisitCount(int visitCount) {
        this.visitCount = visitCount
    }

    int getCategory() {
        return category
    }

    void setCategory(int category) {
        this.category = category
    }

    Date getCreateTime() {
        return createTime
    }

    void setCreateTime(Date createTime) {
        this.createTime = createTime
    }
}
