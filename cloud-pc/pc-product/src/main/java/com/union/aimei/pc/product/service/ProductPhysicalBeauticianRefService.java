package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

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
    
}