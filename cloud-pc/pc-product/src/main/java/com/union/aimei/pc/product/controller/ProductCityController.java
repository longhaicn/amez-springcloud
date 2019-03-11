package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductCity;
import com.union.aimei.pc.product.service.ProductCityService;
import com.union.aimei.common.vo.product.pc.ProductCityByBatchVo;
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
 * @time 2018/2/26 15:01
 */
@Api(tags = "项目城市")
@RestController
@RequestMapping(value = "productCity")
public class ProductCityController {
    @Resource
    private ProductCityService productCityService;

    @PostMapping("/front/findByPage")
    public PageInfo<ProductCity> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                            Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                            Integer pageSize, @ApiParam(value = "查询条件") @RequestBody ProductCity productCity) {
        return this.productCityService.findByPageForFront(pageNo, pageSize, productCity);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ProductCity productCity) {
        return this.productCityService.addObj(productCity);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.productCityService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ProductCity productCity) {
        return this.productCityService.modifyObj(productCity);
    }

    @GetMapping("/queryById/{id}")
    public ProductCity queryById(@PathVariable(value = "id") int id) {
        return this.productCityService.queryObjById(id);
    }

    /**
     * 根据商品ID删除项目城市
     *
     * @param productId 商品ID
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "根据商品ID删除项目城市")
    @DeleteMapping("/deleteByProductId/{productId}")
    public ResponseMessage deleteByProductId(@ApiParam(value = "商品ID") @PathVariable(value = "productId") int productId) {
        return this.productCityService.deleteByProductId(productId);
    }

    /**
     * 批量添加项目城市
     *
     * @author liurenkai
     * @time 2018/2/26 17:10
     */
    @ApiOperation(httpMethod = "POST", value = "批量添加项目城市")
    @PostMapping("/addBatch")
    public ResponseMessage addBatch(@ApiParam(value = "批量项目城市") @RequestBody ProductCityByBatchVo productCityByBatchVo) {
        return this.productCityService.addBatch(productCityByBatchVo);
    }

}