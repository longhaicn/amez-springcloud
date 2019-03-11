package com.union.aimei.app.api.store;

import com.union.aimei.common.feign.app.store.StoreChainBrandFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2017/12/26 14:52
 */
@Api(tags = "门店连锁品牌")
@RestController
@RequestMapping(value = "storeChainBrand")
public class StoreChainBrandApiController {
    @Resource
    private StoreChainBrandFeign storeChainBrandFeign;
}