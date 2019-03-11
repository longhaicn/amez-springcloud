package com.union.aimei.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductCollection;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.common.vo.store.app.ProductStoreByNameVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 项目
 *
 * @author liurenkai
 * @time 2018/1/16 10:51
 */
public interface ProductService extends SpringCloudBaseService<Product> {

    /**
     * 分页查询项目
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param product  查询条件
     * @return
     */
    ResponseMessage<PageInfo<Product>> findByPageForFront(Integer pageNo, Integer pageSize, Product product);

    /**
     * 分页查询项目（名称）
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productStoreByNameVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductByNameResultVo>> findByPageForName(Integer pageNo, Integer pageSize, ProductStoreByNameVo productStoreByNameVo);

    /**
     * 查询店铺项目（店铺优惠券）
     *
     * @param productByStoreCouponsVo 查询条件
     * @return
     */
    ResponseMessage<ProductByStoreCouponsResultVo> findByPageForStoreCoupons(ProductByStoreCouponsVo productByStoreCouponsVo);

    /**
     * 分页查询项目（店铺）
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页数量
     * @param productByStoreIdForSortVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<Product>> findByPageForStoreIdForSort(Integer pageNo, Integer pageSize, ProductByStoreIdForSortVo productByStoreIdForSortVo);

    /**
     * 项目上架
     *
     * @param onSaleVo 条件
     * @return
     */
    ResponseMessage onSaleV111(ProductOnSaleVo onSaleVo);

    /**
     * 项目下架
     *
     * @param offShelvesVo 条件
     * @return
     */
    ResponseMessage offShelvesV111(ProductOffShelvesVo offShelvesVo);

    /**
     * 项目详情
     *
     * @param productByDetailVo
     * @return
     */
    ResponseMessage<ProductByDetailByResultVo> detail(ProductByDetailVo productByDetailVo);

    /**
     * 查询项目上架状态
     *
     * @param storeId   店铺ID
     * @param productId 项目ID
     * @return
     */
    ResponseMessage<Product> findBySaleStatus(int storeId, int productId);

    /**
     * 项目审核
     *
     * @param id          ID
     * @param auditStatus 审核状态  0,待审核  1,已审核 2,不通过
     * @param auditReason 审核原因
     * @return
     */
    ResponseMessage modifyAuditStatus(int id, int auditStatus, String auditReason);

    /**
     * 项目收藏
     *
     * @param productCollection 项目收藏
     * @return
     */
    ResponseMessage collection(ProductCollection productCollection);

    /**
     * 项目库存检查
     *
     * @param inventoryVo
     * @return
     */
    ResponseMessage inventoryCheck(ProductByInventoryVo inventoryVo);

    /**
     * 项目库存订单预约
     *
     * @param inventoryVo
     * @return
     */
    ResponseMessage inventoryOrderReservation(ProductByInventoryVo inventoryVo);

    /**
     * 项目库存取消订单预约
     *
     * @param inventoryCancelOrderReservationVo
     * @return
     */
    ResponseMessage inventoryCancelOrderReservation(ProductByInventoryCancelOrderReservationVo inventoryCancelOrderReservationVo);

    /**
     * 项目库存消耗
     *
     * @param inventoryVo
     * @return
     */
    ResponseMessage inventoryConsumption(ProductByInventoryVo inventoryVo);

    /**
     * 根据ID查询项目
     *
     * @param id
     * @return
     */
    ResponseMessage<Product> findById(int id);

    /**
     * 累积销量
     *
     * @param productBySaleVolumeVo
     * @return
     */
    ResponseMessage<ProductBySaleVolumeVo> accumulateBySaleVolume(ProductBySaleVolumeVo productBySaleVolumeVo);

    /**
     * 分页查询项目（精选）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param selectVo 条件
     * @return
     */
    ResponseMessage<PageInfo<Product>> findByPageForSelect(Integer pageNo, Integer pageSize, ProductBySelectVo selectVo);

    /**
     * 根据店铺ID查询项目
     *
     * @param storeId 店铺ID
     * @return
     */
    ResponseMessage<List<Product>> findListByStoreId(int storeId);

    /**
     * 分页查询招募项目
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    ResponseMessage<PageInfo<ProductByRecruitResVo>> findByPageForRecruitV111(Integer pageNo, Integer pageSize, ProductByRecruitVo recruitVo);

    /**
     * 统计招募项目邀请（美容师-项目管理-项目管理）
     *
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage<Integer> countByRecruitForInvinationV111(int beauticianId);

    /**
     * 根据门店ID分页查询招募项目
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  门店ID
     * @return
     */
    ResponseMessage<PageInfo<ProductByStoreIdForRecruitResVo>> findByPageByStoreIdForRecruitV111(Integer pageNo, Integer pageSize, int storeId);

    /**
     * 统计招募项目申请
     *
     * @param storeId   门店ID
     * @param productId 项目ID
     * @return
     */
    ResponseMessage<Integer> countByRecruitForApplyV111(int storeId, int productId);

    /**
     * 根据美容师ID分页查询项目
     *
     * @param pageNo         分页索引
     * @param pageSize       每页数量
     * @param beauticianIdVo 条件
     * @return
     */
    ResponseMessage<PageInfo<ProductListByBeauticianIdResVo>> listByBeauticianIdV111(Integer pageNo, Integer pageSize, ProductListByBeauticianIdVo beauticianIdVo);

    /**
     * 批量根据ID查询 项目-分类的关联数据(v1.1.0)
     *
     * @param idBatchVo
     * @return
     */
    ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchV110(IdBatchVo idBatchVo);

    /**
     * 批量根据ID查询 项目-分类的关联数据(v1.1.0)
     * (限定只有美容师服务的项目)
     *
     * @param idBatchVo
     * @return
     */
    ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchForStoreBeauticianV110(IdBatchVo idBatchVo);

    /**
     * 项目分类筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    ResponseMessage<ProductCategoryConditionResVo> getCategoryConditionV111(int cityId);

    /**
     * 根据分类ID分页查询项目列表
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param categoryIdVo 条件
     * @return
     */
    ResponseMessage<PageInfo<ProductListDisplayResVo>> listByCategoryIdV111(Integer pageNo, Integer pageSize, ProductListByCategoryIdVo categoryIdVo);

    /**
     * 根据门店ID分页查询到店项目
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param storeIdVo 条件
     * @return
     */
    ResponseMessage<PageInfo<ProductListDisplayResVo>> listStoreByStoreIdV111(Integer pageNo, Integer pageSize, ProductListStoreByStoreIdVo storeIdVo);

    /**
     * 查询项目是否存在库存
     *
     * @param productId 项目ID
     * @return
     */
    ResponseMessage inventoryCheckV111(int productId);

    /**
     * 根据美容师ID查询项目是否存在库存
     *
     * @param productId    项目ID
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage inventoryCheckByBeauticianIdV111(int productId, int beauticianId);

    /**
     * 项目库存订单预约
     *
     * @param productId    项目ID
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage inventoryOrderReservationV111(int productId, int beauticianId);

    /**
     * 项目库存取消订单预约
     *
     * @param inventoryVo 库存条件
     * @return
     */
    ResponseMessage inventoryCancelOrderReservationV111(ProductPhysicalByInventoryVo inventoryVo);

    /**
     * 项目库存消耗
     *
     * @param inventoryVo 库存条件
     * @return
     */
    ResponseMessage inventoryConsumptionV111(ProductPhysicalByInventoryVo inventoryVo);


    /**
     * 美容师-项目管理-项目详情
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param beauticianId           美容师ID
     * @return
     */
    ResponseMessage<ProductByDetailByManageForBeauticianResVo> detailByManageForBeauticianV111(int productBeauticianRefId, int beauticianId);

    /**
     * 美容师-项目申请-项目详情
     *
     * @param productStoreRefId 项目-门店-关联ID
     * @param beauticianId      美容师ID
     * @return
     */
    ResponseMessage<ProductByDetailByApplyForBeauticianResVo> detailByApplyForBeauticianV111(int productStoreRefId, int beauticianId);

    /**
     * 门店招募项目详情
     *
     * @param productStoreRefId 项目-门店-关联ID
     * @param beauticianId      美容师ID
     * @return
     */
    ResponseMessage<ProductRecruitDetailResVo> getRecruitDetailByStoreV111(int productStoreRefId, int beauticianId);

    /**
     * 上门项目详情
     *
     * @param detailVo 条件
     * @return
     */
    ResponseMessage<ProductHomeDetailResVo> getHomeDetailV111(ProductHomeDetailVo detailVo);

    /**
     * 项目佣金比列
     *
     * @param productId    项目ID
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage<Integer> getCommissionRatioV111(int productId, int beauticianId);

    /**
     * 招募项目筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    ResponseMessage<ProductRecruitConditionResVo> getRecruitConditionV111(int cityId);

    /**
     * 项目管理列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param manageVo 条件
     * @return
     */
    ResponseMessage<PageInfo<ProductListManageResVo>> listManageV111(Integer pageNo, Integer pageSize, ProductListManageVo manageVo);

    /**
     * 项目预约人数
     *
     * @param productId     项目ID
     * @param isAppointment 是否预约，true-预约，false-取消预约
     * @return
     */
    ResponseMessage appointmentV111(int productId, boolean isAppointment);

    /**
     * 订单支付项目更新（销量，预约人数）
     *
     * @param orderPayVo 条件
     * @return
     */
    ResponseMessage updateOrderPayV111(ProductUpdateOrderPayVo orderPayVo);

    /**
     * 项目是否上架
     *
     * @param isOnSaleVo 条件
     * @return
     */
    ResponseMessage<Product> isOnSaleV111(ProductIsOnSaleVo isOnSaleVo);

    /**
     * 招募项目是否接单
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param isOrder                是否接单，1-是，0-否
     * @return
     */
    ResponseMessage isOrderByRecruitV111(int productBeauticianRefId, boolean isOrder);

    /**
     * 删除招募项目
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @return
     */
    ResponseMessage deleteByRecruitV111(int productBeauticianRefId);

    /**
     * 申请招募项目
     *
     * @param applyForRecruitVo 条件
     * @return
     */
    ResponseMessage applyByRecruitV111(ProductByApplyForRecruitVo applyForRecruitVo);

    /**
     * 接受招募项目邀请
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @return
     */
    ResponseMessage acceptByRecruitForInvitationV111(int productBeauticianRefId);

    /**
     * 拒绝招募项目邀请
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param auditReason            审核原因
     * @return
     */
    ResponseMessage refuseByRecruitForInvitationV111(int productBeauticianRefId, String auditReason);

    /**
     * 招募项目邀请
     *
     * @param productStoreRefId 项目-门店-关联ID
     * @param beauticianId      美容师ID
     * @return
     */
    ResponseMessage invinationByRecruitV111(int productStoreRefId, int beauticianId);

    /**
     * 同意招募项目申请
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @return
     */
    ResponseMessage agreeByApplyForRecruitV111(int productBeauticianRefId);

    /**
     * 拒绝招募项目申请
     *
     * @param productBeauticianRefId 项目-美容师-关联ID
     * @param auditReason            申请原因d
     * @return
     */
    ResponseMessage refuseByApplyForRecruitV111(int productBeauticianRefId, String auditReason);

    /**
     * 分页查询项目与店铺（名称）
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productStoreByNameVo 查询条件
     * @return
     */
    ResponseMessage<ProductStoreByNameResultVo> findProductStoreByPageForName(Integer pageNo, Integer pageSize, ProductStoreByNameVo productStoreByNameVo);

}