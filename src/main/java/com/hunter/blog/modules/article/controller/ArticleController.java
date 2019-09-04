package com.hunter.blog.modules.article.controller;

import org.springframework.http.HttpRequest;
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

    /**
     * 文章搜索
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(HttpServletRequest request) {
        System.out.println("\033[36;4m" + "search()方法执行了..." + "\033[0m");
        System.out.println("搜索内容: " + request.getParameter("condition"));
        return "";
    }
}
