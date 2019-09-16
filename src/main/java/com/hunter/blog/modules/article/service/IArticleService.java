package com.hunter.blog.modules.article.service;

import com.github.pagehelper.Page;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.article.model.ArticleDto;
import com.hunter.blog.modules.front.model.FrontDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 文章service接口
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/8/30 14:21
 */
public interface IArticleService {

    /**
     * 发布文章
     *
     * @param articleDto
     * @return
     */
    DataResult addArticle(ArticleDto articleDto);

    /**
     * 文章类型
     *
     * @return
     */
    DataResult getArticleLabel();

    /**
     * 搜索文章
     *
     * @param condition
     * @return
     */
    Page<ArticleDo> getArticleByCondition(String condition);

    /**
     * 根据ID删除文章
     *
     * @param articleId
     * @return
     */
    Integer deleteArticleById(int articleId);

    /**
     * 根据key获取文章列表
     *
     * @param map
     * @param key
     * @return
     */
    List<ArticleDo> getArticleByKey(Map<String, Object> map, String key);

    /**
     * 修改文章
     *
     * @param articleDo
     * @return
     */
    Integer updateArticle(ArticleDo articleDo);
}
