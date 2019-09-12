package com.hunter.blog.modules.article.model;


import java.io.Serializable;

/**
 * 文章扩展类
 * @author ChenLiang
 * @data: 2019/9/12 14:14
 * @version 1.0.0
 */
public class ArticleDto extends ArticleDo implements Serializable {

    /**
     * 用户ID
     */
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
