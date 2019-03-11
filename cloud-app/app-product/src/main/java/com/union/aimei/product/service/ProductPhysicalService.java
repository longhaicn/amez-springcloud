package com.union.aimei.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByCalcFreightVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByCategoryVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByIdBatchVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 产品
 *
 * @author liurenkai
 * @time 2018/2/28 15:50
 */
public interface ProductPhysicalService extends SpringCloudBaseService<ProductPhysical> {
    /**
     * 分页查询产品
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productPhysical 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductPhysical>> findByPageForFront(Integer pageNo, Integer pageSize, ProductPhysical productPhysical);

    /**
     * 根据分类分页查询产品
     *
     * @param pageNo                      分页索引
     * @param pageSize                    每页数量
     * @param productPhysicalByCategoryVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductPhysical>> findByPageForCategory(Integer pageNo, Integer pageSize, ProductPhysicalByCategoryVo productPhysicalByCategoryVo);

    /**
     * 产品详情
     *
     * @param id
     * @return
     */
    ResponseMessage<ProductPhysical> detail(int id);

    /**
     * 产品库存检查
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    ResponseMessage inventoryCheck(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 批量根据ID查询产品
     *
     * @param productPhysicalByIdBatchVo
     * @return
     */
    ResponseMessage<List<ProductPhysical>> findListByIdBatch(ProductPhysicalByIdBatchVo productPhysicalByIdBatchVo);

    /**
     * 计算运费
     *
     * @param calcFreightVo
     * @return
     */
    ResponseMessage<Integer> calcFreight(ProductPhysicalByCalcFreightVo calcFreightVo);

    /**
     * 根据ID查询产品
     *
     * @param id
     * @return
     */
    ResponseMessage<ProductPhysical> findById(int id);

    /**
     * 产品库存采购检查
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    ResponseMessage inventoryPurchaseCheckV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 产品库存采购预约
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    ResponseMessage inventoryPurchaseReservationV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 产品库存取消采购预约
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    ResponseMessage inventoryCancelPurchaseReservationV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 产品库存采购入库
     *
     * @param inventoryForBeauticianVo 条件
     * @return
     */
    ResponseMessage inventroyPurchaseStorageV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

}