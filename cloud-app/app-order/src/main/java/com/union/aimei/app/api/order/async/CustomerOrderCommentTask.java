package com.union.aimei.app.api.order.async;


import com.union.aimei.common.feign.app.umeng.BasePushTemplateFeign;
import com.union.aimei.common.vo.order.OrderSendAppVo;
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
 * @describe 用户订单评价任务
 * @time 2018/3/26,11:26
*/
@Component
public class CustomerOrderCommentTask {


    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;



    /**
     * 推送APP消息给美容师
     * @param
     */
    public void pushMsg(OrderSendAppVo vo){
        List<SendMsgParamVo> list=new ArrayList<>(10);
        SendMsgParamVo beauticianVo=new SendMsgParamVo();
        beauticianVo.setMemberId(vo.getBeauticianMemberId());
        beauticianVo.setTemplateCode(ServicePushCodeEnum.SERVICE_EVALUATION_TO_BEAUTICIAN.getValue());
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
            storeVo.setTemplateCode(ServicePushCodeEnum.SERVICE_EVALUATION_TO_STORE.getValue());
            storeVo.setCustoms(map);
            storeVo.setOrderNo(vo.getOrderNo());
            list.add(storeVo);
        }
        basePushTemplateFeign.sendMessage(list);
    }
}
