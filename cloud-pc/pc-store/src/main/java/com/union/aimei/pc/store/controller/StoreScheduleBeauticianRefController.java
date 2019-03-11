package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import com.union.aimei.pc.store.service.StoreScheduleBeauticianRefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺排班-美容师-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Api(tags = "店铺排班-美容师-关联")
@RestController
@RequestMapping(value = "storeScheduleBeauticianRef")
public class StoreScheduleBeauticianRefController {
    @Resource
    private StoreScheduleBeauticianRefService storeScheduleBeauticianRefService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreScheduleBeauticianRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                           Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                           Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return this.storeScheduleBeauticianRefService.findByPageForFront(pageNo, pageSize, storeScheduleBeauticianRef);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return this.storeScheduleBeauticianRefService.addObj(storeScheduleBeauticianRef);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeScheduleBeauticianRefService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return this.storeScheduleBeauticianRefService.modifyObj(storeScheduleBeauticianRef);
    }

    @GetMapping("/queryById/{id}")
    public StoreScheduleBeauticianRef queryById(@PathVariable(value = "id") int id) {
        return this.storeScheduleBeauticianRefService.queryObjById(id);
    }
}