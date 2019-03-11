package com.union.aimei.pc.api.product;

import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.common.feign.pc.product.ProductPhysicalBeauticianRefFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:25
 */
@Api(tags = "产品-美容师-关联")
@RestController
@RequestMapping(value = "productPhysicalBeauticianRef")
public class ProductPhysicalBeauticianRefApiController {
    @Resource
    private ProductPhysicalBeauticianRefFeign productPhysicalBeauticianRefFeign;

    /**
     * 分页查询
     *
     * @param pageNo                       分页索引
     * @param pageSize                     每页显示数量
     * @param productPhysicalBeauticianRef 查询条件
     * @return ResponseMessage<ProductPhysicalBeauticianRef>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询产品-美容师-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<ProductPhysicalBeauticianRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                                    Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                    Integer pageSize, @ApiParam(value = "查询条件") @RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return new ResponseMessage(productPhysicalBeauticianRefFeign.findByPageForFront(pageNo, pageSize, productPhysicalBeauticianRef)); 
    }

    /**
     * 添加ProductPhysicalBeauticianRef
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加产品-美容师-关联")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return new ResponseMessage(productPhysicalBeauticianRefFeign.insert(productPhysicalBeauticianRef)); 
    }

    /**
     * 删除ProductPhysicalBeauticianRef
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除产品-美容师-关联")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productPhysicalBeauticianRefFeign.deleteById(id)); 
    }

    /**
     * 修改ProductPhysicalBeauticianRef
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑产品-美容师-关联")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return new ResponseMessage(productPhysicalBeauticianRefFeign.edit(productPhysicalBeauticianRef)); 
    }

    /**
     * 根据ID查询ProductPhysicalBeauticianRef
     *
     * @param id
     * @returnproductPhysicalBeauticianRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询产品-美容师-关联")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<ProductPhysicalBeauticianRef> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productPhysicalBeauticianRefFeign.queryById(id)); 
    }
}