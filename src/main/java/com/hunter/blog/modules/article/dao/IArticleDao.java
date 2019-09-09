package com.hunter.blog.modules.article.dao;

import com.github.pagehelper.Page;
import com.hunter.blog.modules.article.model.ArticleDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章dao接口
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/2 13:50
 */
@Repository
@Mapper
public interface IArticleDao {

    /**
     * 根据子栏目查找文章
     * @param sortNavId
     * @return
     */
    Page<ArticleDo> getArticles(@Param("sortNavId") Integer sortNavId);

    /**
     * 发布文章
     *
     * @param articleDo
     * @param userId
     * @return
     */
    Integer addArticle(@Param("articleDo") ArticleDo articleDo, @Param("userId") int userId);

    /**
     * 搜索文章
     *
     * @param condition
     * @return
     */
    Page<ArticleDo> getArticleByCondition(@Param("condition") String condition);

    /**
     * 根据ID删除文章
     *
     * @param articleId
     * @return
     */
    Integer deleteArticleById(@Param("articleId") int articleId);

    /**
     * 修改文章
     *
     * @param articleDo
     * @return
     */
    Integer updateArticle(@Param("articleDo") ArticleDo articleDo);

    /**
     * 根据key获取文章列表
     *
     * @param articleKey
     * @return
     */
    List<ArticleDo> getArticleByKey(@Param("articleKey") String articleKey);

    /**
     * 根据文章获取文章详细信息
     *
     * @param articleId
     * @return
     */
    ArticleDo getArticleByArtcleId(@Param("articleId") Integer articleId);


}
