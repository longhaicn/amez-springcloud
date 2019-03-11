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
 * @describe 卖家拒绝退款
 * @time 2018/3/26,14:15
*/
@Component
public class RefuseRefundTask {

    @Resource
    private SendSmsFeign sendSmsFeign;
    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;


    public void sendMsg(String phone,String serviceName){
        SmsMessageVo msgVo=new SmsMessageVo();
        msgVo.setPhone(phone);
        msgVo.setSmsCode(SmsConstant.REFUND_FAIL_NOTIFY_CUSTOMER.getSmsCode());
        JsonObject json=new JsonObject();
        json.addProperty("code",serviceName);
        msgVo.setSmsContent(json.toString());
        //发送短信
        sendSmsFeign.sendSmsMessage(msgVo);
    }

    public void pushtoApp(OrderSendAppVo vo){
        List<SendMsgParamVo> list=new ArrayList<>(10);
        SendMsgParamVo memberMsg=new SendMsgParamVo();
        memberMsg.setMemberId(vo.getMemberId());
        memberMsg.setTemplateCode(ServicePushCodeEnum.REFUSES_REFUND_TO_USER.getValue());
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
    }
}
