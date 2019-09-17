package com.hunter.blog.modules.user.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.user.model.UserDo;
import com.hunter.blog.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户前端控制类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/2 10:51
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public String getUserInfo(@RequestBody UserDo userDo) {
        System.out.println("\u001B[36m" + "getUserInfo()方法执行了..." + "\u001B[36m");
        DataResult res = userService.getUserInfoByUserId(userDo);
        return JSON.toJSONString(res);
    }
}
