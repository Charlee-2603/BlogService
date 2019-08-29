package com.hunter.blog.modules.front.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.modules.front.service.IFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * 前端页面控制类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/8/29 14:43
 */
@RequestMapping("/sys/front")
@RestController
@CrossOrigin
public class FrontController {

    @Autowired
    private IFrontService frontService;

    /**
     * 前端页面默认展示数据
     *
     * @return
     */
    @RequestMapping(value = "/setHtml", method = RequestMethod.POST)
    public String setHtml() {
        System.out.println("************setHtml*************");
        Map<String, Object> map = new HashMap<>(16);
        Map result = frontService.setHtml(map);
        return JSON.toJSONString(result);
    }
}
