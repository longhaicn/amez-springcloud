package com.union.aimei.store.service.impl;

import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.model.store.BeauticianBusinessHour;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.store.app.BeauticianBusinessHourByAddVo;
import com.union.aimei.store.mapper.BeauticianBusinessHourMapper;
import com.union.aimei.store.mapper.StoreBeauticianMapper;
import com.union.aimei.store.service.BeauticianBusinessHourService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 美容师营业时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:03
 */
@Service("beauticianBusinessHourService")
public class BeauticianBusinessHourServiceImpl implements BeauticianBusinessHourService {
    @Resource
    private BeauticianBusinessHourMapper beauticianBusinessHourMapper;
    @Resource
    private StoreBeauticianMapper storeBeauticianMapper;

    @Override
    public ResponseMessage addBatchV111(List<BeauticianBusinessHour> beauticianBusinessHourList) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.beauticianBusinessHourMapper.addBatch(beauticianBusinessHourList);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteByBeauticianIdV111(int beauticianId) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.beauticianBusinessHourMapper.deleteByBeauticianId(beauticianId);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<BeauticianBusinessHour>> findListByBeauticianIdV111(int beauticianId) {
        ResponseMessage<List<BeauticianBusinessHour>> responseMessage = new ResponseMessage<>();
        BeauticianBusinessHour bbhCond = new BeauticianBusinessHour();
        bbhCond.setBeauticianId(beauticianId);
        List<BeauticianBusinessHour> list = this.beauticianBusinessHourMapper.selectListByConditions(bbhCond);
        if (list.isEmpty()) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_BUSINESS_HOUR_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_BUSINESS_HOUR_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(list);
        return responseMessage;
    }


    @Override
    public ResponseMessage addV111(BeauticianBusinessHourByAddVo addVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 美容师
        StoreBeautician beautician = new StoreBeautician();
        beautician.setId(addVo.getBeauticianId());
        beautician.setStartBusinessHour(addVo.getStartTime());
        beautician.setEndBusinessHour(addVo.getEndTime());
        String[] workDayArr = addVo.getWorkday().split(",");
        Set<Integer> workDayIntSet = new HashSet<>();
        for (int i = 0; i < workDayArr.length; i++) {
            workDayIntSet.add(Integer.valueOf(workDayArr[i]));
        }
        Integer[] workDayIntArr = workDayIntSet.toArray(new Integer[]{});
        Arrays.sort(workDayIntArr);
        StringBuffer workDayBuffer = new StringBuffer();
        for (int i = 0; i < workDayIntArr.length; i++) {
            if (i > 0) {
                workDayBuffer.append(",");
            }
            workDayBuffer.append(workDayIntArr[i]);
        }
        beautician.setWorkday(workDayBuffer.toString());
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        return responseMessage;
    }

}