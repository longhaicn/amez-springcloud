package com.union.aimei.store.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.union.aimei.common.model.store.BeauticianFollower;
import com.union.aimei.store.mapper.BeauticianFollowerMapper;
import com.union.aimei.store.mapper.StoreBeauticianMapper;
import com.union.aimei.store.service.BeauticianFollowerService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 美容师粉丝
 *
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Service("beauticianFollowerService")
public class BeauticianFollowerServiceImpl implements BeauticianFollowerService {

    @Resource
    private BeauticianFollowerMapper beauticianFollowerMapper;
    @Resource
    private StoreBeauticianMapper storeBeauticianMapper;

    @Override
    public ResponseMessage followerV111(BeauticianFollower follower) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 美容师粉丝
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(follower), Map.class);
        BeauticianFollower oldFollower = this.beauticianFollowerMapper.getByRefId(condMap);
        Boolean followerFlag = null;
        if (null == oldFollower) {
            this.beauticianFollowerMapper.insertSelective(follower);
            if (follower.getIsFollower()) {
                followerFlag = follower.getIsFollower();
            }
        } else {
            if (!follower.getIsFollower().equals(oldFollower.getIsFollower())) {
                oldFollower.setIsFollower(follower.getIsFollower());
                this.beauticianFollowerMapper.updateByPrimaryKeySelective(oldFollower);
                followerFlag = follower.getIsFollower();
            }
        }
        if (null != followerFlag) {
            Map<String, Object> updateMap = new HashMap<>(16);
            updateMap.put("beauticianId", follower.getBeauticianId());
            updateMap.put("addNumber", followerFlag ? 1 : -1);
            this.storeBeauticianMapper.updateFollowerNumber(updateMap);
        }
        return responseMessage;
    }

}