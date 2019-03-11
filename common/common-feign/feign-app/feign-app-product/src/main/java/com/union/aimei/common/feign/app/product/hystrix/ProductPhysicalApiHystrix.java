package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductPhysicalFeign;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByCalcFreightVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByCategoryVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByIdBatchVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 产品
 *
 * @author liurenkai
 * @time 2018/2/28 16:18
 */
@Component(value = "app-ProductPhysicalFeign")
public class ProductPhysicalApiHystrix implements ProductPhysicalFeign {

    /**
     * 前端分页查询产品
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param productPhysical 查询条件
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<ProductPhysical>> findByPageForFront(Integer pageNo, Integer pageSize, ProductPhysical productPhysical) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加产品
     *
     * @param productPhysical
     * @return
     */
    @Override
    public int insert(ProductPhysical productPhysical) {
        return 0;
    }

    /**
     * 删除产品
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改产品
     *
     * @param productPhysical
     * @return
     */
    @Override
    public int edit(ProductPhysical productPhysical) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductPhysical
     */
    @Override
    public ProductPhysical queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<PageInfo<ProductPhysical>> findByPageForCategory(Integer pageNo, Integer pageSize, ProductPhysicalByCategoryVo productPhysicalByCategoryVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductPhysical> detail(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryCheck(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<ProductPhysical>> findListByIdBatch(ProductPhysicalByIdBatchVo productPhysicalByIdBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> calcFreight(ProductPhysicalByCalcFreightVo calcFreightVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductPhysical> findById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryPurchaseCheckV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryPurchaseReservationV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryCancelPurchaseReservationV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventroyPurchaseStorageV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return HystrixResponse.invokeFail();
    }
    
}