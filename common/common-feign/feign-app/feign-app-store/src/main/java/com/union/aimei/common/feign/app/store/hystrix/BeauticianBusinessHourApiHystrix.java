package com.union.aimei.common.feign.app.store.hystrix;

import com.union.aimei.common.feign.app.store.BeauticianBusinessHourFeign;
import com.union.aimei.common.model.store.BeauticianBusinessHour;
import com.union.aimei.common.vo.store.app.BeauticianBusinessHourByAddVo;
import com.union.aimei.common.vo.store.app.BeauticianBusinessHourByBatchVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 美容师营业时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:05
 */
@Component(value = "app-BeauticianBusinessHourFeign")
public class BeauticianBusinessHourApiHystrix implements BeauticianBusinessHourFeign {

    @Override
    public ResponseMessage addBatchV111(BeauticianBusinessHourByBatchVo batchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage deleteByBeauticianIdV111(int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<BeauticianBusinessHour>> findListByBeauticianIdV111(int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage addV111(BeauticianBusinessHourByAddVo addVo) {
        return HystrixResponse.invokeFail();
    }

}