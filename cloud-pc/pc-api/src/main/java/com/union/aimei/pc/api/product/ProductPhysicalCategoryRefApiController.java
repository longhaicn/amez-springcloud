package com.union.aimei.pc.api.product;

import com.union.aimei.common.model.product.ProductPhysicalCategoryRef;
import com.union.aimei.common.feign.pc.product.ProductPhysicalCategoryRefFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 产品-分类-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:25
 */
@Api(tags = "产品-分类-关联")
@RestController
@RequestMapping(value = "productPhysicalCategoryRef")
public class ProductPhysicalCategoryRefApiController {
    @Resource
    private ProductPhysicalCategoryRefFeign productPhysicalCategoryRefFeign;

    /**
     * 分页查询
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页显示数量
     * @param productPhysicalCategoryRef 查询条件
     * @return ResponseMessage<ProductPhysicalCategoryRef>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询产品-分类-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<ProductPhysicalCategoryRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                                  Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                  Integer pageSize, @ApiParam(value = "查询条件") @RequestBody ProductPhysicalCategoryRef productPhysicalCategoryRef) {
        return new ResponseMessage(productPhysicalCategoryRefFeign.findByPageForFront(pageNo, pageSize, productPhysicalCategoryRef)); 
    }

    /**
     * 添加ProductPhysicalCategoryRef
     *
     * @param productPhysicalCategoryRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加产品-分类-关联")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody ProductPhysicalCategoryRef productPhysicalCategoryRef) {
        return new ResponseMessage(productPhysicalCategoryRefFeign.insert(productPhysicalCategoryRef)); 
    }

    /**
     * 删除ProductPhysicalCategoryRef
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除产品-分类-关联")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productPhysicalCategoryRefFeign.deleteById(id)); 
    }

    /**
     * 修改ProductPhysicalCategoryRef
     *
     * @param productPhysicalCategoryRef
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑产品-分类-关联")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody ProductPhysicalCategoryRef productPhysicalCategoryRef) {
        return new ResponseMessage(productPhysicalCategoryRefFeign.edit(productPhysicalCategoryRef)); 
    }

    /**
     * 根据ID查询ProductPhysicalCategoryRef
     *
     * @param id
     * @returnproductPhysicalCategoryRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询产品-分类-关联")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<ProductPhysicalCategoryRef> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productPhysicalCategoryRefFeign.queryById(id)); 
    }
}