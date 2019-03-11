package com.union.aimei.common.feign.app.store;

import com.union.aimei.common.feign.app.store.hystrix.StoreChainBrandApiHystrix;
import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2018/1/24 16:46
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreChainBrandApiHystrix.class)
public interface StoreChainBrandFeign {

    /**
     * 所有门店连锁品牌列表
     *
     * @return
     */
    @GetMapping("/storeChainBrand/listAll")
    ResponseMessage<List<StoreChainBrand>> listAll();

}