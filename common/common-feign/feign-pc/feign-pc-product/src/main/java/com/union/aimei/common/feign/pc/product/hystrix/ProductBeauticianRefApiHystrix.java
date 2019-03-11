package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductBeauticianRefFeign;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.pc.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/26 15:07
 */
@Component(value = "pc-ProductBeauticianRefFeign")
public class ProductBeauticianRefApiHystrix implements ProductBeauticianRefFeign {

    /**
     * 前端分页查询项目-美容师-关联
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param productBeauticianRef 查询条件
     * @return
     */
    @Override
    public PageInfo<ProductBeauticianRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductBeauticianRef productBeauticianRef) {
        return null;
    }

    /**
     * 添加项目-美容师-关联
     *
     * @param productBeauticianRef
     * @return
     */
    @Override
    public int insert(ProductBeauticianRef productBeauticianRef) {
        return 0;
    }

    /**
     * 删除项目-美容师-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改项目-美容师-关联
     *
     * @param productBeauticianRef
     * @return
     */
    @Override
    public int edit(ProductBeauticianRef productBeauticianRef) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductBeauticianRef
     */
    @Override
    public ProductBeauticianRef queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage deleteByProductId(int productId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage addBatch(ProductBeauticianRefByBatchVo productBeauticianRefByBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductBeauticianRefByDetailResVo> detail(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<ProductBeauticianRefByResVo>> findByPage(Integer pageNo, Integer pageSize, ProductBeauticianRefVo productBeauticianRefVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage agree(ProductBeauticianRefByAgreeVo agreeVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductBeauticianRef> auth(ProductBeauticianRefByAuthVo authVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage beauticianStatus(ProductBeauticianRefByBeauticianStatusVo beauticianStatusVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage coursePassV111(ProductBeauticianRefCoursePassVo coursePassVo) {
        return HystrixResponse.invokeFail();
    }

}