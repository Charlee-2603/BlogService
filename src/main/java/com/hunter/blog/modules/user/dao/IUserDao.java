package com.hunter.blog.modules.user.dao;

import com.hunter.blog.modules.user.model.UserDo;
import com.hunter.blog.modules.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


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
     * @param userDto
     * @return
     */
    UserDto findUserInfo(@Param("userDto") UserDto userDto);

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

    /**
     * 根据用户ID获取用户信息
     * @param userId
     * @return
     */
    UserDo getUserInfoByUserId(@Param("userId") Integer userId);
}
