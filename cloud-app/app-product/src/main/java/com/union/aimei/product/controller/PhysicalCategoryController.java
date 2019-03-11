package com.union.aimei.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.PhysicalCategory;
import com.union.aimei.product.service.PhysicalCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    /**
     * 获取所有产品分类数据
     *
     * @param physicalCategory
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "获取所有产品分类数据")
    @PostMapping("/1.1.1/front/findByForFront")
    public PageInfo<PhysicalCategory> findByForFrontV111(@ApiParam(value = "查询条件") @RequestBody PhysicalCategory physicalCategory) {
        return this.physicalCategoryService.findByForFrontV111(physicalCategory);
    }

}