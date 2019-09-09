package com.hunter.blog.modules.article.service.impl;

import com.github.pagehelper.Page;
import com.hunter.blog.modules.article.dao.IArticleDao;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.article.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 文章service接口实现类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/2 10:53
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleDao articleDao;

    /**
     * 发布文章
     *
     * @param articleDo
     * @param userId
     * @return
     */
    @Override
    public int addArticle(ArticleDo articleDo, int userId) {
        int result = articleDao.addArticle(articleDo, userId);
        return result;
    }

    /**
     * 搜索文章
     *
     * @param condition
     * @return
     */
    @Override
    public Page<ArticleDo> getArticleByCondition(String condition) {
        return articleDao.getArticleByCondition(condition);
    }

    /**
     * 删除文章
     *
     * @param articleId
     * @return
     */
    @Override
    public Integer deleteArticleById(int articleId) {
        return articleDao.deleteArticleById(articleId);
    }

    @Override
    public List<ArticleDo> getArticleByKey(Map<String, Object> map, String key) {
        return null;
    }

    /**
     * 修改文章
     *
     * @param articleDo
     * @return
     */
    @Override
    public Integer updateArticle(ArticleDo articleDo) {
        return articleDao.updateArticle(articleDo);
    }

}
