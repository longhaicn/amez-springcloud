package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.BeauticianBusyTime;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 美容师忙碌时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:02
 */
public interface BeauticianBusyTimeMapper extends BaseMapper<BeauticianBusyTime> {

    /**
     * 批量新增美容师忙碌时间
     *
     * @param list 美容师忙碌时间集合
     * @return
     */
    int addBatch(@Param(value = "list") List<BeauticianBusyTime> list);

    /**
     * 根据忙碌日期删除美容师忙碌时间
     *
     * @param condMap 条件
     * @return
     */
    int deleteByBeauticianIdForBusyDate(Map<String, Object> condMap);

    /**
     * 根据忙碌日期查询美容师忙碌时间
     *
     * @param condMap 条件
     * @return
     */
    BeauticianBusyTime selectByBeauticianIdForBusyDate(Map<String, Object> condMap);

    /**
     * 根据忙碌日期查询美容师集合的忙碌时间
     *
     * @param condMap 条件
     * @return
     */
    List<BeauticianBusyTime> listBeauticianListByBusyDate(Map<String, Object> condMap);

}