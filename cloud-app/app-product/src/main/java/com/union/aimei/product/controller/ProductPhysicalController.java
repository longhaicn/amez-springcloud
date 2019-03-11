package com.union.aimei.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByCalcFreightVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByCategoryVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByIdBatchVo;
import com.union.aimei.product.service.ProductPhysicalService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品
 *
 * @author liurenkai
 * @time 2018/2/28 16:07
 */
@Api(tags = "产品")
@RestController
@RequestMapping(value = "productPhysical")
public class ProductPhysicalController {
    @Resource
    private ProductPhysicalService productPhysicalService;

    /**
     * 分页查询产品
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productPhysical 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询产品")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ProductPhysical>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                         @ApiParam(value = "查询条件") @RequestBody ProductPhysical productPhysical) {
        return this.productPhysicalService.findByPageForFront(pageNo, pageSize, productPhysical);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ProductPhysical productPhysical) {
        return this.productPhysicalService.addObj(productPhysical);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.productPhysicalService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ProductPhysical productPhysical) {
        return this.productPhysicalService.modifyObj(productPhysical);
    }

    @GetMapping("/queryById/{id}")
    public ProductPhysical queryById(@PathVariable(value = "id") int id) {
        return this.productPhysicalService.queryObjById(id);
    }

    /**
     * 根据分类分页查询产品
     *
     * @param pageNo                      分页索引
     * @param pageSize                    每页数量
     * @param productPhysicalByCategoryVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据分类分页查询产品")
    @PostMapping("/findByPageForCategory")
    public ResponseMessage<PageInfo<ProductPhysical>> findByPageForCategory(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                            @ApiParam(value = "查询条件") @RequestBody ProductPhysicalByCategoryVo productPhysicalByCategoryVo) {
        return this.productPhysicalService.findByPageForCategory(pageNo, pageSize, productPhysicalByCategoryVo);
    }

    /**
     * 产品详情
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "产品详情")
    @GetMapping("/detail/{id}")
    public ResponseMessage<ProductPhysical> detail(@PathVariable(value = "id") int id) {
        return this.productPhysicalService.detail(id);
    }

    /**
     * 产品库存检查
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品库存检查")
    @PostMapping("/inventoryCheck")
    public ResponseMessage inventoryCheck(@ApiParam(value = "查询条件") @RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return this.productPhysicalService.inventoryCheck(inventoryForBeauticianVo);
    }

    /**
     * 批量根据ID查询产品
     *
     * @param productPhysicalByIdBatchVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量根据ID查询产品")
    @PostMapping("/findListByIdBatch")
    public ResponseMessage<List<ProductPhysical>> findListByIdBatch(@ApiParam(value = "查询条件") @RequestBody ProductPhysicalByIdBatchVo productPhysicalByIdBatchVo) {
        return this.productPhysicalService.findListByIdBatch(productPhysicalByIdBatchVo);
    }

    /**
     * 计算运费
     *
     * @param calcFreightVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "计算运费")
    @PostMapping("/calcFreight")
    public ResponseMessage<Integer> calcFreight(@ApiParam(value = "查询条件") @RequestBody ProductPhysicalByCalcFreightVo calcFreightVo) {
        return this.productPhysicalService.calcFreight(calcFreightVo);
    }

    /**
     * 根据ID查询产品
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询产品")
    @GetMapping("/findById/{id}")
    public ResponseMessage<ProductPhysical> findById(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productPhysicalService.findById(id);
    }

    /**
     * 产品库存采购检查
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品库存采购检查")
    @PostMapping("/1.1.1/inventoryPurchaseCheck")
    public ResponseMessage inventoryPurchaseCheckV111(@RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return this.productPhysicalService.inventoryPurchaseCheckV111(inventoryForBeauticianVo);
    }

    /**
     * 产品库存采购预约
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品库存采购预约")
    @PostMapping("/1.1.1/inventoryPurchaseReservation")
    public ResponseMessage inventoryPurchaseReservationV111(@RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return this.productPhysicalService.inventoryPurchaseReservationV111(inventoryForBeauticianVo);
    }


    /**
     * 产品库存取消采购预约
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品库存取消采购预约")
    @PostMapping("/1.1.1/inventoryCancelPurchaseReservation")
    public ResponseMessage inventoryCancelPurchaseReservationV111(@RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return this.productPhysicalService.inventoryCancelPurchaseReservationV111(inventoryForBeauticianVo);
    }

    /**
     * 产品库存采购入库
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品库存采购入库")
    @PostMapping("/1.1.1/inventroyPurchaseStorage")
    public ResponseMessage inventroyPurchaseStorageV111(@RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return this.productPhysicalService.inventroyPurchaseStorageV111(inventoryForBeauticianVo);
    }

}