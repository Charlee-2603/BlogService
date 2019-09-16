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

    /**
     * 文章标签
     */
    private Integer frontId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getFrontId() {
        return frontId;
    }

    public void setFrontId(Integer frontId) {
        this.frontId = frontId;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "userId=" + userId +
                ", frontId=" + frontId +
                "} " + super.toString();
    }
}
