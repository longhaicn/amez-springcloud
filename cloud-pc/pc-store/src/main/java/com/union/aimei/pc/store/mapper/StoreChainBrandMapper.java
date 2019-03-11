package com.union.aimei.pc.store.mapper;

import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.common.utils.base.BaseMapper;

import java.util.Map;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
public interface StoreChainBrandMapper extends BaseMapper<StoreChainBrand> {

    /**
     * 根据品牌ID累积店铺总数
     *
     * @param condMap
     * @return
     */
    int accumStoreTotalByByBrandId(Map<String, Object> condMap);

    /**
     * 根据品牌ID累积商品总数
     *
     * @param condMap
     * @return
     */
    int accumProductTotalByByBrandId(Map<String, Object> condMap);

    /**
     * 限定 品牌所属公司下的所有品牌名称不可重复
     * @param condMap
     * @return
     */
    int selectListByConditionsCount(Map<String, Object> condMap);


}