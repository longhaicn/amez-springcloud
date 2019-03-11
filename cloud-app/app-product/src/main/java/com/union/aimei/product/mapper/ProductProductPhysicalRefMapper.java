package com.union.aimei.product.mapper;

import com.union.aimei.common.model.product.ProductProductPhysicalRef;
import com.union.aimei.common.vo.product.app.ProductProductPhysicalRefByBatchVo;
import com.union.aimei.common.vo.product.app.ProductProductPhysicalRefByProductIdReturnVo;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目-产品-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:44
 */
public interface ProductProductPhysicalRefMapper extends BaseMapper<ProductProductPhysicalRef> {

    /**
     * 根据商品ID删除项目-产品-关联
     *
     * @param productId 商品ID
     * @return
     */
    int deleteByProductId(@Param(value = "productId") int productId);

    /**
     * 批量添加项目-产品-关联
     *
     * @param productProductPhysicalRefByBatchVo
     * @return
     */
    int addBatch(ProductProductPhysicalRefByBatchVo productProductPhysicalRefByBatchVo);

    /**
     * 根据商品ID查询项目-产品-关联
     *
     * @param productId 商品ID
     * @return
     */
    List<ProductProductPhysicalRef> selectListByProductId(@Param(value = "productId") int productId);

    /**
     * 根据商品ID查询项目-产品-关联
     *
     * @param productId 商品ID
     * @return
     */
    List<ProductProductPhysicalRefByProductIdReturnVo> selectListByProductIdForOrder(@Param(value = "productId") int productId);

    /**
     * 根据商品ID查询项目-产品-关联
     *
     * @param productId 商品ID
     * @return
     */
    ProductProductPhysicalRef getByProductId(@Param(value = "productId") int productId);

}