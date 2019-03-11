package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductPhysicalFeign;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.pc.PhyByDetailResVo;
import com.union.aimei.common.vo.product.pc.PhyByManageResVo;
import com.union.aimei.common.vo.product.pc.PhyByManageVo;
import com.union.aimei.common.vo.product.pc.ProductPhysicalByAddVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 产品
 *
 * @author liurenkai
 * @time 2018/2/28 16:18
 */
@Component(value = "pc-ProductPhysicalFeign")
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
    public ResponseMessage<ProductPhysical> add(ProductPhysicalByAddVo productPhysicalByAddVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryCheck(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventroyStorage(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductPhysical> findById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<PhyByManageResVo>> findByPageForManage(Integer pageNo, Integer pageSize, PhyByManageVo manageVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PhyByDetailResVo> detail(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryOrderReservation(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryCancelOrderReservation(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage inventoryConsumption(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return HystrixResponse.invokeFail();
    }
}