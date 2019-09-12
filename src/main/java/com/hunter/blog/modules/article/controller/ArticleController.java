package com.hunter.blog.modules.article.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.hunter.blog.core.data.CodeMsg;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.article.model.ArticleDto;
import com.hunter.blog.modules.article.service.IArticleService;
import com.hunter.blog.modules.front.model.FrontDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String search(@RequestParam(value = "condition", defaultValue = "") String condition) {
        System.out.println("搜索内容: " + condition);
        Page<ArticleDo> articleList = articleService.getArticleByCondition(condition);
        DataResult<Object> data = new DataResult<>(articleList);
        return JSON.toJSONString(data);
    }

    @RequestMapping("/label")
    public String getArticleLabel() {
        System.out.println("\u001B[36m" + "getArticleLabel()方法执行了..." + "\u001B[36m");
        DataResult res = articleService.getArticleLabel();
        return JSON.toJSONString(res);
    }

    /**
     * 发布文章
     *
     * @param articleDto
     * @return
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String addArticle(@RequestBody ArticleDto articleDto) {
        DataResult res = articleService.addArticle(articleDto);
        return JSON.toJSONString(res);
    }

    /**
     * 删除文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String deleteArticle(int articleId) {
        System.out.println("\u001B[36m" + "deleteArticle()方法执行了..." + "\u001B[36m");
        DataResult<Object> data = null;
        Integer artId = articleService.deleteArticleById(articleId);
        if (artId == 1) {
            data = new DataResult(artId);
            return JSON.toJSONString(data);
        }
        data = new DataResult<>(CodeMsg.BIND_ERROR);
        return JSON.toJSONString(data);
    }

    /**
     * 修改文章
     *
     * @param articleDo
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateArticle(ArticleDo articleDo) {
        CodeMsg data = null;
        if (articleDo != null) {
            int result = articleService.updateArticle(articleDo);
            if (result == 1) {
                data = new CodeMsg("200", "更新成功!");
                return JSON.toJSONString(data);
            }
            data = new CodeMsg("0", "更新失败!");
            return JSON.toJSONString(data);
        }
        data = CodeMsg.BIND_ERROR;
        return JSON.toJSONString(data);
    }
}
