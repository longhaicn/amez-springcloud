package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.CourseProductRef;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 课程适用的服务表
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface CourseProductRefService extends SpringCloudBaseService<CourseProductRef> {
       /**
        * 前端分页查询课程适用的服务表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param courseProductRef 查询条件
        * @return 
        */
       PageInfo<CourseProductRef> findByPageForFront(Integer pageNo, Integer pageSize, CourseProductRef courseProductRef);
}