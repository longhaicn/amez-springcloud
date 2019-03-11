package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductProductPhysicalRef;
import com.union.aimei.common.vo.product.pc.ProductProductPhysicalRefByBatchVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 品-产品-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:51
 */
public interface ProductProductPhysicalRefService extends SpringCloudBaseService<ProductProductPhysicalRef> {
    /**
     * 前端分页查询项目-产品-关联
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页显示数量
     * @param productProductPhysicalRef 查询条件
     * @return
     */
    PageInfo<ProductProductPhysicalRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductProductPhysicalRef productProductPhysicalRef);

    /**
     * 根据商品ID删除项目-产品-关联
     *
     * @param productId 商品ID
     * @return
     */
    ResponseMessage deleteByProductId(int productId);

    /**
     * 批量添加项目-产品-关联
     *
     * @param productProductPhysicalRefByBatchVo
     * @return
     */
    ResponseMessage addBatch(ProductProductPhysicalRefByBatchVo productProductPhysicalRefByBatchVo);

    /**
     * 保存项目-产品-关联
     *
     * @param productProductPhysicalRef 项目-产品-关联
     * @return
     */
    ResponseMessage save(ProductProductPhysicalRef productProductPhysicalRef);

}