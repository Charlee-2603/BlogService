package com.hunter.blog.modules.article.dao;

import com.hunter.blog.modules.article.model.ArticleDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

    /**
     * 根据key获取文章列表
     *
     * @param articleKey
     * @return
     */
    List<ArticleDo> getArticleByKey(@Param("articleKey") String articleKey);

    /**
     * 根据文章获取文章详细信息
     * @param articleId
     * @return
     */
    ArticleDo getArticleByArtcleId(@Param("articleId") Integer articleId);
}
