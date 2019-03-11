package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.BeauticianBusinessHour;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 美容师营业时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:01
 */
public interface BeauticianBusinessHourMapper extends BaseMapper<BeauticianBusinessHour> {

    /**
     * 批量新增美容师营业时间
     *
     * @param beauticianBusinessHourList 美容师营业时间集合
     * @return
     */
    int addBatch(@Param(value = "beauticianBusinessHourList") List<BeauticianBusinessHour> beauticianBusinessHourList);

    /**
     * 根据美容师ID删除美容师营业时间
     *
     * @param beauticianId 美容师ID
     * @return
     */
    int deleteByBeauticianId(@Param(value = "beauticianId") int beauticianId);

}