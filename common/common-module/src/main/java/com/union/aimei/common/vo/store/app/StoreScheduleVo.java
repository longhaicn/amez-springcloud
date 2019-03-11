package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.model.store.StoreSchedule;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺排班vo
 *
 * @author liurenkai
 * @time 2017/12/25 10:55
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺排班vo")
public class StoreScheduleVo implements Serializable {

    /**
     * 店铺排班
     */
    private StoreSchedule storeSchedule;
    /**
     * 店铺排班-美容师-关联集合
     */
    private List<StoreScheduleBeauticianRef> beauticianRefList;
}
