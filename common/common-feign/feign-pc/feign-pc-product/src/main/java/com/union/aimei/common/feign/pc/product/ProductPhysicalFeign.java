package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.ProductPhysicalApiHystrix;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.pc.PhyByDetailResVo;
import com.union.aimei.common.vo.product.pc.PhyByManageResVo;
import com.union.aimei.common.vo.product.pc.PhyByManageVo;
import com.union.aimei.common.vo.product.pc.ProductPhysicalByAddVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 产品
 *
 * @author liurenkai
 * @time 2018/2/28 16:18
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = ProductPhysicalApiHystrix.class)
public interface ProductPhysicalFeign {
    /**
     * 添加产品
     *
     * @param productPhysical
     * @return
     */
    @PostMapping(value = "/productPhysical/insert")
    int insert(@RequestBody ProductPhysical productPhysical);

    /**
     * 删除产品
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/productPhysical/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改产品
     *
     * @param productPhysical
     * @return
     */
    @PutMapping(value = "/productPhysical/edit")
    int edit(@RequestBody ProductPhysical productPhysical);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductPhysical
     */
    @GetMapping(value = "/productPhysical/queryById/{id}")
    ProductPhysical queryById(@PathVariable(value = "id") int id);

    /**
     * 分页查询产品
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param productPhysical 查询条件
     * @return
     */
    @PostMapping(value = "/productPhysical/front/findByPage")
    ResponseMessage<PageInfo<ProductPhysical>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @RequestBody ProductPhysical productPhysical);

    /**
     * 添加产品
     *
     * @param productPhysicalByAddVo
     * @return
     */
    @PostMapping("/productPhysical/add")
    ResponseMessage<ProductPhysical> add(@RequestBody ProductPhysicalByAddVo productPhysicalByAddVo);

    /**
     * 产品库存检查
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @PostMapping("/productPhysical/inventoryCheck")
    ResponseMessage inventoryCheck(@RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 产品库存入库
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @PostMapping("/productPhysical/inventroyStorage")
    ResponseMessage inventroyStorage(@RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 根据ID查询产品
     *
     * @param id
     * @return
     */
    @GetMapping("/productPhysical/findById/{id}")
    ResponseMessage<ProductPhysical> findById(@PathVariable(value = "id") int id);

    /**
     * 分页查询产品（管理）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param manageVo 查询条件
     * @return
     */
    @PostMapping("/productPhysical/findByPageForManage")
    ResponseMessage<PageInfo<PhyByManageResVo>> findByPageForManage(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestBody PhyByManageVo manageVo);

    /**
     * 产品详情
     *
     * @param id ID
     * @return
     */
    @GetMapping("/productPhysical/detail/{id}")
    ResponseMessage<PhyByDetailResVo> detail(@PathVariable(value = "id") int id);

    /**
     * 产品库存订单预约
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品库存订单预约")
    @PostMapping("/productPhysical/inventoryOrderReservation")
    ResponseMessage inventoryOrderReservation(@ApiParam(value = "查询条件") @RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 产品库存取消订单预约
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品库存取消订单预约")
    @PostMapping("/productPhysical/inventoryCancelOrderReservation")
    ResponseMessage inventoryCancelOrderReservation(@ApiParam(value = "查询条件") @RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 商品库存消耗
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "商品库存消耗")
    @PostMapping("/productPhysical/inventoryConsumption")
    ResponseMessage inventoryConsumption(@ApiParam(value = "查询条件") @RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

}