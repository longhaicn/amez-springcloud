package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeLog;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
public interface StoreBeauticianLevelUpgradeLogService extends SpringCloudBaseService<StoreBeauticianLevelUpgradeLog> {
    /**
     * 前端分页查询美容师成长值记录
     *
     * @param pageNo                         分页索引
     * @param pageSize                       每页显示数量
     * @param storeBeauticianLevelUpgradeLog 查询条件
     * @return
     */
    PageInfo<StoreBeauticianLevelUpgradeLog> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog);
}