package com.hunter.blog.modules.article.service;

import com.hunter.blog.modules.article.model.ArticleDo;

import java.util.List;
import java.util.Map;

/**
 * 文章service接口
 * @author ChenLiang
 * @data: 2019/8/30 14:21
 * @version 1.0.0
 */
public interface IArticleService {


    /**
     * 根据key获取文章列表
     * @param map
     * @param key
     * @return
     */
    List<ArticleDo> getArticleByKey(Map<String, Object> map, String key);

    /**
     * 发布文章
     * @param articleDo
     * @return
     */
    int addArticle(ArticleDo articleDo);
}
