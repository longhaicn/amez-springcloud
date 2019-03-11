package com.union.aimei.common.feign.app.im.hystrix;

import com.union.aimei.common.feign.app.im.EasemobImMessagesFeign;
import com.union.aimei.common.vo.im.common.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * IM消息feign hystrix
 *
 * @author liurenkai
 * @time 2017/11/28 16:03
 */
@Component(value = "app-EasemobImMessagesFeign")
public class EasemobImMessagesFeignHystrix implements EasemobImMessagesFeign {

    @Override
    public ResponseMessage<ResponseResult> sendTxt(MsgTxt msgTxt) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> sendImg(MsgImg msgImg) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> sendAudio(MsgAudio msgAudio) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> sendVideo(MsgVideo msgVideo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> sendCmd(MsgCmd msgCmd) {
        return HystrixResponse.invokeFail();
    }
}
