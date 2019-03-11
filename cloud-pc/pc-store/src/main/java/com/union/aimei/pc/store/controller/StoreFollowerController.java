package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.pc.store.service.StoreFollowerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺粉丝
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Api(tags = "店铺粉丝")
@RestController
@RequestMapping(value = "storeFollower")
public class StoreFollowerController {
    @Resource
    private StoreFollowerService storeFollowerService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreFollower> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                              Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                              Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreFollower storeFollower) {
        return this.storeFollowerService.findByPageForFront (pageNo, pageSize, storeFollower);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreFollower storeFollower) {
        return this.storeFollowerService.addObj (storeFollower);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeFollowerService.deleteObjById (id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreFollower storeFollower) {
        return this.storeFollowerService.modifyObj (storeFollower);
    }

    @GetMapping("/queryById/{id}")
    public StoreFollower queryById(@PathVariable(value = "id") int id) {
        return this.storeFollowerService.queryObjById (id);
    }


}