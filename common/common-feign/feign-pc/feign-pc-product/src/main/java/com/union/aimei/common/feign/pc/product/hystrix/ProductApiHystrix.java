package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductFeign;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目
 *
 * @author liurenkai
 * @time 2018/1/5 19:18
 */
@Component(value = "pc-ProductFeign")
public class ProductApiHystrix implements ProductFeign {

    @Override
    public ResponseMessage<Product> add(Product product) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modify(Product product) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Product> addStoreSelf(ProductStoreSelfAddVo addVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Product> addBrand(ProductBrandAddVo addVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Product> addPlatformSelf(ProductPlatformSelfAddVo addVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Product> modifyStoreSelf(ProductStoreSelfModifyVo modifyVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Product> modifyBrand(ProductBrandModifyVo modifyVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Product> modifyPlatformSelf(ProductPlatformSelfModifyVo modifyVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductByDetailResVo> detailByStoreSelf(int productId, int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductByDetailResVo> detailByBrand(int productId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductByDetailResVo> detailByPlatformSelf(int productId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage storeByOnSale(ProductByOnSaleVo onSaleVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage storeByOffShelves(ProductByOffShelvesVo offShelvesVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage onSale(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage offShelves(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modifyAuditStatus(int id, int auditStatus, String auditReason) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForBrand(Integer pageNo, Integer pageSize, ProductByBrandVo brandVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Product>> findListByBrandId(Integer brandId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<ProductByMemberCardResultVo>> findByPageForMemberCard(Integer pageNo, Integer pageSize, ProductByMemberCardVo memberCardVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForStore(Integer pageNo, Integer pageSize, ProductByStoreVo storeVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> pendingByCount(StoreByDataCountVo dataCountVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> addByCount(StoreByDataCountVo dataCountVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Product>> findListByStoreId(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Product>> findListByIdBatch(IdBatchVo idBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage labelByBatch(ProductByLabelBatchVo labelBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForLabel(Integer pageNo, Integer pageSize, ProductByLabelVo labelVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductByStoreCouponsResultVo> findByPageForStoreCoupons(ProductByStoreCouponsVo storeCouponsVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchV110(IdBatchVo idBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Integer>> findIsEnableIdListByIdBatchV110(IdBatchVo idBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Product>> listManage(Integer pageNo, Integer pageSize, ProductByManageVo manageVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage removeById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Product>> listStoreHomeFloor(Integer pageNo, Integer pageSize, ProductListStoreHomeFloorVo homeFloorVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Product>> findByPageForSelect(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForCouponsId(Integer pageNo, Integer pageSize, int couponsId) {
        return HystrixResponse.invokeFail();
    }

}