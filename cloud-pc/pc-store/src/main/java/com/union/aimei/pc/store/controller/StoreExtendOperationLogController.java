package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreExtendOperationLog;
import com.union.aimei.pc.store.service.StoreExtendOperationLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺扩展操作日志
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Api(tags = "店铺扩展操作日志")
@RestController
@RequestMapping(value = "storeExtendOperationLog")
public class StoreExtendOperationLogController {
    @Resource
    private StoreExtendOperationLogService storeExtendOperationLogService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreExtendOperationLog> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                        Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                        Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreExtendOperationLog storeExtendOperationLog) {
        return this.storeExtendOperationLogService.findByPageForFront(pageNo, pageSize, storeExtendOperationLog);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreExtendOperationLog storeExtendOperationLog) {
        return this.storeExtendOperationLogService.addObj(storeExtendOperationLog);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeExtendOperationLogService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreExtendOperationLog storeExtendOperationLog) {
        return this.storeExtendOperationLogService.modifyObj(storeExtendOperationLog);
    }

    @GetMapping("/queryById/{id}")
    public StoreExtendOperationLog queryById(@PathVariable(value = "id") int id) {
        return this.storeExtendOperationLogService.queryObjById(id);
    }
}