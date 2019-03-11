package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeLog;
import com.union.aimei.pc.store.mapper.StoreBeauticianLevelUpgradeLogMapper;
import com.union.aimei.pc.store.service.StoreBeauticianLevelUpgradeLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Service("storeBeauticianLevelUpgradeLogService")
public class StoreBeauticianLevelUpgradeLogServiceImpl implements StoreBeauticianLevelUpgradeLogService {
    @Resource
    private StoreBeauticianLevelUpgradeLogMapper storeBeauticianLevelUpgradeLogMapper;

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
        PageHelper.startPage(pageNo, pageSize);
        List<StoreBeauticianLevelUpgradeLog> list = this.storeBeauticianLevelUpgradeLogMapper.selectListByConditions(storeBeauticianLevelUpgradeLog);
        PageInfo<StoreBeauticianLevelUpgradeLog> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加美容师成长值记录
     *
     * @param storeBeauticianLevelUpgradeLog
     * @return
     */
    @Override
    public int addObj(StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog) {
        return this.storeBeauticianLevelUpgradeLogMapper.insertSelective(storeBeauticianLevelUpgradeLog);
    }

    /**
     * 删除美容师成长值记录
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeBeauticianLevelUpgradeLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改美容师成长值记录
     *
     * @param storeBeauticianLevelUpgradeLog
     * @return
     */
    @Override
    public int modifyObj(StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog) {
        return this.storeBeauticianLevelUpgradeLogMapper.updateByPrimaryKeySelective(storeBeauticianLevelUpgradeLog);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianLevelUpgradeLog
     */
    @Override
    public StoreBeauticianLevelUpgradeLog queryObjById(int id) {
        StoreBeauticianLevelUpgradeLog model = this.storeBeauticianLevelUpgradeLogMapper.selectByPrimaryKey(id);
        return model;
    }
}