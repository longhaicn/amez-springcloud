package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevelUpgradeLog;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 门店成长值记录
 *
 * @author liurenkai
 * @time 2018/4/11 14:39
 */
public interface StoreLevelUpgradeLogService extends SpringCloudBaseService<StoreLevelUpgradeLog> {
    /**
     * 前端分页查询门店成长值记录
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeLevelUpgradeLog 查询条件
     * @return
     */
    PageInfo<StoreLevelUpgradeLog> findByPageForFront(Integer pageNo, Integer pageSize, StoreLevelUpgradeLog storeLevelUpgradeLog);
}