package com.union.aimei.pc.api.product;

import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.feign.pc.product.ProductCategoryFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品分类
 *
 * @author liurenkai
 * @time 2018/1/5 19:26
 */
@Api(tags = "商品分类")
@RestController
@RequestMapping(value = "productCategory")
public class ProductCategoryApiController {
    @Resource
    private ProductCategoryFeign productCategoryFeign;

    /**
     * 分页查询商品分类
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param productCategory 查询条件
     * @return ResponseMessage<ProductCategory>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询商品分类")
    @PostMapping("/front/findByPage")
    public ResponseMessage<ProductCategory> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                               @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                               @ApiParam(value = "查询条件") @RequestBody ProductCategory productCategory) {
        return new ResponseMessage(productCategoryFeign.findByPageForFront(pageNo, pageSize, productCategory)); 
    }

    /**
     * 添加商品分类
     *
     * @param productCategory
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加商品分类")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody ProductCategory productCategory) {
        return new ResponseMessage(productCategoryFeign.insert(productCategory)); 
    }

    /**
     * 删除ProductCategory
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除商品分类")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productCategoryFeign.deleteById(id)); 
    }

    /**
     * 修改商品分类
     *
     * @param productCategory
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑商品分类")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody ProductCategory productCategory) {
        return new ResponseMessage(productCategoryFeign.edit(productCategory)); 
    }

    /**
     * 根据ID查询商品分类
     *
     * @param id
     * @returnproductCategory
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询商品分类")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<ProductCategory> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productCategoryFeign.queryById(id)); 
    }
}