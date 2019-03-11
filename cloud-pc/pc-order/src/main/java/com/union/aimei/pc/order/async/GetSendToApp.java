package com.union.aimei.pc.order.async;


import com.union.aimei.common.vo.order.OrderSendAppVo;
import com.union.aimei.common.vo.order.SendToAppVo;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:55
  * @description
  */
public class GetSendToApp {


    /**
     * 获取订单推送APP对象
     * @param type 类型1：店长，2：客户，3：美容师
     * @param vo
     * @return
     */
    public static SendToAppVo getSendToAppVo(int type, OrderSendAppVo vo){
        SendToAppVo sendVo=new SendToAppVo();
        Integer orderId=vo.getOrderId();
        Integer memberId=vo.getMemberId();
        Integer storeSellerMemberId=vo.getStoreSellerMemberId();
        Integer beauMemberId=vo.getBeauticianMemberId();
        Integer serverNeedTime=vo.getServerNeedTime();
        String productImg=vo.getProductImg();
        String productName=vo.getProductName();
        Integer productId=vo.getProductId();
        Integer productType=vo.getProductType();
        sendVo.setOrderId(orderId);
        if(1==type){
            sendVo.setMemberId(storeSellerMemberId);
        }else if(OrderSendAppVo.SendType.BEAUTICIAN==type){
            sendVo.setMemberId(memberId);
        }else if(OrderSendAppVo.SendType.STORE_SELLER==type){
            sendVo.setMemberId(beauMemberId);
        }
        sendVo.setServerNeedTime(serverNeedTime);
        sendVo.setProductImg(productImg);
        sendVo.setProductName(productName);
        sendVo.setProductId(productId);
        sendVo.setProductType(productType);
        return sendVo;
    }
}
