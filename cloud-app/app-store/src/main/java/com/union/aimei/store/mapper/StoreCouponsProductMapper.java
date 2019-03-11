package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券-商品-关联
 *
 * @author liurenkai
 * @time 2017/12/22 10:37
 */
public interface StoreCouponsProductMapper extends BaseMapper<StoreCouponsProduct> {

    /**
     * 根据优惠券ID更新软删除标记
     *
     * @param storeCouponsProduct 优惠券-商品-关联
     * @return
     */
    int updateByIsEnabledByStoreCouponsId(StoreCouponsProduct storeCouponsProduct);

    /**
     * 批量添加优惠券-商品-关联
     *
     * @param storeCouponsProductList 优惠券-商品-关联集合
     * @return
     */
    int addBatch(@Param(value = "storeCouponsProductList") List<StoreCouponsProduct> storeCouponsProductList);

}