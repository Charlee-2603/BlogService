package com.hunter.blog.config.page.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 分页实体类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/18 13:57
 */
@Component
public class PageDo implements Serializable {
    private Integer pageIndex;
    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageDo{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}
