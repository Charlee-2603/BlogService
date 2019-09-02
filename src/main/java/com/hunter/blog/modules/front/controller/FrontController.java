package com.hunter.blog.modules.front.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.hunter.blog.modules.front.service.IFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String setHtml(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize) {
        System.out.println("************setHtml*************");
        System.out.println("pageSize：" + pageSize);
        System.out.println("pageIndex：" + pageIndex);

        Map<String, Object> map = new HashMap<>(16);
        map.put("pageIndex", pageIndex);
        map.put("pageSize", pageSize);
        Map result = frontService.setHtml(map);
        return JSON.toJSONString(result);
    }
}
