package com.hunter.blog.modules.user.dao;

import com.hunter.blog.modules.user.model.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户dao接口
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/3 19:24
 */
@Mapper
@Repository
public interface IUserDao {

    /**
     * 判断用户是否存在
     *
     * @param userName
     * @param userPwd
     * @return
     */
    List<UserDo> findUserInfo(@Param("userName") String userName, @Param("userPwd") String userPwd);

    /**
     * 添加用户
     *
     * @param userDo
     * @return
     */
    int addUser(@Param("userDo") UserDo userDo);

    /**
     * 根据用户Id删除用户
     *
     * @param userId
     * @return
     */
    Integer delUserById(@Param("userId") int userId);

    /**
     * 根据用户id修改用户信息
     * @param userDo
     * @return
     */
    Integer updateUserById(UserDo userDo);

    /**
     * 根据用户名查找用户是否存在
     * @param userName
     * @return
     */
    Integer getUserByName(@Param("userName") String userName);
}
