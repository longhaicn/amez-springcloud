package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductCollection;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.common.vo.store.app.ProductStoreByNameVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品
 *
 * @author liurenkai
 * @time 2018/1/16 19:40
 */
@Component(value = "app-ProductFeign")
public class ProductApiHystrix implements ProductFeign {

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForFront(Integer pageNo, Integer pageSize, Product product) {
        return HystrixResponse.invokeFail();
    }


    @Override
    public ResponseMessage<PageInfo<ProductByNameResultVo>> findByPageForName(Integer pageNo, Integer pageSize, ProductStoreByNameVo productStoreByNameVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductStoreByNameResultVo> findProductStoreByPageForName(Integer pageNo, Integer pageSize, ProductStoreByNameVo productStoreByNameVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductByStoreCouponsResultVo> findByPageForStoreCoupons(ProductByStoreCouponsVo productByStoreCouponsVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForStoreIdForSort(Integer pageNo, Integer pageSize, ProductByStoreIdForSortVo productByStoreIdForSortVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage onSaleV111(ProductOnSaleVo onSaleVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage offShelvesV111(ProductOffShelvesVo offShelvesVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductByDetailByResultVo> detail(ProductByDetailVo productByDetailVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Product> findBySaleStatus(int storeId, int productId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modifyAuditStatus(int id, int auditStatus, String auditReason) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage collection(ProductCollection productCollection) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryCheck(ProductByInventoryVo inventoryVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryOrderReservation(ProductByInventoryVo inventoryVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryCancelOrderReservation(ProductByInventoryCancelOrderReservationVo productByInventoryCancelOrderReservationVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryConsumption(ProductByInventoryVo inventoryVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Product> findById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage accumulateBySaleVolume(ProductBySaleVolumeVo productBySaleVolumeVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForSelect(Integer pageNo, Integer pageSize, ProductBySelectVo selectVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Product>> findListByStoreId(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<ProductByRecruitResVo>> findByPageForRecruitV111(Integer pageNo, Integer pageSize, ProductByRecruitVo recruitVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> countByRecruitForInvinationV111(int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<ProductByStoreIdForRecruitResVo>> findByPageByStoreIdForRecruitV111(Integer pageNo, Integer pageSize, int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> countByRecruitForApplyV111(int storeId, int productId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchV110(IdBatchVo idBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchForStoreBeauticianV110(IdBatchVo idBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<ProductListByBeauticianIdResVo>> listByBeauticianIdV111(Integer pageNo, Integer pageSize, ProductListByBeauticianIdVo beauticianIdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductCategoryConditionResVo> getCategoryConditionV111(int cityId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<ProductListDisplayResVo>> listByCategoryIdV111(Integer pageNo, Integer pageSize, ProductListByCategoryIdVo categoryIdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<ProductListDisplayResVo>> listStoreByStoreIdV111(Integer pageNo, Integer pageSize, ProductListStoreByStoreIdVo storeIdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryCheckV111(int productId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryCheckByBeauticianIdV111(int productId, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryOrderReservationV111(int productId, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryCancelOrderReservationV111(ProductPhysicalByInventoryVo inventoryVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryConsumptionV111(ProductPhysicalByInventoryVo inventoryVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductByDetailByManageForBeauticianResVo> detailByManageForBeauticianV111(int productBeauticianRefId, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductByDetailByApplyForBeauticianResVo> detailByApplyForBeauticianV111(int productStoreRefId, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductRecruitDetailResVo> getRecruitDetailByStoreV111(int productStoreRefId, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductHomeDetailResVo> getHomeDetailV111(ProductHomeDetailVo detailVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<ProductListManageResVo>> listManageV111(Integer pageNo, Integer pageSize, ProductListManageVo manageVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> getCommissionRatioV111(int productId, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductRecruitConditionResVo> getRecruitConditionV111(int cityId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage appointmentV111(int productId, boolean isAppointment) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateOrderPayV111(ProductUpdateOrderPayVo orderPayVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Product> isOnSaleV111(ProductIsOnSaleVo isOnSaleVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage isOrderByRecruitV111(int productBeauticianRefId, boolean isOrder) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage deleteByRecruitV111(int productBeauticianRefId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage applyByRecruitV111(ProductByApplyForRecruitVo applyForRecruitVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage acceptByRecruitForInvitationV111(int productBeauticianRefId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage refuseByRecruitForInvitationV111(int productBeauticianRefId, AuditReasonVo auditReasonVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage invinationByRecruitV111(int productStoreRefId, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage agreeByApplyForRecruitV111(int productBeauticianRefId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage refuseByApplyForRecruitV111(int productBeauticianRefId, AuditReasonVo auditReasonVo) {
        return HystrixResponse.invokeFail();
    }

}