package com.union.aimei.pay.util;

import com.union.aimei.common.vo.pay.WeChatPayNotifyVo;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.SortedMap;

/**
*@author GaoWei
*descrption:
*time  2018/1/29 22:10
*/
public class WxNotifyUtil {
    
    public   static String returnXML(String returnCode) {
        return "<xml><return_code><![CDATA["+returnCode+"]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
    }

    public static SortedMap<String, Object> getSortMap(String resultStr){
        SortedMap<String, Object> map=null;
        try {
            map = XmlUtil.doXMLParse(resultStr);
        }catch (JDOMException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取签名字符串(传递给微信的参数不计算)
     * @param
     * @return
     */
    public static boolean signVerifyPass(SortedMap<String, Object> resultMap){
        //业务结果
        String resultCode = resultMap.get("result_code")==null?"":resultMap.get("result_code").toString();
        //是否关注了微信公众号
        String isSubscribe = resultMap.get("is_subscribe")==null?"":resultMap.get("is_subscribe").toString();
        //订单号
        String outTradeNo = resultMap.get("out_trade_no")==null?"":resultMap.get("out_trade_no").toString();
        //微信支付订单号  类似于支付宝的交易号
        String transactionId = resultMap.get("transaction_id")==null?"":resultMap.get("transaction_id").toString();
        //签名
        String sign = resultMap.get("sign")==null?"":resultMap.get("sign").toString();
        //订单总金额  单位为 分
        String totalFee = resultMap.get("total_fee")==null?"":resultMap.get("total_fee").toString();
        //用户在商户appid下的唯一标识
        String openid = resultMap.get("openid")==null?"":resultMap.get("openid").toString();
        String timeEnd = resultMap.get("time_end")==null?"":resultMap.get("time_end").toString();
        String bankType = resultMap.get("bank_type")==null?"":resultMap.get("bank_type").toString();
        //签名验证
        String signStr = SignUtil.createSign("UTF-8",resultMap);
        return sign.equals(signStr);
    }




    /**
     * 获取微信支付回传对象
     * @param map
     * @param
     * @return
     * @throws Exception
     */
    public static WeChatPayNotifyVo getParseResult(SortedMap<String, Object> map) {
       WeChatPayNotifyVo weChatPayNotifyVo=new WeChatPayNotifyVo();
        //公共回传参数为
        String attach=map.get("attach")==null?"":map.get("attach").toString();
        weChatPayNotifyVo.setAttach(attach);
        //商家订单编号
        String outTradeNo=map.get("out_trade_no")==null?"":map.get("out_trade_no").toString();
        weChatPayNotifyVo.setOutTradeNo(outTradeNo);
        //订单总金额
        String totalFee=map.get("total_fee")==null?"":map.get("total_fee").toString();
        weChatPayNotifyVo.setTotalFee(Integer.valueOf(totalFee));
        //微信交易流水号
        String transactionId=map.get("transaction_id")==null?"":map.get("transaction_id").toString();
        weChatPayNotifyVo.setTransactionId(transactionId);
        return weChatPayNotifyVo;
    }

}
