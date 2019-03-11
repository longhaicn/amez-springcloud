package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.aimei.pc.product.service.ProductCategoryRefService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品-商品分类-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:04
 */
@Api(tags = "商品-商品分类-关联")
@RestController
@RequestMapping(value = "productCategoryRef")
public class ProductCategoryRefController {
    @Resource
    private ProductCategoryRefService productCategoryRefService;

    @PostMapping("/front/findByPage")
    public PageInfo<ProductCategoryRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                           @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                           @ApiParam(value = "查询条件") @RequestBody ProductCategoryRef productCategoryRef) {
        return this.productCategoryRefService.findByPageForFront(pageNo, pageSize, productCategoryRef);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ProductCategoryRef productCategoryRef) {
        return this.productCategoryRefService.addObj(productCategoryRef);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.productCategoryRefService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ProductCategoryRef productCategoryRef) {
        return this.productCategoryRefService.modifyObj(productCategoryRef);
    }

    @GetMapping("/queryById/{id}")
    public ProductCategoryRef queryById(@PathVariable(value = "id") int id) {
        return this.productCategoryRefService.queryObjById(id);
    }

    /**
     * 新增商品-商品分类-关联
     *
     * @param productCategoryRef 商品-商品分类-关联
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增商品-商品分类-关联")
    @PostMapping("/add")
    public ResponseMessage add(@ApiParam(value = "商品-商品分类-关联") @RequestBody ProductCategoryRef productCategoryRef) {
        return this.productCategoryRefService.add(productCategoryRef);
    }

}