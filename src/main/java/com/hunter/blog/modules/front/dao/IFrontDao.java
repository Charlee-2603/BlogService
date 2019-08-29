package com.hunter.blog.modules.front.dao;

import com.hunter.blog.modules.front.model.FrontDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 前端页面展示dao接口
 * @author ChenLiang
 * @data: 2019/8/29 15:21
 * @version 1.0.0
 */
@Mapper
@Repository
public interface IFrontDao {

    /**
     * 根据前端key获取展示数据
     * @param frontKey
     * @return
     */
    List<FrontDo> getFrontConfig(@Param("frontKey") String frontKey);
}
