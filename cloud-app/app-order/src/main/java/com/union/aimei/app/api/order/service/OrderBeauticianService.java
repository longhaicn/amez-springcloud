package com.union.aimei.app.api.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.vo.order.BeauticianArrangeVo;
import com.union.aimei.common.vo.order.BeauticianBusyTimeVo;
import com.union.aimei.common.vo.order.BeauticianReserved;
import com.union.aimei.common.vo.order.ChooseBeauticianListVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:42
 */
public interface OrderBeauticianService {




    /**
     * 查询店铺美容师预约看板
     * @param pageNo
     * @param pageSize
     * @param storeId
     * @param chooseTime
     * @return
     */
    ResponseMessage<PageInfo<BeauticianReserved>> reservedBoard(Integer pageNo, Integer pageSize, Integer storeId, String chooseTime);


    /**
     * 查询店铺美容师安排详情查询
     * @param pageNo
     * @param pageSize
     * @param storeId
     * @param id
     * @param chooseTime
     * @return
     */
    ResponseMessage<PageInfo<BeauticianArrangeVo>> beauticianArrange(Integer pageNo, Integer pageSize, Integer storeId, Integer id, String chooseTime);


    /**
     * 查询美容师已安排时间
     * @param chooseBeauticianListVo
     * @return ResponseMessage
     */
    ResponseMessage<List<BeauticianBusyTimeVo>> queryBeauticianBusyTime(ChooseBeauticianListVo chooseBeauticianListVo);


    /**
     * 通过订单ID查询订单美容师信息
     * @param orderId
     * @return
     */
    ResponseMessage<OrderBeautician> queryByOrderId(Integer orderId);

    /**
     * 通过订单编号查询
     * @param orderNo
     * @return
     */
    ResponseMessage<OrderBeautician> queryByOrderNo(String orderNo);

    /**
     * 查询美容师当前时间是否已安排
     * @param chooseBeauticianListVo
     * @return
     */
    ResponseMessage<List<Integer>> queryBeauticianChooseTimeTimeForBusy(ChooseBeauticianListVo chooseBeauticianListVo);



}