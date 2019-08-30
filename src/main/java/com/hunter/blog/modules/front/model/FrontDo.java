package com.hunter.blog.modules.front.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 前端默认展示页面实体类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/8/29 15:23
 */
@Component
public class FrontDo implements Serializable {
    private Integer frontId;
    private String frontKey;
    private String frontType;
    private String frontName;
    private String frontValue;
    private Integer is_deleted;

    public Integer getFrontId() {
        return frontId;
    }

    public void setFrontId(Integer frontId) {
        this.frontId = frontId;
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

    @Override
    public String toString() {
        return "FrontDo{" +
                "frontId=" + frontId +
                ", frontKey='" + frontKey + '\'' +
                ", frontType='" + frontType + '\'' +
                ", frontName='" + frontName + '\'' +
                ", frontValue='" + frontValue + '\'' +
                ", is_deleted=" + is_deleted +
                '}';
    }
}
