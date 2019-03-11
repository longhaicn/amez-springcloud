package com.union.aimei.umeng.service;

import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import com.union.common.utils.ResponseMessage;

/**
 * @author houji
 * @date 2018/3/9  14:46
 */
public interface PushAndroidService {

    /**
     * 推送消息
     * @param baseUmengPushTemplate
     * @return
     */
    public ResponseMessage sendMessage(BaseUmengPushTemplate baseUmengPushTemplate);

}
