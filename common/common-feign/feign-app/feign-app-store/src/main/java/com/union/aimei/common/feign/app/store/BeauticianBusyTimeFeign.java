package com.union.aimei.common.feign.app.store;

import com.union.aimei.common.feign.app.store.hystrix.BeauticianBusyTimeApiHystrix;
import com.union.aimei.common.model.store.BeauticianBusyTime;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 美容师忙碌时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:05
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = BeauticianBusyTimeApiHystrix.class)
public interface BeauticianBusyTimeFeign {

    /**
     * 新增美容师忙碌时间
     *
     * @param beauticianBusyTime 美容师忙碌时间
     * @return
     */
    @PostMapping("/beauticianBusyTime/1.1.1/add")
    ResponseMessage addV111(@RequestBody BeauticianBusyTime beauticianBusyTime);

    /**
     * 根据忙碌日期查询美容师忙碌时间
     *
     * @param beauticianId 美容师ID
     * @param busyDate     忙碌日期
     * @return
     */
    @GetMapping("/beauticianBusyTime/1.1.1/findByBeauticianIdForBusyDate/{beauticianId}/{busyDate}")
    ResponseMessage<BeauticianBusyTime> findByBeauticianIdForBusyDateV111(@PathVariable(value = "beauticianId") int beauticianId,
                                                                          @PathVariable(value = "busyDate") String busyDate);

    /**
     * 根据忙碌日期删除美容师忙碌时间
     *
     * @param beauticianId 美容师ID
     * @param busyDate     忙碌日期
     * @return
     */
    @PutMapping("/beauticianBusyTime/1.1.1/deleteByBeauticianIdForBusyDate/{beauticianId}/{busyDate}")
    ResponseMessage deleteByBeauticianIdForBusyDateV111(@PathVariable(value = "beauticianId") int beauticianId,
                                                        @PathVariable(value = "busyDate") String busyDate);

}