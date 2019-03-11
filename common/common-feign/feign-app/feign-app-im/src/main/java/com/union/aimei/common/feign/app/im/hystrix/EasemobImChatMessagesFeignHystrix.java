package com.union.aimei.common.feign.app.im.hystrix;

import com.union.aimei.common.feign.app.im.EasemobImChatMessagesFeign;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * IM聊天消息feign hystrix
 *
 * @author liurenkai
 * @time 2017/11/28 16:03
 */
@Component(value = "app-EasemobImChatMessagesFeign")
public class EasemobImChatMessagesFeignHystrix implements EasemobImChatMessagesFeign {

    @Override
    public ResponseMessage<ResponseResult> exportTime(String timeStr) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> exportLimit(long limit, String cursor, String query) {
        return HystrixResponse.invokeFail();
    }
}
