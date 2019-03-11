package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.ProductCity;
import com.union.aimei.common.vo.product.pc.ProductCityByBatchVo;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 项目城市
 *
 * @author liurenkai
 * @time 2018/2/26 10:33
 */
public interface ProductCityMapper extends BaseMapper<ProductCity> {

    /**
     * 根据商品ID删除项目城市
     *
     * @param productId 商品ID
     * @return
     */
    int deleteByProductId(@Param(value = "productId") int productId);

    /**
     * 批量添加项目城市
     *
     * @param batchVo 批量项目城市
     * @return
     */
    int addBatch(ProductCityByBatchVo batchVo);

    /**
     * 根据城市ID禁用项目城市
     *
     * @param cityId 城市ID
     * @return
     */
    int disabledByCityId(@Param(value = "cityId") int cityId);

    /**
     * 根据城市ID设置商品标签
     *
     * @param condMap 条件
     * @return
     */
    int labelByCityId(Map<String, Object> condMap);

}