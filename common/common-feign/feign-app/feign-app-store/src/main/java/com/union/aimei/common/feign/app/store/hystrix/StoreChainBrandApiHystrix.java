package com.union.aimei.common.feign.app.store.hystrix;

import com.union.aimei.common.feign.app.store.StoreChainBrandFeign;
import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2018/4/11 14:29
 */
@Component(value = "app-StoreChainBrandFeign")
public class StoreChainBrandApiHystrix implements StoreChainBrandFeign {

    @Override
    public ResponseMessage<List<StoreChainBrand>> listAll() {
        return HystrixResponse.invokeFail();
    }

}