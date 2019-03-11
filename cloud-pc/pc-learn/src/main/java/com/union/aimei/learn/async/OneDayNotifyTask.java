package com.union.aimei.learn.async;

import com.google.gson.Gson;
import com.union.aimei.common.constant.base.SmsConstant;
import com.union.aimei.common.feign.pc.system.SendSmsFeign;
import com.union.aimei.common.feign.pc.umeng.BasePushTemplateFeign;
import com.union.aimei.common.vo.learn.pc.ActivityPushMemberVo;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.common.vo.umeng.templatecode.SystemPushCodeEnum;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author houji
 * @date 2018/6/15  11:20
 * <p>
 * 提前一天推送消息和发送短信用户和美容师
 */
@Component
public class OneDayNotifyTask {

    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;

    @Resource
    private SendSmsFeign sendSmsFeign;


    public void handle(List<ActivityPushMemberVo> voList) {
        Set<Integer> set = new HashSet<Integer>();
        for (ActivityPushMemberVo vo : voList) {
            set.add(vo.getId());
        }
        for (Integer str : set) {
            Map<Integer, ActivityPushMemberVo> map = new HashMap<>(16);
            for (ActivityPushMemberVo vo : voList) {
                if (Objects.equals(str, vo.getId())) {
                    map.put(vo.getMemberId(), vo);
                }
            }
            for (Map.Entry<Integer, ActivityPushMemberVo> entry : map.entrySet()) {
                ActivityPushMemberVo vo = entry.getValue();
                this.pushMsgOnStore(vo);
            }
        }
    }


    /**
     * 活动前一天发送短信给美容师或者店长
     *
     * @param vo
     */
    @Async
    public void sendMsg(ActivityPushMemberVo vo) {
        SmsMessageVo beauVo = new SmsMessageVo();
        //当storeId为null，则是美容师自己报名，用ContactPhone作为自己手机号
        if (vo.getStoreId() == null) {
            beauVo.setPhone(vo.getContactPhone());
            beauVo.setSmsCode(SmsConstant.JOIN_TRAINING_ACTIVITY_NOTIFY_CUSTOMER.getSmsCode());
        } else {
            //当storeId不为null,则是门店报名，phone则是自己的手机号，而ContactPhone是店长手机号
            beauVo.setPhone(vo.getPhone());
            beauVo.setSmsCode(SmsConstant.JOIN_TRAINING_COURSE_NOTIFY_STORE.getSmsCode());
        }
        HashMap<String, Object> hashMap = new HashMap<>(16);
        hashMap.put("name", vo.getMtitle());
        hashMap.put("time", vo.getStartTime());
        beauVo.setSmsContent(new Gson().toJson(hashMap));
        sendSmsFeign.sendSmsMessageCode(beauVo);

    }


    /**
     * 活动前一天推送消息给店长
     *
     * @param vo
     */
    @Async
    public void pushMsgOnStore(ActivityPushMemberVo vo) {
        List<SendMsgParamVo> list = new ArrayList<>(10);
        SendMsgParamVo sendMsgParamVo = new SendMsgParamVo();
        Map<String, Object> map = new HashMap(16);
        sendMsgParamVo.setTemplateCode(SystemPushCodeEnum.ACTIVITY_BEFORE_TO_STORE.getValue());
        map.put("type", SendMsgParamVo.ACTIVITY_STORE_ONE_DAY_TYPE);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sendMsgParamVo.setMemberId(vo.getMemberId());
        sendMsgParamVo.setActivityName(vo.getMtitle());
        sendMsgParamVo.setActivityTime(df.format(vo.getStartTime()));
        map.put("id", vo.getId());
        map.put("name", vo.getMtitle());
        map.put("time", df.format(vo.getStartTime()));
        sendMsgParamVo.setCustoms(map);
        list.add(sendMsgParamVo);
        this.basePushTemplateFeign.sendMessage(list);
    }

    /**
     * 活动开始前一天推送消息给美容师
     *
     * @param
     */
    @Async
    public void pushMsg(ActivityPushMemberVo vo) {
        List<SendMsgParamVo> list = new ArrayList<>(10);
        SendMsgParamVo sendMsgParamVo = new SendMsgParamVo();
        Map<String, Object> map = new HashMap(16);
        if (vo.getTag() == 1) {
            sendMsgParamVo.setTemplateCode(SystemPushCodeEnum.ACTIVITY_BEFORE_TO_STORE.getValue());
            map.put("type", SendMsgParamVo.ACTIVITY_STORE_ONE_DAY_TYPE);
        } else {
            sendMsgParamVo.setTemplateCode(SystemPushCodeEnum.ACTIVITY_BEFORE_TO_BEAUTICIAN.getValue());
            map.put("type", SendMsgParamVo.ACTIVITY_BEAUTICIAN_ONE_DAY_TYPE);
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sendMsgParamVo.setMemberId(vo.getMemberId());
        sendMsgParamVo.setActivityName(vo.getMtitle());
        sendMsgParamVo.setActivityTime(df.format(vo.getStartTime()));
        map.put("id", vo.getId());
        map.put("name", vo.getMtitle());
        map.put("time", df.format(vo.getStartTime()));
        sendMsgParamVo.setCustoms(map);
        list.add(sendMsgParamVo);
        this.basePushTemplateFeign.sendMessage(list);
    }

}
