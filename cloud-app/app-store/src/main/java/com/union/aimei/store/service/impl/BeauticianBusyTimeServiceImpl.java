package com.union.aimei.store.service.impl;

import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.model.store.BeauticianBusyTime;
import com.union.aimei.store.mapper.BeauticianBusyTimeMapper;
import com.union.aimei.store.service.BeauticianBusyTimeService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 美容师忙碌时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:03
 */
@Service("beauticianBusyTimeService")
public class BeauticianBusyTimeServiceImpl implements BeauticianBusyTimeService {
    @Resource
    private BeauticianBusyTimeMapper beauticianBusyTimeMapper;

    @Override
    public ResponseMessage addV111(BeauticianBusyTime beauticianBusyTime) {
        ResponseMessage responseMessage = new ResponseMessage();
        ResponseMessage deleteRes = this.deleteByBeauticianIdForBusyDateV111(beauticianBusyTime.getBeauticianId(), beauticianBusyTime.getBusyDate());
        if (ResponseUtil.isFail(deleteRes)) {
            return deleteRes;
        }
        int result = this.beauticianBusyTimeMapper.insertSelective(beauticianBusyTime);
        responseMessage.setData(result);
        return responseMessage;
    }


    @Override
    public ResponseMessage deleteByBeauticianIdForBusyDateV111(int beauticianId, String busyDate) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("beauticianId", beauticianId);
        condMap.put("busyDate", busyDate);
        int result = this.beauticianBusyTimeMapper.deleteByBeauticianIdForBusyDate(condMap);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage<BeauticianBusyTime> findByBeauticianIdForBusyDateV111(int beauticianId, String busyDate) {
        ResponseMessage<BeauticianBusyTime> responseMessage = new ResponseMessage<>();
        BeauticianBusyTime bbtCond = new BeauticianBusyTime();
        bbtCond.setBeauticianId(beauticianId);
        bbtCond.setBusyDate(busyDate);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("beauticianId", beauticianId);
        condMap.put("busyDate", busyDate);
        BeauticianBusyTime beauticianBusyTime = this.beauticianBusyTimeMapper.selectByBeauticianIdForBusyDate(condMap);
        if (null == beauticianBusyTime) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_BUSY_TIME_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_BUSY_TIME_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(beauticianBusyTime);
        return responseMessage;
    }

}