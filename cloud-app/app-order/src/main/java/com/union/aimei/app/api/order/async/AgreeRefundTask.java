package com.union.aimei.app.api.order.async;


import com.google.gson.JsonObject;
import com.union.aimei.common.constant.base.SmsConstant;
import com.union.aimei.common.feign.app.system.SendSmsFeign;
import com.union.aimei.common.feign.app.umeng.BasePushTemplateFeign;
import com.union.aimei.common.vo.order.OrderSendAppVo;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.common.vo.umeng.templatecode.ServicePushCodeEnum;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author GaoWei
 * @describe 同意订单退款
 * @time 2018/3/26,11:50
*/
@Component
@CommonsLog
public class AgreeRefundTask {

      @Resource
      private SendSmsFeign sendSmsFeign;
      @Resource
      private BasePushTemplateFeign basePushTemplateFeign;



    /**
     * 发送短信给用户
     * @param phone
     * @param serviceName
     * @param refund
     */
    public void sendMsg(String phone,String serviceName,Integer refund){
        log.info("审核同意发送短信");
        SmsMessageVo msgVo=new SmsMessageVo();
        msgVo.setPhone(phone);
        msgVo.setSmsCode(SmsConstant.REFUND_SUCCESS_NOTIFY_CUSTOMER.getSmsCode());
        JsonObject json=new JsonObject();
        json.addProperty("code",serviceName);
        double money=(double)refund/100;
        json.addProperty("refund",money);
        msgVo.setSmsContent(json.toString());
        //发送短信
        sendSmsFeign.sendSmsMessage(msgVo);
        log.info("发送短信成功");
    }

    /**
     * 推送APP消息给用户
     * @param vo
     */
    public void pushAppInfo(OrderSendAppVo vo){
        log.info("审核同意推送消息");
        List<SendMsgParamVo> list=new ArrayList<>(10);
        SendMsgParamVo memberMsg=new SendMsgParamVo();
        memberMsg.setMemberId(vo.getMemberId());
        memberMsg.setTemplateCode(ServicePushCodeEnum.APPROVAL_REFUND_TO_USER.getValue());
        memberMsg.setOrderNo(vo.getOrderNo());
        Map<String,Object> map=new HashMap<>(16);
        map.put("type",SendMsgParamVo.ORDER_TYPE);
        map.put("id",vo.getOrderId());
        map.put("productName",vo.getProductName());
        map.put("productImg",vo.getProductImg());
        map.put("serverNeedTime",vo.getServerNeedTime());
        map.put("orderType",vo.getProductType());
        map.put("appointTime",vo.getServerStartTime());
        memberMsg.setCustoms(map);
        list.add(memberMsg);
        basePushTemplateFeign.sendMessage(list);
        log.info("审核同意推送消息成功");
    }


}
