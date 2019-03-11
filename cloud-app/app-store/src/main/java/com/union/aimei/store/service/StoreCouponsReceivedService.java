package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCouponsReceived;
import com.union.aimei.common.vo.store.app.StoreCouponsReceivedByUsedVo;
import com.union.common.utils.ResponseMessage;

/**
 * 店铺优惠券领取
 *
 * @author liurenkai
 * @time 2017/12/22 11:00
 */
public interface StoreCouponsReceivedService {
    /**
     * 前端分页查询店铺优惠券领取
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeCouponsReceived 查询条件
     * @return
     */
    PageInfo<StoreCouponsReceived> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsReceived storeCouponsReceived);

    /**
     * 领取店铺优惠券
     *
     * @param storeCouponsId 店铺优惠卷ID
     * @param memberId       会员ID
     * @return
     */
    ResponseMessage add(int storeCouponsId, int memberId);

    /**
     * 领取的店铺优惠券使用
     *
     * @param storeCouponsReceivedByUsedVo
     * @return
     */
    ResponseMessage used(StoreCouponsReceivedByUsedVo storeCouponsReceivedByUsedVo);

    /**
     * 根据订单号退还优惠券
     *
     * @param orderNo
     * @return
     */
    ResponseMessage sendBackByOrderNo(String orderNo);

}