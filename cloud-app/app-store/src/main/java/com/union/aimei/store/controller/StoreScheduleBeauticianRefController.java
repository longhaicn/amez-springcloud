package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import com.union.aimei.store.service.StoreScheduleBeauticianRefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 店铺排班-美容师-关联
 *
 * @author liurenkai
 * @time 2017/12/25 11:41
 */
@Api(tags = "店铺排班-美容师-关联")
@RestController
@RequestMapping(value = "storeScheduleBeauticianRef")
public class StoreScheduleBeauticianRefController {
    @Resource
    private StoreScheduleBeauticianRefService storeScheduleBeauticianRefService;

    /**
     * 前端分页查询店铺排班-美容师-关联
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页显示数量
     * @param storeScheduleBeauticianRef 查询条件
     * @return,
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺排班-美容师-关联")
    @PostMapping("/front/findByPage")
    public PageInfo<StoreScheduleBeauticianRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                   @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                   @ApiParam(value = "查询条件") @RequestBody StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return this.storeScheduleBeauticianRefService.findByPageForFront(pageNo, pageSize, storeScheduleBeauticianRef);
    }
}