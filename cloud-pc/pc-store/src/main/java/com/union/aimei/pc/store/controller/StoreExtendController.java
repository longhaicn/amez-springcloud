package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreExtend;
import com.union.aimei.pc.store.service.StoreExtendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺扩展
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Api(tags = "店铺扩展")
@RestController
@RequestMapping(value = "storeExtend")
public class StoreExtendController {
    @Resource
    private StoreExtendService storeExtendService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreExtend> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                            Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                            Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreExtend storeExtend) {
        return this.storeExtendService.findByPageForFront(pageNo, pageSize, storeExtend);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreExtend storeExtend) {
        return this.storeExtendService.addObj(storeExtend);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeExtendService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreExtend storeExtend) {
        return this.storeExtendService.modifyObj(storeExtend);
    }

    @GetMapping("/queryById/{id}")
    public StoreExtend queryById(@PathVariable(value = "id") int id) {
        return this.storeExtendService.queryObjById(id);
    }
}