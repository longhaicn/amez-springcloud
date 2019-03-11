package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreBeauticianLevelUpgradeLogFeign;
import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeLog;
import org.springframework.stereotype.Component;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Component(value = "pc-StoreBeauticianLevelUpgradeLogFeign")
public class StoreBeauticianLevelUpgradeLogApiHystrix implements StoreBeauticianLevelUpgradeLogFeign {

    /**
     * 前端分页查询美容师成长值记录
     *
     * @param pageNo                         分页索引
     * @param pageSize                       每页显示数量
     * @param storeBeauticianLevelUpgradeLog 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreBeauticianLevelUpgradeLog> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog) {
        return null;
    }

    /**
     * 添加美容师成长值记录
     *
     * @param storeBeauticianLevelUpgradeLog
     * @return
     */
    @Override
    public int insert(StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog) {
        return 0;
    }

    /**
     * 删除美容师成长值记录
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改美容师成长值记录
     *
     * @param storeBeauticianLevelUpgradeLog
     * @return
     */
    @Override
    public int edit(StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianLevelUpgradeLog
     */
    @Override
    public StoreBeauticianLevelUpgradeLog queryById(int id) {
        return null;
    }
}