package com.union.aimei.common.feign.pc.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.CourseProductRefFeign;
import com.union.aimei.common.model.learn.CourseProductRef;
import org.springframework.stereotype.Component;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Component(value = "pc-CourseProductRefFeign")
public class CourseProductRefApiHystrix implements CourseProductRefFeign {

       /**
        * 前端分页查询课程适用的服务表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param courseProductRef 查询条件
        * @return 
        */
       @Override
       public PageInfo<CourseProductRef> findByPageForFront(Integer pageNo, Integer pageSize, CourseProductRef courseProductRef) {
              return null;
       }

       /**
        * 添加课程适用的服务表
        * @param courseProductRef
        * @return
        */
       @Override
       public int insert(CourseProductRef courseProductRef) {
              return 0;
       }

       /**
        * 删除课程适用的服务表
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改课程适用的服务表
        * @param courseProductRef
        * @return
        */
       @Override
       public int edit(CourseProductRef courseProductRef) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returncourseProductRef
        */
       @Override
       public CourseProductRef queryById(int id) {
              return null;
       }
}