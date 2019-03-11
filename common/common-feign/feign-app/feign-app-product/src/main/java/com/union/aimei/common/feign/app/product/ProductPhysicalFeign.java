package com.union.aimei.common.feign.app.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.hystrix.ProductPhysicalApiHystrix;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByCalcFreightVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByCategoryVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByIdBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品
 *
 * @author liurenkai
 * @time 2018/2/28 16:18
 */
@FeignClient(serviceId = "APP-PRODUCT-SERVICE", fallback = ProductPhysicalApiHystrix.class)
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
     * @param pageSize        每页数量
     * @param productPhysical 查询条件
     * @return
     */
    @PostMapping(value = "/productPhysical/front/findByPage")
    ResponseMessage<PageInfo<ProductPhysical>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @RequestBody ProductPhysical productPhysical);

    /**
     * 根据分类分页查询产品
     *
     * @param pageNo                      分页索引
     * @param pageSize                    每页数量
     * @param productPhysicalByCategoryVo 查询条件
     * @return
     */
    @PostMapping(value = "/productPhysical/findByPageForCategory")
    ResponseMessage<PageInfo<ProductPhysical>> findByPageForCategory(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                     @RequestBody ProductPhysicalByCategoryVo productPhysicalByCategoryVo);

    /**
     * 产品详情
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/productPhysical/detail/{id}")
    ResponseMessage<ProductPhysical> detail(@PathVariable(value = "id") int id);

    /**
     * 产品库存检查
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @PostMapping("/productPhysical/inventoryCheck")
    ResponseMessage inventoryCheck(@RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 批量根据ID查询产品
     *
     * @param productPhysicalByIdBatchVo 查询条件
     * @return
     */
    @PostMapping("/productPhysical/findListByIdBatch")
    ResponseMessage<List<ProductPhysical>> findListByIdBatch(@RequestBody ProductPhysicalByIdBatchVo productPhysicalByIdBatchVo);

    /**
     * 计算运费
     *
     * @param calcFreightVo 查询条件
     * @return
     */
    @PostMapping("/productPhysical/calcFreight")
    ResponseMessage<Integer> calcFreight(@RequestBody ProductPhysicalByCalcFreightVo calcFreightVo);

    /**
     * 根据ID查询产品
     *
     * @param id
     * @return
     */
    @GetMapping("/productPhysical/findById/{id}")
    ResponseMessage<ProductPhysical> findById(@PathVariable(value = "id") int id);

    /**
     * 产品库存采购检查
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    @PostMapping("/productPhysical/1.1.1/inventoryPurchaseCheck")
    ResponseMessage inventoryPurchaseCheckV111(@RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 产品库存采购预约
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    @PostMapping("/productPhysical/1.1.1/inventoryPurchaseReservation")
    ResponseMessage inventoryPurchaseReservationV111(@RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);


    /**
     * 产品库存取消采购预约
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    @PostMapping("/productPhysical/1.1.1/inventoryCancelPurchaseReservation")
    ResponseMessage inventoryCancelPurchaseReservationV111(@RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 产品库存采购入库
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    @PostMapping("/productPhysical/1.1.1/inventroyPurchaseStorage")
    ResponseMessage inventroyPurchaseStorageV111(@RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

}