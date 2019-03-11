package com.union.aimei.pay.controller;


import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.feign.app.learn.LearnTradeRecodeFeign;
import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.feign.app.order.OrderGoodsBaseFeign;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.aimei.common.vo.pay.WeChatPayNotifyVo;
import com.union.aimei.pay.service.AfterPayService;
import com.union.aimei.pay.service.WxbsPayService;
import com.union.aimei.pay.util.WxNotifyUtil;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.SortedMap;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:47
  * @description
  */
@RestController
@RequestMapping(value = "wx/pay")
@Api(tags = "微信支付")
@CommonsLog
public class WeixinPayController {

    @Resource
    private WxbsPayService wxbsPayService;
    @Resource
    private OrderBaseFeign orderBaseFeign;
    @Resource
    private OrderGoodsBaseFeign orderGoodsBaseFeign;
    @Resource
    private LearnTradeRecodeFeign learnTradeRecodeFeign;
    @Resource
    private AfterPayService afterPayService;


    /**
     * <pre>
     * 查询订单(详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_2)
     * 该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
     * 需要调用查询接口的情况：
     * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
     * ◆ 调用支付接口后，返回系统错误或未知交易状态情况；
     * ◆ 调用被扫支付API，返回USERPAYING的状态；
     * ◆ 调用关单或撤销接口API之前，需确认支付状态；
     * 接口地址：https://api.mch.weixin.qq.com/pay/orderquery
     * </pre>
     *
     * @param transactionId 微信订单号
     * @param outTradeNo    商户系统内部的订单号，当没提供transactionId时需要传这个。
     */
//    @GetMapping("/queryOrder")
//    @ApiOperation(httpMethod = "GET", value = "查询订单")
//    public WxPayOrderQueryResult queryOrder(@RequestParam(required = false) @ApiParam(value = "微信订单号") String transactionId,
//                                            @RequestParam(required = false) @ApiParam(value = "商户系统内部的订单号，当没提供transactionId时需要传这个") String outTradeNo)
//            throws WxPayException {
//        return this.wxService.queryOrder(transactionId, outTradeNo);
//    }

    /**
     * <pre>
     * 关闭订单
     * 应用场景
     * 以下情况需要调用关单接口：
     * 1. 商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；
     * 2. 系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
     * 注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
     * 接口地址：https://api.mch.weixin.qq.com/pay/closeorder
     * 是否需要证书：   不需要。
     * </pre>
     *
     * @param outTradeNo 商户系统内部的订单号
     */
//    @GetMapping("/closeOrder/{outTradeNo}")
//    @ApiOperation(httpMethod = "GET", value = "关闭订单")
//    public WxPayOrderCloseResult closeOrder(@PathVariable @ApiParam(value = "商户系统内部的订单号") String outTradeNo) {
//        try {
//            WxPayOrderCloseResult orderCloseResult = this.wxService.closeOrder(outTradeNo);
//            return orderCloseResult;
//        } catch (WxPayException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//
//    }


    /**
     * 统一下单(详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1)
     * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识"
     * 接口地址：https://api.mch.weixin.qq.com/pay/unifiedorder
     *
     * @param tradeVo 请求对象，注意一些参数如appid、mchid等不用设置，方法内会自动从配置对象中获取到（前提是对应配置中已经设置）
     */

    @PostMapping("/unifiedOrder")
    @ApiOperation(httpMethod = "POST", value = "统一下单")
    public ResponseMessage unifiedOrder(@RequestBody TradeVo tradeVo) throws WxPayException {
       return wxbsPayService.unifiedOrder(tradeVo);
    }

    /**
     * <pre>
     * 微信支付-申请退款
     * 详见 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_4
     * 接口链接：https://api.mch.weixin.qq.com/secapi/pay/refund
     * </pre>
     * @return 退款操作结果
     */
    @GetMapping(value = "/refund/{paySource}/{orderNo}")
    public ResponseMessage<WxPayRefundResult> refund(@PathVariable(value = "paySource")int paySource,
                                                     @PathVariable(value = "orderNo")String orderNo) throws WxPayException {
        return wxbsPayService.refund(paySource,orderNo);
    }


    /**
     * 微信支付回调
     *
     * @return
     */
    @PostMapping(value = "/notify")
    @ApiOperation(httpMethod = "POST", value = "微信支付回调")
    public String callBackUrl(@RequestBody String xmlData) throws WxPayException{
        log.info("收到微信支付回调请求");
        SortedMap<String, Object> sortedMap= WxNotifyUtil.getSortMap(xmlData);
        boolean isSignPass= WxNotifyUtil.signVerifyPass(sortedMap);
        if(!isSignPass){
            WxNotifyUtil.returnXML("ERROR");
        }
        WeChatPayNotifyVo weChatPayNotifyVo=WxNotifyUtil.getParseResult(sortedMap);
        if (weChatPayNotifyVo != null) {
            //判断支付用途(项目支付，实物产品购买，课程或活动购买)
            String tradeType=weChatPayNotifyVo.getAttach();
            //订单号
            String orderNo = weChatPayNotifyVo.getOutTradeNo();
            //流水号
            String tradeNo=weChatPayNotifyVo.getTransactionId();
            //实际支付金额
            Integer totalFee=weChatPayNotifyVo.getTotalFee();
            //校验金额是否正确
            boolean isRight=checkAmountIsRight(tradeType,orderNo,totalFee);
            if(!isRight){
                WxNotifyUtil.returnXML("FAIL");
            }
            PayReturnVo returnVo=getPayReturnVo(tradeType,orderNo,tradeNo,totalFee);
            log.info("微信支付修改订单VO"+returnVo);
            //存入redis，保存支付成功记录
            updateOrderStatus(returnVo);
            //执行后续业务操作
            afterPayService.hasPaySuccess(returnVo);
        } else {
            WxNotifyUtil.returnXML("FAIL");
        }
        return WxNotifyUtil.returnXML("SUCCESS");
    }

    /**
     * 修改订单状态为已支付
     * @param returnVo
     */
    private void updateOrderStatus(PayReturnVo returnVo){
        int payUseType=returnVo.getPayUseType();
        switch (payUseType){
            case 0:
                ResponseMessage res=orderBaseFeign.updateStateAfterPay(returnVo);
                if(res.getCode()==HttpStatusConstant.OK.getStatus()){
                    log.warn("项目订单状态已更新为支付成功");
                }else {
                    log.warn("项目订单状态未更新");
                }
                ;break;
            default:;break;
        }
    }

    private boolean checkAmountIsRight(String tradeType,String orderNo,int actuAmount){
        boolean isTrue=true;
        //订单实际支付金额
        int orderAmount=0;
        switch (tradeType){
            case "isBuyProduct":
                OrderBase orderBase=orderBaseFeign.queryByOrderNo(orderNo);
                if(orderBase!=null){
                    orderAmount=orderBase.getNeedPay();
                }
                break;
            case "buyGoods":
                ResponseMessage<OrderGoodsBase> res=orderGoodsBaseFeign.queryByOrderNo(orderNo);
                OrderGoodsBase orderGoodsBase=res.getData();
                orderAmount=orderGoodsBase.getAmountTotal();
                break;
            case "buyLearns":
                orderAmount= getLearnTradeAmount(orderNo); break;
            case "buyActivity":
                orderAmount= getLearnTradeAmount(orderNo); break;
            default:;break;
        }
        if(actuAmount!=orderAmount){
            log.warn("订单应付金额与实际支付金额数目不正确");
            return false;
        }
        return isTrue;
    }


    private int getLearnTradeAmount(String orderNo){
        ResponseMessage<LearnTradeRecode> learnRes=learnTradeRecodeFeign.queryTradeRecodeByOrderNo(orderNo);
        LearnTradeRecode recode=learnRes.getData();
        int orderAmount=recode.getTradeAmount();
        return orderAmount;

    }

    private int getPayUseType(String tradeType){
        int type=0;
        switch (tradeType){
            case "isBuyProduct":
                break;
            case "buyGoods":
                type=1;
                break;
            case "buyLearns":
                type=2; break;
            case "buyActivity":
                type=3; break;
            default:;break;
        }
        return type;
    }

    private PayReturnVo getPayReturnVo(String tradeType, String orderNo, String tradeNo, int amountPay){
        return PayReturnVo.builder()
                .payType(2)
                .amountPay(amountPay)
                .orderNo(orderNo)
                .tradeNo(tradeNo)
                .payUseType(getPayUseType(tradeType))
                .build();
    }






//    /**
//     * <pre>
//     * 微信支付-查询退款
//     * 应用场景：
//     *  提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，
//     *  银行卡支付的退款3个工作日后重新查询退款状态。
//     * 详见 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_5
//     * 接口链接：https://api.mch.weixin.qq.com/pay/refundquery
//     * </pre>
//     * 以下四个参数四选一
//     *
//     * @param transactionId 微信订单号
//     * @param outTradeNo    商户订单号
//     * @param outRefundNo   商户退款单号
//     * @param refundId      微信退款单号
//     * @return 退款信息
//     */
//    @GetMapping("/refundQuery")
//    @ApiOperation(httpMethod = "GET", value = "查询退款")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "transactionId", value = "微信订单号"),
//            @ApiImplicitParam(name = "outTradeNo", value = "商户订单号"),
//            @ApiImplicitParam(name = "outRefundNo", value = "商户退款单号"),
//            @ApiImplicitParam(name = "refundId", value = "微信退款单号")
//    })
//    public WxPayRefundQueryResult refundQuery(@RequestParam(required = false)  String transactionId,
//                                              @RequestParam(required = false)  String outTradeNo,
//                                              @RequestParam(required = false)  String outRefundNo,
//                                              @RequestParam(required = false)  String refundId)
//            throws WxPayException {
//        return this.wxService.refundQuery(transactionId, outTradeNo, outRefundNo, refundId);
//    }

}
