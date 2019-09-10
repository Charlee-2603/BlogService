package com.hunter.blog.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.google.code.kaptcha.Producer;
import com.hunter.blog.core.data.CodeMsg;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.sys.service.ISysService;
import com.hunter.blog.modules.user.model.UserDo;
import com.hunter.blog.modules.user.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private Producer captchaProducer = null;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(UserDto user, HttpServletRequest  request) {
        System.out.println("\u001B[36m" + "login()方法执行了..." + "\u001B[36m");
        System.out.println("aaaaa,:" + request.getSession().getId());
        Map<String, Object> map = new HashMap<>(16);
        DataResult<UserDo> data = sysService.login(user, map);
        return JSON.toJSONString(data);
    }

    /**
     * 获取验证码
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    public String getCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("\033[36;4m" + "getCodeImage()方法执行了..." + "\033[0m");
        Map<String, Object> map = new HashMap<>(16);
        String sessionId = request.getSession().getId();
        System.out.println("第一次获取sessionId = " + sessionId);

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        //生成验证码
        String capText = captchaProducer.createText();
        System.out.println("capText:" + capText);
        Jedis jedis = new Jedis();
        jedis.set(sessionId, capText);

        String result = jedis.get(sessionId);
        System.out.println("redis中：" + result);

        //向客户端写出
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedImage bi = captchaProducer.createImage(capText);
        ImageIO.write(bi, "jpg", outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Img = encoder.encode(outputStream.toByteArray());

        try {
            outputStream.flush();
        } finally {
            outputStream.close();
        }
        map.put("codeImg", base64Img);
        map.put("sessionId", sessionId);
        return JSON.toJSONString(map);
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
     *
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
