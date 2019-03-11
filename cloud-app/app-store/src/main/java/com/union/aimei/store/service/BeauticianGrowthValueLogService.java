package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.BeauticianGrowthValueLog;
import com.union.common.utils.ResponseMessage;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/6/4 13:33
 */
public interface BeauticianGrowthValueLogService {

    /**
     * 保存美容师成长值记录
     *
     * @param beauticianGrowthValueLog 美容师成长值记录
     * @return
     */
    ResponseMessage<BeauticianGrowthValueLog> saveV111(BeauticianGrowthValueLog beauticianGrowthValueLog);

    /**
     * 根据美容师ID分页查询美容师成长值记录
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage<PageInfo<BeauticianGrowthValueLog>> listByBeauticianIdV111(Integer pageNo, Integer pageSize, int beauticianId);

}