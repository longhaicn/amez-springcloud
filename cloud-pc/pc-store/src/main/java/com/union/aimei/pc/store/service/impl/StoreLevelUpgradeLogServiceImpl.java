package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevelUpgradeLog;
import com.union.aimei.pc.store.mapper.StoreLevelUpgradeLogMapper;
import com.union.aimei.pc.store.service.StoreLevelUpgradeLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺成长值记录
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Service("storeLevelUpgradeLogService")
public class StoreLevelUpgradeLogServiceImpl implements StoreLevelUpgradeLogService {
    @Resource
    private StoreLevelUpgradeLogMapper storeLevelUpgradeLogMapper;

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
        PageHelper.startPage(pageNo, pageSize);
        List<StoreLevelUpgradeLog> list = this.storeLevelUpgradeLogMapper.selectListByConditions(storeLevelUpgradeLog);
        PageInfo<StoreLevelUpgradeLog> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加店铺成长值记录
     *
     * @param storeLevelUpgradeLog
     * @return
     */
    @Override
    public int addObj(StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return this.storeLevelUpgradeLogMapper.insertSelective(storeLevelUpgradeLog);
    }

    /**
     * 删除店铺成长值记录
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeLevelUpgradeLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺成长值记录
     *
     * @param storeLevelUpgradeLog
     * @return
     */
    @Override
    public int modifyObj(StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return this.storeLevelUpgradeLogMapper.updateByPrimaryKeySelective(storeLevelUpgradeLog);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreLevelUpgradeLog
     */
    @Override
    public StoreLevelUpgradeLog queryObjById(int id) {
        StoreLevelUpgradeLog model = this.storeLevelUpgradeLogMapper.selectByPrimaryKey(id);
        return model;
    }
}