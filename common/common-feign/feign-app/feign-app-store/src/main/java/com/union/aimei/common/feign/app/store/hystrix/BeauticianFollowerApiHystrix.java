package com.union.aimei.common.feign.app.store.hystrix;

import com.union.aimei.common.feign.app.store.BeauticianFollowerFeign;
import com.union.aimei.common.model.store.BeauticianFollower;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 美容师粉丝
 *
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Component(value = "app-BeauticianFollowerFeign")
public class BeauticianFollowerApiHystrix implements BeauticianFollowerFeign {

    @Override
    public ResponseMessage followerV111(BeauticianFollower follower) {
        return HystrixResponse.invokeFail();
    }

}