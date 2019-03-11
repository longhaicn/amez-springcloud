package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.pc.PhyByDetailResVo;
import com.union.aimei.common.vo.product.pc.PhyByManageResVo;
import com.union.aimei.common.vo.product.pc.PhyByManageVo;
import com.union.aimei.common.vo.product.pc.ProductPhysicalByAddVo;
import com.union.aimei.pc.product.service.ProductPhysicalService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
     * 分页查询查询产品
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productPhysical 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询产品")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ProductPhysical>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
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
     * 添加产品
     *
     * @param productPhysicalByAddVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加产品")
    @PostMapping("/add")
    public ResponseMessage<ProductPhysical> add(@ApiParam(value = "添加产品") @RequestBody ProductPhysicalByAddVo productPhysicalByAddVo) {
        return this.productPhysicalService.add(productPhysicalByAddVo);
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
     * 产品库存入库
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品库存入库")
    @PostMapping("/inventroyStorage")
    public ResponseMessage inventroyStorage(@ApiParam(value = "查询条件") @RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return this.productPhysicalService.inventroyStorage(inventoryForBeauticianVo);
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
     * 分页查询产品（管理）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param manageVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询产品（管理）")
    @PostMapping("/findByPageForManage")
    public ResponseMessage<PageInfo<PhyByManageResVo>> findByPageForManage(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                           @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                           @ApiParam(value = "查询条件") @RequestBody PhyByManageVo manageVo) {
        return this.productPhysicalService.findByPageForManage(pageNo, pageSize, manageVo);
    }

    /**
     * 产品详情
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "产品详情")
    @GetMapping("/detail/{id}")
    public ResponseMessage<PhyByDetailResVo> detail(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productPhysicalService.detail(id);
    }

    /**
     * 产品库存订单预约
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品库存订单预约")
    @PostMapping("/inventoryOrderReservation")
    public ResponseMessage inventoryOrderReservation(@ApiParam(value = "查询条件") @RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return this.productPhysicalService.inventoryOrderReservation(inventoryForBeauticianVo);
    }

    /**
     * 产品库存取消订单预约
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品库存取消订单预约")
    @PostMapping("/inventoryCancelOrderReservation")
    public ResponseMessage inventoryCancelOrderReservation(@ApiParam(value = "查询条件") @RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return this.productPhysicalService.inventoryCancelOrderReservation(inventoryForBeauticianVo);
    }

    /**
     * 商品库存消耗
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "商品库存消耗")
    @PostMapping("/inventoryConsumption")
    public ResponseMessage inventoryConsumption(@ApiParam(value = "查询条件") @RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return this.productPhysicalService.inventoryConsumption(inventoryForBeauticianVo);
    }

}