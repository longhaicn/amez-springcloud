package com.union.aimei.common.feign.app.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.hystrix.ProductApiHystrix;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductCollection;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.common.vo.product.pc.ProductByDetailResVo;
import com.union.aimei.common.vo.store.app.ProductStoreByNameVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目
 *
 * @author liurenkai
 * @time 2018/1/10 14:11
 */
@FeignClient(serviceId = "APP-PRODUCT-SERVICE", fallback = ProductApiHystrix.class)
public interface ProductFeign {

    /**
     * 前端分页查询门店项目
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param product  查询条件
     * @return
     */
    @PostMapping(value = "/product/front/findByPage")
    ResponseMessage<PageInfo<Product>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @RequestBody Product product);

    /**
     * 根据名称查询项目
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productStoreByNameVo 查询条件
     * @return
     */
    @PostMapping(value = "/product/findByPageForName")
    ResponseMessage<PageInfo<ProductByNameResultVo>> findByPageForName(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                       @RequestBody ProductStoreByNameVo productStoreByNameVo);

    /**
     * 根据名称查询项目与门店
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productStoreByNameVo 查询条件
     * @return
     */
    @PostMapping(value = "/product/findProductStoreByPageForName")
    ResponseMessage<ProductStoreByNameResultVo> findProductStoreByPageForName(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                   @RequestBody ProductStoreByNameVo productStoreByNameVo);

    /**
     * 查询门店项目（门店优惠券）
     *
     * @param productByStoreCouponsVo 查询条件
     * @return
     */
    @PostMapping(value = "/product/findByPageForStoreCoupons")
    ResponseMessage<ProductByStoreCouponsResultVo> findByPageForStoreCoupons(@RequestBody ProductByStoreCouponsVo productByStoreCouponsVo);

    /**
     * 分页查询项目（门店）
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页数量
     * @param productByStoreIdForSortVo 查询条件
     * @return
     */
    @PostMapping("/product/findByPageForStoreIdForSort")
    ResponseMessage<PageInfo<Product>> findByPageForStoreIdForSort(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                   @RequestBody ProductByStoreIdForSortVo productByStoreIdForSortVo);

    /**
     * 项目上架
     *
     * @param onSaleVo 条件
     * @return
     */
    @PostMapping(value = "/product/1.1.1/onSale")
    ResponseMessage onSaleV111(@RequestBody ProductOnSaleVo onSaleVo);

    /**
     * 项目下架
     *
     * @param offShelvesVo 条件
     * @return
     */
    @PostMapping(value = "/product/1.1.1/offShelves")
    ResponseMessage offShelvesV111(@RequestBody ProductOffShelvesVo offShelvesVo);

    /**
     * 项目详情
     *
     * @param productByDetailVo
     * @return
     */
    @PostMapping("/product/detail")
    ResponseMessage<ProductByDetailByResultVo> detail(@RequestBody ProductByDetailVo productByDetailVo);

    /**
     * 查询项目上架状态
     *
     * @param storeId   门店ID
     * @param productId 项目ID
     * @return
     */
    @GetMapping("/product/findBySaleStatus/{storeId}/{productId}")
    ResponseMessage<Product> findBySaleStatus(@PathVariable(value = "storeId") int storeId,
                                              @PathVariable(value = "productId") int productId);

    /**
     * 项目审核
     *
     * @param id          ID
     * @param auditStatus 审核状态  0,待审核  1,已审核 2,不通过
     * @param auditReason 审核原因
     * @return
     */
    @PutMapping(value = "/product/modify/auditStatus/{id}/{auditStatus}")
    ResponseMessage modifyAuditStatus(@PathVariable(value = "id") int id,
                                      @PathVariable(value = "auditStatus") int auditStatus,
                                      @RequestParam(value = "auditReason") String auditReason);

    /**
     * 项目收藏
     *
     * @param productCollection
     * @return
     */
    @PostMapping(value = "/product/collection")
    ResponseMessage collection(@RequestBody ProductCollection productCollection);

    /**
     * 项目库存检查
     *
     * @param inventoryVo
     * @return
     */
    @PostMapping("/product/inventoryCheck")
    ResponseMessage inventoryCheck(@RequestBody ProductByInventoryVo inventoryVo);

    /**
     * 项目库存订单预约
     *
     * @param inventoryVo
     * @return
     */
    @PostMapping(value = "/product/inventoryOrderReservation")
    ResponseMessage inventoryOrderReservation(@RequestBody ProductByInventoryVo inventoryVo);

    /**
     * 项目库存取消订单预约
     *
     * @param inventoryCancelOrderReservationVo
     * @return
     */
    @PostMapping(value = "/product/inventoryCancelOrderReservation")
    ResponseMessage inventoryCancelOrderReservation(@RequestBody ProductByInventoryCancelOrderReservationVo inventoryCancelOrderReservationVo);

    /**
     * 项目库存消耗
     *
     * @param inventoryVo
     * @return
     */
    @PostMapping(value = "/product/inventoryConsumption")
    ResponseMessage inventoryConsumption(@RequestBody ProductByInventoryVo inventoryVo);

    /**
     * 根据ID查询项目
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/product/findById/{id}")
    ResponseMessage<Product> findById(@ApiParam(value = "ID") @PathVariable(value = "id") int id);

    /**
     * 累积销量
     *
     * @param productBySaleVolumeVo
     * @return
     */
    @PostMapping(value = "/product/accumulateBySaleVolume")
    ResponseMessage accumulateBySaleVolume(ProductBySaleVolumeVo productBySaleVolumeVo);

    /**
     * 分页查询项目（精选）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param selectVo 条件
     * @return
     */
    @PostMapping("/product/findByPageForSelect")
    ResponseMessage<PageInfo<Product>> findByPageForSelect(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                           @RequestBody ProductBySelectVo selectVo);

    /**
     * 根据门店查询项目
     *
     * @param storeId 门店ID
     * @return
     */
    @PostMapping("/product/findListByStoreId/{storeId}")
    ResponseMessage<List<Product>> findListByStoreId(@PathVariable(value = "storeId") int storeId);

    /**
     * 分页查询招募项目
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    @PostMapping("/product/1.1.1/findByPageForRecruit")
    ResponseMessage<PageInfo<ProductByRecruitResVo>> findByPageForRecruitV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                              @RequestBody ProductByRecruitVo recruitVo);

    /**
     * 统计招募项目邀请
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @GetMapping("/product/1.1.1/countByRecruitForInvination/{beauticianId}")
    ResponseMessage<Integer> countByRecruitForInvinationV111(@PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 根据门店ID分页查询招募项目
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  门店ID
     * @return
     */
    @PostMapping("/product/1.1.1/findByPageByStoreIdForRecruit/{storeId}")
    ResponseMessage<PageInfo<ProductByStoreIdForRecruitResVo>> findByPageByStoreIdForRecruitV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                 @PathVariable(value = "storeId") int storeId);

    /**
     * 统计招募项目申请
     *
     * @param storeId   门店ID
     * @param productId 项目ID
     * @return
     */
    @GetMapping("/product/1.1.1/countByRecruitForApply/{storeId}/{productId}")
    ResponseMessage<Integer> countByRecruitForApplyV111(@PathVariable(value = "storeId") int storeId,
                                                        @PathVariable(value = "productId") int productId);

    /**
     * 根据美容师ID分页查询项目列表
     *
     * @param pageNo         分页索引
     * @param pageSize       每页数量
     * @param beauticianIdVo 条件
     * @return
     */
    @PostMapping(value = "/product/1.1.1/listByBeauticianId")
    ResponseMessage<PageInfo<ProductListByBeauticianIdResVo>> listByBeauticianIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                     @RequestBody ProductListByBeauticianIdVo beauticianIdVo);

    /**
     * 批量根据ID查询 项目-分类的关联数据(v1.1.0)
     *
     * @param idBatchVo 批量ID
     * @return
     */
    @PostMapping("/product/1.1.0/findProductCategoryRefListByIdBatch")
    ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchV110(@RequestBody IdBatchVo idBatchVo);

    /**
     * 批量根据ID查询 项目-分类的关联数据(v1.1.0)
     * (限定只有美容师服务的项目)
     *
     * @param idBatchVo 批量ID
     * @return
     */
    @PostMapping("/product/1.1.0/findProductCategoryRefListByIdBatchForStoreBeautician")
    ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchForStoreBeauticianV110(@RequestBody IdBatchVo idBatchVo);

    /**
     * 项目分类筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    @GetMapping("/product/1.1.1/getCategoryCondition/{cityId}")
    ResponseMessage<ProductCategoryConditionResVo> getCategoryConditionV111(@PathVariable(value = "cityId") int cityId);

    /**
     * 根据分类ID分页查询项目列表
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param categoryIdVo 条件
     * @return
     */
    @PostMapping("/product/1.1.1/listByCategoryId")
    ResponseMessage<PageInfo<ProductListDisplayResVo>> listByCategoryIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                            @RequestBody ProductListByCategoryIdVo categoryIdVo);

    /**
     * 根据门店ID分页查询到店项目
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param storeIdVo 条件
     * @return
     */
    @PostMapping("/product/1.1.1/listStoreByStoreId")
    ResponseMessage<PageInfo<ProductListDisplayResVo>> listStoreByStoreIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                              @RequestBody ProductListStoreByStoreIdVo storeIdVo);

    /**
     * 项目库存检查
     *
     * @param productId 项目ID
     * @return
     */
    @GetMapping(value = "/product/1.1.1/inventoryCheck/{productId}")
    ResponseMessage inventoryCheckV111(@PathVariable(value = "productId") int productId);

    /**
     * 美容师项目库存检查
     *
     * @param productId    项目ID
     * @param beauticianId 美容师ID
     * @return
     */
    @GetMapping(value = "/product/1.1.1/inventoryCheckByBeauticianId/{productId}/{beauticianId}")
    ResponseMessage inventoryCheckByBeauticianIdV111(@PathVariable(value = "productId") int productId,
                                                     @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 项目库存订单预约
     *
     * @param productId    项目ID
     * @param beauticianId 美容师ID
     * @return
     */
    @PostMapping(value = "/product/1.1.1/inventoryOrderReservation/{productId}/{beauticianId}")
    ResponseMessage inventoryOrderReservationV111(@PathVariable(value = "productId") int productId,
                                                  @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 项目库存取消订单预约
     *
     * @param inventoryVo 库存条件
     * @return
     */
    @PutMapping(value = "/product/1.1.1/inventoryCancelOrderReservation")
    ResponseMessage inventoryCancelOrderReservationV111(@ApiParam(value = "库存条件") @RequestBody ProductPhysicalByInventoryVo inventoryVo);

    /**
     * 项目库存消耗
     *
     * @param inventoryVo 库存条件
     * @return
     */
    @PutMapping(value = "/product/1.1.1/inventoryConsumption")
    ResponseMessage inventoryConsumptionV111(@ApiParam(value = "库存条件") @RequestBody ProductPhysicalByInventoryVo inventoryVo);

    /**
     * 美容师-项目管理-项目详情
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param beauticianId           美容师ID
     * @return
     */
    @GetMapping(value = "/product/1.1.1/detailByManageForBeautician/{productBeauticianRefId}/{beauticianId}")
    ResponseMessage<ProductByDetailByManageForBeauticianResVo> detailByManageForBeauticianV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId,
                                                                                               @ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 美容师-项目申请-项目详情
     *
     * @param productStoreRefId 项目-门店-关联ID
     * @param beauticianId      美容师ID
     * @return
     */
    @GetMapping(value = "/product/1.1.1/detailByApplyForBeautician/{productStoreRefId}/{beauticianId}")
    ResponseMessage<ProductByDetailByApplyForBeauticianResVo> detailByApplyForBeauticianV111(@ApiParam(value = "项目-门店-关联ID", required = true) @PathVariable(value = "productStoreRefId") int productStoreRefId,
                                                                                             @ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 门店招募项目详情
     *
     * @param productStoreRefId 项目-门店-关联ID
     * @param beauticianId      美容师ID
     * @return
     */
    @GetMapping(value = "/product/1.1.1/getRecruitDetailByStore/{productStoreRefId}/{beauticianId}")
    ResponseMessage<ProductRecruitDetailResVo> getRecruitDetailByStoreV111(@ApiParam(value = "项目-门店-关联ID", required = true) @PathVariable(value = "productStoreRefId") int productStoreRefId,
                                                                           @ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 上门项目详情
     *
     * @param detailVo 条件
     * @return
     */
    @PostMapping(value = "/product/1.1.1/getHomeDetail")
    ResponseMessage<ProductHomeDetailResVo> getHomeDetailV111(@RequestBody ProductHomeDetailVo detailVo);

    /**
     * 分页查询项目管理列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param manageVo 条件
     * @return
     */
    @PostMapping("/product/1.1.1/listManage")
    ResponseMessage<PageInfo<ProductListManageResVo>> listManageV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                     @RequestBody ProductListManageVo manageVo);

    /**
     * 项目佣金比列
     *
     * @param productId    项目ID
     * @param beauticianId 美容师ID
     * @return
     */
    @GetMapping("/product/1.1.1/getCommissionRatio/{productId}/{beauticianId}")
    ResponseMessage<Integer> getCommissionRatioV111(@ApiParam(value = "项目ID") @PathVariable(value = "productId") int productId,
                                                    @ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 招募项目筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    @GetMapping("/product/1.1.1/getRecruitCondition/{cityId}")
    ResponseMessage<ProductRecruitConditionResVo> getRecruitConditionV111(@PathVariable(value = "cityId") int cityId);

    /**
     * 项目预约人数
     *
     * @param productId     项目ID
     * @param isAppointment 是否预约，true-预约，false-取消预约
     * @return
     */
    @PutMapping("/product/1.1.1/appointment/{productId}/{isAppointment}")
    ResponseMessage appointmentV111(@PathVariable(value = "productId") int productId,
                                    @PathVariable(value = "isAppointment") boolean isAppointment);

    /**
     * 订单支付项目更新（销量，预约人数）
     *
     * @param orderPayVo 条件
     * @return
     */
    @PutMapping("/product/1.1.1/updateOrderPay")
    ResponseMessage updateOrderPayV111(@RequestBody ProductUpdateOrderPayVo orderPayVo);

    /**
     * 项目是否上架
     *
     * @param isOnSaleVo 条件
     * @return
     */
    @PostMapping("/product/1.1.1/isOnSale")
    ResponseMessage<Product> isOnSaleV111(@RequestBody ProductIsOnSaleVo isOnSaleVo);

    /**
     * 招募项目是否接单
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param isOrder                是否接单，1-是，0-否
     * @return
     */
    @PutMapping("/product/1.1.1/isOrderByRecruit/{productBeauticianRefId}/{isOrder}")
    ResponseMessage isOrderByRecruitV111(@PathVariable(value = "productBeauticianRefId") int productBeauticianRefId,
                                         @PathVariable(value = "isOrder") boolean isOrder);

    /**
     * 删除招募项目
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @return
     */
    @DeleteMapping("/product/1.1.1/deleteByRecruit/{productBeauticianRefId}")
    ResponseMessage deleteByRecruitV111(@PathVariable(value = "productBeauticianRefId") int productBeauticianRefId);

    /**
     * 申请招募项目（美容师-项目管理-项目申请）
     *
     * @param applyForRecruitVo 条件
     * @return
     */
    @PostMapping("/product/1.1.1/applyByRecruit")
    ResponseMessage applyByRecruitV111(@ApiParam(value = "条件") @RequestBody ProductByApplyForRecruitVo applyForRecruitVo);

    /**
     * 接受招募项目邀请（美容师-项目管理-项目申请-门店邀请）
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @return
     */
    @PutMapping("/product/1.1.1/acceptByRecruitForInvitation/{productBeauticianRefId}")
    ResponseMessage acceptByRecruitForInvitationV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId);

    /**
     * 拒绝招募项目邀请（美容师-项目管理-项目申请-门店邀请）
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param auditReasonVo          审核原因条件
     * @return
     */
    @PutMapping("/product/1.1.1/refuseByRecruitForInvitation/{productBeauticianRefId}")
    ResponseMessage refuseByRecruitForInvitationV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId,
                                                     @ApiParam(value = "审核原因", required = true) @RequestBody AuditReasonVo auditReasonVo);

    /**
     * 招募项目邀请（门店-首页-招募挂靠-项目招募-项目招募管理-项目招募（人员选择））
     *
     * @param productStoreRefId 项目-门店-关联ID
     * @param beauticianId      美容师ID
     * @return
     */
    @PostMapping("/product/1.1.1/invinationByRecruit/{productStoreRefId}/{beauticianId}")
    ResponseMessage invinationByRecruitV111(@ApiParam(value = "项目-门店-关联ID", required = true) @PathVariable(value = "productStoreRefId") int productStoreRefId,
                                            @ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 同意招募项目申请（门店-首页-招募挂靠-项目招募-项目招募管理-项目申请）
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @return
     */
    @PutMapping("/product/1.1.1/agreeByApplyForRecruit/{productBeauticianRefId}")
    ResponseMessage agreeByApplyForRecruitV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId);

    /**
     * 拒绝招募项目申请（门店-首页-招募挂靠-项目招募-项目招募管理-项目申请）
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param auditReasonVo          审核原因
     * @return
     */
    @PutMapping("/product/1.1.1/refuseByApplyForRecruit/{productBeauticianRefId}")
    ResponseMessage refuseByApplyForRecruitV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId,
                                                @ApiParam(value = "审核原因", required = true) @RequestBody AuditReasonVo auditReasonVo);


}