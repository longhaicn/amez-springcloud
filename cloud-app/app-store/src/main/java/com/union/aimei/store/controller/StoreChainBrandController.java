package com.union.aimei.store.controller;

import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.aimei.store.service.StoreChainBrandService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2018/1/24 16:45
 */
@Api(tags = "门店连锁品牌")
@RestController
@RequestMapping(value = "storeChainBrand")
public class StoreChainBrandController {
    @Resource
    private StoreChainBrandService storeChainBrandService;

    /**
     * 所有门店连锁品牌列表
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "所有门店连锁品牌列表")
    @GetMapping("/listAll")
    public ResponseMessage<List<StoreChainBrand>> listAll() {
        return this.storeChainBrandService.listAll();
    }

}