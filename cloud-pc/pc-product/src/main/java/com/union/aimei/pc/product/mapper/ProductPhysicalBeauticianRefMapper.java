package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.common.utils.base.BaseMapper;

import java.util.Map;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:43
 */
public interface ProductPhysicalBeauticianRefMapper extends BaseMapper<ProductPhysicalBeauticianRef> {

    /**
     * 根据产品ID，美容师ID查询产品-美容师-关联
     *
     * @param condMap 条件
     * @return
     */
    ProductPhysicalBeauticianRef getByRefId(Map<String, Object> condMap);

}