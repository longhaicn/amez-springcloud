package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.BeauticianFollower;
import com.union.common.utils.base.BaseMapper;

import java.util.Map;

/**
 * 美容师粉丝
 *
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
public interface BeauticianFollowerMapper extends BaseMapper<BeauticianFollower> {

    /**
     * 是否关注
     *
     * @param condMap 条件
     * @return
     */
    boolean isFollower(Map<String, Object> condMap);

    /**
     * 查询美容师粉丝
     *
     * @param condMap 条件
     * @return
     */
    BeauticianFollower getByRefId(Map<String, Object> condMap);

}