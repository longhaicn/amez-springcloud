package com.union.aimei.store.service;

import com.union.aimei.common.model.store.BeauticianBusinessHour;
import com.union.aimei.common.vo.store.app.BeauticianBusinessHourByAddVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 美容师营业时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:02
 */
public interface BeauticianBusinessHourService {

    /**
     * 批量新增美容师营业时间
     *
     * @param beauticianBusinessHourList 美容师营业时间集合
     * @return
     */
    ResponseMessage addBatchV111(List<BeauticianBusinessHour> beauticianBusinessHourList);

    /**
     * 根据美容师ID删除美容师营业时间
     *
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage deleteByBeauticianIdV111(int beauticianId);

    /**
     * 根据美容师ID查询美容师营业时间
     *
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage<List<BeauticianBusinessHour>> findListByBeauticianIdV111(int beauticianId);

    /**
     * 新增美容师营业时间
     *
     * @param addVo 条件
     * @return
     */
    ResponseMessage addV111(BeauticianBusinessHourByAddVo addVo);

}