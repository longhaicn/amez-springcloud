package com.union.aimei.pc.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductPhysicalFeign;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
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
 * @time 2018/2/28 16:25
 */
@Api(tags = "产品")
@RestController
@RequestMapping(value = "productPhysical")
public class ProductPhysicalApiController {
    @Resource
    private ProductPhysicalFeign productPhysicalFeign;

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
        return this.productPhysicalFeign.findByPageForFront(pageNo, pageSize, productPhysical);
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
        return this.productPhysicalFeign.inventoryOrderReservation(inventoryForBeauticianVo);
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
        return this.productPhysicalFeign.inventoryCancelOrderReservation(inventoryForBeauticianVo);
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
        return this.productPhysicalFeign.inventoryConsumption(inventoryForBeauticianVo);
    }

}