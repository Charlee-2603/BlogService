package com.hunter.blog.modules.article.dao;

import com.github.pagehelper.Page;
import com.hunter.blog.modules.article.model.ArticleDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章dao接口
 * @author ChenLiang
 * @data: 2019/9/2 13:50
 * @version 1.0.0
 */
@Repository
@Mapper
public interface IArticleDao {

    /**
     * 查询所有文章
     *
     * @return
     */
    Page<ArticleDo> getArticles();

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
