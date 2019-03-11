package com.union.aimei.pc.order.async;

import com.google.gson.JsonObject;
import com.union.aimei.common.constant.base.SmsConstant;
import com.union.aimei.common.feign.pc.system.SendSmsFeign;
import com.union.aimei.common.feign.pc.umeng.BasePushTemplateFeign;
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
 * 异步组件
 * @describe 提前半小时小时通知用户和美容师
 * @time 2018/3/26,10:02
 */
@Component
@CommonsLog
public class HalfHourNotifyTask {

    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;
    @Resource
    private SendSmsFeign sendSmsFeign;

    public void push(OrderSendAppVo vo){
        sendMsg(vo);
        pushMsg(vo);
    }


    public void sendMsg(OrderSendAppVo vo){
        SmsMessageVo beauVo=new SmsMessageVo();
        JsonObject json=new JsonObject();
        int length=vo.getOrderNo().length();
        String no=vo.getOrderNo().substring(length-5,length);
        json.addProperty("code",no);
        beauVo.setPhone(vo.getBeauticianPhone());
        beauVo.setSmsContent(json.toString());
        beauVo.setSmsCode(SmsConstant.SERVICE_START_NOTIFY_BEAUTICIAN.getSmsCode());
        List<SmsMessageVo> list=new ArrayList<>(10);
        list.add(beauVo);
        //通知用户
        SmsMessageVo memMsg=new SmsMessageVo();
        memMsg.setPhone(vo.getMemberPhone());
        memMsg.setSmsCode(SmsConstant.SERVICE_START.getSmsCode());
        memMsg.setSmsContent(json.toString());
        list.add(memMsg);
        SmsMessageVo storeVo;
        boolean isStoreSeller=vo.getProductType()==0;
        if(isStoreSeller){
            storeVo=new SmsMessageVo();
            storeVo.setPhone(vo.getStoreSellerPhone());
            storeVo.setSmsCode(SmsConstant.SERVICE_START_NOTIFY_STORE.getSmsCode());
            storeVo.setSmsContent(json.toString());
            list.add(storeVo);
        }
        //发送短信
        sendSmsFeign.sendSmsCodeList(list);
        log.info("发送短信提醒成功");
    }

    /**
     * 服务开始半小时推送用户，美容师及店长
     * @param
     */
    public void pushMsg(OrderSendAppVo vo){
        log.info("推送消息提醒");
        List<SendMsgParamVo> list=new ArrayList<>(10);
        SendMsgParamVo memberMsg=new SendMsgParamVo();
        memberMsg.setMemberId(vo.getMemberId());
        memberMsg.setTemplateCode(ServicePushCodeEnum.SERVICE_BEFORE_TO_USER.getValue());
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
        SendMsgParamVo beauMsg=new SendMsgParamVo();
        beauMsg.setMemberId(vo.getBeauticianMemberId());
        beauMsg.setTemplateCode(ServicePushCodeEnum.SERVICE_BEFORE_TO_BEAUTICIAN.getValue());
        beauMsg.setOrderNo(vo.getOrderNo());
        Map<String,Object> map1=new HashMap<>(16);
        map1.put("type",SendMsgParamVo.ORDER_TYPE);
        map1.put("id",vo.getOrderId());
        map1.put("productName",vo.getProductName());
        map1.put("productImg",vo.getProductImg());
        map1.put("serverNeedTime",vo.getServerNeedTime());
        map1.put("orderType",vo.getProductType());
        map1.put("appointTime",vo.getServerStartTime());
        beauMsg.setCustoms(map1);
        list.add(beauMsg);
        if(vo.getProductType()==0){
            SendMsgParamVo stoMsg=new SendMsgParamVo();
            stoMsg.setMemberId(vo.getStoreSellerMemberId());
            stoMsg.setTemplateCode(ServicePushCodeEnum.SERVICE_BEFORE_TO_STORE.getValue());
            stoMsg.setOrderNo(vo.getOrderNo());
            Map<String,Object> map2=new HashMap<>(16);
            map2.put("type",SendMsgParamVo.ORDER_TYPE);
            map2.put("id",vo.getOrderId());
            map2.put("productName",vo.getProductName());
            map2.put("productImg",vo.getProductImg());
            map2.put("serverNeedTime",vo.getServerNeedTime());
            map2.put("orderType",vo.getProductType());
            map2.put("appointTime",vo.getServerStartTime());
            stoMsg.setCustoms(map2);
            list.add(stoMsg);
        }
        basePushTemplateFeign.sendMessage(list);
        log.info("推送消息成功");
    }
}
