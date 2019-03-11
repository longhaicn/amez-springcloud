package com.union.aimei.app.api.pay;


import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.union.aimei.common.feign.app.pay.AliPayFeign;
import com.union.aimei.common.vo.pay.AlipayNotifyVo;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * @author GaoWei
 * @describe 支付宝支付
 * @time 2018/1/8,16:23
*/
@Api(tags = "支付宝支付")
@RestController
@RequestMapping(value = "alipay")
@CommonsLog
public class AliPayController {



    @Resource
    private AliPayFeign aliPayFeign;



    @ApiOperation(httpMethod="POST", value="支付宝App支付",notes = "传递订单编号,交易类型，交易方式,（交易金额不需要传递）")
    @PostMapping(value = "/appPay")
    public ResponseMessage appPay(@RequestBody TradeVo tradeVo){
        return aliPayFeign.appPayReturnBody(tradeVo);
    }


    /**
     *
     * @param orderNo
     * @return
     * @throws AlipayApiException
     */
    @ApiOperation(httpMethod="GET", value="支付宝申请退款")
    @GetMapping(value ="/refund/{orderNo}")
    public ResponseMessage<AlipayTradeRefundResponse> tradeRefund(@PathVariable(value = "orderNo")String orderNo){
        return aliPayFeign.tradeRefund(orderNo);
    }


    /**
     * 支付宝回调-判断充值结果，修改会员卡金额，添加交易记录等等
     *
     * @param request
     * @return
     */
    @ApiOperation(httpMethod="POST", value="支付宝支付回调，请勿调用")
    @PostMapping(value = "/notify")
    public String notifyResult(HttpServletRequest request) {
        Map<String, String> params=getParamMap(request);
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
        AlipayNotifyVo vo= AlipayNotifyVo.builder()
                .map(params)
                .outTradeNo(outTradeNo)
                .tradeNo(tradeNo)
                .appId(appId)
                .tradeType(tradeType)
                .totalAmount(amountPay.intValue())
                .build();
        String res=aliPayFeign.notifyResult(vo);
        log.info("支付业务处理返回结果："+res);
        return res;
    }



    private Map<String,String> getParamMap(HttpServletRequest request){
        Map<String, String> params = new HashMap<String, String>(2);
        //取出所有参数是为了验证签名
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            params.put(parameterName, request.getParameter(parameterName));
        }
        return params;
    }

}
