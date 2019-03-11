package com.union.aimei.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.common.vo.product.app.PhysicalBeauticianRefListInventoryByProductIdVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalBeauticianRefByBeauticianIdResVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalBeauticianRefByFindVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:50
 */
public interface ProductPhysicalBeauticianRefService extends SpringCloudBaseService<ProductPhysicalBeauticianRef> {
    /**
     * 分页查询产品-美容师-关联
     *
     * @param pageNo                       分页索引
     * @param pageSize                     每页数量
     * @param productPhysicalBeauticianRef 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductPhysicalBeauticianRef>> findByPageForFront(Integer pageNo, Integer pageSize, ProductPhysicalBeauticianRef productPhysicalBeauticianRef);

    /**
     * 产品-美容师-关联查询
     *
     * @param productPhysicalBeauticianRefByFindVo
     * @return
     */
    ResponseMessage<ProductPhysicalBeauticianRef> find(ProductPhysicalBeauticianRefByFindVo productPhysicalBeauticianRefByFindVo);

    /**
     * 分页查询产品-美容师-关联（根据美容师ID）
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage<PageInfo<ProductPhysicalBeauticianRefByBeauticianIdResVo>> findByPageForBeauticianId(Integer pageNo, Integer pageSize, int beauticianId);

    /**
     * 根据项目ID查询存在可消耗库存的产品-美容师-关联列表
     *
     * @param productIdVo 条件
     * @return
     */
    ResponseMessage<List<ProductPhysicalBeauticianRef>> listInventoryByProductIdV111(PhysicalBeauticianRefListInventoryByProductIdVo productIdVo);

}