package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreExtendOperationLog;
import com.union.aimei.pc.store.mapper.StoreExtendOperationLogMapper;
import com.union.aimei.pc.store.service.StoreExtendOperationLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺扩展操作日志
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Service("storeExtendOperationLogService")
public class StoreExtendOperationLogServiceImpl implements StoreExtendOperationLogService {
    @Resource
    private StoreExtendOperationLogMapper storeExtendOperationLogMapper;

    /**
     * 前端分页查询店铺扩展操作日志
     *
     * @param pageNo                  分页索引
     * @param pageSize                每页显示数量
     * @param storeExtendOperationLog 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreExtendOperationLog> findByPageForFront(Integer pageNo, Integer pageSize, StoreExtendOperationLog storeExtendOperationLog) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreExtendOperationLog> list = this.storeExtendOperationLogMapper.selectListByConditions(storeExtendOperationLog);
        PageInfo<StoreExtendOperationLog> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加店铺扩展操作日志
     *
     * @param storeExtendOperationLog
     * @return
     */
    @Override
    public int addObj(StoreExtendOperationLog storeExtendOperationLog) {
        return this.storeExtendOperationLogMapper.insertSelective(storeExtendOperationLog);
    }

    /**
     * 删除店铺扩展操作日志
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeExtendOperationLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺扩展操作日志
     *
     * @param storeExtendOperationLog
     * @return
     */
    @Override
    public int modifyObj(StoreExtendOperationLog storeExtendOperationLog) {
        return this.storeExtendOperationLogMapper.updateByPrimaryKeySelective(storeExtendOperationLog);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreExtendOperationLog
     */
    @Override
    public StoreExtendOperationLog queryObjById(int id) {
        StoreExtendOperationLog model = this.storeExtendOperationLogMapper.selectByPrimaryKey(id);
        return model;
    }
}