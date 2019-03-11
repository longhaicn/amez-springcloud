package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByBatchVo;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author liurenkai
 * @time 2018/1/5 12:05
 */
public interface ProductStoreRefMapper extends BaseMapper<ProductStoreRef> {

    /**
     * 根据商品ID更新上架状态
     *
     * @param condMap 条件
     * @return
     */
    int updateSaleStatusByProductId(Map<String, Object> condMap);

    /**
     * 根据店铺ID更新上架状态
     *
     * @param condMap 条件
     * @return
     */
    int updateSaleStatusByStoreId(Map<String, Object> condMap);

    /**
     * 根据店铺ID更新商品状态
     *
     * @param condMap
     * @return
     */
    int freezeByStoreId(Map<String, Object> condMap);

    /**
     * 根据商品ID删除项目-门店-关联
     *
     * @param productId 商品ID
     * @return
     */
    int deleteByProductId(@Param(value = "productId") int productId);

    /**
     * 根据店铺ID删除项目-门店-关联
     *
     * @param storeId 店铺ID
     * @return
     */
    int deleteByStoreId(@Param(value = "storeId") int storeId);

    /**
     * 批量添加
     *
     * @param productStoreRefByBatchVo
     * @return
     */
    int addBatch(ProductStoreRefByBatchVo productStoreRefByBatchVo);

    /**
     * 根据店铺的storeId来查询商品的productId
     *
     * @param list
     * @return
     */
    List<Integer> findByStoreIdList(List<Integer> list);

}