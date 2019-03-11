package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.common.vo.learn.pc.ActivityPushMemberVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface ActivityMapper extends BaseMapper<Activity> {

    /**
     * 查询活动前一天报名参加活动的会员
     *
     * @param map
     * @return
     */
    List<ActivityPushMemberVo> selectWillStartActivity(Map<String, Object> map);


    /**
     * 查询已经结束的活动
     *
     * @param
     * @return
     */
    void updateActivityStopStatus();

    /**
     * 查询要结束的活动的id集合
     *
     * @return
     */
    List<Integer> selectIdListWillStop();
}