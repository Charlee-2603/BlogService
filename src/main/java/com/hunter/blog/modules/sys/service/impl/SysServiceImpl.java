package com.hunter.blog.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.core.data.CodeMsg;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.sys.service.ISysService;
import com.hunter.blog.modules.user.dao.IUserDao;
import com.hunter.blog.modules.user.model.UserDo;
import com.hunter.blog.modules.user.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;


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

    /**
     * 登录
     * @param user
     * @param map
     * @return
     */
    @Override
    public DataResult<UserDo> login(UserDto user, Map<String, Object> map) {
        DataResult<UserDo> data;
        // 验证码
        String code = user.getCode();
        // 获取sessionId
        String sessionId = user.getSessionId();
        // 判断user对象是否存在
        if (user != null) {
            // 判断sessionId是否存在
            if (sessionId != null && !"".equals(sessionId)) {
//                Jedis jedis = new Jedis();
//                String sid = jedis.get(user.getSessionId());
                // 判断sessionId对象的验证码值是否存在
//                if (sid != null && !"".equals(sid)) {
                    // 比较验证码（不区分大小写）
//                    if (sid.toUpperCase().equals(code.toUpperCase())) {
                        // 根据user对象查询结果
                        List<UserDto> result = userDao.findUserInfo(user);
                        System.out.println(result);
                        // 如果存在多个用户 则系统出错（用户名不能重复）
                        if (result.size() > 1) {
                            data = new DataResult<>(CodeMsg.SERVER_ERROR);
                            return data;
                        }
                        // 如果不等于空 登录成功
                        if (!result.isEmpty()) {
                            // 登录成功
                            data = new DataResult(result);
                            return data;
                        }
                        // 用户密码错误
                        data = new DataResult<>(new CodeMsg("error", "用户名或密码错误"));
                        return data;
                    }
                    // 验证码错误
                    data = new DataResult<>(new CodeMsg("error", "验证码错误"));
                    return data;
//                }
//            }
        }
        data = new DataResult<>(CodeMsg.SERVER_ERROR);
        return data;
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
