package com.hunter.blog.modules.front.dao;

import com.hunter.blog.modules.front.model.FrontDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 前端页面展示dao接口
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/8/29 15:21
 */
@Mapper
@Repository
public interface IFrontDao {

    /**
     * 根据前端key获取展示数据
     * @param frontType
     * @return
     */
    List<FrontDo> getFrontConfig(@Param("frontType") String frontType);

    /**
     * 根据父栏目Id找到子栏目
     *
     * @param frontKey
     * @param frontId
     * @return
     */
    List<FrontDo> getSortNavConfig(@Param("frontType") String frontKey, @Param("frontId") Integer frontId);
}
