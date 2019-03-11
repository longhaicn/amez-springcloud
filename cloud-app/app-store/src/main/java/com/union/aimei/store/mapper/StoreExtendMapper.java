package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreExtend;
import com.union.common.utils.base.BaseMapper;

/**
 * 店铺扩展 mapper
 *
 * @author liurenkai
 * @time 2017/12/19 19:15
 */
public interface StoreExtendMapper extends BaseMapper<StoreExtend> {


    /**
     * 根据店铺查询店铺扩展
     *
     * @param storeId 店铺ID
     * @return
     */
    StoreExtend selectByStoreId(int storeId);

    /**
     * 根据店铺ID禁用店铺扩展
     *
     * @param storeId 店铺ID
     * @return
     */
    int updateByDisableByStoreId(int storeId);
}