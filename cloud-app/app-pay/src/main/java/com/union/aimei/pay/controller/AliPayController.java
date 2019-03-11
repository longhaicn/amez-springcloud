package com.union.aimei.pay.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.feign.app.learn.LearnTradeRecodeFeign;
import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.feign.app.order.OrderGoodsBaseFeign;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.pay.AlipayNotifyVo;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.aimei.pay.config.AliPayProperties;
import com.union.aimei.pay.service.AfterPayService;
import com.union.aimei.pay.service.AlibsPayService;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午2:53
  * @description
  */
@Api(tags = "支付宝支付")
@RequestMapping(value = "alipay")
@RestController
@CommonsLog
public class AliPayController {

    private static final String FAIL="failed";

    @Resource
    private AlibsPayService alibsPayService;
    @Resource
    private AliPayProperties aliPayProperties;
    @Resource
    private OrderBaseFeign orderBaseFeign;
    @Resource
    private OrderGoodsBaseFeign orderGoodsBaseFeign;
    @Resource
    private LearnTradeRecodeFeign learnTradeRecodeFeign;
    @Resource
    private AfterPayService afterPayService;


    /**
     * 支付宝appPay
     * @param tradeVo
     * @return
     */
    @PostMapping(value = "/appPay")
    public ResponseMessage<String> appPay(@RequestBody TradeVo tradeVo) {
        return alibsPayService.appPay(tradeVo);
    }


    /**
     * 支付宝支付退款
     * @return
     * @throws AlipayApiException
     */
    @GetMapping(value ="refund/{orderNo}")
    public ResponseMessage<AlipayTradeRefundResponse> tradeRefund(@PathVariable(value = "orderNo")String orderNo)throws AlipayApiException{
        return alibsPayService.applyRefund(orderNo);
    }




    /**
     * 支付宝回调-判断充值结果，修改会员卡金额，添加交易记录等等
     *
     * @param 
     * @return
     */
    @ApiOperation(httpMethod="POST", value="支付宝支付回调，请勿调用")
    @PostMapping(value = "/notify")
    public String notifyResult(@RequestBody AlipayNotifyVo vo){
        log.info("收到上层支付回调请求");
        //获取支付宝返回参数
        Map<String, String> params=vo.getMap();
        //校验交易参数是否正确
        boolean isRight= verify(params);
        log.info("校验结果为:"+isRight);
        if(!isRight){
            log.warn("验证签名失败");
            return "failed";
        }
        //检查appId以及交易金额是否正确
        String appId=params.get("app_id");
        //获取商户订单号
        String outTradeNo = params.get("out_trade_no");
        //获取交易流水号
        String tradeNo  = params.get("trade_no");
        //获取公用回传的交易类型
        String tradeType=params.get("passback_params");
        //获取交易金额
        String totalAmount=params.get("total_amount");
        //转化为int类型，以分为单位
        Integer amountPay=(int)(Double.parseDouble(totalAmount)*100);
        String checkStr=checkAppIdAndAmount(appId,tradeType,outTradeNo,amountPay);
        if(FAIL.equals(checkStr)){
            return checkStr;
        }
        PayReturnVo returnVo=getPayReturnVo(tradeType,outTradeNo,tradeNo,amountPay);
        updateOrderStatus(returnVo);
        afterPayService.hasPaySuccess(returnVo);
        log.info("支付宝-订单支付业务逻辑完成");
        return "success";
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


    private boolean verify(Map<String, String> params){
        boolean signVerified;
        try {
            //RSA2加密的话调用方法,调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, aliPayProperties.getAlipayPublicKey(), "UTF-8", aliPayProperties.getSignType());
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return false;
        }
        return signVerified;
    }



    /**
     * 校验APPId及实际支付金额是否是一致
     * @param appId
     * @param tradeType
     * @param orderNo
     * @param actuAmount
     * @return
     */
    private String checkAppIdAndAmount(String appId,String tradeType,String orderNo,int actuAmount){
        String returnStr="success";
        //若参数中的appid和填入的appid不相同，则为异常通知
        if (!aliPayProperties.getAppid().equals(appId)) {
            log.warn("与付款时的appid不同，此为异常通知，应忽略！");
            returnStr="failed";
            return returnStr;
        }
        //订单实际支付金额
        int orderAmount=0;
        switch (tradeType){
            case "buyProduct":
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
            returnStr="failed";
            return returnStr;
        }
        return returnStr;
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
            case "buyProduct":
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
                .payType(1)
                .amountPay(amountPay)
                .orderNo(orderNo)
                .tradeNo(tradeNo)
                .payUseType(getPayUseType(tradeType))
                .build();
    }










//    @ApiOperation(httpMethod = "POST", value = "支付宝预支付生成二维码")
//    @PostMapping({"/app/tradePrecreate"})
//    public AlipayTradePrecreateResponse tradeRrecreate(@RequestBody AliPayOrder aliPayOrder)
//            throws AlipayApiException {
//        AlipayClient alipayClient = new DefaultAlipayClient(this.aliPayProperties.getOpenApiDomain(), this.aliPayProperties.getAppid(), this.aliPayProperties.getPrivateKey(), "json", "utf-8", this.aliPayProperties.getAlipayPublicKey(), this.aliPayProperties.getSignType());
//        AlipayTradePrecreateRequest alipayRequest = new AlipayTradePrecreateRequest();
//        alipayRequest.setNotifyUrl(this.aliPayProperties.getNotifyUrl());
//        log.info(aliPayOrder.getOutTradeNo() + ":这是商品订单号");
//        alipayRequest.setBizContent("{    \"out_trade_no\":\"" + aliPayOrder
//                .getOutTradeNo() + "\",    \"subject\":\"" + aliPayOrder
//                .getSubject() + "\",    \"terminal_id\":\"" + aliPayOrder
//                .getTerminalId() + "\",    \"store_id\":\"" + aliPayOrder
//                .getStoreId() + "\",    \"body\":\"" + aliPayOrder
//                .getBody() + "\",    \"timeout_express\":\"" + aliPayOrder
//                .getTimeoutExpress() + "\",    \"total_amount\":\"" + aliPayOrder
//                .getTotalAmount() + "\"  }");
//
//        AlipayTradePrecreateResponse alipayResponse = null;
//        try {
//            alipayResponse = (AlipayTradePrecreateResponse) alipayClient.execute(alipayRequest);
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//        return alipayResponse;
//    }


//    @ApiOperation(httpMethod = "POST", value = "支付宝当面查询订单")
//    @PostMapping({"/app/tradeQuery"})
//    public AlipayTradeQueryResponse tradeQuery(
//            @RequestParam(required = false) @ApiParam("商户订单号") String outTradeNo,
//            @RequestParam(required = false) @ApiParam("支付宝系统订单号") String tradeNo)
//            throws AlipayApiException {
//        /*这里处理,当商户订单号和系统订单号同时为空,,tradeNo为优先，吧tradeNo设置为""*/
//        String alipayOrder = "";
//        if (tradeNo == null) {
//            tradeNo = alipayOrder;
//        }
//        /*结束*/
//        AlipayClient alipayClient = new DefaultAlipayClient(this.aliPayProperties.getOpenApiDomain(), this.aliPayProperties.getAppid(), this.aliPayProperties.getPrivateKey(), "json", "utf-8", this.aliPayProperties.getAlipayPublicKey(), this.aliPayProperties.getSignType());
//        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
//        request.setBizContent("{    \"out_trade_no\":\"" + outTradeNo + "\",    \"trade_no\":\"" + tradeNo + "\"  }");
//
//        AlipayTradeQueryResponse response = (AlipayTradeQueryResponse) alipayClient.execute(request);
//        if (response.isSuccess()) {
//            System.out.println("查询成功");
//        } else {
//            System.out.println("查询失败");
//        }
//        return response;
//    }



//    @ApiOperation(httpMethod = "POST", value = "支付宝交易撤销")
//    @PostMapping({"/app/tradeCancel"})
//    public AlipayTradeCancelResponse tradeCancel(
//            @RequestParam(required = false) @ApiParam("商户订单号") String outTradeNo,
//            @RequestParam(required = false) @ApiParam("支付宝订单号") String tradeNo)
//            throws AlipayApiException {
//        AlipayClient alipayClient = new DefaultAlipayClient(this.aliPayProperties.getOpenApiDomain(), this.aliPayProperties.getAppid(), this.aliPayProperties.getPrivateKey(), "json", "utf-8", this.aliPayProperties.getAlipayPublicKey(), this.aliPayProperties.getSignType());
//        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
//        request.setBizContent("{    \"out_trade_no\":\"" + outTradeNo + "\",    \"trade_no\":\"" + tradeNo + "\"  }");
//
//        AlipayTradeCancelResponse response = (AlipayTradeCancelResponse) alipayClient.execute(request);
//        return response;
//    }


}

