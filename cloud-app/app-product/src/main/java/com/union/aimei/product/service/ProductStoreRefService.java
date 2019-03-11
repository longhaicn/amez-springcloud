package com.union.aimei.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.vo.product.app.ProductStoreRefByByProductIdForOrderVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:34
 */
public interface ProductStoreRefService extends SpringCloudBaseService<ProductStoreRef> {

    /**
     * 分页查询项目-门店-关联
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param productStoreRef 查询条件
     * @return
     */
    PageInfo<ProductStoreRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductStoreRef productStoreRef);

    /**
     * 根据商品ID查询项目-门店-关联（提交订单）
     *
     * @param pageNo                                 分页索引
     * @param pageSize                               每页数量
     * @param productStoreRefByByProductIdForOrderVo
     * @return
     */
    ResponseMessage<PageInfo<ProductStoreRef>> findByPageByProductIdForOrder(Integer pageNo, Integer pageSize, ProductStoreRefByByProductIdForOrderVo productStoreRefByByProductIdForOrderVo);

    /**
     * 根据ID查询项目-门店-关联
     *
     * @param id ID
     * @return
     */
    ResponseMessage<ProductStoreRef> findById(int id);

}