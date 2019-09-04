package com.hunter.blog.modules.sys.service.impl;

import com.hunter.blog.modules.sys.service.ISysService;
import com.hunter.blog.modules.user.dao.IUserDao;
import com.hunter.blog.modules.user.model.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 系统service接口实现类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/3 19:23
 */
@Service
public class SysServiceImpl implements ISysService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<UserDo> login(UserDo user) {
        // 用户名
        String userName = user.getUserName();
        // 用户密码
        String userPwd = user.getUserPwd();
        return userDao.findUserInfo(userName, userPwd);
    }

    @Override
    public int userRegister(UserDo userDo) {
        int res = userDao.addUser(userDo);
        return res;
    }

    @Override
    public Integer getUserByName(UserDo userDo) {
        String userName = userDo.getUserName();
        return userDao.getUserByName(userName);
    }
}
