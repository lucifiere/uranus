package com.mvc.admin.pojo

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */
class Article {

    private int id
    private String title
    private String digest
    private String content
    private String recover_url
    private int author_id
    private int visit_count
    private int category
    private Date create_time

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

    String getRecover_url() {
        return recover_url
    }

    void setRecover_url(String recover_url) {
        this.recover_url = recover_url
    }

    int getAuthor_id() {
        return author_id
    }

    void setAuthor_id(int author_id) {
        this.author_id = author_id
    }

    int getVisit_count() {
        return visit_count
    }

    void setVisit_count(int visit_count) {
        this.visit_count = visit_count
    }

    int getCategory() {
        return category
    }

    void setCategory(int category) {
        this.category = category
    }

    Date getCreate_time() {
        return create_time
    }

    void setCreate_time(Date create_time) {
        this.create_time = create_time
    }
}
