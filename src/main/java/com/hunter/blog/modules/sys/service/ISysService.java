package com.hunter.blog.modules.sys.service;

import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.user.model.UserDo;
import com.hunter.blog.modules.user.model.UserDto;

import java.util.Map;

/**
 * 系统service接口
 *
 * @author ChenLiang
 * @version 1.0.0t
 * @data: 2019/9/3 19:23
 */
public interface ISysService {

    /**
     * 用户登录
     *
     * @param user
     * @param map
     * @return
     */
    DataResult<UserDo> login(UserDto user, Map<String, Object> map);

    /**
     * 用户注册
     *
     * @param userDo
     * @return
     */
    int userRegister(UserDo userDo);

    /**
     * 根据用户名查找用户是否存在
     *
     * @param userDo
     * @return
     */
    Integer getUserByName(UserDo userDo);
}
