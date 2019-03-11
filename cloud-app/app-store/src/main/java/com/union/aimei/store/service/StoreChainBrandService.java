package com.union.aimei.store.service;

import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2017/12/26 14:43
 */
public interface StoreChainBrandService {

    /**
     * 所有门店连锁品牌列表
     *
     * @return
     */
    ResponseMessage<List<StoreChainBrand>> listAll();

}