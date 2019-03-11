package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefResultVo;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 课程-美容师-关联
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface CourseBeauticianRefService extends SpringCloudBaseService<CourseBeauticianRef> {
    /**
     * 前端分页查询课程-美容师-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param courseBeauticianRef 查询条件
     * @return
     */
    PageInfo<CourseBeauticianRef> findByPageForFront(Integer pageNo, Integer pageSize, CourseBeauticianRef courseBeauticianRef);


    /**
     * 根据条件查询美容师-课程集合数据(1.1.0)
     *
     * @param courseBeauticianRef
     * @return
     */
    ResponseMessage<List<CourseBeauticianRef>> findByListForFrontV110(CourseBeauticianRef courseBeauticianRef);

    /**
     * 根据条件查询美容师-课程 统计数据(1.1.0)
     *
     * @param courseBeauticianRef
     * @return
     */
    ResponseMessage<Integer> findByCountForFrontV110(CourseBeauticianRef courseBeauticianRef);

    /**
     * 根据美容师id 跟课程id判断是否已报名(1.1.0)
     *
     * @param beauticianId 美容师id
     * @param courseId     课程id
     * @return
     */
    ResponseMessage checkBeauticianOnlyV110(Integer beauticianId, Integer courseId);

    /**
     * 美容师报名课程的数据添加(1.1.0)
     *
     * @param courseBeauticianRefVo
     * @return
     */
    ResponseMessage insertCourseBeauticianRefV110(CourseBeauticianRefVo courseBeauticianRefVo);

    /**
     * 查询美容师学习培训记录(v1.1.0)
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param beauticianId  美容师id
     * @return
     */
    ResponseMessage<PageInfo<CourseBeauticianRefResultVo>> findPageCourseBeauticianRefV110(Integer pageNo, Integer pageSize, Integer beauticianId);

}