package com.union.aimei.store.service;

import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.common.vo.store.app.StoreLevelVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 门店级别
 *
 * @author liurenkai
 * @time 2017/12/27 14:29
 */
public interface StoreLevelService {

    /**
     * 新增门店级别
     *
     * @param storeLevelVo 门店级别vo
     * @return
     */
    ResponseMessage add(StoreLevelVo storeLevelVo);

    /**
     * 查询门店级别
     *
     * @return
     */
    ResponseMessage<List<StoreLevel>> findList();
}