package com.union.aimei.common.feign.app.store.hystrix;

import com.union.aimei.common.feign.app.store.BeauticianBusyTimeFeign;
import com.union.aimei.common.model.store.BeauticianBusyTime;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 美容师忙碌时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:06
 */
@Component(value = "app-BeauticianBusyTimeFeign")
public class BeauticianBusyTimeApiHystrix implements BeauticianBusyTimeFeign {

    @Override
    public ResponseMessage addV111(BeauticianBusyTime beauticianBusyTime) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<BeauticianBusyTime> findByBeauticianIdForBusyDateV111(int beauticianId, String busyDate) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage deleteByBeauticianIdForBusyDateV111(int beauticianId, String busyDate) {
        return HystrixResponse.invokeFail();
    }

}