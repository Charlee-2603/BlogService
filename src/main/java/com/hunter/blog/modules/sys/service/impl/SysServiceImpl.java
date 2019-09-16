package com.hunter.blog.modules.sys.service.impl;

import com.hunter.blog.core.data.CodeMsg;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.sys.service.ISysService;
import com.hunter.blog.modules.user.dao.IUserDao;
import com.hunter.blog.modules.user.model.UserDo;
import com.hunter.blog.modules.user.model.UserDto;
import com.hunter.blog.utils.UUIDUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


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
     *
     * @param user
     * @param map
     * @return
     */
    @Override
    public DataResult<UserDo> login(UserDto user, Map<String, Object> map) {
        HashMap<String, Object> mp = new HashMap<>(16);
        String UUID = UUIDUntil.getUUID32();
        DataResult<UserDo> data;
        // 验证码
        String code = user.getCode();
        // 获取sessionId
        String sessionId = (String) map.get("sessionId");
        // 判断user对象是否存在
        if (user != null) {
            // 判断sessionId是否存在
            if (sessionId != null && !"".equals(sessionId)) {
                Jedis jedis = new Jedis();
                String sid = jedis.get(sessionId);
                // 判断sessionId对象的验证码值是否存在
                if (sid != null && !"".equals(sid)) {
                    // 比较验证码（不区分大小写）
                    if (sid.toUpperCase().equals(code.toUpperCase())) {
                        // 根据user对象查询结果
                        UserDto userDto = userDao.findUserInfo(user);
                        // 如果不等于空 登录成功
                        if (userDto != null) {
                            map.remove("sessionId");
                            jedis.set(UUID, userDto.getUserId().toString());
                            System.out.println(userDto.getUserAvatar());
                            mp.put("uid", userDto.getUserId());
                            mp.put("avatar", userDto.getUserAvatar());
                            mp.put("tokenId", UUID);
                            map.put("token", mp);
                            data = new DataResult(CodeMsg.SUCCESS, map);
                            return data;
                        }
                        // 用户密码错误
                        data = new DataResult<>(new CodeMsg("error", "用户名或密码错误"));
                        return data;
                    }
                    // 验证码错误
                    data = new DataResult<>(new CodeMsg("error", "验证码错误"));
                    return data;
                }
            }
        }
        data = new DataResult<>(CodeMsg.SERVER_ERROR);
        return data;
    }

    /**
     * 用户登录状态
     *
     * @param map
     * @return
     */
    @Override
    public DataResult userIsLogin(Map<String, Object> map) {

        DataResult data;
        String sessionId = (String) map.get("sessionId");
        String tokenId = (String) map.get("tokenId");
        String userId = (String) map.get("uid");

        if (sessionId != null && !"".equals(sessionId)) {
            if (tokenId != null && !"".equals(tokenId)) {
                Jedis jedis = new Jedis();
                Boolean flag = jedis.exists(sessionId);
                // sessionId存在
                if (flag) {
                    Boolean tk = jedis.exists(tokenId);
                    // tokenId存在
                    if (tk) {
                        int tid = Integer.parseInt(jedis.get(tokenId));
                        if (tid == Integer.parseInt(userId)) {
                            data = new DataResult(CodeMsg.SUCCESS);
                            return data;
                        }
                    }
                }
                data = new DataResult(CodeMsg.ERROR);
                return data;
            }
        }
        data = new DataResult(CodeMsg.REQUEST_PARAMETER_ERROR);
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
