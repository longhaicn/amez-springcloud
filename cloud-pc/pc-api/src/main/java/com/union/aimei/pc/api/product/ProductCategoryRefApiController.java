package com.union.aimei.pc.api.product;

import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.aimei.common.feign.pc.product.ProductCategoryRefFeign;
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
 * @time 2018/1/5 19:12
 */
@Api(tags = "商品-商品分类-关联")
@RestController
@RequestMapping(value = "productCategoryRef")
public class ProductCategoryRefApiController {
    @Resource
    private ProductCategoryRefFeign productCategoryRefFeign;

    /**
     * 分页查询商品-商品分类-关联
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param productCategoryRef 查询条件
     * @return ResponseMessage<ProductCategoryRef>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询商品-商品分类-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<ProductCategoryRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @ApiParam(value = "查询条件") @RequestBody ProductCategoryRef productCategoryRef) {
        return new ResponseMessage(productCategoryRefFeign.findByPageForFront(pageNo, pageSize, productCategoryRef)); 
    }

    /**
     * 添加商品-商品分类-关联
     *
     * @param productCategoryRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加商品-商品分类-关联")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody ProductCategoryRef productCategoryRef) {
        return new ResponseMessage(productCategoryRefFeign.insert(productCategoryRef)); 
    }

    /**
     * 删除商品-商品分类-关联
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除商品-商品分类-关联")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productCategoryRefFeign.deleteById(id)); 
    }

    /**
     * 修改商品-商品分类-关联
     *
     * @param productCategoryRef
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑商品-商品分类-关联")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody ProductCategoryRef productCategoryRef) {
        return new ResponseMessage(productCategoryRefFeign.edit(productCategoryRef)); 
    }

    /**
     * 根据ID查询商品-商品分类-关联
     *
     * @param id
     * @returnproductCategoryRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询商品-商品分类-关联")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<ProductCategoryRef> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productCategoryRefFeign.queryById(id)); 
    }
}