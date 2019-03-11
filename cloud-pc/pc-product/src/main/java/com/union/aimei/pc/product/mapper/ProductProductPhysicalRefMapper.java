package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.ProductProductPhysicalRef;
import com.union.aimei.common.vo.product.pc.ProductProductPhysicalRefByBatchVo;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 项目-产品-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:44
 */
public interface ProductProductPhysicalRefMapper extends BaseMapper<ProductProductPhysicalRef> {

    /**
     * 根据项目ID删除项目-产品-关联
     *
     * @param productId 项目ID
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
     * 根据项目ID查询项目-产品-关联
     * @param productId 项目ID
     * @return
     */
    ProductProductPhysicalRef getByProductId(@Param(value = "productId") int productId);
    
}