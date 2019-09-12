package com.hunter.blog.modules.article.service.impl;

import com.github.pagehelper.Page;
import com.hunter.blog.core.data.CodeMsg;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.article.dao.IArticleDao;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.article.model.ArticleDto;
import com.hunter.blog.modules.article.service.IArticleService;
import com.hunter.blog.modules.front.dao.IFrontDao;
import com.hunter.blog.modules.front.model.FrontDo;
import com.hunter.blog.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private IFrontDao frontDao;

    /**
     * 发布文章
     *
     * @param articleDto
     * @return
     */
    @Override
    public DataResult addArticle(ArticleDto articleDto) {
        DataResult<Object> data = null;
        if (articleDto != null) {
            Integer userId = articleDto.getUserId();
            if (userId > 0) {
                articleDto.setArticleCreateTime(TimeUtil.getSystemTime(new Date()));
                int result = articleDao.addArticle(articleDto);
                if (result == 1) {
                    data = new DataResult<>(CodeMsg.SUCCESS);
                    return data;
                }
                data = new DataResult<>(CodeMsg.ERROR);
                return data;
            }
        }
        data = new DataResult<>(CodeMsg.REQUEST_PARAMETER_ERROR);
        return data;
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

    @Override
    public DataResult getArticleLabel() {
        DataResult data = null;
        List<FrontDo> res = frontDao.getFrontConfig("sortNavBar");
        if (res.size() > 0) {
            data = new DataResult(CodeMsg.SUCCESS, res);
            return data;
        }
        data = new DataResult(CodeMsg.REQUEST_PARAMETER_ERROR);
        return data;
    }

}
