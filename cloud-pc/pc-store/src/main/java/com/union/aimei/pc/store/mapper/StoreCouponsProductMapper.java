package com.union.aimei.pc.store.mapper;

import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductByBatchVo;
import com.union.common.utils.base.BaseMapper;

import java.util.Map;

/**
 * 优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
public interface StoreCouponsProductMapper extends BaseMapper<StoreCouponsProduct> {

    /**
     * 批量新增优惠券-服务-关联
     *
     * @param batchVo 批量优惠券-服务-关联
     * @return
     */
    int addBatch(StoreCouponsProductByBatchVo batchVo);

    /**
     * 根据优惠券ID更新软删除标记
     *
     * @param condMap 条件
     * @return
     */
    int updateByIsEnabledByCouponsId(Map<String, Object> condMap);

    /**
     * 根据商品ID更新软删除标记
     *
     * @param condMap 条件
     * @return
     */
    int updateByIsEnabledByProductId(Map<String, Object> condMap);

}