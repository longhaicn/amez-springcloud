package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreSchedule;
import com.union.aimei.pc.store.service.StoreScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺排班
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Api(tags = "店铺排班")
@RestController
@RequestMapping(value = "storeSchedule")
public class StoreScheduleController {
    @Resource
    private StoreScheduleService storeScheduleService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreSchedule> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                              Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                              Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreSchedule storeSchedule) {
        return this.storeScheduleService.findByPageForFront(pageNo, pageSize, storeSchedule);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreSchedule storeSchedule) {
        return this.storeScheduleService.addObj(storeSchedule);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeScheduleService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreSchedule storeSchedule) {
        return this.storeScheduleService.modifyObj(storeSchedule);
    }

    @GetMapping("/queryById/{id}")
    public StoreSchedule queryById(@PathVariable(value = "id") int id) {
        return this.storeScheduleService.queryObjById(id);
    }
}