package com.union.aimei.umeng.service.impl;

import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import com.union.aimei.common.util.umeng.PushClient;
import com.union.aimei.umeng.service.PushAndroidService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import org.springframework.stereotype.Service;


/**
 * @author houji
 * @date 2018/3/9  14:46
 */
@Service("pushAndroidService")
public class PushAndroidServiceImpl implements PushAndroidService {

    private PushClient client = new PushClient();


    @Override
    public ResponseMessage sendMessage(BaseUmengPushTemplate baseUmengPushTemplate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        return result;
    }

}
