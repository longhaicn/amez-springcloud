package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.pc.CourseBeauticianRefResultVo;
import com.union.aimei.common.vo.learn.pc.CourseParamVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 课程
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 根据条件统计课程
     *
     * @param course
     * @return
     */
    Integer countByConditions(Course course);

    /**
     * 根据条件查询课程列表
     *
     * @param courseParamVo
     * @return
     */
    List<Course> selectListPageByCourse(CourseParamVo courseParamVo);


    /**
     * 根据条件更新正在进行中的课程
     *
     * @param course
     * @return
     */
    int updateByOngoingCourse(Course course);

    /**
     * 根据条件更新已结束的课程
     *
     * @param course
     * @return
     */
    int updateByEndedCourse(Course course);


    /**
     * 查询指定时间区间即将开始培训的课程
     *
     * @param courseParamVo
     * @return
     */
    List<CourseBeauticianRefResultVo> findIsAboutToBeginCourse(CourseParamVo courseParamVo);

}