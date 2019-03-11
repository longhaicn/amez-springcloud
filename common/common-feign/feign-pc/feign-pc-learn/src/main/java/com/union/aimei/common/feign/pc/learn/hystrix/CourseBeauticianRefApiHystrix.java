package com.union.aimei.common.feign.pc.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.CourseBeauticianRefFeign;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.pc.BeauticianParamVo;
import com.union.aimei.common.vo.learn.pc.UpdateBeauticianVo;
import com.union.aimei.common.vo.product.pc.ProductBeauticianRefByCourseVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Component(value = "pc-CourseBeauticianRefFeign")
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
    public ResponseMessage<PageInfo<CourseBeauticianRef>> findByPageForFrontV110(Integer pageNo, Integer pageSize, BeauticianParamVo beauticianParamVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage batchUpdateByIdsTypeV110(UpdateBeauticianVo updateBeauticianVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<ProductBeauticianRefByCourseVo>> selectBeauticianIsOpenService() {
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