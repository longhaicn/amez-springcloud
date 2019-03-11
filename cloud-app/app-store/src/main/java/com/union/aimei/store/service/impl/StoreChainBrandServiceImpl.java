package com.union.aimei.store.service.impl;

import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.aimei.store.mapper.StoreChainBrandMapper;
import com.union.aimei.store.service.StoreChainBrandService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2017/12/26 14:44
 */
@Service("storeChainBrandService")
public class StoreChainBrandServiceImpl implements StoreChainBrandService {
    @Resource
    private StoreChainBrandMapper storeChainBrandMapper;

    @Override
    public ResponseMessage<List<StoreChainBrand>> listAll() {
        ResponseMessage<List<StoreChainBrand>> responseMessage = new ResponseMessage<>();
        List<StoreChainBrand> storeChainBrandList = this.storeChainBrandMapper.listAll();
        if (CollectionUtils.isEmpty(storeChainBrandList)) {
            throw new ResponseException(StoreConstant.Query.STORE_CHAIN_BRAND_NULL, StoreConstant.Query.STORE_CHAIN_BRAND_NULL_MSG);
        }
        responseMessage.setData(storeChainBrandList);
        return responseMessage;
    }
    
}