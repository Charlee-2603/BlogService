package com.hunter.blog.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.modules.sys.service.ISysService;
import com.hunter.blog.modules.user.model.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统控制类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/3 19:14
 */
@RestController
@RequestMapping("/sys")
public class SysController {

    @Autowired
    private ISysService sysService;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(UserDo user) {
        if (user != null) {
            UserDo result = sysService.login(user);
            return JSON.toJSONString(result);
        } else {
            return "";
        }
    }

    /**
     * 用户注册
     * @param userDo
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String userRegister(UserDo userDo) {
        int result = sysService.userRegister(userDo);
        return JSON.toJSONString(result);
    }
}
