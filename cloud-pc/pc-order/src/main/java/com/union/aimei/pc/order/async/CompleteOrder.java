package com.union.aimei.pc.order.async;

import com.union.aimei.common.feign.pc.umeng.BasePushTemplateFeign;
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
 * @time 2018/7/12 17:31
 * @description
 */
@Component
public class CompleteOrder {

    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;

    /**
     * 服务完成提醒用户评价
     * @param
     */
    public void pushMsg(OrderSendAppVo vo){
        List<SendMsgParamVo> list=new ArrayList<>(10);
        SendMsgParamVo memberMsg=new SendMsgParamVo();
        memberMsg.setMemberId(vo.getMemberId());
        memberMsg.setTemplateCode(ServicePushCodeEnum.SERVICE_EVALUATION_TO_USER.getValue());
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
