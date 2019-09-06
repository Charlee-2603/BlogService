package com.hunter.blog.modules.article.controller;

import com.hunter.blog.core.data.CodeMsg;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.article.dao.IArticleDao;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.article.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 文章前端控制类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/2 11:01
 */
@RestController
@RequestMapping("/sys/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    /**
     * 文章搜索
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(HttpServletRequest request) {
        System.out.println("搜索内容: " + request.getParameter("condition"));
        return "";
    }


    /**
     * 发布文章
     *
     * @param articleDo
     * @return
     */
    @RequestMapping("/post")
    public String addArticle(ArticleDo articleDo) {
        DataResult<Object> data = null;
        if (articleDo != null) {
            int result = articleService.addArticle(articleDo);
        }
        data = new DataResult<>(CodeMsg.BIND_ERROR);
        return "";
    }


    /**
     * 删除文章
     *
     * @param articleId
     * @return
     */
    public String deleteArticle(int articleId) {
        return "";
    }

    /**
     * 修改文章
     *
     * @param articleDo
     * @return
     */
    public String updateArticle(ArticleDo articleDo) {
        return "";
    }
}
