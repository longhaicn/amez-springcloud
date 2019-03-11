package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.PhysicalCategory;
import com.union.aimei.pc.product.service.PhysicalCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "产品分类")
@RestController
@RequestMapping(value = "physicalCategory")
public class PhysicalCategoryController {
    @Resource
    private PhysicalCategoryService physicalCategoryService;

    @PostMapping("/front/findByPage")
    public PageInfo<PhysicalCategory> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                 Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                 Integer pageSize, @ApiParam(value = "查询条件") @RequestBody PhysicalCategory physicalCategory) {
        return this.physicalCategoryService.findByPageForFront(pageNo, pageSize, physicalCategory);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody PhysicalCategory physicalCategory) {
        return this.physicalCategoryService.addObj(physicalCategory);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.physicalCategoryService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody PhysicalCategory physicalCategory) {
        return this.physicalCategoryService.modifyObj(physicalCategory);
    }

    @GetMapping("/queryById/{id}")
    public PhysicalCategory queryById(@PathVariable(value = "id") int id) {
        return this.physicalCategoryService.queryObjById(id);
    }
}