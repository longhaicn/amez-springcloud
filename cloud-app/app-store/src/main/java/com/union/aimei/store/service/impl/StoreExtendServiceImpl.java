package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreExtend;
import com.union.aimei.common.model.store.StoreExtendOperationLog;
import com.union.aimei.store.mapper.StoreExtendMapper;
import com.union.aimei.store.mapper.StoreExtendOperationLogMapper;
import com.union.aimei.store.service.StoreExtendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 店铺扩展 service impl
 *
 * @author liurenkai
 * @time 2017/12/19 19:17
 */
@Service("storeExtendService")
public class StoreExtendServiceImpl implements StoreExtendService {
    @Resource
    private StoreExtendMapper storeExtendMapper;
    @Resource
    private StoreExtendOperationLogMapper storeExtendOperationLogMapper;

    /**
     * 前端分页查询店铺扩展
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param storeExtend 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreExtend> findByPageForFront(Integer pageNo, Integer pageSize, StoreExtend storeExtend) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreExtend> list = this.storeExtendMapper.selectListByConditions(storeExtend);
        PageInfo<StoreExtend> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加店铺扩展
     *
     * @param storeExtend
     * @return
     */
    @Override
    public int addObj(StoreExtend t) {
        return this.storeExtendMapper.insertSelective(t);
    }

    /**
     * 删除店铺扩展
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeExtendMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺扩展
     *
     * @param storeExtend
     * @return
     */
    @Override
    public int modifyObj(StoreExtend storeExtend) {
        StoreExtend oldStoreExtend = this.storeExtendMapper.selectByPrimaryKey(storeExtend.getId());
        int seResult = this.storeExtendMapper.updateByPrimaryKeySelective(storeExtend);
        if (seResult > 0) {
            //TODO 需要获取当前登录用户信息
            StoreExtendOperationLog storeExtendOperationLog = new StoreExtendOperationLog();
            storeExtendOperationLog.setStoreId(storeExtend.getStoreId());
            storeExtendOperationLog.setContent("");
            storeExtendOperationLog.setOldValue(oldStoreExtend.toString());
            storeExtendOperationLog.setNewValue(storeExtend.toString());
            storeExtendOperationLog.setOperationUserId(null);
            storeExtendOperationLog.setOperationLoginName("");
            storeExtendOperationLog.setOperationTime(new Date());
            this.storeExtendOperationLogMapper.insertSelective(storeExtendOperationLog);
        }
        return seResult;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreExtend
     */
    @Override
    public StoreExtend queryObjById(int id) {
        StoreExtend model = this.storeExtendMapper.selectByPrimaryKey(id);
        return model;
    }
}