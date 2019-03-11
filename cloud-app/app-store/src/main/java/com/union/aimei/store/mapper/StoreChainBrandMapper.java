package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2018/1/4 15:37
 */
public interface StoreChainBrandMapper extends BaseMapper<StoreChainBrand> {

    /**
     * 根据门店ID更新门店总数+1
     *
     * @param storeId 门店ID
     * @return
     */
    int updateByAddStoreTotalByByStoreId(int storeId);

    /**
     * 根据门店ID更新门店总数-1
     *
     * @param storeId 门店ID
     * @return
     */
    int updateBySubtractStoreTotalByByStoreId(int storeId);

    /**
     * 所有门店连锁品牌列表
     *
     * @return
     */
    List<StoreChainBrand> listAll();
}