package com.hunter.blog.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.core.data.CodeMsg;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.sys.service.ISysService;
import com.hunter.blog.modules.user.model.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        DataResult<UserDo> data = null;
        if (user != null) {
            List<UserDo> result = sysService.login(user);
            if (result.size() > 1) {
                data = new DataResult<>(CodeMsg.SERVER_ERROR);
                return JSON.toJSONString(data);
            }
            if (!result.isEmpty()) {
                // 登录成功
                data = new DataResult(result);
                return JSON.toJSONString(data);
            }
            data = new DataResult<>(new CodeMsg("error", "用户名或密码错误"));
            return JSON.toJSONString(data);
        }
        data = new DataResult<>(CodeMsg.BIND_ERROR);
        return JSON.toJSONString(data);
    }

    /**
     * 用户注册
     *
     * @param userDo
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String userRegister(UserDo userDo) {
        DataResult<Integer> data = null;
        if (userDo != null) {
            // 查询用户名是否重复
            int userByName = sysService.getUserByName(userDo);
            // 用户名不存在 可用
            if (userByName == 0) {
                int result = sysService.userRegister(userDo);
                if (result == 1) {
                    data = new DataResult<>(CodeMsg.SUCCESS);
                    return JSON.toJSONString(data);
                }
                data = new DataResult<>(new CodeMsg("error", "注册失败"));
                return JSON.toJSONString(data);
            }
            data = new DataResult<>(new CodeMsg("error", "用户名已存在"));
            return JSON.toJSONString(data);
        }
        data = new DataResult<>(CodeMsg.BIND_ERROR);
        return JSON.toJSONString(data);
    }

    /**
     * 找回密码
     * @param userDo
     * @param code
     * @return
     */
    @RequestMapping("/findPwd")
    public String findPwd(UserDo userDo, String code) {
        System.out.println("\u001B[36m" + "findPwd()方法执行了..." + "\u001B[36m");
        CodeMsg codeMsg = null;
        if (userDo != null && code != null) {
//            sysService.findPwd(userDo);
        }
        codeMsg = CodeMsg.BIND_ERROR;
        return JSON.toJSONString(codeMsg);
    }
}
