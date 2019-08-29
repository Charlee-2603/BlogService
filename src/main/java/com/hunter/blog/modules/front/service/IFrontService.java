package com.hunter.blog.modules.front.service;

import java.util.Map;

/**
 * 前端页面展示service接口
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/8/29 15:00
 */
public interface IFrontService {

    /**
     * 设置默认前端页面展示的数据
     * @param map
     * @return
     */
    Map setHtml(Map<String, Object> map);
}
