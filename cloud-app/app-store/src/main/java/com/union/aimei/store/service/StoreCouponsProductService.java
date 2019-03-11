package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 店铺优惠券-商品-关联
 *
 * @author liurenkai
 * @time 2017/12/22 10:52
 */
public interface StoreCouponsProductService {
    /**
     * 前端分页查询店铺优惠券-商品-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param storeCouponsProduct 查询条件
     * @return
     */
    PageInfo<StoreCouponsProduct> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsProduct storeCouponsProduct);

    /**
     * 根据店铺优惠券ID查询店铺优惠券-商品-关联
     *
     * @param storeCouponsId 店铺优惠券ID
     * @return
     */
    ResponseMessage<List<StoreCouponsProduct>> findListByStoreCouponsId(int storeCouponsId);
}