package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.BeauticianFollower;
import com.union.aimei.pc.store.service.BeauticianFollowerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "美容师粉丝")
@RestController
@RequestMapping(value = "beauticianFollower")
public class BeauticianFollowerController {
    @Resource
    private BeauticianFollowerService beauticianFollowerService;

    @PostMapping("/front/findByPage")
    public PageInfo<BeauticianFollower> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                   Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                   Integer pageSize, @ApiParam(value = "查询条件") @RequestBody BeauticianFollower beauticianFollower) {
        return this.beauticianFollowerService.findByPageForFront(pageNo, pageSize, beauticianFollower);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody BeauticianFollower beauticianFollower) {
        return this.beauticianFollowerService.addObj(beauticianFollower);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.beauticianFollowerService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody BeauticianFollower beauticianFollower) {
        return this.beauticianFollowerService.modifyObj(beauticianFollower);
    }

    @GetMapping("/queryById/{id}")
    public BeauticianFollower queryById(@PathVariable(value = "id") int id) {
        return this.beauticianFollowerService.queryObjById(id);
    }
}