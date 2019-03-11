package com.union.aimei.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductProductPhysicalRef;
import com.union.aimei.common.vo.product.app.ProductProductPhysicalRefByBatchVo;
import com.union.aimei.common.vo.product.app.ProductProductPhysicalRefByProductIdReturnVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 项目-产品-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:51
 */
public interface ProductProductPhysicalRefService extends SpringCloudBaseService<ProductProductPhysicalRef> {
    /**
     * 分页查询项目-产品-关联
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页数量
     * @param productProductPhysicalRef 查询条件
     * @return
     */
    PageInfo<ProductProductPhysicalRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductProductPhysicalRef productProductPhysicalRef);

    /**
     * 根据项目ID删除项目-产品-关联
     *
     * @param productId 项目ID
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
     * 根据项目ID查询项目-产品-关联
     *
     * @param productId 项目ID
     * @return
     */
    ResponseMessage<List<ProductProductPhysicalRefByProductIdReturnVo>> findListByProductId(int productId);

    /**
     * 根据项目ID查询项目-产品-关联
     *
     * @param productId 项目ID
     * @return
     */
    ResponseMessage<ProductProductPhysicalRef> getByProductIdV111(int productId);

}