package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.pc.*;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/26 14:55
 */
public interface ProductBeauticianRefService extends SpringCloudBaseService<ProductBeauticianRef> {

    /**
     * 分页查询项目-美容师-关联
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productBeauticianRef 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductBeauticianRef>> findByPageForFront(Integer pageNo, Integer pageSize, ProductBeauticianRef productBeauticianRef);

    /**
     * 根据商品ID删除项目-美容师-关联
     *
     * @param productId 商品ID
     * @return
     */
    ResponseMessage deleteByProductId(int productId);

    /**
     * 批量添加项目-美容师-关联
     *
     * @param productBeauticianRefByBatchVo
     * @return
     */
    ResponseMessage addBatch(ProductBeauticianRefByBatchVo productBeauticianRefByBatchVo);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    ResponseMessage<ProductBeauticianRefByDetailResVo> detail(int id);

    /**
     * 分页查询项目-美容师-关联
     *
     * @param pageNo                 分页索引
     * @param pageSize               每页数量
     * @param productBeauticianRefVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductBeauticianRefByResVo>> findByPage(Integer pageNo, Integer pageSize, ProductBeauticianRefVo productBeauticianRefVo);

    /**
     * 项目-美容师-关联（同意）
     *
     * @param agreeVo
     * @return
     */
    ResponseMessage agree(ProductBeauticianRefByAgreeVo agreeVo);

    /**
     * 项目-美容师-关联（审核）
     *
     * @param authVo
     * @return
     */
    ResponseMessage<ProductBeauticianRef> auth(ProductBeauticianRefByAuthVo authVo);

    /**
     * 项目-美容师-关联（美容师状态）
     *
     * @param beauticianStatusVo
     * @return
     */
    ResponseMessage beauticianStatus(ProductBeauticianRefByBeauticianStatusVo beauticianStatusVo);

    /**
     * 课程通过
     *
     * @param coursePassVo 条件
     * @return
     */
    ResponseMessage coursePass(ProductBeauticianRefCoursePassVo coursePassVo);

}