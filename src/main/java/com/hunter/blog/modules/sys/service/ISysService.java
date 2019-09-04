package com.hunter.blog.modules.sys.service;

import com.hunter.blog.modules.user.model.UserDo;

import java.util.List;

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
    List<UserDo> login(UserDo user);

    /**
     * 用户注册
     * @param userDo
     * @return
     */
    int userRegister(UserDo userDo);

    /**
     * 根据用户名查找用户是否存在
     * @param userDo
     * @return
     */
    Integer getUserByName(UserDo userDo);
}
