package com.union.aimei.pc.api.product;

import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.feign.pc.product.ProductStoreRefFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:14
 */
@Api(tags = "项目-门店-关联")
@RestController
@RequestMapping(value = "productStoreRef")
public class ProductStoreRefApiController {
    @Resource
    private ProductStoreRefFeign productStoreRefFeign;

    /**
     * 分页查询项目-门店-关联
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param productStoreRef 查询条件
     * @return ResponseMessage<ProductStoreRef>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询项目-门店-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<ProductStoreRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                               @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                               @ApiParam(value = "查询条件") @RequestBody ProductStoreRef productStoreRef) {
        return new ResponseMessage(productStoreRefFeign.findByPageForFront(pageNo, pageSize, productStoreRef)); 
    }

    /**
     * 添加项目-门店-关联
     *
     * @param productStoreRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加项目-门店-关联")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody ProductStoreRef productStoreRef) {
        return new ResponseMessage(productStoreRefFeign.insert(productStoreRef)); 
    }

    /**
     * 删除项目-门店-关联
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除项目-门店-关联")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productStoreRefFeign.deleteById(id)); 
    }

    /**
     * 修改项目-门店-关联
     *
     * @param productStoreRef
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑项目-门店-关联")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody ProductStoreRef productStoreRef) {
        return new ResponseMessage(productStoreRefFeign.edit(productStoreRef)); 
    }

    /**
     * 根据ID查询项目-门店-关联
     *
     * @param id
     * @returnproductStoreRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询项目-门店-关联")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<ProductStoreRef> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productStoreRefFeign.queryById(id)); 
    }
}