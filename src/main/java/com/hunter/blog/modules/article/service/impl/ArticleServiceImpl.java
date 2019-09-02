package com.hunter.blog.modules.article.service.impl;

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

//    @Autowired
//    private IArticleDao articleDao;


    @Override
    public List<ArticleDo> getArticleByKey(Map<String, Object> map, String key) {
        return null;
    }



}
