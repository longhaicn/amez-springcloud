package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.CourseEvaluate;
import com.union.aimei.learn.mapper.CourseEvaluateMapper;
import com.union.aimei.learn.service.CourseEvaluateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Service("courseEvaluateService")
public class CourseEvaluateServiceImpl implements CourseEvaluateService {
    @Resource
    private CourseEvaluateMapper courseEvaluateMapper;

    /**
     * 前端分页查询课程试题(v1.1.0)
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param courseEvaluate 查询条件
     * @return
     */
    @Override
    public PageInfo<CourseEvaluate> findByPageForFrontV110(Integer pageNo, Integer pageSize, CourseEvaluate courseEvaluate) {
        PageHelper.startPage (pageNo, pageSize);
        courseEvaluate.setIsEnabled (CourseEvaluate.IS_ENABLED_TURE);
        courseEvaluate.setSort (0);
        List<CourseEvaluate> list = this.courseEvaluateMapper.selectListByConditions (courseEvaluate);
        PageInfo<CourseEvaluate> page = new PageInfo<> (list);
        return page;
    }

    /**
     * 添加课程试题
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(CourseEvaluate t) {
        return this.courseEvaluateMapper.insertSelective (t);
    }

    /**
     * 删除课程试题
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.courseEvaluateMapper.deleteByPrimaryKey (id);
    }

    /**
     * 修改课程试题
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(CourseEvaluate t) {
        return this.courseEvaluateMapper.updateByPrimaryKeySelective (t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourseEvaluate
     */
    @Override
    public CourseEvaluate queryObjById(int id) {
        CourseEvaluate model = this.courseEvaluateMapper.selectByPrimaryKey (id);
        return model;
    }
}