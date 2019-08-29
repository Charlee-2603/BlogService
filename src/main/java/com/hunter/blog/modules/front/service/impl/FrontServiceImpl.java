package com.hunter.blog.modules.front.service.impl;

import com.hunter.blog.modules.front.dao.IFrontDao;
import com.hunter.blog.modules.front.service.IFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 前端页面展示service实现类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/8/29 15:05
 */
@Service
public class FrontServiceImpl implements IFrontService {

    @Autowired
    private IFrontDao frontDao;

    @Override
    public Map setHtml(Map<String, Object> map) {
        // 获取logo图片地址
        map.put("logoImgUrl", frontDao.getFrontConfig("logoImg"));

        // 顶部导航栏列表
        map.put("navBarList",frontDao.getFrontConfig("navBar"));

        // 分类导航栏列表
        map.put("sortNavBarList",frontDao.getFrontConfig("sortNavBar"));

        // 广告图片地址
        map.put("adImgHref",frontDao.getFrontConfig("adImg"));

        // 广告跳转链接
        map.put("articleList",frontDao.getFrontConfig("adImgHref"));

        // 文章列表
        return map;
    }
}
