package com.union.aimei.app.api.pay;

import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.union.aimei.common.feign.app.pay.WxPayFeign;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @describe 微信支付
 * @time 2018/1/8,17:01
*/
@Api(tags = "微信支付")
@RestController
@RequestMapping(value = "wxPay")
@CommonsLog
public class WxPayController {


    @Resource
    private WxPayFeign wxPayFeign;


    /**
     * 微信支付-APP支付
     * @param tradeVo
     * @return
     * @throws WxPayException
     */
    @ApiOperation(httpMethod="POST", value="微信App支付",notes = "传递订单编号,交易类型，交易方式,（交易金额不需要传递）")
    @PostMapping(value = "/appPay")
    public ResponseMessage appPay(@RequestBody TradeVo tradeVo)throws WxPayException{
        return wxPayFeign.unifiedOrder(tradeVo);
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
    @ApiOperation(httpMethod = "GET", value = "申请退款")
    public ResponseMessage<WxPayRefundResult> refund(@PathVariable(value = "paySource") int paySource,
                                                     @PathVariable(value = "orderNo") String orderNo)throws WxPayException{
        return wxPayFeign.refund(paySource, orderNo);
    }


    /**
     * 微信支付回调
     * @param xmlData
     * @return
     */
    @PostMapping(value = "/notify")
    @ApiOperation(httpMethod = "POST", value = "微信支付回调")
    public String callBackUrl(@RequestBody String xmlData){
        log.info("收到微信支付回调");
        return wxPayFeign.callBackUrl(xmlData);
    }



}
