package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.CourseProductRef;
import com.union.aimei.learn.mapper.CourseProductRefMapper;
import com.union.aimei.learn.service.CourseProductRefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Service("courseProductRefService")
public class CourseProductRefServiceImpl implements CourseProductRefService {
    @Resource
    private CourseProductRefMapper courseProductRefMapper;

    /**
     * 前端分页查询课程适用的服务表
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param courseProductRef 查询条件
     * @return
     */
    @Override
    public PageInfo<CourseProductRef> findByPageForFront(Integer pageNo, Integer pageSize, CourseProductRef courseProductRef) {
        PageHelper.startPage (pageNo, pageSize);
        courseProductRef.setIsEnabled (CourseProductRef.IS_ENABLED_TURE);
        List<CourseProductRef> list = this.courseProductRefMapper.selectListByConditions (courseProductRef);
        PageInfo<CourseProductRef> page = new PageInfo<> (list);
        return page;
    }

    /**
     * 添加课程适用的服务表
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(CourseProductRef t) {
        return this.courseProductRefMapper.insertSelective (t);
    }

    /**
     * 删除课程适用的服务表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.courseProductRefMapper.deleteByPrimaryKey (id);
    }

    /**
     * 修改课程适用的服务表
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(CourseProductRef t) {
        return this.courseProductRefMapper.updateByPrimaryKeySelective (t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourseProductRef
     */
    @Override
    public CourseProductRef queryObjById(int id) {
        CourseProductRef model = this.courseProductRefMapper.selectByPrimaryKey (id);
        return model;
    }


}