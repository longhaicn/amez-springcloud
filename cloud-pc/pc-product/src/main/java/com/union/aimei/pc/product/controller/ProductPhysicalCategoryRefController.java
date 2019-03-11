package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysicalCategoryRef;
import com.union.aimei.pc.product.service.ProductPhysicalCategoryRefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 产品-分类-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:07
 */
@Api(tags = "产品-分类-关联")
@RestController
@RequestMapping(value = "productPhysicalCategoryRef")
public class ProductPhysicalCategoryRefController {
    @Resource
    private ProductPhysicalCategoryRefService productPhysicalCategoryRefService;

    @PostMapping("/front/findByPage")
    public PageInfo<ProductPhysicalCategoryRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                           Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                           Integer pageSize, @ApiParam(value = "查询条件") @RequestBody ProductPhysicalCategoryRef productPhysicalCategoryRef) {
        return this.productPhysicalCategoryRefService.findByPageForFront(pageNo, pageSize, productPhysicalCategoryRef);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ProductPhysicalCategoryRef productPhysicalCategoryRef) {
        return this.productPhysicalCategoryRefService.addObj(productPhysicalCategoryRef);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.productPhysicalCategoryRefService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ProductPhysicalCategoryRef productPhysicalCategoryRef) {
        return this.productPhysicalCategoryRefService.modifyObj(productPhysicalCategoryRef);
    }

    @GetMapping("/queryById/{id}")
    public ProductPhysicalCategoryRef queryById(@PathVariable(value = "id") int id) {
        return this.productPhysicalCategoryRefService.queryObjById(id);
    }
}