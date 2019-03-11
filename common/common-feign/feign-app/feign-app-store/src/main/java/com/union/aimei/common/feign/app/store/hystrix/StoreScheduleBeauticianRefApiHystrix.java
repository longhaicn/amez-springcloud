package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreScheduleBeauticianRefFeign;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import org.springframework.stereotype.Component;

/**
 * 店铺排班-美容师-关联
 *
 * @author liurenkai
 * @time 2017/12/25 11:59
 */
@Component(value = "app-StoreScheduleBeauticianRefFeign")
public class StoreScheduleBeauticianRefApiHystrix implements StoreScheduleBeauticianRefFeign {

    @Override
    public PageInfo<StoreScheduleBeauticianRef> findByPageForFront(Integer pageNo, Integer pageSize, StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return null;
    }
}