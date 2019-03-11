package com.union.aimei.pay.settle;

/**
 * @author GaoWei
 * @time 2018/6/5 10:44
 * @description
 */
public class SettleUtil {


    public static Integer changePayTypeToInt(String payType){
        Integer payMethod=0;
        choose:switch (payType){
            case "alipay":
                payMethod=1
                ;break choose;
            case "wxpay":
                payMethod=2
                ;break choose;
            case "cardpay":
                payMethod=3
                ;break choose;
            case "oneCardPay":
                payMethod=4
                ;break choose;
            case "balancePay":
                payMethod=5;
                break choose;
            default:   payMethod=1
            ;break choose;
        }
        return payMethod;
    }



}
