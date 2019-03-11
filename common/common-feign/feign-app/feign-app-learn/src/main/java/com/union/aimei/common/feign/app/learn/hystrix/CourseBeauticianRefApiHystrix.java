package com.union.aimei.common.feign.app.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.CourseBeauticianRefFeign;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefResultVo;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 课程-美容师-关联
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Component(value = "appCourseBeauticianRefFeign")
public class CourseBeauticianRefApiHystrix implements CourseBeauticianRefFeign {

    /**
     * 前端分页查询课程-美容师-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param courseBeauticianRef 查询条件
     * @return
     */
    @Override
    public PageInfo<CourseBeauticianRef> findByPageForFront(Integer pageNo, Integer pageSize, CourseBeauticianRef courseBeauticianRef) {
        return null;
    }

    @Override
    public ResponseMessage<List<CourseBeauticianRef>> findByListForFrontV110(CourseBeauticianRef courseBeauticianRef) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> findByCountForFrontV110(CourseBeauticianRef courseBeauticianRef) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage checkBeauticianOnlyV110(int beauticianId, int courseId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage insertCourseBeauticianRefV110(CourseBeauticianRefVo courseBeauticianRefVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<CourseBeauticianRefResultVo>> findPageCourseBeauticianRefV110(int pageNo, int pageSize, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加课程-美容师-关联
     *
     * @param courseBeauticianRef
     * @return
     */
    @Override
    public int insert(CourseBeauticianRef courseBeauticianRef) {
        return 0;
    }

    /**
     * 删除课程-美容师-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改课程-美容师-关联
     *
     * @param courseBeauticianRef
     * @return
     */
    @Override
    public int edit(CourseBeauticianRef courseBeauticianRef) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourseBeauticianRef
     */
    @Override
    public CourseBeauticianRef queryById(int id) {
        return null;
    }
}