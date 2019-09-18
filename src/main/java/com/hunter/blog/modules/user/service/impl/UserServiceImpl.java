package com.hunter.blog.modules.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hunter.blog.core.data.CodeMsg;
import com.hunter.blog.core.data.DataResult;
import com.hunter.blog.modules.article.dao.IArticleDao;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.user.dao.IUserDao;
import com.hunter.blog.modules.user.model.UserDo;
import com.hunter.blog.modules.user.model.UserDto;
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
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private IArticleDao articleDao;

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

    /**
     * 根据用户ID获取该用户相关的文章
     *
     * @param userDto
     * @return
     */
    @Override
    public DataResult getArticleByUserId(UserDto userDto) {
        DataResult data;
        int pageIndex = userDto.getPageDo().getPageIndex();
        int pageSize = userDto.getPageDo().getPageSize();
        if (userDto != null) {
            if (userDto.getUserId() != null && userDto.getUserId() > 0) {
                PageHelper.startPage(pageIndex, pageSize);
                Page<ArticleDo> res = articleDao.getArticleByUserId(userDto.getUserId());
                data = new DataResult(CodeMsg.SUCCESS, res);
                return data;
            }
        }
        data = new DataResult(CodeMsg.ERROR);
        return data;
    }
}
