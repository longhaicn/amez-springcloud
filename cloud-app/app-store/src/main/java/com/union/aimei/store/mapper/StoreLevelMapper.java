package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreLevel;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 门店级别
 *
 * @author liurenkai
 * @time 2017/12/27 15:45
 */
public interface StoreLevelMapper extends BaseMapper<StoreLevel> {

    /**
     * 删除所有门店级别
     *
     * @return
     */
    int deleteForAll();

    /**
     * 所有门店级别列表
     *
     * @return
     */
    List<StoreLevel> listAll();

}