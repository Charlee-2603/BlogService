package com.hunter.blog.modules.article.model;

import com.hunter.blog.modules.user.model.UserDo;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 文章实体类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/8/30 14:20
 */
@Component
public class ArticleDo implements Serializable {
    /**
     * 文章id
     */
    private Integer articleId;
    /**
     * 文章key
     */
    private String articleKey;
    /**
     * 文章创建时间
     */
    private String articleCreateTime;
    /**
     * 文章阅读数
     */
    private Integer articleReadNum;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章简介
     */
    private String articleDesc;
    /**
     * 文章内容
     */
    private String articleContent;
    /**
     * 文章评论
     */
    private String articleComment;

    /**
     * 文章是否删除 (0 删除 / 默认1 未删)
     */
    private Integer articleIsDeleted;

    /**
     * 文章状态 (0 未发 / 默认1 发布)
     */
    private Integer articleStatus;

    /**
     * 文章是否为推荐( 默认0 不是 / 1 是)
     */
    private Integer articleIsRecommend;

    private UserDo userDo;

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserDo getUserDo() {
        return userDo;
    }

    public void setUserDo(UserDo userDo) {
        this.userDo = userDo;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleKey() {
        return articleKey;
    }

    public void setArticleKey(String articleKey) {
        this.articleKey = articleKey;
    }

    public String getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(String articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public Integer getArticleReadNum() {
        return articleReadNum;
    }

    public void setArticleReadNum(Integer articleReadNum) {
        this.articleReadNum = articleReadNum;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleComment() {
        return articleComment;
    }

    public void setArticleComment(String articleComment) {
        this.articleComment = articleComment;
    }

    public Integer getArticleIsDeleted() {
        return articleIsDeleted;
    }

    public void setArticleIsDeleted(Integer articleIsDeleted) {
        this.articleIsDeleted = articleIsDeleted;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getArticleIsRecommend() {
        return articleIsRecommend;
    }

    public void setArticleIsRecommend(Integer articleIsRecommend) {
        this.articleIsRecommend = articleIsRecommend;
    }

    @Override
    public String toString() {
        return "ArticleDo{" +
                "articleId=" + articleId +
                ", articleKey='" + articleKey + '\'' +
                ", articleCreateTime='" + articleCreateTime + '\'' +
                ", articleReadNum=" + articleReadNum +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleDesc='" + articleDesc + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleComment='" + articleComment + '\'' +
                ", articleIsDeleted=" + articleIsDeleted +
                ", articleStatus=" + articleStatus +
                ", articleIsRecommend=" + articleIsRecommend +
                ", userDo=" + userDo +
                ", userId=" + userId +
                '}';
    }
}
