package com.hunter.blog.modules.user.service;

import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.user.model.UserDo;

/**
 * 用户service接口
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/17 16:43
 */
public interface IUserService {
    /**
     * 根据用户ID获取用户信息
     * @param userDo
     * @return
     */
    DataResult getUserInfoByUserId(UserDo userDo);
}
