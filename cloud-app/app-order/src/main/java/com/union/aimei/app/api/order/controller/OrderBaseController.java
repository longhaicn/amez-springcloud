package com.union.aimei.app.api.order.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.vo.order.*;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.aimei.app.api.order.service.OrderBaseService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:51
 */
@RestController
@RequestMapping(value = "orderBase")
public class OrderBaseController {
    private static final Logger log= LoggerFactory.getLogger(OrderBaseController.class);

    @Resource
    private OrderBaseService orderBaseService;

    /**
     * 分页查询订单信息
     * @param pageNo
     * @param pageSize
     * @param orderBase
     * @return
     */
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<HashMap<String,Object>>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                          Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                          Integer pageSize, @ApiParam(value = "查询条件") @RequestBody OrderBase orderBase) {
        return this.orderBaseService.findByPageForFront(pageNo, pageSize, orderBase);
    }


    /**
     * 通过ID查询订单基础信息
     * @param id
     * @return
     */
    @GetMapping("/queryById/{id}")
    public OrderBase queryById(@PathVariable int id) {
        return this.orderBaseService.queryObjById(id);
    }


    @PutMapping(value = "/edit")
    public int edit(@RequestBody OrderBase orderBase){
        return orderBaseService.modifyObj(orderBase);
    }



    /**
     * 根据传入订单ID查询订单详情
     * @param id
     * @return
     */
    @GetMapping("/queryOrderDetailsInfO/{id}")
    public ResponseMessage<HashMap<String,Object>> queryOrderDetailsInfO(@PathVariable(value = "id") Integer id){
        return orderBaseService.getOrderDetailsInfo(id);
    }

    /**
     * 提交项目订单
     * @param
     * @return
     */
    @PostMapping(value = "/submitProductOrder")
    public ResponseMessage<HashMap<String,Object>> submitOrder(@RequestBody SubmitOrderVo submitOrderVo){
        return  orderBaseService.submitProductOrder(submitOrderVo);
    }


    /**
     * 验证二维码数字码
     * @param orderNo 订单编号
     * @param verificationCode 验证码
     * @return
     */
    @GetMapping(value = "/verificationByCode")
    public ResponseMessage verificationByCode( @RequestParam(value = "isStoreOwner",required = false)Integer isStoreOwner,
                                               @RequestParam(value = "mobile")String mobile,
                                               @RequestParam(value = "storeId",required = false)Integer storeId,
                                               @RequestParam(value = "beauticianId")Integer beauticianId,
                                               @RequestParam(value = "orderNo") String orderNo,
                                               @RequestParam(value = "verificationCode") String verificationCode) {
        return orderBaseService.verificationByCode(isStoreOwner, mobile, storeId, beauticianId, orderNo, verificationCode);
    }


    /**
     * 申请退款
     * @return
     */
    @GetMapping(value = "/refund")
    public ResponseMessage refund(@RequestParam(name = "orderNo",value = "orderNo") String orderNo,
                                  @RequestParam(name="reason",value = "reason") String reason,
                                  @RequestParam(name="remark",value = "remark",required = false) String remark){
          return orderBaseService.refund(orderNo,reason,remark);
    }


    /**
     * 修改退款申请
     * @return
     */
    @GetMapping(value = "/updateRefundApplication")
    public ResponseMessage updateRefundApplication(@RequestParam(name = "orderNo",value = "orderNo") String orderNo,
                                                   @RequestParam(name="reason",value = "reason") String reason,
                                                   @RequestParam(name="remark",value = "remark",required = false) String remark){
         return orderBaseService.updateRefundApplication(orderNo,reason,remark);
    }

    /**
     * 撤销退款申请
     * @param orderId
     * @return
     */
    @GetMapping(value = "/cancelRefundApply/{orderId}")
    public ResponseMessage cancelRefundApply(@PathVariable(value = "orderId") Integer orderId){
        return orderBaseService.cancelRefundApply(orderId);
    }

    /**
     * 审核退款申请
     * @param auditRefundVo
     * @return
     */
    @PostMapping(value = "/auditOrderRefund")
    public ResponseMessage auditRefundApply(@RequestBody AuditRefundVo auditRefundVo){
        return orderBaseService.auditRefundApply(auditRefundVo);
    }




    /**
     * 查询退款详情
     * @param orderNo
     * @return
     */
    @GetMapping(value = "/queryRefundDetails/{orderNo}")
    public ResponseMessage<RefundDetailsVo> queryRefundDetails(@PathVariable(value = "orderNo")String orderNo){
        return orderBaseService.queryRefundDetails(orderNo);
    }

    /**
     * 根据订单编号查询订单信息
     * @param orderNo
     * @return
     */
    @GetMapping(value = "/queryByOrder")
    public OrderBase queryByOrderNo(@RequestParam(value = "orderNo") String orderNo) {
          return orderBaseService.queryByOrderNo(orderNo);
    }



    /**
     * 订单支付成功更改订单状态，添加支付类型,交易流水
     * 支付类型(1:支付宝支付，2：微信支付，3：会员卡支付，4：一卡通支付，5：余额支付)
     */
    @PostMapping(value = "updateStateAfterPay")
    public ResponseMessage updateStateAfterPay(@RequestBody PayReturnVo vo){


        return orderBaseService.updateStateAfterPay(vo);
    }


    /**
     * 查询用户是否在门店消费过
     * @param memberId 会员ID
     * @return
     */
    @GetMapping(value = "/hasConsumer/{storeId}/{memberId}")
    public ResponseMessage queryMemberHasConsumer(
            @PathVariable(value = "storeId")Integer storeId,
            @PathVariable(value = "memberId")Integer memberId){
         return orderBaseService.queryMemberHasConsumer(storeId,memberId);
    }

    /**
     * 通过订单编号查询订单全部信息
     * @param orderNo
     * @return
     */
    @GetMapping(value = "/queryOrderAllInfo/{orderNo}")
    public ResponseMessage<SubmitOrder> queryOrderAllInfoByOrderNo(@PathVariable(value = "orderNo")String orderNo){
        return orderBaseService.queryOrderAllInfoByOrderNo(orderNo);
    }


    /**
     * 通过订单ID查询发送APP消息对象
     * @param orderId
     * @return
     */
    @GetMapping(value = "/querySendToAppVo/{orderId}")
    public ResponseMessage<OrderSendAppVo> querySendToAppVoByOrderId(@PathVariable(value = "orderId")Integer orderId){
        return orderBaseService.querySendToAppVoByOrderId(orderId);
    }




    /**
     * 美容师端根据条件搜索订单
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "美容师查询服务订单信息")
    @PostMapping(value = "/queryByCondition")
    public PageInfo<HashMap<String,Object>> queryByCondition(
            @RequestParam(value = "pageNo",defaultValue = "0")Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
            @RequestBody BeauticianQueryVo beauticianQueryVo){
        return orderBaseService.queryByCondition(pageNo, pageSize, beauticianQueryVo);
    }

    /**
     * @author GaoWei
     * @describe 查询订单退款失败详情
     * @time 2018/5/21,14:13
    */
    @GetMapping(value = "/queryOrderRefundFailInfo/{orderId}")
    public ResponseMessage<HashMap<String,Object>> queryOrderRefundFailInfo(@PathVariable(value = "orderId")Integer orderId){
                return orderBaseService.queryOrderRefundFailInfo(orderId);
    }

    /**
     * @author GaoWei
     * @describe 统计美容师预收入总金额
     * @time 2018/5/21,14:13
    */
    @GetMapping(value = "/countBeauticianPreIncome/{beauticianId}")
    public ResponseMessage<Integer> countBeauticianPreIncome(@PathVariable(value = "beauticianId") Integer beauticianId) {
        return orderBaseService.countBeauticianPreIncome(beauticianId);
    }


    /**
     * 查询店铺不同状态订单数量
     * @param storeId
     * @return
     */
    @GetMapping(value = "/queryOrderNumByStoreId/{storeId}")
    public ResponseMessage<List<StoreTodayOrderCount>> queryOrderNumByStoreId(@PathVariable(value = "storeId")Integer storeId){
        return orderBaseService.queryOrderNumByStoreId(storeId);
    }


    /**
     * 查询美容师不同状态订单数量
     * @param beauticianId
     * @return
     */
    @GetMapping(value = "/queryOrderNumByBeauticianId/{beauticianId}")
    public ResponseMessage<List<BeauticianTodayOrderCount>> queryOrderNumByBeauticianId(@PathVariable(value = "beauticianId")Integer beauticianId){
        return orderBaseService.queryOrderNumByBeauticianId(beauticianId);
    }

    /**
     * 统计营业金额
     * @param statisticsOrderVo
     * @return
     */
    @PostMapping(value = "/sumOrderAmountByStoreIdAndDays")
    public ResponseMessage<Integer> sumOrderAmountByStoreIdAndDays(@RequestBody StatisticsOrderVo statisticsOrderVo){
          return orderBaseService.sumOrderAmountByStoreIdAndDays(statisticsOrderVo);
    }
}