package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.GrowthRuleLog;
import com.union.aimei.store.service.GrowthRuleLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "成长规则日志表")
@RestController
@RequestMapping(value = "growthRuleLog")
public class GrowthRuleLogController {
    @Resource
    private GrowthRuleLogService growthRuleLogService;

    @PostMapping("/front/findByPage")
    public PageInfo<GrowthRuleLog> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                              Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                              Integer pageSize, @ApiParam(value = "查询条件") @RequestBody GrowthRuleLog growthRuleLog) {
        return this.growthRuleLogService.findByPageForFront(pageNo, pageSize, growthRuleLog);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody GrowthRuleLog growthRuleLog) {
        return this.growthRuleLogService.addObj(growthRuleLog);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.growthRuleLogService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody GrowthRuleLog growthRuleLog) {
        return this.growthRuleLogService.modifyObj(growthRuleLog);
    }

    @GetMapping("/queryById/{id}")
    public GrowthRuleLog queryById(@PathVariable(value = "id") int id) {
        return this.growthRuleLogService.queryObjById(id);
    }
}