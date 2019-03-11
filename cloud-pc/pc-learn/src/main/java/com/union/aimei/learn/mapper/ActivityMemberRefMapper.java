package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.ActivityMemberRef;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface ActivityMemberRefMapper extends BaseMapper<ActivityMemberRef> {
    /**
     * 根据活动id的集合，批量查询参加活动的会员
     * @param list
     * @return
     */
    List<ActivityMemberRef> selectBatchByActivityIdList(List<Integer> list);


    /**
     * 根据活动id的，批量已经报名活动人员的状态
     * @param list
     */
    void updateBatchByActivityIdList(@Param("list")List<Integer> list);
}