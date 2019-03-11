package com.union.aimei.pc.store.mapper;

import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.common.vo.store.pc.StoreLevelByBatchVo;
import com.union.common.utils.base.BaseMapper;

/**
 * 店铺等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
public interface StoreLevelMapper extends BaseMapper<StoreLevel> {

    /**
     * 删除所有店铺等级
     *
     * @return
     */
    int deleteByAll();

    /**
     * 批量添加店铺等级
     *
     * @param storeLevelByBatchVo
     * @return
     */
    int addByBatch(StoreLevelByBatchVo storeLevelByBatchVo);

}