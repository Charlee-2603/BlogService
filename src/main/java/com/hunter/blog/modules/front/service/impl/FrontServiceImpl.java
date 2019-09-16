package com.hunter.blog.modules.front.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hunter.blog.modules.article.dao.IArticleDao;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.front.dao.IFrontDao;
import com.hunter.blog.modules.front.service.IFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Autowired
    private IArticleDao articleDao;

    @Override
    public Map setHtml(Map<String, Object> map) {
        // 获取logo图片地址
        map.put("logoImgUrl", frontDao.getFrontConfig("logoImg"));

        // 顶部导航栏列表
        map.put("navBarList", frontDao.getFrontConfig("navBarTitle"));

        // 顶部导航栏按钮
        map.put("navBarListBtn", frontDao.getFrontConfig("navBarBtn"));

        // 分类导航栏列表
        Integer frontId = (Integer) map.get("frontId");
        map.put("sortNavBarList", frontDao.getSortNavConfig("sortNavBar", "sortNavBar1", frontId));

        // 广告图片地址
        map.put("adInfo", frontDao.getFrontConfig("adInfo"));

        // 文章列表
        Integer pageIndex = (Integer) map.get("pageIndex");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer sortNavId = (Integer) map.get("sortNavId");
        PageHelper.startPage(pageIndex, pageSize);
        if (sortNavId == 10) {
            sortNavId = null;
        }
        Page<ArticleDo> articleList = articleDao.getArticles(sortNavId);
        map.put("articleList", articleList);
        return map;
    }
}
