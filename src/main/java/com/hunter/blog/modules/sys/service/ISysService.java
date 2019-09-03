package com.hunter.blog.modules.sys.service;

import com.hunter.blog.modules.user.model.UserDo;

/**
 * 系统service接口
 * @author ChenLiang
 * @data: 2019/9/3 19:23
 * @version 1.0.0
 */
public interface ISysService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    UserDo login(UserDo user);

    /**
     * 用户注册
     * @param userDo
     * @return
     */
    int userRegister(UserDo userDo);
}
