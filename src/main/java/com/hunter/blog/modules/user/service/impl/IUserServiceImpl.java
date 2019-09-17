package com.hunter.blog.modules.user.service.impl;

import com.hunter.blog.core.data.CodeMsg;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.user.dao.IUserDao;
import com.hunter.blog.modules.user.model.UserDo;
import com.hunter.blog.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户service实现类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/17 16:49
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 根据用户ID获取用户信息
     *
     * @param userDo
     * @return
     */
    @Override
    public DataResult getUserInfoByUserId(UserDo userDo) {
        DataResult data;
        if (userDo != null) {
            if (userDo.getUserId() > 0) {
                UserDo us = userDao.getUserInfoByUserId(userDo.getUserId());
                if (us != null) {
                    data = new DataResult(CodeMsg.SUCCESS, us);
                    return data;
                }
            }
        }
        data = new DataResult(CodeMsg.ERROR);
        return data;
    }
}
