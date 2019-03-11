package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.pc.product.service.ProductPhysicalBeauticianRefService;
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
 * @time 2018/2/28 16:07
 */
@Api(tags = "产品-美容师-关联")
@RestController
@RequestMapping(value = "productPhysicalBeauticianRef")
public class ProductPhysicalBeauticianRefController {
    @Resource
    private ProductPhysicalBeauticianRefService productPhysicalBeauticianRefService;

    /**
     * 分页查询产品-美容师-关联
     *
     * @param pageNo                       分页索引
     * @param pageSize                     每页数量
     * @param productPhysicalBeauticianRef 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询产品-美容师-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ProductPhysicalBeauticianRef>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                      @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                      @ApiParam(value = "查询条件") @RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return this.productPhysicalBeauticianRefService.findByPageForFront(pageNo, pageSize, productPhysicalBeauticianRef);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return this.productPhysicalBeauticianRefService.addObj(productPhysicalBeauticianRef);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.productPhysicalBeauticianRefService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return this.productPhysicalBeauticianRefService.modifyObj(productPhysicalBeauticianRef);
    }

    @GetMapping("/queryById/{id}")
    public ProductPhysicalBeauticianRef queryById(@PathVariable(value = "id") int id) {
        return this.productPhysicalBeauticianRefService.queryObjById(id);
    }
}