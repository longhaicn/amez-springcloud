package com.union.aimei.common.feign.app.umeng.hystrix;

import com.union.aimei.common.feign.app.umeng.PushIosFeign;
import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * @author houji
 * @date 2018/3/9  17:05
 */
@Component(value = "app-PushIOSFeign")
public class PushIosApiHystrix implements PushIosFeign {

    @Override
    public ResponseMessage sendNoticeForConsumer(BaseUmengPushTemplate baseUmengPushTemplate) {
        return null;
    }

    @Override
    public ResponseMessage sendNoticeForBeautician(BaseUmengPushTemplate baseUmengPushTemplate) {
        return null;
    }

    @Override
    public ResponseMessage sendPaySuccess(BaseUmengPushTemplate baseUmengPushTemplate) {
        return null;
    }

    @Override
    public ResponseMessage sendNoticeRefund(BaseUmengPushTemplate baseUmengPushTemplate) {
        return null;
    }

    @Override
    public ResponseMessage sendNoticeRecruit(BaseUmengPushTemplate baseUmengPushTemplate) {
        return null;
    }

    @Override
    public ResponseMessage sendNoticeFoManager(BaseUmengPushTemplate baseUmengPushTemplate) {
        return null;
    }
}
