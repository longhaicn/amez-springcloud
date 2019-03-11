package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevelUpgradeLog;
import com.union.aimei.pc.store.service.StoreLevelUpgradeLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺成长值记录
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Api(tags = "店铺成长值记录")
@RestController
@RequestMapping(value = "storeLevelUpgradeLog")
public class StoreLevelUpgradeLogController {
    @Resource
    private StoreLevelUpgradeLogService storeLevelUpgradeLogService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreLevelUpgradeLog> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                     Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                     Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return this.storeLevelUpgradeLogService.findByPageForFront(pageNo, pageSize, storeLevelUpgradeLog);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return this.storeLevelUpgradeLogService.addObj(storeLevelUpgradeLog);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeLevelUpgradeLogService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return this.storeLevelUpgradeLogService.modifyObj(storeLevelUpgradeLog);
    }

    @GetMapping("/queryById/{id}")
    public StoreLevelUpgradeLog queryById(@PathVariable(value = "id") int id) {
        return this.storeLevelUpgradeLogService.queryObjById(id);
    }
}