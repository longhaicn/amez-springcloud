package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevelUpgradeLog;
import com.union.aimei.store.service.StoreLevelUpgradeLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 门店成长值记录
 *
 * @author liurenkai
 * @time 2018/4/11 14:40
 */
@Api(tags = "门店成长值记录", description = "api")
@RestController
@RequestMapping(value = "storeLevelUpgradeLog")
public class StoreLevelUpgradeLogController {
    @Resource
    private StoreLevelUpgradeLogService storeLevelUpgradeLogService;

    @ApiOperation(httpMethod = "POST", value = "前端分页查询门店成长值记录")
    @PostMapping("/front/findByPage")
    public PageInfo<StoreLevelUpgradeLog> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                     Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                     Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return this.storeLevelUpgradeLogService.findByPageForFront(pageNo, pageSize, storeLevelUpgradeLog);
    }

    @ApiOperation(httpMethod = "POST", value = "添加门店成长值记录")
    @PostMapping("/insert")
    public int insert(@RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return this.storeLevelUpgradeLogService.addObj(storeLevelUpgradeLog);
    }

    @ApiOperation(httpMethod = "GET", value = "删除门店成长值记录")
    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable int id) {
        return this.storeLevelUpgradeLogService.deleteObjById(id);
    }

    @ApiOperation(httpMethod = "POST", value = "编辑门店成长值记录")
    @PutMapping("/edit")
    public int edit(@RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return this.storeLevelUpgradeLogService.modifyObj(storeLevelUpgradeLog);
    }

    @ApiOperation(httpMethod = "GET", value = "通过ID查询门店成长值记录")
    @GetMapping("/queryById/{id}")
    public StoreLevelUpgradeLog queryById(@PathVariable int id) {
        return this.storeLevelUpgradeLogService.queryObjById(id);
    }
}