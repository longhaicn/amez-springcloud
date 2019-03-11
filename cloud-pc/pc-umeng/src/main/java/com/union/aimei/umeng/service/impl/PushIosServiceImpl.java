package com.union.aimei.umeng.service.impl;

import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import com.union.aimei.common.util.umeng.PushClient;
import com.union.aimei.umeng.config.BeauticianIosProperties;
import com.union.aimei.umeng.config.ConsumerIosProperties;
import com.union.aimei.umeng.config.ManagerIosProperties;
import com.union.aimei.umeng.mapper.BaseUmengPushHistoryMapper;
import com.union.aimei.umeng.service.PushIosService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author houji
 * @date 2018/3/10  17:24
 */
@Service("pushIosService")
class PushIosServiceImpl implements PushIosService {
    private PushClient client = new PushClient();

    @Autowired
    private ConsumerIosProperties consumerIosProperties;

    @Autowired
    private BeauticianIosProperties beauticianIosProperties;

    @Autowired
    private ManagerIosProperties managerIosProperties;

    @Resource
    private BaseUmengPushHistoryMapper baseUmengPushHistoryMapper;


    @Override
    public ResponseMessage sendMessage(BaseUmengPushTemplate baseUmengPushTemplate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        return result;
    }


    @Override
    public ResponseMessage testIOSBeautician(BaseUmengPushTemplate baseUmengPushTemplate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();

        return result;
    }
}
