package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreLevelUpgradeLogFeign;
import com.union.aimei.common.model.store.StoreLevelUpgradeLog;
import org.springframework.stereotype.Component;

/**
 * 店铺成长值记录
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Component(value = "pc-StoreLevelUpgradeLogFeign")
public class StoreLevelUpgradeLogApiHystrix implements StoreLevelUpgradeLogFeign {

    /**
     * 前端分页查询店铺成长值记录
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeLevelUpgradeLog 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreLevelUpgradeLog> findByPageForFront(Integer pageNo, Integer pageSize, StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return null;
    }

    /**
     * 添加店铺成长值记录
     *
     * @param storeLevelUpgradeLog
     * @return
     */
    @Override
    public int insert(StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return 0;
    }

    /**
     * 删除店铺成长值记录
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺成长值记录
     *
     * @param storeLevelUpgradeLog
     * @return
     */
    @Override
    public int edit(StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreLevelUpgradeLog
     */
    @Override
    public StoreLevelUpgradeLog queryById(int id) {
        return null;
    }
}