package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeLog;
import com.union.aimei.pc.store.service.StoreBeauticianLevelUpgradeLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Api(tags = "美容师成长值记录")
@RestController
@RequestMapping(value = "storeBeauticianLevelUpgradeLog")
public class StoreBeauticianLevelUpgradeLogController {
    @Resource
    private StoreBeauticianLevelUpgradeLogService storeBeauticianLevelUpgradeLogService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreBeauticianLevelUpgradeLog> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                               Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                               Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog) {
        return this.storeBeauticianLevelUpgradeLogService.findByPageForFront(pageNo, pageSize, storeBeauticianLevelUpgradeLog);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog) {
        return this.storeBeauticianLevelUpgradeLogService.addObj(storeBeauticianLevelUpgradeLog);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeBeauticianLevelUpgradeLogService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog) {
        return this.storeBeauticianLevelUpgradeLogService.modifyObj(storeBeauticianLevelUpgradeLog);
    }

    @GetMapping("/queryById/{id}")
    public StoreBeauticianLevelUpgradeLog queryById(@PathVariable(value = "id") int id) {
        return this.storeBeauticianLevelUpgradeLogService.queryObjById(id);
    }
}