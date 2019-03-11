package com.union.aimei.app.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductCollection;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.common.vo.product.pc.ProductByDetailResVo;
import com.union.aimei.common.vo.store.app.ProductStoreByNameVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目
 *
 * @author liurenkai
 * @time 2018/1/10 14:10
 */
@Api(tags = "项目", description = "api")
@RestController
@RequestMapping("/product")
@SuppressWarnings("ALL")
public class ProductApiController {
    
    @Resource
    private ProductFeign productFeign;

    /**
     * 分页查询项目
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param product  查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<Product>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 @ApiParam(value = "查询条件") @RequestBody Product product) {
        return this.productFeign.findByPageForFront(pageNo, pageSize, product);
    }

    /**
     * 分页查询项目（名称）
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productStoreByNameVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目（名称）")
    @PostMapping(value = "/findByPageForName")
    public ResponseMessage<PageInfo<ProductByNameResultVo>> findByPageForName(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                              @ApiParam(value = "查询条件") @RequestBody ProductStoreByNameVo productStoreByNameVo) {
        return this.productFeign.findByPageForName(pageNo, pageSize, productStoreByNameVo);
    }

    /**
     * 分页查询项目与店铺（名称）
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productStoreByNameVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目与店铺（名称）")
    @PostMapping(value = "/findProductStoreByPageForName")
    public ResponseMessage<ProductStoreByNameResultVo> findProductStoreByPageForName(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                     @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                     @ApiParam(value = "查询条件") @RequestBody ProductStoreByNameVo productStoreByNameVo) {
        return this.productFeign.findProductStoreByPageForName(pageNo, pageSize, productStoreByNameVo);
    }

    /**
     * 查询店铺项目（店铺优惠券）
     *
     * @param productByStoreCouponsVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询店铺项目（店铺优惠券）")
    @PostMapping(value = "/findByPageForStoreCoupons")
    public ResponseMessage<ProductByStoreCouponsResultVo> findByPageForStoreCoupons(@ApiParam(value = "查询条件") @RequestBody ProductByStoreCouponsVo productByStoreCouponsVo) {
        return this.productFeign.findByPageForStoreCoupons(productByStoreCouponsVo);
    }

    /**
     * 分页查询项目（店铺）
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页数量
     * @param productByStoreIdForSortVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目（店铺）")
    @PostMapping("/findByPageForStoreIdForSort")
    public ResponseMessage<PageInfo<Product>> findByPageForStoreIdForSort(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                          @ApiParam(value = "查询条件") @RequestBody ProductByStoreIdForSortVo productByStoreIdForSortVo) {
        return this.productFeign.findByPageForStoreIdForSort(pageNo, pageSize, productByStoreIdForSortVo);
    }

    /**
     * 项目上架
     *
     * @param onSaleVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目上架")
    @PostMapping(value = "/1.1.1/onSale")
    public ResponseMessage onSaleV111(@ApiParam(value = "查询条件") @RequestBody ProductOnSaleVo onSaleVo) {
        return this.productFeign.onSaleV111(onSaleVo);
    }

    /**
     * 项目下架
     *
     * @param offShelvesVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目下架")
    @PostMapping(value = "/1.1.1/offShelves")
    public ResponseMessage offShelvesV111(@ApiParam(value = "查询条件") @RequestBody ProductOffShelvesVo offShelvesVo) {
        return this.productFeign.offShelvesV111(offShelvesVo);
    }

    /**
     * 项目详情
     *
     * @param productByDetailVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目详情")
    @PostMapping("/detail")
    public ResponseMessage<ProductByDetailByResultVo> detail(@ApiParam(value = "查询条件") @RequestBody ProductByDetailVo productByDetailVo) {
        return this.productFeign.detail(productByDetailVo);
    }

    /**
     * 查询项目上架状态
     *
     * @param storeId   店铺ID
     * @param productId 项目ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询项目上架状态")
    @GetMapping("/findBySaleStatus/{storeId}/{productId}")
    public ResponseMessage<Product> findByProductId(@ApiParam(value = "店铺ID", required = true) @PathVariable(value = "storeId") int storeId,
                                                    @ApiParam(value = "项目ID", required = true) @PathVariable(value = "productId") int productId) {
        return this.productFeign.findBySaleStatus(storeId, productId);
    }

    /**
     * 项目审核
     *
     * @param id          ID
     * @param auditStatus 审核状态  0,待审核  1,已审核 2,不通过
     * @param auditReason 审核原因
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "项目审核")
    @PutMapping(value = "/modify/auditStatus/{id}/{auditStatus}")
    public ResponseMessage modifySaleStatusBySelf(@ApiParam(value = "ID") @PathVariable(value = "id") int id,
                                                  @ApiParam(value = "审核状态  0,待审核  1,已审核 2,不通过") @PathVariable(value = "auditStatus") int auditStatus,
                                                  @ApiParam(value = "审核原因") @RequestParam(value = "auditReason") String auditReason) {
        return this.productFeign.modifyAuditStatus(id, auditStatus, auditReason);
    }

    /**
     * 项目收藏
     *
     * @param productCollection 项目收藏
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目收藏")
    @PostMapping(value = "/collection")
    public ResponseMessage collection(@ApiParam(value = "项目收藏") @RequestBody ProductCollection productCollection) {
        return this.productFeign.collection(productCollection);
    }

    /**
     * 项目库存检查
     *
     * @param inventoryVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目库存检查")
    @PostMapping("/inventoryCheck")
    public ResponseMessage inventoryCheck(@ApiParam(value = "查询条件") @RequestBody ProductByInventoryVo inventoryVo) {
        return this.productFeign.inventoryCheck(inventoryVo);
    }

    /**
     * 项目库存订单预约
     *
     * @param inventoryVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目库存订单预约")
    @PostMapping(value = "/inventoryOrderReservation")
    public ResponseMessage inventoryOrderReservation(@ApiParam(value = "项目库存订单预约") @RequestBody ProductByInventoryVo inventoryVo) {
        return this.productFeign.inventoryOrderReservation(inventoryVo);
    }

    /**
     * 项目库存取消订单预约
     *
     * @param inventoryCancelOrderReservationVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目库存取消订单预约")
    @PostMapping(value = "/inventoryCancelOrderReservation")
    public ResponseMessage inventoryCancelOrderReservation(@ApiParam(value = "项目库存取消订单预约") @RequestBody ProductByInventoryCancelOrderReservationVo inventoryCancelOrderReservationVo) {
        return this.productFeign.inventoryCancelOrderReservation(inventoryCancelOrderReservationVo);
    }

    /**
     * 项目库存消耗
     *
     * @param inventoryVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目库存消耗")
    @PostMapping(value = "/inventoryConsumption")
    public ResponseMessage inventoryConsumption(@ApiParam(value = "项目库存消耗") @RequestBody ProductByInventoryVo inventoryVo) {
        return this.productFeign.inventoryConsumption(inventoryVo);
    }

    /**
     * 根据ID查询项目
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询项目")
    @GetMapping(value = "/findById/{id}")
    public ResponseMessage<Product> findById(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productFeign.findById(id);
    }

    /**
     * 累积销量
     *
     * @param productBySaleVolumeVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "累积销量")
    @PostMapping("/accumulateBySaleVolume")
    public ResponseMessage accumulateBySaleVolume(@ApiParam(value = "销量") @RequestBody ProductBySaleVolumeVo productBySaleVolumeVo) {
        return this.productFeign.accumulateBySaleVolume(productBySaleVolumeVo);
    }

    /**
     * 分页查询项目（精选）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param selectVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目（精选）")
    @PostMapping("/findByPageForSelect")
    public ResponseMessage<PageInfo<Product>> findByPageForSelect(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @ApiParam(value = "条件") @RequestBody ProductBySelectVo selectVo) {
        return this.productFeign.findByPageForSelect(pageNo, pageSize, selectVo);
    }

    /**
     * 分页查询招募项目
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询招募项目（美容师-首页-项目管理-项目管理，美容师-首页-项目管理-项目申请）")
    @PostMapping("/1.1.1/findByPageForRecruit")
    public ResponseMessage<PageInfo<ProductByRecruitResVo>> findByPageForRecruitV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                     @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                     @ApiParam(value = "条件") @RequestBody ProductByRecruitVo recruitVo) {
        return this.productFeign.findByPageForRecruitV111(pageNo, pageSize, recruitVo);
    }

    /**
     * 招募项目是否接单（美容师-项目管理-项目管理）
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param isOrder                是否接单，1-是，0-否
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "招募项目是否接单（美容师-项目管理-项目管理）")
    @GetMapping("/1.1.1/isOrderByRecruit/{productBeauticianRefId}/{isOrder}")
    public ResponseMessage<ProductByDetailForRecruitResVo> isOrderByRecruitV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId,
                                                                                @ApiParam(value = "是否接单，1-是，0-否", required = true) @PathVariable(value = "isOrder") boolean isOrder) {
        return this.productFeign.isOrderByRecruitV111(productBeauticianRefId, isOrder);
    }

    /**
     * 删除招募项目（美容师-项目管理-项目管理）
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "删除招募项目（美容师-项目管理-项目管理）")
    @GetMapping("/1.1.1/deleteByRecruit/{productBeauticianRefId}")
    public ResponseMessage<ProductByDetailForRecruitResVo> deleteByRecruitV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId) {
        return this.productFeign.deleteByRecruitV111(productBeauticianRefId);
    }

    /**
     * 美容师-项目管理-项目详情
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param beauticianId           美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "美容师-项目管理-项目详情（美容师-项目管理-项目管理）")
    @GetMapping(value = "/1.1.1/detailByManageForBeautician/{productBeauticianRefId}/{beauticianId}")
    public ResponseMessage<ProductByDetailByManageForBeauticianResVo> detailByManageForBeauticianV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId,
                                                                                                      @ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId) {
        return this.productFeign.detailByManageForBeauticianV111(productBeauticianRefId, beauticianId);
    }

    /**
     * 美容师-项目申请-项目详情
     *
     * @param productStoreRefId 项目-门店-关联ID
     * @param beauticianId      美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "美容师-项目申请-项目详情（美容师-项目管理-项目申请）")
    @GetMapping(value = "/1.1.1/detailByApplyForBeautician/{productStoreRefId}/{beauticianId}")
    public ResponseMessage<ProductByDetailByApplyForBeauticianResVo> detailByApplyForBeauticianV111(@ApiParam(value = "项目-门店-关联ID", required = true) @PathVariable(value = "productStoreRefId") int productStoreRefId,
                                                                                                    @ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId) {
        return this.productFeign.detailByApplyForBeauticianV111(productStoreRefId, beauticianId);
    }

    /**
     * 门店招募项目详情
     *
     * @param productStoreRefId 项目-门店-关联ID
     * @param beauticianId      美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "门店招募项目详情（门店-项目管理）")
    @GetMapping(value = "/1.1.1/getRecruitDetailByStore/{productStoreRefId}/{beauticianId}")
    public ResponseMessage<ProductRecruitDetailResVo> getRecruitDetailByStoreV111(@ApiParam(value = "项目-门店-关联ID", required = true) @PathVariable(value = "productStoreRefId") int productStoreRefId,
                                                                                  @ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId) {
        return this.productFeign.getRecruitDetailByStoreV111(productStoreRefId, beauticianId);
    }


    /**
     * 统计招募项目邀请（美容师-项目管理-项目管理）
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "统计招募项目邀请（美容师-项目管理-项目申请）")
    @GetMapping("/1.1.1/countByRecruitForInvination/{beauticianId}")
    public ResponseMessage<Integer> countByRecruitForInvinationV111(@ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId) {
        return this.productFeign.countByRecruitForInvinationV111(beauticianId);
    }

    /**
     * 申请招募项目（美容师-项目管理-项目申请）
     *
     * @param applyForRecruitVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "申请招募项目（美容师-项目管理-项目申请）")
    @PostMapping("/1.1.1/applyByRecruit")
    public ResponseMessage applyByRecruitV111(@ApiParam(value = "条件") @RequestBody ProductByApplyForRecruitVo applyForRecruitVo) {
        return this.productFeign.applyByRecruitV111(applyForRecruitVo);
    }

    /**
     * 接受招募项目邀请（美容师-项目管理-项目申请-门店邀请）
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "接受招募项目邀请（美容师-项目管理-项目申请-门店邀请）")
    @PutMapping("/1.1.1/acceptByRecruitForInvitation/{productBeauticianRefId}")
    public ResponseMessage acceptByRecruitForInvitationV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId) {
        return this.productFeign.acceptByRecruitForInvitationV111(productBeauticianRefId);
    }

    /**
     * 拒绝招募项目邀请（美容师-项目管理-项目申请-门店邀请）
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param auditReasonVo          审核原因条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "拒绝招募项目邀请（美容师-项目管理-项目申请-门店邀请）")
    @PutMapping("/1.1.1/refuseByRecruitForInvitation/{productBeauticianRefId}")
    public ResponseMessage refuseByRecruitForInvitationV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId,
                                                            @ApiParam(value = "审核原因", required = true) @RequestBody AuditReasonVo auditReasonVo) {
        return this.productFeign.refuseByRecruitForInvitationV111(productBeauticianRefId, auditReasonVo);
    }

    /**
     * 根据门店ID分页查询招募项目（门店-首页-招募挂靠-项目招募-项目招募管理）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  门店ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据门店ID分页查询招募项目（门店-首页-招募挂靠-项目招募-项目招募管理）")
    @PostMapping("/1.1.1/findByPageByStoreIdForRecruit/{storeId}")
    public ResponseMessage<PageInfo<ProductByStoreIdForRecruitResVo>> findByPageByStoreIdForRecruitV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                        @ApiParam(value = "门店ID", required = true) @PathVariable(value = "storeId") int storeId) {
        return this.productFeign.findByPageByStoreIdForRecruitV111(pageNo, pageSize, storeId);
    }

    /**
     * 统计招募项目申请（门店-首页-招募挂靠-项目招募-项目招募管理-项目招募）
     *
     * @param storeId   门店ID
     * @param productId 项目ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "统计招募项目申请（门店-首页-招募挂靠-项目招募-项目招募管理-项目招募（人员选择））")
    @GetMapping("/1.1.1/countByRecruitForApply/{storeId}/{productId}")
    public ResponseMessage<Integer> countByRecruitForApplyV111(@ApiParam(value = "门店ID", required = true) @PathVariable(value = "storeId") int storeId,
                                                               @ApiParam(value = "项目ID", required = true) @PathVariable(value = "productId") int productId) {
        return this.productFeign.countByRecruitForApplyV111(storeId, productId);
    }

    /**
     * 招募项目邀请（门店-首页-招募挂靠-项目招募-项目招募管理-项目招募（人员选择））
     *
     * @param productStoreRefId 项目-门店-关联ID
     * @param beauticianId      美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "招募项目邀请（门店-首页-招募挂靠-项目招募-项目招募管理-项目招募（人员选择））")
    @PostMapping("/1.1.1/invinationByRecruit/{productStoreRefId}/{beauticianId}")
    public ResponseMessage invinationByRecruitV111(@ApiParam(value = "项目-门店-关联ID", required = true) @PathVariable(value = "productStoreRefId") int productStoreRefId,
                                                   @ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId) {
        return this.productFeign.invinationByRecruitV111(productStoreRefId, beauticianId);
    }

    /**
     * 根据美容师ID分页查询项目列表（用户-首页-附近的邦女郎-邦女郎详情（全部项目））
     *
     * @param pageNo         分页索引
     * @param pageSize       每页数量
     * @param beauticianIdVo  条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据美容师ID分页查询项目列表（用户-首页-附近的邦女郎-邦女郎详情（全部项目））")
    @PostMapping("/1.1.1/listByBeauticianId")
    public ResponseMessage<PageInfo<ProductListByBeauticianIdResVo>> listByBeauticianIdV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                            @ApiParam(value = "条件") @RequestBody ProductListByBeauticianIdVo beauticianIdVo) {
        return this.productFeign.listByBeauticianIdV111(pageNo, pageSize, beauticianIdVo);
    }

    /**
     * 同意招募项目申请（门店-首页-招募挂靠-项目招募-项目招募管理-项目申请）
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "同意招募项目申请（门店-首页-招募挂靠-项目招募-项目招募管理-项目申请）")
    @PutMapping("/1.1.1/agreeByApplyForRecruit/{productBeauticianRefId}")
    public ResponseMessage agreeByApplyForRecruitV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId) {
        return this.productFeign.agreeByApplyForRecruitV111(productBeauticianRefId);
    }

    /**
     * 拒绝招募项目申请（门店-首页-招募挂靠-项目招募-项目招募管理-项目申请）
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param auditReasonVo          审核原因
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "拒绝招募项目申请（门店-首页-招募挂靠-项目招募-项目招募管理-项目申请）")
    @PutMapping("/1.1.1/refuseByApplyForRecruit/{productBeauticianRefId}")
    public ResponseMessage refuseByApplyForRecruitV111(@ApiParam(value = "项目-美容师-关联ID", required = true) @PathVariable(value = "productBeauticianRefId") int productBeauticianRefId,
                                                       @ApiParam(value = "审核原因", required = true) @RequestBody AuditReasonVo auditReasonVo) {
        return this.productFeign.refuseByApplyForRecruitV111(productBeauticianRefId, auditReasonVo);
    }

    /**
     * 上门项目详情
     *
     * @param detailVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "上门项目详情（用户-首页-上门项目列表-项目详情，用户-首页-附近的邦女郎-项目详情（邦女郎））", notes = "{\n" +
            "  \"cityId\": 440300,\n" +
            "  \"memberId\": 663,\n" +
            "  \"point\": {\n" +
            "    \"x\": \"20\",\n" +
            "    \"y\": \"100\"\n" +
            "  },\n" +
            "  \"productId\": 418\n" +
            "}")
    @PostMapping("/1.1.1/getHomeDetail")
    public ResponseMessage<ProductHomeDetailResVo> getHomeDetailV111(@ApiParam(value = "条件") @RequestBody ProductHomeDetailVo detailVo) {
        return this.productFeign.getHomeDetailV111(detailVo);
    }

    /**
     * 项目分类筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "项目分类筛选条件")
    @GetMapping("/1.1.1/getCategoryCondition/{cityId}")
    public ResponseMessage<ProductCategoryConditionResVo> getCategoryConditionV111(@ApiParam(value = "城市ID") @PathVariable(value = "cityId") int cityId) {
        return this.productFeign.getCategoryConditionV111(cityId);
    }

    /**
     * 根据分类ID分页查询项目列表
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param categoryIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据分类ID分页查询项目列表（用户-首页-上门项目列表，用户-首页-到店项目列表）")
    @PostMapping("/1.1.1/listByCategoryId")
    public ResponseMessage<PageInfo<ProductListDisplayResVo>> listByCategoryIdV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                   @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                   @ApiParam(value = "条件") @RequestBody ProductListByCategoryIdVo categoryIdVo) {
        return this.productFeign.listByCategoryIdV111(pageNo, pageSize, categoryIdVo);
    }

    /**
     * 根据门店ID分页查询到店项目
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param storeIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据门店ID分页查询到店项目（用户-美店-门店详情）")
    @PostMapping("/1.1.1/listStoreByStoreId")
    public ResponseMessage<PageInfo<ProductListDisplayResVo>> listStoreByStoreIdV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                     @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                     @ApiParam(value = "条件") @RequestBody ProductListStoreByStoreIdVo storeIdVo) {
        return this.productFeign.listStoreByStoreIdV111(pageNo, pageSize, storeIdVo);
    }

    /**
     * 项目库存检查
     *
     * @param productId 项目ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "项目库存检查")
    @GetMapping(value = "/1.1.1/inventoryCheck/{productId}")
    public ResponseMessage inventoryCheckV111(@ApiParam(value = "项目ID", required = true) @PathVariable(value = "productId") int productId) {
        return this.productFeign.inventoryCheckV111(productId);
    }

    /**
     * 美容师项目库存检查
     *
     * @param productId    项目ID
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "美容师项目库存检查")
    @GetMapping(value = "/1.1.1/inventoryCheckByBeauticianId/{productId}/{beauticianId}")
    public ResponseMessage inventoryCheckByBeauticianIdV111(@ApiParam(value = "项目ID", required = true) @PathVariable(value = "productId") int productId,
                                                            @ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId) {
        return this.productFeign.inventoryCheckByBeauticianIdV111(productId, beauticianId);
    }

    /**
     * 项目库存订单预约
     *
     * @param productId    项目ID
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目库存订单预约")
    @PostMapping(value = "/1.1.1/inventoryOrderReservation/{productId}/{beauticianId}")
    public ResponseMessage inventoryOrderReservationV111(@ApiParam(value = "项目ID", required = true) @PathVariable(value = "productId") int productId,
                                                         @ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId) {
        return this.productFeign.inventoryOrderReservationV111(productId, beauticianId);
    }

    /**
     * 项目库存取消订单预约
     *
     * @param inventoryVo 库存条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "项目库存取消订单预约")
    @PutMapping(value = "/1.1.1/inventoryCancelOrderReservation")
    public ResponseMessage inventoryCancelOrderReservationV111(@ApiParam(value = "库存条件") @RequestBody ProductPhysicalByInventoryVo inventoryVo) {
        return this.productFeign.inventoryCancelOrderReservationV111(inventoryVo);
    }

    /**
     * 项目库存消耗
     *
     * @param inventoryVo 库存条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "项目库存消耗")
    @PutMapping(value = "/1.1.1/inventoryConsumption")
    public ResponseMessage inventoryConsumptionV111(@ApiParam(value = "库存条件") @RequestBody ProductPhysicalByInventoryVo inventoryVo) {
        return this.productFeign.inventoryConsumptionV111(inventoryVo);
    }

    /**
     * 项目管理列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param manageVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目管理列表")
    @PostMapping("/1.1.1/listManage")
    public ResponseMessage<PageInfo<ProductListManageResVo>> listManageV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                            @ApiParam(value = "条件") @RequestBody ProductListManageVo manageVo) {
        return this.productFeign.listManageV111(pageNo, pageSize, manageVo);
    }

    /**
     * 招募项目筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "招募项目筛选条件（美容师-项目管理-项目管理，美容师-项目管理-项目申请）")
    @GetMapping("/1.1.1/getRecruitCondition/{cityId}")
    public ResponseMessage<ProductRecruitConditionResVo> getRecruitConditionV111(@ApiParam(value = "城市ID", required = true) @PathVariable(value = "cityId") int cityId) {
        return this.productFeign.getRecruitConditionV111(cityId);
    }

}