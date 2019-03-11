package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductByBatchVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
public interface StoreCouponsProductService extends SpringCloudBaseService<StoreCouponsProduct> {

    /**
     * 分页查询优惠券-服务-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param storeCouponsProduct 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreCouponsProduct>> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsProduct storeCouponsProduct);

    /**
     * 批量新增优惠券-服务-关联
     *
     * @param batchVo 批量优惠券-服务-关联
     * @return
     */
    ResponseMessage addBatch(StoreCouponsProductByBatchVo batchVo);

    /**
     * 根据优惠券ID更新软删除标记
     *
     * @param couponsId 优惠券ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    ResponseMessage updateByIsEnabledByCouponsId(int couponsId, boolean isEnabled);

    /**
     * 根据商品ID更新软删除标记
     *
     * @param productId 商品ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    ResponseMessage updateByIsEnabledByProductId(int productId, boolean isEnabled);

}
