package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.pc.product.service.ProductCategoryService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类
 *
 * @author liurenkai
 * @time 2018/1/5 19:04
 */
@Api(tags = "商品分类")
@RestController
@RequestMapping(value = "productCategory")
public class ProductCategoryController {
    @Resource
    private ProductCategoryService productCategoryService;

    @PostMapping("/front/findByPage")
    public PageInfo<ProductCategory> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                        @ApiParam(value = "查询条件") @RequestBody ProductCategory productCategory) {
        return this.productCategoryService.findByPageForFront(pageNo, pageSize, productCategory);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ProductCategory productCategory) {
        return this.productCategoryService.addObj(productCategory);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.productCategoryService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ProductCategory productCategory) {
        return this.productCategoryService.modifyObj(productCategory);
    }

    @GetMapping("/queryById/{id}")
    public ProductCategory queryById(@PathVariable(value = "id") int id) {
        return this.productCategoryService.queryObjById(id);
    }

    /**
     * 批量根据ID查询商品分类(v1.1.0)
     *
     * @param idBatchVo 批量ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量根据ID查询商品分类(v1.1.0)")
    @PostMapping("/1.1.0/findListByIdBatch")
    public ResponseMessage<List<ProductCategory>> findListByIdBatchV110(@ApiParam(value = "批量ID") @RequestBody IdBatchVo idBatchVo) {
        return this.productCategoryService.findListByIdBatchV110 (idBatchVo);
    }
}