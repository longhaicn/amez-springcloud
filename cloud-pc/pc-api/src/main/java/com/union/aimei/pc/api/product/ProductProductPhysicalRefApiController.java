package com.union.aimei.pc.api.product;

import com.union.aimei.common.model.product.ProductProductPhysicalRef;
import com.union.aimei.common.feign.pc.product.ProductProductPhysicalRefFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目-产品-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:26
 */
@Api(tags = "项目-产品-关联")
@RestController
@RequestMapping(value = "productProductPhysicalRef")
public class ProductProductPhysicalRefApiController {
    @Resource
    private ProductProductPhysicalRefFeign productProductPhysicalRefFeign;

    /**
     * 分页查询
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页显示数量
     * @param productProductPhysicalRef 查询条件
     * @return ResponseMessage<ProductProductPhysicalRef>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询项目-产品-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<ProductProductPhysicalRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                                 Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                 Integer pageSize, @ApiParam(value = "查询条件") @RequestBody ProductProductPhysicalRef productProductPhysicalRef) {
        return new ResponseMessage(productProductPhysicalRefFeign.findByPageForFront(pageNo, pageSize, productProductPhysicalRef)); 
    }

    /**
     * 添加ProductProductPhysicalRef
     *
     * @param productProductPhysicalRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加项目-产品-关联")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody ProductProductPhysicalRef productProductPhysicalRef) {
        return new ResponseMessage(productProductPhysicalRefFeign.insert(productProductPhysicalRef)); 
    }

    /**
     * 删除ProductProductPhysicalRef
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除项目-产品-关联")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productProductPhysicalRefFeign.deleteById(id)); 
    }

    /**
     * 修改ProductProductPhysicalRef
     *
     * @param productProductPhysicalRef
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑项目-产品-关联")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody ProductProductPhysicalRef productProductPhysicalRef) {
        return new ResponseMessage(productProductPhysicalRefFeign.edit(productProductPhysicalRef)); 
    }

    /**
     * 根据ID查询ProductProductPhysicalRef
     *
     * @param id
     * @returnproductProductPhysicalRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询项目-产品-关联")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<ProductProductPhysicalRef> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productProductPhysicalRefFeign.queryById(id)); 
    }
}