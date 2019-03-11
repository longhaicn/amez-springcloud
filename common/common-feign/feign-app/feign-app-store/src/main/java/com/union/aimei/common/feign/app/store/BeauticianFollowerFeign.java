package com.union.aimei.common.feign.app.store;

import com.union.aimei.common.feign.app.store.hystrix.BeauticianFollowerApiHystrix;
import com.union.aimei.common.model.store.BeauticianFollower;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 美容师粉丝
 *
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = BeauticianFollowerApiHystrix.class)
public interface BeauticianFollowerFeign {

    /**
     * 关注美容师
     *
     * @param follower 美容师粉丝
     * @return
     */
    @PostMapping("/beauticianFollower/1.1.1/follower")
    ResponseMessage followerV111(@RequestBody BeauticianFollower follower);

}