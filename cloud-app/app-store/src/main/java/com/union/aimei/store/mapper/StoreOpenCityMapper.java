package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreOpenCity;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 门店开通城市
 *
 * @author liurenkai
 * @time 2018/1/12 19:02
 */
public interface StoreOpenCityMapper extends BaseMapper<StoreOpenCity> {

    /**
     * 所有门店开通城市
     *
     * @return
     */
    List<StoreOpenCity> listAll();
}