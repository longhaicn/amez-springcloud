package com.union.aimei.common.feign.app.im.hystrix;

import com.union.aimei.common.feign.app.im.EasemobImChatFilesFeign;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * IM聊天文件feign hystrix
 *
 * @author liurenkai
 * @time 2017/11/28 16:03
 */
@Component(value = "app-EasemobImChatFilesFeign")
public class EasemobImChatFilesFeignHystrix implements EasemobImChatFilesFeign {

    @Override
    public ResponseMessage<ResponseResult> upload(CommonsMultipartFile multipartFile) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> download(String fileUUID, String shareSecret, boolean isThumbnail) {
        return HystrixResponse.invokeFail();
    }
}
