package com.union.aimei.umeng.mapper;

import com.union.aimei.common.model.umeng.BaseUmengPushHistory;
import com.union.common.utils.base.BaseMapper;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface BaseUmengPushHistoryMapper extends BaseMapper<BaseUmengPushHistory> {

    /**
     * 根据会员id和通知类型把会员得所有通知改为已经读取
     * @param baseUmengPushHistory
     * @return
     */
    int updateReadStatus(BaseUmengPushHistory baseUmengPushHistory);

}