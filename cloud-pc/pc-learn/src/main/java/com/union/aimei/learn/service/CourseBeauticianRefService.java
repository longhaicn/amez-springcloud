package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.pc.BeauticianParamVo;
import com.union.aimei.common.vo.learn.pc.UpdateBeauticianVo;
import com.union.aimei.common.vo.product.pc.ProductBeauticianRefByCourseVo;
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
     * 根据条件筛选课程-美容师-关联表
     *
     * @param pageNo
     * @param pageSize
     * @param beauticianParamVo
     * @return
     */
    ResponseMessage<PageInfo<CourseBeauticianRef>> findByPageForFrontV110(Integer pageNo, Integer pageSize, BeauticianParamVo beauticianParamVo);


    /**
     * 根据类型批量更新课程-美容师-关联表数据
     *
     * @param updateBeauticianVo
     * @return
     */
    ResponseMessage batchUpdateByIdsTypeV110(UpdateBeauticianVo updateBeauticianVo);

    /**
     * 查询已通过培训的美容师获取可开通的服务
     *
     * @return
     */
    ResponseMessage<List<ProductBeauticianRefByCourseVo>> selectBeauticianIsOpenService();

}