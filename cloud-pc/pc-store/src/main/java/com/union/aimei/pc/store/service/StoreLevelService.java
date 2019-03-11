package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.common.vo.store.pc.StoreLevelByBatchVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 店铺等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
public interface StoreLevelService extends SpringCloudBaseService<StoreLevel> {
    /**
     * 分页查询店铺等级
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param storeLevel 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreLevel>> findByPageForFront(Integer pageNo, Integer pageSize, StoreLevel storeLevel);

    /**
     * 批量添加店铺
     *
     * @param storeLevelByBatchVo
     * @return
     */
    ResponseMessage addByBatch(StoreLevelByBatchVo storeLevelByBatchVo);

    /**
     * 查询所有店铺等级
     *
     * @return
     */
    ResponseMessage<List<StoreLevel>> findListByAll();

}