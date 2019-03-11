package com.union.aimei.common.feign.app.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.hystrix.OrderBaseApiHystrix;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.vo.order.*;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,10:51
 */
@FeignClient(serviceId = "APP-ORDER-SERVICE", fallback = OrderBaseApiHystrix.class)
public interface OrderBaseFeign {
    /**
     * 添加订单
     *
     * @param orderBase
     * @return
     */
    @PostMapping(value = "/orderBase/insert")
    int insert(@RequestBody OrderBase orderBase);

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/orderBase/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改订单
     *
     * @param orderBase
     * @return
     */
    @PutMapping(value = "/orderBase/edit")
    int edit(@RequestBody OrderBase orderBase);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderBase
     */
    @GetMapping(value = "/orderBase/queryById/{id}")
    OrderBase queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询订单
     *
     * @param pageNo    分页索引
     * @param pageSize  每页显示数量
     * @param orderBase 查询条件
     * @return
     */
    @PostMapping(value = "/orderBase/front/findByPage")
    ResponseMessage<PageInfo<HashMap<String, Object>>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                                  Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                  Integer pageSize, @RequestBody OrderBase orderBase);


    /**
     * 提交项目订单
     *
     * @param submitOrderVo
     * @return
     */
    @PostMapping(value = "/orderBase/submitProductOrder")
    ResponseMessage<HashMap<String, Object>> submitProductOrder(@RequestBody SubmitOrderVo submitOrderVo);

    /**
     * 验证二维码数字码
     *
     * @param isStoreOwner     是否店长
     * @param mobile           手机号
     * @param storeId          门店ID
     * @param beauticianId     美容师ID
     * @param orderNo          订单编号
     * @param verificationCode 验证码
     * @return
     */
    @GetMapping(value = "/orderBase/verificationByCode")
    ResponseMessage verificationByCode(@RequestParam(value = "isStoreOwner", required = false) Integer isStoreOwner,
                                       @RequestParam(value = "mobile") String mobile,
                                       @RequestParam(value = "storeId", required = false) Integer storeId,
                                       @RequestParam(value = "beauticianId") Integer beauticianId,
                                       @RequestParam(value = "orderNo") String orderNo,
                                       @RequestParam(value = "verificationCode") String verificationCode);

    /**
     * 申请退款
     *
     * @param orderNo 订单编号
     * @param reason  原因
     * @param remark  备注
     * @return
     */
    @GetMapping(value = "/orderBase/refund")
    ResponseMessage refund(@RequestParam(name = "orderNo", value = "orderNo") String orderNo,
                           @RequestParam(name = "reason", value = "reason") String reason,
                           @RequestParam(name = "remark", value = "remark", required = false) String remark);


    /**
     * 修改退款申请
     *
     * @param orderNo 订单编号
     * @param reason  原因
     * @param remark  备注
     * @return
     */
    @GetMapping(value = "/orderBase/updateRefundApplication")
    ResponseMessage updateRefundApplication(@RequestParam(name = "orderNo", value = "orderNo") String orderNo,
                                            @RequestParam(name = "reason", value = "reason") String reason,
                                            @RequestParam(name = "remark", value = "remark", required = false) String remark);

    /**
     * 撤销退款请求
     *
     * @param orderId 订单ID
     * @return
     */
    @GetMapping(value = "/orderBase/cancelRefundApply/{orderId}")
    ResponseMessage cancelRefundApply(@PathVariable(value = "orderId") Integer orderId);


    /**
     * 审核退款申请
     *
     * @param auditRefundVo
     * @return
     */
    @PostMapping(value = "/orderBase/auditOrderRefund")
    ResponseMessage auditRefundApply(@RequestBody AuditRefundVo auditRefundVo);


    /**
     * 调换订单美容师
     *
     * @param orderNo
     * @param beauticianId
     * @return
     */
    @GetMapping(value = "/orderBase/changeOrderBeautician")
    ResponseMessage changeOrderBeautician(@RequestParam(value = "orderNo") String orderNo, @RequestParam(value = "beauticianId") Integer beauticianId);

    /**
     * 查询退款详情
     *
     * @param orderNo
     * @return
     */
    @GetMapping(value = "/orderBase/queryRefundDetails/{orderNo}")
    ResponseMessage<RefundDetailsVo> queryRefundDetails(@PathVariable(value = "orderNo") String orderNo);

    /**
     * 根据订单编号查询订单信息
     *
     * @param orderNo
     * @return
     */
    @GetMapping(value = "/orderBase/queryByOrder")
    OrderBase queryByOrderNo(@RequestParam(value = "orderNo") String orderNo);

    /**
     * 订单支付成功更改订单信息
     *
     * @param returnVo
     * @return
     */
    @PostMapping(value = "/orderBase/updateStateAfterPay")
    ResponseMessage updateStateAfterPay(@RequestBody PayReturnVo returnVo);

    /**
     * 根据传入订单ID查询订单详情
     *
     * @param id
     * @return
     */
    @GetMapping("/orderBase/queryOrderDetailsInfO/{id}")
    ResponseMessage<HashMap<String, Object>> queryOrderDetailsInfO(@PathVariable(value = "id") Integer id);

    /**
     * 查询会员在门店是否消费过
     *
     * @param storeId
     * @param memberId
     * @return
     */
    @GetMapping(value = "/orderBase/hasConsumer/{storeId}/{memberId}")
    ResponseMessage queryMemberHasConsumer(
            @PathVariable(value = "storeId") Integer storeId
            , @PathVariable(value = "memberId") Integer memberId);


    /**
     * 通过订单编号查询订单全部信息
     *
     * @param orderNo
     * @return
     */
    @GetMapping(value = "/orderBase/queryOrderAllInfo/{orderNo}")
    ResponseMessage<SubmitOrder> queryOrderAllInfoByOrderNo(@PathVariable(value = "orderNo") String orderNo);

    /**
     * 通过订单ID查询发送APP消息对象
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "/orderBase/querySendToAppVo/{orderId}")
    ResponseMessage<OrderSendAppVo> querySendToAppVoByOrderId(@PathVariable(value = "orderId") Integer orderId);


    /**
     * 美容师查询订单信息
     *
     * @param pageNo
     * @param pageSize
     * @param beauticianQueryVo
     * @return
     */
    @PostMapping(value = "/orderBase/queryByCondition")
    PageInfo<HashMap<String, Object>> queryByCondition(
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestBody BeauticianQueryVo beauticianQueryVo);


    /**
     * 查询退款失败原因及凭证
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "/orderBase/queryOrderRefundFailInfo/{orderId}")
    ResponseMessage<HashMap<String, Object>> queryOrderRefundFailInfo(@PathVariable(value = "orderId") Integer orderId);


    /**
     * 统计美容师预收入金额
     *
     * @param beauticianId
     * @return
     */
    @GetMapping(value = "/orderBase/countBeauticianPreIncome/{beauticianId}")
    ResponseMessage<Integer> countBeauticianPreIncome(@PathVariable(value = "beauticianId") Integer beauticianId);

    /**
     * 修改订单预约时间
     *
     * @param updateAppointmentTimeVo
     * @return
     */
    @PostMapping(value = "/orderBase/updateAppointmentTime")
    ResponseMessage updateAppointmentTime(@RequestBody UpdateAppointmentTimeVo updateAppointmentTimeVo);


    /**
     * 查询店铺不同状态订单数量
     *
     * @param storeId
     * @return
     */
    @GetMapping(value = "/orderBase//queryOrderNumByStoreId/{storeId}")
    ResponseMessage<List<StoreTodayOrderCount>> queryOrderNumByStoreId(@PathVariable(value = "storeId") Integer storeId);


    /**
     * 查询美容师不同状态订单数量
     *
     * @param beauticianId
     * @return
     */
    @GetMapping(value = "/orderBase//queryOrderNumByBeauticianId/{beauticianId}")
    ResponseMessage<List<BeauticianTodayOrderCount>> queryOrderNumByBeauticianId(@PathVariable(value = "beauticianId") Integer beauticianId);

}