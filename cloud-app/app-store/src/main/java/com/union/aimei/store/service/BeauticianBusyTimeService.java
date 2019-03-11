package com.union.aimei.store.service;

import com.union.aimei.common.model.store.BeauticianBusyTime;
import com.union.common.utils.ResponseMessage;

/**
 * 美容师忙碌时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:02
 */
public interface BeauticianBusyTimeService {

    /**
     * 新增美容师忙碌时间
     *
     * @param beauticianBusyTime 美容师忙碌时间
     * @return
     */
    ResponseMessage addV111(BeauticianBusyTime beauticianBusyTime);

    /**
     * 根据忙碌日期删除美容师忙碌时间
     *
     * @param beauticianId 美容师ID
     * @param busyDate     忙碌日期
     * @return
     */
    ResponseMessage deleteByBeauticianIdForBusyDateV111(int beauticianId, String busyDate);

    /**
     * 根据忙碌日期查询美容师忙碌时间
     *
     * @param beauticianId 美容师ID
     * @param busyDate     忙碌日期
     * @return
     */
    ResponseMessage<BeauticianBusyTime> findByBeauticianIdForBusyDateV111(int beauticianId, String busyDate);

}