package com.union.aimei.app.api.order.mapper;


import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.vo.order.BeauticianArrangeVo;
import com.union.aimei.common.vo.order.ChooseBeauticianListVo;
import com.union.aimei.common.vo.order.OrderTimeVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:40
 */
public interface OrderBeauticianMapper extends BaseMapper<OrderBeautician> {
    /**
     * 根据订单ID查询订单美容师信息
     * @param orderId
     * @return
     */
    OrderBeautician queryByOrderId(Integer orderId);

    /**
     * 查询美容师预约看板
     * @param map
     * @return
     */
    @Deprecated
    List<Map<String,Object>> queryBeauticianReserved(Map<String,Object> map);

    /**
     * 查询美容师订单安排计划
     * @param map
     * @return
     */
    List<BeauticianArrangeVo> queryBeauticianArrange(Map<String,Object> map);

    /**
     * 根据店铺ID和所选时间分组查询店铺美容师
     * @param map
     * @return
     */
    List<Map<String,Object>> queryStoreBeauticianByGroup(Map<String,Object> map);

    /**
     * 根据美容师ID和所选时间查询店铺美容师订单数量
     * @param map
     * @return
     */
    int queryBeauticianOrderNum(Map<String,Object> map);

    /**
     * 根据美容师ID查询订单简单详情
     * @param map
     * @return
     */
    List<Map<String,Object>> queryBeauticianOrderInfo(Map<String,Object> map);

    /**
     * 查询店铺美容师订单时间信息
     * @param map
     * @return
     */
    Set<OrderTimeVo> queryStoreBeauticianOrderTime(Map<String,Object> map);

    /**
     * 查询美容师当前时间是否已安排
     * @param chooseBeauticianListVo
     * @return
     */
    List<Integer> queryBeauticianChooseTimeTimeForBusy(ChooseBeauticianListVo chooseBeauticianListVo);

    /**
     * 通过订单编号查询
     * @param orderNo
     * @return
     */
    OrderBeautician queryByOrderNo(String orderNo);


}