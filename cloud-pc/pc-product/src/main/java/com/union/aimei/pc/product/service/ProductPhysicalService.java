package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.pc.PhyByDetailResVo;
import com.union.aimei.common.vo.product.pc.PhyByManageResVo;
import com.union.aimei.common.vo.product.pc.PhyByManageVo;
import com.union.aimei.common.vo.product.pc.ProductPhysicalByAddVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

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
     * 添加产品
     *
     * @param productPhysicalByAddVo
     * @return
     */
    ResponseMessage<ProductPhysical> add(ProductPhysicalByAddVo productPhysicalByAddVo);

    /**
     * 产品库存检查
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    ResponseMessage inventoryCheck(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 产品库存入库
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    ResponseMessage inventroyStorage(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 根据ID查询产品
     *
     * @param id
     * @return
     */
    ResponseMessage<ProductPhysical> findById(int id);

    /**
     * 分页查询产品（管理）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param manageVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<PhyByManageResVo>> findByPageForManage(Integer pageNo, Integer pageSize, PhyByManageVo manageVo);

    /**
     * 产品详情
     *
     * @param id
     * @return
     */
    ResponseMessage<PhyByDetailResVo> detail(int id);

    /**
     * 产品库存订单预约
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    ResponseMessage inventoryOrderReservation(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 产品库存取消订单预约
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    ResponseMessage inventoryCancelOrderReservation(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

    /**
     * 产品库存消耗
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    ResponseMessage inventoryConsumption(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo);

}