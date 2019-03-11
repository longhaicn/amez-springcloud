package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import com.union.common.utils.base.BaseMapper;

/**
 * 店铺排班-美容师-关联
 *
 * @author liurenkai
 * @time 2017/12/25 11:16
 */
public interface StoreScheduleBeauticianRefMapper extends BaseMapper<StoreScheduleBeauticianRef> {

    /**
     * 根据店铺排班ID删除店铺排班-美容师-关联
     *
     * @param storeScheduleId 店铺排班ID
     * @return
     */
    int deleteByStoreScheduleId(int storeScheduleId);

    /**
     * 根据店铺排班ID更新软删除标记
     *
     * @param storeScheduleBeauticianRef 店铺排班-美容师-关联
     * @return
     */
    int updateByIsEnabledByStoreScheduleId(StoreScheduleBeauticianRef storeScheduleBeauticianRef);

}