package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.PhysicalCategoryRef;
import com.union.aimei.pc.product.service.PhysicalCategoryRefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "产品-产品分类-关联")
@RestController
@RequestMapping(value = "physicalCategoryRef")
public class PhysicalCategoryRefController {
    @Resource
    private PhysicalCategoryRefService physicalCategoryRefService;

    @PostMapping("/front/findByPage")
    public PageInfo<PhysicalCategoryRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                    Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                    Integer pageSize, @ApiParam(value = "查询条件") @RequestBody PhysicalCategoryRef physicalCategoryRef) {
        return this.physicalCategoryRefService.findByPageForFront(pageNo, pageSize, physicalCategoryRef);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody PhysicalCategoryRef physicalCategoryRef) {
        return this.physicalCategoryRefService.addObj(physicalCategoryRef);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.physicalCategoryRefService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody PhysicalCategoryRef physicalCategoryRef) {
        return this.physicalCategoryRefService.modifyObj(physicalCategoryRef);
    }

    @GetMapping("/queryById/{id}")
    public PhysicalCategoryRef queryById(@PathVariable(value = "id") int id) {
        return this.physicalCategoryRefService.queryObjById(id);
    }
}