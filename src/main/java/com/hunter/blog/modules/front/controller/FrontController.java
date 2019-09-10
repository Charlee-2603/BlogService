package com.hunter.blog.modules.front.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.front.service.IFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String setHtml(@RequestParam(defaultValue = "1") Integer pageIndex,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          @RequestParam(defaultValue = "2") Integer frontId,
                          @RequestParam(defaultValue = "13") Integer sortNavId,
                          HttpServletRequest  request) {
        System.out.println("bbbb,:" + request.getSession().getId());
        Map<String, Object> map = new HashMap<>(16);
        map.put("pageIndex", pageIndex);
        map.put("pageSize", pageSize);
        map.put("frontId", frontId);
        map.put("sortNavId", sortNavId);
        Map result = frontService.setHtml(map);
        DataResult<Map> data = new DataResult<>(result);
        return JSON.toJSONString(data);
    }
}
