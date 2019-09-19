package com.hunter.blog.modules.view.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面跳转控制类
 * @author ChenLiang
 * @data: 2019/9/19 19:13
 * @version 1.0.0
 */
@RestController
@RequestMapping("/view")
public class ViewController {

    /**
     * 跳转到登录页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView toLoginView(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
