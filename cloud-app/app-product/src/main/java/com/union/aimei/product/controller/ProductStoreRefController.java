package com.union.aimei.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.vo.product.app.ProductStoreRefByByProductIdForOrderVo;
import com.union.aimei.product.service.ProductStoreRefService;
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
 * @time 2018/1/5 19:01
 */
@Api(tags = "项目-门店-关联")
@RestController
@RequestMapping(value = "productStoreRef")
public class ProductStoreRefController {
    @Resource
    private ProductStoreRefService productStoreRefService;

    @PostMapping("/front/findByPage")
    public PageInfo<ProductStoreRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                        @ApiParam(value = "查询条件") @RequestBody ProductStoreRef productStoreRef) {
        return this.productStoreRefService.findByPageForFront(pageNo, pageSize, productStoreRef);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ProductStoreRef productStoreRef) {
        return this.productStoreRefService.addObj(productStoreRef);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.productStoreRefService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ProductStoreRef productStoreRef) {
        return this.productStoreRefService.modifyObj(productStoreRef);
    }

    @GetMapping("/queryById/{id}")
    public ProductStoreRef queryById(@PathVariable(value = "id") int id) {
        return this.productStoreRefService.queryObjById(id);
    }

    /**
     * 根据商品ID查询项目-门店-关联（距离排序）（提交订单）
     *
     * @param pageNo                                 分页索引
     * @param pageSize                               每页数量
     * @param productStoreRefByByProductIdForOrderVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据商品ID查询项目-门店-关联（距离排序）（提交订单）")
    @PostMapping("/findByPageByProductIdForOrder")
    public ResponseMessage<PageInfo<ProductStoreRef>> findByPageByProductIdForOrder(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                    @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                    @ApiParam(value = "查询条件") @RequestBody ProductStoreRefByByProductIdForOrderVo productStoreRefByByProductIdForOrderVo) {
        return this.productStoreRefService.findByPageByProductIdForOrder(pageNo, pageSize, productStoreRefByByProductIdForOrderVo);
    }

    /**
     * 根据ID查询项目-门店-关联
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询项目-门店-关联")
    @GetMapping("/findById/{id}")
    public ResponseMessage<ProductStoreRef> findById(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productStoreRefService.findById(id);
    }

}