package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefResultVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 课程-美容师-关联
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface CourseBeauticianRefMapper extends BaseMapper<CourseBeauticianRef> {

    /**
     * 查询美容师学习培训记录
     *
     * @param courseBeauticianRef
     * @return
     */
    List<CourseBeauticianRefResultVo> findPageCourseBeauticianRef(CourseBeauticianRef courseBeauticianRef);

    /**
     * 根据条件查询美容师-课程 统计数据(1.1.0)
     *
     * @param courseBeauticianRef
     * @return
     */
    int selectCountByConditions(CourseBeauticianRef courseBeauticianRef);
}