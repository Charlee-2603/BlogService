package com.hunter.blog.modules.user.model;

import com.hunter.blog.config.page.model.PageDo;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 用户实体扩展类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/10 9:17
 */
@Component
public class UserDto extends UserDo implements Serializable {
    /**
     * 验证码
     */
    private String code;
    /**
     * sessionId
     */
    private String sessionId;

    private PageDo pageDo;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PageDo getPageDo() {
        return pageDo;
    }

    public void setPageDo(PageDo pageDo) {
        this.pageDo = pageDo;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "code='" + code + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", pageDo=" + pageDo +
                "} " + super.toString();
    }
}