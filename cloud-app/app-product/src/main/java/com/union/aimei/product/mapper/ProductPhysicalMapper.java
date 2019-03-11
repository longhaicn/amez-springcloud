package com.union.aimei.product.mapper;

import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.app.ProductPhysicalByCategoryVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByIdBatchVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByInventoryVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 产品
 *
 * @author liurenkai
 * @time 2018/2/28 15:44
 */
public interface ProductPhysicalMapper extends BaseMapper<ProductPhysical> {

    /**
     * 根据分类查询产品
     *
     * @param productPhysicalByCategoryVo
     * @return
     */
    List<ProductPhysical> selectListByCategory(ProductPhysicalByCategoryVo productPhysicalByCategoryVo);

    /**
     * 批量根据ID查询产品
     *
     * @param productPhysicalByIdBatchVo
     * @return
     */
    List<ProductPhysical> selectListByIdBatch(ProductPhysicalByIdBatchVo productPhysicalByIdBatchVo);

    /**
     * 产品库存采购检查
     *
     * @param inventoryVo 库存条件
     * @return
     */
    boolean inventoryPurchaseCheck(ProductPhysicalByInventoryVo inventoryVo);

    /**
     * 产品库存采购预约
     *
     * @param inventoryVo 库存条件
     * @return
     */
    int inventoryPurchaseReservation(ProductPhysicalByInventoryVo inventoryVo);

}