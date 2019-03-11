package com.union.aimei.pc.api.product;

import com.union.aimei.common.model.product.ProductCity;
import com.union.aimei.common.feign.pc.product.ProductCityFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目城市
 *
 * @author liurenkai
 * @time 2018/2/26 15:14
 */
@Api(tags = "项目城市")
@RestController
@RequestMapping(value = "productCity")
public class ProductCityApiController {
    @Resource
    private ProductCityFeign productCityFeign;

    /**
     * 分页查询
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param productCity 查询条件
     * @return ResponseMessage<ProductCity>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询项目城市")
    @PostMapping("/front/findByPage")
    public ResponseMessage<ProductCity> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                   Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                   Integer pageSize, @ApiParam(value = "查询条件") @RequestBody ProductCity productCity) {
        return new ResponseMessage(productCityFeign.findByPageForFront(pageNo, pageSize, productCity)); 
    }

    /**
     * 添加ProductCity
     *
     * @param productCity
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加项目城市")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody ProductCity productCity) {
        return new ResponseMessage(productCityFeign.insert(productCity)); 
    }

    /**
     * 删除ProductCity
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除项目城市")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productCityFeign.deleteById(id)); 
    }

    /**
     * 修改ProductCity
     *
     * @param productCity
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑项目城市")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody ProductCity productCity) {
        return new ResponseMessage(productCityFeign.edit(productCity)); 
    }

    /**
     * 根据ID查询ProductCity
     *
     * @param id
     * @returnproductCity
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询项目城市")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<ProductCity> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productCityFeign.queryById(id)); 
    }
}