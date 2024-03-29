package com.hunter.blog.modules.front.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.core.data.DataResult;
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
@RequestMapping("/api/front")
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
                          @RequestParam(defaultValue = "10") Integer sortNavId) {
        Map<String, Object> map = new HashMap<>(16);
        System.out.println("pageIndex= " + pageIndex);
        System.out.println("pageSize= " + pageSize);
        map.put("pageIndex", pageIndex);
        map.put("pageSize", pageSize);
        map.put("frontId", frontId);
        map.put("sortNavId", sortNavId);
        Map result = frontService.setHtml(map);
        DataResult<Map> data = new DataResult<>(result);
        return JSON.toJSONString(data);
    }


    @RequestMapping(value = "/myCenter", method = RequestMethod.POST)
    public String setMyData() {
        System.out.println("\u001B[36m" + "setMyData()方法执行了..." + "\u001B[36m");
        DataResult res = frontService.getNavBar();
        return JSON.toJSONString(res);
    }
}
