package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.app.CourseParamVo;
import com.union.aimei.common.vo.learn.app.CourseResultVo;
import com.union.aimei.common.vo.learn.app.UpdateCourseVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 培训课程列表
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 查询培训课程列表
     *
     * @param courseParamVo
     * @return
     */
    List<CourseResultVo> selectCourseListByBeautic(CourseParamVo courseParamVo);

    /**
     * 根据id查询培训课程详情
     *
     * @param id
     * @return
     */
    CourseResultVo selectByCourseId(Integer id);

    /**
     * 根据id和类型自增统计数据
     *
     * @param updateCourseVo
     */
    void updateCourseById(UpdateCourseVo updateCourseVo);

}