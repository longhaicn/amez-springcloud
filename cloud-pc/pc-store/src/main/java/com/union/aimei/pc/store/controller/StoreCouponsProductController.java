package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.aimei.pc.store.service.StoreCouponsProductService;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductByBatchVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Api(tags = "优惠券-服务-关联")
@RestController
@RequestMapping(value = "storeCouponsProduct")
public class StoreCouponsProductController {
    @Resource
    private StoreCouponsProductService storeCouponsProductService;

    /**
     * 分页查询优惠券-服务-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页数量
     * @param storeCouponsProduct 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询优惠券-服务-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreCouponsProduct>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0", value = "pageNo") Integer pageNo,
                                                                             @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                             @ApiParam(value = "查询条件") @RequestBody StoreCouponsProduct storeCouponsProduct) {
        return this.storeCouponsProductService.findByPageForFront(pageNo, pageSize, storeCouponsProduct);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreCouponsProduct storeCouponsProduct) {
        return this.storeCouponsProductService.addObj(storeCouponsProduct);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeCouponsProductService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreCouponsProduct storeCouponsProduct) {
        return this.storeCouponsProductService.modifyObj(storeCouponsProduct);
    }

    @GetMapping("/queryById/{id}")
    public StoreCouponsProduct queryById(@PathVariable(value = "id") int id) {
        return this.storeCouponsProductService.queryObjById(id);
    }

    /**
     * 批量新增优惠券-服务-关联
     *
     * @param batchVo 批量优惠券-服务-关联
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量新增优惠券-服务-关联")
    @PostMapping(value = "/addBatch")
    public ResponseMessage addBatch(@ApiParam(value = "批量优惠券-服务-关联") @RequestBody StoreCouponsProductByBatchVo batchVo) {
        return this.storeCouponsProductService.addBatch(batchVo);
    }

    /**
     * 根据优惠券ID更新软删除标记
     *
     * @param couponsId 优惠券ID
     * @param isEnabled 软删除标记，1-正常，0-删除
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "根据优惠券ID更新软删除标记")
    @PutMapping("/updateByIsEnabledByCouponsId/{couponsId}/{isEnabled}")
    public ResponseMessage updateByIsEnabledByCouponsId(@ApiParam(value = "优惠券ID") @PathVariable(value = "couponsId") int couponsId,
                                                        @ApiParam(value = "软删除标记，1-正常，0-删除") @PathVariable(value = "isEnabled") boolean isEnabled) {
        return this.storeCouponsProductService.updateByIsEnabledByCouponsId(couponsId, isEnabled);
    }

    /**
     * 根据商品ID更新软删除标记
     *
     * @param productId 商品ID
     * @param isEnabled 软删除标记，1-正常，0-删除
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "根据商品ID更新软删除标记")
    @PutMapping("/updateByIsEnabledByProductId/{productId}/{isEnabled}")
    public ResponseMessage updateByIsEnabledByProductId(@ApiParam(value = "商品ID") @PathVariable(value = "productId") int productId,
                                                        @ApiParam(value = "软删除标记，1-正常，0-删除") @PathVariable(value = "isEnabled") boolean isEnabled) {
        return this.storeCouponsProductService.updateByIsEnabledByProductId(productId, isEnabled);
    }

}