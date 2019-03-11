package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreScheduleFeign;
import com.union.aimei.common.model.store.StoreSchedule;
import com.union.aimei.common.vo.store.app.StoreScheduleVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 店铺排班
 *
 * @author liurenkai
 * @time 2017/12/25 11:53
 */
@Component(value = "app-StoreScheduleFeign")
public class StoreScheduleApiHystrix implements StoreScheduleFeign {

    @Override
    public PageInfo<StoreSchedule> findByPageForFront(Integer pageNo, Integer pageSize, StoreSchedule storeSchedule) {
        return null;
    }

    @Override
    public ResponseMessage add(StoreScheduleVo storeScheduleVo) {
        return null;
    }

    @Override
    public ResponseMessage modify(StoreScheduleVo storeScheduleVo) {
        return null;
    }

    @Override
    public ResponseMessage isEnabled(int id, int isEnabled) {
        return null;
    }

    @Override
    public ResponseMessage<List<StoreScheduleVo>> findListByStoreId(int storeId) {
        return null;
    }
}