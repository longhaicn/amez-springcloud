package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.PhysicalFreightTemplateRef;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 产品-运费模板-关联
 *
 * @author liurenkai
 * @time 2018/3/12 16:35
 */
public interface PhysicalFreightTemplateRefService extends SpringCloudBaseService<PhysicalFreightTemplateRef> {

    /**
     * 分页查询产品-运费模板-关联
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页数量
     * @param physicalFreightTemplateRef 查询条件
     * @return
     */
    ResponseMessage<PageInfo<PhysicalFreightTemplateRef>> findByPageForFront(Integer pageNo, Integer pageSize, PhysicalFreightTemplateRef physicalFreightTemplateRef);

    /**
     * 添加
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    ResponseMessage add(PhysicalFreightTemplateRef physicalFreightTemplateRef);
}