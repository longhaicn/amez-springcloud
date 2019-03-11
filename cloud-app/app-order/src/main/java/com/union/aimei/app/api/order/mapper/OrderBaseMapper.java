package com.union.aimei.app.api.order.mapper;


import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.vo.order.*;
import com.union.common.utils.base.BaseMapper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:37
 */
public interface OrderBaseMapper extends BaseMapper<OrderBase> {
    /**
     * 获取用户最新添加订单信息
     * @param memberId 用户ID
     * @return
     */
    OrderBase getMemberNewestOrderInfo(Integer memberId);

    /**
     * 根据订单编号查询订单基本信息
     * @param orderNo
     * @return
     */
    OrderBase getByOrderNo(String orderNo);

    /**
     * 根据订单编号修改订单支付方式
     * @param map
     * @return
     */
    int updateStateAfterPay(Map<String,Object> map);

    /**
     * 查询订单信息
     * @param orderBase
     * @return
     */
     List<HashMap<String,Object>> selectOrderInfo(OrderBase orderBase);

    /**
     * 查询美容师订单
     * @param beauticianQueryVo
     * @return
     */
     List<HashMap<String,Object>> selectBeauticianOrderInfo(BeauticianQueryVo beauticianQueryVo);

    /**
     * 查询会员订单美容师信息
     * @param map
     * @return Map<String,Object
     */
     Map<String,Object> queryMemberHasConsumer(Map<String,Object> map);

    /**
     * 查询推送APP及短信消息对象
     * @param orderId
     * @return
     */
    OrderSendAppVo queryById(Integer orderId);

    /**
     * 查询退款失败原因
     * @param orderId
     * @return
     */
    HashMap<String,Object> queryRefundFail(Integer orderId);

    /**
     * 查询美容师订单信息
     * @param beauticianId
     * @return
     */
    List<CountBeauticianIncomeVo> countBeauticianPreIncome(Integer beauticianId);

    /**
     * 查询美容师大于当前时间的订单
     * @param updateAppointmentTimeV
     * @return
     */
    List<OrderBase> queryBeauticianOrderBase(UpdateAppointmentTimeVo updateAppointmentTimeV);


    /**
     * 统计店铺不同状态的订单数量
     * @param storeId
     * @return
     */
    List<StoreTodayOrderCount> queryOrderNumByStoreId(int storeId);

    /**
     * 统计美容师不同状态的订单数量
     * @param beauticianId
     * @return
     */
    List<BeauticianTodayOrderCount> queryOrderNoByBeauticianId(int beauticianId);

    /**
     * 统计店铺营业额
     * @param map
     * @return
     */
    Integer countStoreTurnoverByDays(Map<String,Object> map);

    /**
     * 统计平台营业额
     * @param ma
     * @return
     */
    Integer countPlatformTurnoverByDays(Map<String,Object> ma);
}