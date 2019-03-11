package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreExtendOperationLogFeign;
import com.union.aimei.common.model.store.StoreExtendOperationLog;
import org.springframework.stereotype.Component;

/**
 * 店铺扩展操作日志
 *
 * @author liurenkai
 * @time 2018/4/11 14:29
 */
@Component(value = "app-StoreExtendOperationLogFeign")
public class StoreExtendOperationLogApiHystrix implements StoreExtendOperationLogFeign {

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
        return null;
    }

    /**
     * 添加店铺扩展操作日志
     *
     * @param storeExtendOperationLog
     * @return
     */
    @Override
    public int insert(StoreExtendOperationLog storeExtendOperationLog) {
        return 0;
    }

    /**
     * 删除店铺扩展操作日志
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺扩展操作日志
     *
     * @param storeExtendOperationLog
     * @return
     */
    @Override
    public int edit(StoreExtendOperationLog storeExtendOperationLog) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreExtendOperationLog
     */
    @Override
    public StoreExtendOperationLog queryById(int id) {
        return null;
    }
}