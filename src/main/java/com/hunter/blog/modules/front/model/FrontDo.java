package com.hunter.blog.modules.front.model;

import com.hunter.blog.modules.article.model.ArticleDo;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 前端默认展示页面实体类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/8/29 15:23
 */
@Component
public class FrontDo implements Serializable {
    /**
     * 父栏目id
     */
    private Integer frontId;
    /**
     *  子栏目id
     */
    private Integer fatherId;
    /**
     * 分类key
     */
    private String frontKey;
    /**
     * 栏目类型
     */
    private String frontType;
    /**
     * 栏目名称
     */
    private String frontName;
    /**
     * 栏目链接
     */
    private String frontValue;
    /**
     * 栏目是否删除
     */
    private Integer is_deleted;
    /**
     * 文章对象（多对多）
     * @return
     */
    private List<ArticleDo> articleDos;

    public Integer getFrontId() {
        return frontId;
    }

    public void setFrontId(Integer frontId) {
        this.frontId = frontId;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public String getFrontKey() {
        return frontKey;
    }

    public void setFrontKey(String frontKey) {
        this.frontKey = frontKey;
    }

    public String getFrontType() {
        return frontType;
    }

    public void setFrontType(String frontType) {
        this.frontType = frontType;
    }

    public String getFrontName() {
        return frontName;
    }

    public void setFrontName(String frontName) {
        this.frontName = frontName;
    }

    public String getFrontValue() {
        return frontValue;
    }

    public void setFrontValue(String frontValue) {
        this.frontValue = frontValue;
    }

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    public List<ArticleDo> getArticleDos() {
        return articleDos;
    }

    public void setArticleDos(List<ArticleDo> articleDos) {
        this.articleDos = articleDos;
    }

    @Override
    public String toString() {
        return "FrontDo{" +
                "frontId=" + frontId +
                ", fatherId=" + fatherId +
                ", frontKey='" + frontKey + '\'' +
                ", frontType='" + frontType + '\'' +
                ", frontName='" + frontName + '\'' +
                ", frontValue='" + frontValue + '\'' +
                ", is_deleted=" + is_deleted +
                ", articleDos=" + articleDos +
                '}';
    }
}
