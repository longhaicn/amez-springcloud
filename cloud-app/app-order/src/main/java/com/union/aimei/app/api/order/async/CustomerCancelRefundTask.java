package com.union.aimei.app.api.order.async;


import com.google.gson.JsonObject;
import com.union.aimei.common.constant.base.SmsConstant;
import com.union.aimei.common.feign.app.system.SendSmsFeign;
import com.union.aimei.common.feign.app.umeng.BasePushTemplateFeign;
import com.union.aimei.common.vo.order.OrderSendAppVo;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.common.vo.umeng.templatecode.ServicePushCodeEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GaoWei
 * @describe 用户撤销退款
 * @time 2018/3/26,14:42
*/
@Component
public class CustomerCancelRefundTask {


    @Resource
    private SendSmsFeign sendSmsFeign;
    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;


    /**
     * 发送短信给美容师及门店，告知用户撤销退款信息
     * @param
     */
    public void sendMsg(String beauticianPhone,String storePhone,String orderNo,int orderType,Integer productType){
        SmsMessageVo beauVo=new SmsMessageVo();
        beauVo.setPhone(beauticianPhone);
        beauVo.setSmsCode(SmsConstant.REFUND_CANCEL_NOTIFY_BEAUTICIAN.getSmsCode());
        JsonObject json=new JsonObject();
        int length=orderNo.length();
        String no=orderNo.substring(length-5,length);
        json.addProperty("code",no);
        beauVo.setSmsContent(json.toString());
        List<SmsMessageVo> list=new ArrayList<>(10);
        list.add(beauVo);
        SmsMessageVo storeVo;
        boolean isStoreSeller=orderType==0;
        if(isStoreSeller){
            storeVo=new SmsMessageVo();
            storeVo.setPhone(storePhone);
            storeVo.setSmsCode(SmsConstant.REFUND_CANCEL_NOTIFY_STORE_FOR_STORE_SELL.getSmsCode());
            storeVo.setSmsContent(json.toString());
            list.add(storeVo);
        }
        //发送短信
        sendSmsFeign.sendSmsCodeList(list);
    }

    /**
     * 推送APP消息给美容师及店长
     * @param vo
     */
    public void pushMsg(OrderSendAppVo vo){
        List<SendMsgParamVo> list=new ArrayList<>(10);
        SendMsgParamVo beauticianVo=new SendMsgParamVo();
        beauticianVo.setMemberId(vo.getBeauticianMemberId());
        beauticianVo.setTemplateCode(ServicePushCodeEnum.USER_CANCEL_REFUND_TO_BEAUTICIAN.getValue());
        beauticianVo.setOrderNo(vo.getOrderNo());
        Map<String,Object> map=new HashMap<>(16);
        map.put("type",SendMsgParamVo.ORDER_TYPE);
        map.put("id",vo.getOrderId());
        map.put("productName",vo.getProductName());
        map.put("productImg",vo.getProductImg());
        map.put("serverNeedTime",vo.getServerNeedTime());
        map.put("orderType",vo.getProductType());
        map.put("appointTime",vo.getServerStartTime());
        beauticianVo.setCustoms(map);
        list.add(beauticianVo);
        if(vo.getProductType()==0){
            SendMsgParamVo storeVo=new SendMsgParamVo();
            storeVo.setMemberId(vo.getStoreSellerMemberId());
            storeVo.setTemplateCode(ServicePushCodeEnum.USER_CANCEL_REFUND_TO_STORE.getValue());
            storeVo.setCustoms(map);
            storeVo.setOrderNo(vo.getOrderNo());
            list.add(storeVo);
        }
        basePushTemplateFeign.sendMessage(list);
    }
}
