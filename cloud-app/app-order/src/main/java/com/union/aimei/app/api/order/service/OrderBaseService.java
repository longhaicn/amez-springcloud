package com.union.aimei.app.api.order.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.vo.order.*;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.HashMap;
import java.util.List;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:42
 */
@SuppressWarnings("ALL")
public interface OrderBaseService extends SpringCloudBaseService<OrderBase> {
    /**
     * 前端分页查询订单
     *
     * @param pageNo    分页索引
     * @param pageSize  每页显示数量
     * @param orderBase 查询条件
     * @return
     */
    ResponseMessage<PageInfo<HashMap<String,Object>>> findByPageForFront(Integer pageNo, Integer pageSize, OrderBase orderBase);


    /**
     * 提交项目订单
     * @param submitOrderVo
     * @return
     */
    ResponseMessage<HashMap<String,Object>> submitProductOrder(SubmitOrderVo submitOrderVo);


    /**
     * 验证验证码
     * @param isStoreOwner
     * @param mobile
     * @param storeId
     * @param beauticianId
     * @param orderNo
     * @param verificationCode
     * @return
     */
    ResponseMessage verificationByCode(Integer isStoreOwner, String mobile, Integer storeId, Integer beauticianId, String orderNo, String verificationCode);


    /**
     * 申请退款
     * @param orderNo
     * @param reason
     * @param remark
     * @return
     */
     ResponseMessage refund(String orderNo,String reason,String remark);


    /**
     * 修改退款申请
     * @param orderNo
     * @param reason
     * @param remark
     * @return
     */
    ResponseMessage updateRefundApplication(String orderNo,String reason,String remark);


    /**
     * 撤销退款申请
     * @param orderId
     * @return
     */
    ResponseMessage cancelRefundApply(Integer orderId);


    /**
     * 审核退款
     * @param auditRefundVo
     * @return
     */
    ResponseMessage auditRefundApply(AuditRefundVo auditRefundVo);



    /**
     * 根据订单编号查询订单信息
     * @param orderNo
     * @return
     */
     OrderBase queryByOrderNo(String orderNo);

    /**
     * 支付成功回调更新订单信息
     * @param vo
     * @return
     */
    ResponseMessage updateStateAfterPay(PayReturnVo vo);

    /**
     * 根据订单ID查询订单详情，包括订单基础信息，订单美容师，订单商品信息
     * @param id
     * @return
     */
    ResponseMessage<HashMap<String,Object>> getOrderDetailsInfo(Integer id);

    /**
     * 查询用户是否在门店消费过
     * @param storeId
     * @param memberId
     * @return
     */
    ResponseMessage queryMemberHasConsumer(Integer storeId,Integer memberId);

    /**
     * 根据订单编号查询订单全部信息
     * @param orderNo
     * @return
     */
    ResponseMessage<SubmitOrder> queryOrderAllInfoByOrderNo(String orderNo);


    /**
     * 查询退款详情
     * @param orderNo
     * @return
     */
    ResponseMessage<RefundDetailsVo> queryRefundDetails(String orderNo);


    /**
     * 美容师查询订单
     * @param pageNo
     * @param pageSize
     * @param beauticianQueryVo
     * @return
     */
    PageInfo<HashMap<String,Object>> queryByCondition(Integer pageNo, Integer pageSize, BeauticianQueryVo beauticianQueryVo);


    /**
     * 通过订单ID查询推送订单消息对象
     * @param orderId
     * @return
     */
    ResponseMessage<OrderSendAppVo> querySendToAppVoByOrderId(Integer orderId);

    /**
     * 查询订单退款失败信息
     * @param orderId
     * @return
     */
    ResponseMessage<HashMap<String,Object>> queryOrderRefundFailInfo(Integer orderId);



    /**
     * 统计美容师预收入总金额
     * @param beauticianId
     * @return
     */
    ResponseMessage<Integer> countBeauticianPreIncome(Integer beauticianId);



    /**
     * 查询店铺订单数量
     * @param storeId
     * @return
     */
    ResponseMessage<List<StoreTodayOrderCount>> queryOrderNumByStoreId(int storeId);

    /**
     * 查询美容师订单数量
     * @param beauticianId
     * @return
     */
    ResponseMessage<List<BeauticianTodayOrderCount>> queryOrderNumByBeauticianId(int beauticianId);

    /**
     * 根据店铺ID和天数统计店铺营业金额
     * @param statisticsOrderVo
     * @return
     */
    ResponseMessage<Integer> sumOrderAmountByStoreIdAndDays(StatisticsOrderVo statisticsOrderVo);
}