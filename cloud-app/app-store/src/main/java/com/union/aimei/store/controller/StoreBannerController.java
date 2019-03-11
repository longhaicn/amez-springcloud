package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBanner;
import com.union.aimei.store.service.StoreBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺图片
 *
 * @author liurenkai
 * @time 2018/4/11 14:40
 */
@Api(tags = "店铺图片表", description = "api")
@RestController
@RequestMapping(value = "storeBanner")
public class StoreBannerController {
    @Resource
    private StoreBannerService storeBannerService;

    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺图片表")
    @PostMapping("/front/findByPage")
    public PageInfo<StoreBanner> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                            Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                            Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreBanner storeBanner) {
        return this.storeBannerService.findByPageForFront(pageNo, pageSize, storeBanner);
    }

    @ApiOperation(httpMethod = "POST", value = "添加店铺图片表")
    @PostMapping("/insert")
    public int insert(@RequestBody StoreBanner storeBanner) {
        return this.storeBannerService.addObj(storeBanner);
    }

    @ApiOperation(httpMethod = "GET", value = "删除店铺图片表")
    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable int id) {
        return this.storeBannerService.deleteObjById(id);
    }

    @ApiOperation(httpMethod = "POST", value = "编辑店铺图片表")
    @PutMapping("/edit")
    public int edit(@RequestBody StoreBanner storeBanner) {
        return this.storeBannerService.modifyObj(storeBanner);
    }

    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺图片表")
    @GetMapping("/queryById/{id}")
    public StoreBanner queryById(@PathVariable int id) {
        return this.storeBannerService.queryObjById(id);
    }
}