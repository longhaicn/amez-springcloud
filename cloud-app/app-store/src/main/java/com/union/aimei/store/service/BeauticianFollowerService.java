package com.union.aimei.store.service;

import com.union.aimei.common.model.store.BeauticianFollower;
import com.union.common.utils.ResponseMessage;

/**
 * 美容师粉丝
 *
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
public interface BeauticianFollowerService {

    /**
     * 关注美容师
     *
     * @param follower 美容师粉丝
     * @return
     */
    ResponseMessage followerV111(BeauticianFollower follower);

}