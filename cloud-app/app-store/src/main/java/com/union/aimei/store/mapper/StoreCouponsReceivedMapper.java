package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreCouponsReceived;
import com.union.common.utils.base.BaseMapper;

/**
 * 店铺优惠券领取
 *
 * @author liurenkai
 * @time 2017/12/22 14:45
 */
public interface StoreCouponsReceivedMapper extends BaseMapper<StoreCouponsReceived> {

    /**
     * 根据会员ID查询店铺优惠券领取总数
     *
     * @param storeCouponsReceived 店铺优惠券领取
     * @return
     */
    int selectByCountByMemberId(StoreCouponsReceived storeCouponsReceived);

    /**
     * 根据优惠券ID，会员ID查询店铺优惠券领取
     *
     * @param storeCouponsReceived
     * @return
     */
    StoreCouponsReceived selectByStoreCouponsIdByMemberId(StoreCouponsReceived storeCouponsReceived);

    /**
     * 根据订单号更新使用状态
     *
     * @param storeCouponsReceived
     * @return
     */
    int updateIsUsedByOrderNo(StoreCouponsReceived storeCouponsReceived);

}