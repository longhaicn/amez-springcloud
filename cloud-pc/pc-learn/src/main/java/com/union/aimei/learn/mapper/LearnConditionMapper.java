package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.LearnCondition;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门槛
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface LearnConditionMapper extends BaseMapper<LearnCondition> {

    /**
     * 批量添加
     * @param list
     * @return
     */
    int addBatch(List<LearnCondition> list);

    /**
     * 批量删除
     * @param list
     * @return
     */
    int deleteByPrimaryKeyList(List<Integer> list);

    /**
     * 根据sourceId查询活动的门槛集合
     * @param sourceId
     * @return
     */
    List<Integer> queryIdListBySourceId(@Param("sourceId") Integer sourceId);


}