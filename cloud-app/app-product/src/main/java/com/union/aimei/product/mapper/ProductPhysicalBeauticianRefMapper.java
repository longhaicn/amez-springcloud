package com.union.aimei.product.mapper;

import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.common.vo.product.app.*;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:43
 */
public interface ProductPhysicalBeauticianRefMapper extends BaseMapper<ProductPhysicalBeauticianRef> {

    /**
     * 商品库存检查（美容师）
     *
     * @param inventoryVo
     * @return
     */
    int inventoryCheckByBeautician(ProductByInventoryVo inventoryVo);

    /**
     * 商品库存检查（店铺）
     *
     * @param inventoryVo
     * @return
     */
    int inventoryCheckByStore(ProductByInventoryVo inventoryVo);

    /**
     * 产品库存订单预约（美容师）
     *
     * @param inventoryVo
     * @return
     */
    int inventoryOrderReservationByBeautician(ProductPhysicalBeauticianRefByInventoryVo inventoryVo);

    /**
     * 产品库存订单预约（店铺）
     *
     * @param inventoryVo
     * @return
     */
    int inventoryOrderReservationByStore(ProductPhysicalBeauticianRefByInventoryVo inventoryVo);

    /**
     * 产品库存取消订单预约（美容师）
     *
     * @param inventoryVo
     * @return
     */
    int inventoryCancelOrderReservationByBeautician(ProductPhysicalBeauticianRefByInventoryVo inventoryVo);

    /**
     * 产品库存取消订单预约（店铺）
     *
     * @param inventoryVo
     * @return
     */
    int inventoryCancelOrderReservationByStore(ProductPhysicalBeauticianRefByInventoryVo inventoryVo);

    /**
     * 产品库存订单预约（美容师）
     *
     * @param inventoryVo
     * @return
     */
    int inventoryConsumptionByBeautician(ProductPhysicalBeauticianRefByInventoryVo inventoryVo);

    /**
     * 产品库存订单预约（店铺）
     *
     * @param inventoryVo
     * @return
     */
    int inventoryConsumptionByStore(ProductPhysicalBeauticianRefByInventoryVo inventoryVo);

    /**
     * 查询产品-美容师-关联（根据美容师ID）
     *
     * @param beauticianId 美容师ID
     * @return
     */
    List<ProductPhysicalBeauticianRefByBeauticianIdResVo> selectListByBeauticianId(@Param("beauticianId") int beauticianId);

    /**
     * 产品库存检查
     *
     * @param inventoryVo 库存条件
     * @return
     */
    boolean inventoryCheck(ProductPhysicalByInventoryVo inventoryVo);

    /**
     * 产品库存订单预约
     *
     * @param inventoryVo 库存条件
     * @return
     */
    int inventoryOrderReservation(ProductPhysicalByInventoryVo inventoryVo);

    /**
     * 产品库存取消订单预约
     *
     * @param inventoryVo 库存条件
     * @return
     */
    int inventoryCancelOrderReservation(ProductPhysicalByInventoryVo inventoryVo);

    /**
     * 产品库存消耗
     *
     * @param inventoryVo 库存条件
     * @return
     */
    int inventoryConsumption(ProductPhysicalByInventoryVo inventoryVo);

    /**
     * 产品库存采购预约
     *
     * @param inventoryVo 库存条件
     * @return
     */
    int inventoryPurchaseReservation(ProductPhysicalByInventoryVo inventoryVo);

    /**
     * 根据产品ID，美容师ID查询产品-美容师-关联
     *
     * @param condMap 条件
     * @return
     */
    ProductPhysicalBeauticianRef getByRefId(Map<String, Object> condMap);

    /**
     * 产品库存取消采购预约
     *
     * @param inventoryVo 库存条件
     * @return
     */
    int inventoryCancelPurchaseReservation(ProductPhysicalByInventoryVo inventoryVo);

    /**
     * 产品库存采购入库
     *
     * @param inventoryVo 库存条件
     * @return
     */
    int inventoryPurchaseStorage(ProductPhysicalByInventoryVo inventoryVo);

    /**
     * 根据项目ID查询存在可消耗库存的产品-美容师-关联
     *
     * @param condMap 条件
     * @return
     */
    List<ProductPhysicalBeauticianRef> listInventoryByProductId(Map<String, Object> condMap);

}