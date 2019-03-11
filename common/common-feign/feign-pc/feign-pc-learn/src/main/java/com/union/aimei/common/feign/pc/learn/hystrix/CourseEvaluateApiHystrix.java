package com.union.aimei.common.feign.pc.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.CourseEvaluateFeign;
import com.union.aimei.common.model.learn.CourseEvaluate;
import org.springframework.stereotype.Component;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Component(value = "pc-CourseEvaluateFeign")
public class CourseEvaluateApiHystrix implements CourseEvaluateFeign {

    /**
     * 前端分页查询课程试题
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param courseEvaluate 查询条件
     * @return
     */
    @Override
    public PageInfo<CourseEvaluate> findByPageForFront(Integer pageNo, Integer pageSize, CourseEvaluate courseEvaluate) {
        return null;
    }

    /**
     * 添加课程试题
     *
     * @param courseEvaluate
     * @return
     */
    @Override
    public int insert(CourseEvaluate courseEvaluate) {
        return 0;
    }

    /**
     * 删除课程试题
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改课程试题
     *
     * @param courseEvaluate
     * @return
     */
    @Override
    public int edit(CourseEvaluate courseEvaluate) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourseEvaluate
     */
    @Override
    public CourseEvaluate queryById(int id) {
        return null;
    }
}