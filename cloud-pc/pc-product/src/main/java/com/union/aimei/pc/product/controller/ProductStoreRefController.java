package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByBatchVo;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByStoreIdListVo;
import com.union.aimei.pc.product.service.ProductStoreRefService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("/findByStoreIdList")
    public List<Integer> findByStoreIdList(@RequestBody ProductStoreRefByStoreIdListVo productStoreRefByStoreIdListVo) {
        return this.productStoreRefService.findByStoreIdList(productStoreRefByStoreIdListVo);
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
     * 根据商品ID删除项目-门店-关联
     *
     * @param productId 商品ID
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "根据商品ID删除项目-门店-关联")
    @DeleteMapping("/deleteByProductId/{productId}")
    public ResponseMessage deleteByProductId(@ApiParam(value = "商品ID") @PathVariable(value = "productId") int productId) {
        return this.productStoreRefService.deleteByProductId(productId);
    }

    /**
     * 根据店铺ID删除项目-门店-关联
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "根据店铺ID删除项目-门店-关联")
    @DeleteMapping("/deleteByStoreId/{storeId}")
    public ResponseMessage deleteByStoreId(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId) {
        return this.productStoreRefService.deleteByStoreId(storeId);
    }

    /**
     * 批量添加项目-门店-关联
     *
     * @author liurenkai
     * @time 2018/2/26 17:37
     */
    @ApiOperation(httpMethod = "POST", value = "批量添加项目-门店-关联")
    @PostMapping("/addBatch")
    public ResponseMessage addBatch(@ApiParam(value = "批量项目-门店-关联") @RequestBody ProductStoreRefByBatchVo productStoreRefByBatchVo) {
        return this.productStoreRefService.addBatch(productStoreRefByBatchVo);
    }

    /**
     * 门店商品下架
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "门店商品下架")
    @PutMapping("/store/offShelves/{storeId}")
    public ResponseMessage storeByOffShelves(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.productStoreRefService.storeByOffShelves(storeId);
    }


    /**
     * 门店商品 冻结 解冻操作
     *
     * @param storeId  门店ID
     * @param isFreeze 是否冻结，true-冻结，false-解冻
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "门店商品 冻结 解冻操作")
    @PutMapping("/storeByFreeze/{storeId}/{isFreeze}")
    public ResponseMessage storeByFreeze(@ApiParam(value = "门店ID", required = true) @PathVariable(value = "storeId") int storeId,
                                         @ApiParam(value = "是否冻结，true-冻结，false-解冻", required = true) @PathVariable(value = "type") boolean isFreeze) {
        return this.productStoreRefService.storeByFreeze(storeId, isFreeze);
    }

}