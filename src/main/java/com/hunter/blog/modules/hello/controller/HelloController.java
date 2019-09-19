package com.hunter.blog.modules.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/19 11:12
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/v", method = RequestMethod.GET)
    public String success(Model model) {
        model.addAttribute("username", "SpringBoot");
        return "/index";
    }
}
