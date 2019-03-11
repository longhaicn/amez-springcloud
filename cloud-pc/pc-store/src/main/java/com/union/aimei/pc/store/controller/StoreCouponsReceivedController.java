package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCouponsReceived;
import com.union.aimei.pc.store.service.StoreCouponsReceivedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺优惠券领取
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Api(tags = "店铺优惠券领取")
@RestController
@RequestMapping(value = "storeCouponsReceived")
public class StoreCouponsReceivedController {
    @Resource
    private StoreCouponsReceivedService storeCouponsReceivedService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreCouponsReceived> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                     Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                     Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreCouponsReceived storeCouponsReceived) {
        return this.storeCouponsReceivedService.findByPageForFront(pageNo, pageSize, storeCouponsReceived);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreCouponsReceived storeCouponsReceived) {
        return this.storeCouponsReceivedService.addObj(storeCouponsReceived);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeCouponsReceivedService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreCouponsReceived storeCouponsReceived) {
        return this.storeCouponsReceivedService.modifyObj(storeCouponsReceived);
    }

    @GetMapping("/queryById/{id}")
    public StoreCouponsReceived queryById(@PathVariable(value = "id") int id) {
        return this.storeCouponsReceivedService.queryObjById(id);
    }
}