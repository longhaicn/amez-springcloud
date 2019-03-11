package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.common.vo.learn.app.ActivityTopVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface ActivityMapper extends BaseMapper<Activity> {

    /**
     * 根据美容师id和活动id查询美容师是否可以报名活动
     * @param map
     * @return
     */
    Integer queryIdByActivityIdAndMemberId(Map<String,Integer> map);

    /**
     * 查询活动置顶帖子轮播图
     * @param activityTopVo
     * @return
     */
    List<ActivityTopVo> selectTopActivityList(ActivityTopVo activityTopVo);

}