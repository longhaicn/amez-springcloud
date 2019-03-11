package com.union.aimei.umeng.service;

import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import com.union.common.utils.ResponseMessage;

/**
 * @author houji
 * @date 2018/3/10  17:24
 */
public interface PushIosService {

    /**
     * 推送消息
     * @param baseUmengPushTemplate
     * @return
     */
    ResponseMessage sendMessage(BaseUmengPushTemplate baseUmengPushTemplate);

    /**
     * 美容师测试
     * @param baseUmengPushTemplate
     * @return
     */
    ResponseMessage testIOSBeautician(BaseUmengPushTemplate baseUmengPushTemplate);

}
