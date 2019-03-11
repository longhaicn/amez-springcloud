package com.union.aimei.product.mapper;

import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/1/12 14:08
 */
public interface ProductStoreRefMapper extends BaseMapper<ProductStoreRef> {

    /**
     * 根据商品ID更新软删除标记
     *
     * @param productStoreRef 项目-门店-关联
     * @return
     */
    int updateIsEnabledByProductId(ProductStoreRef productStoreRef);

    /**
     * 根据商品ID更新上架状态
     *
     * @param productStoreRef 项目-门店-关联
     * @return
     */
    int updateSaleStatusByProductId(ProductStoreRef productStoreRef);

    /**
     * 根据商品ID查询项目-门店-关联（提交订单）
     *
     * @param condMap 条件
     * @return
     */
    List<ProductStoreRef> selectListByProductIdForOrder(Map<String, Object> condMap);

    /**
     * 根据商品ID，店铺ID更新销售状态
     *
     * @param productStoreRef
     * @return
     */
    int updateSaleStatusByProductIdByStoreId(ProductStoreRef productStoreRef);

    /**
     * 根据商品ID查询项目-门店-关联（距离最近）
     *
     * @param condMap 条件
     * @return
     */
    ProductStoreRef selectByProductIdForDistanceNearest(Map<String, Object> condMap);

    /**
     * 根据店铺ID更新商品的状态
     *
     * @param condMap 条件
     * @return
     */
    int updateProductStatusByStoreId(Map<String, Object> condMap);

    /**
     * 查询项目-门店-关联
     *
     * @param condMap 条件
     * @return
     */
    ProductStoreRef getByRefId(Map<String, Object> condMap);

}