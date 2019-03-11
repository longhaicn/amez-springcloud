package com.union.aimei.common.util.umeng;

import com.google.gson.Gson;
import com.union.aimei.common.constant.member.MrbMemberConstant;
import com.union.aimei.common.constant.umeng.PushMsgDeviceConstant;
import com.union.aimei.common.model.umeng.BaseMemberDevice;
import com.union.aimei.common.model.umeng.BasePushTemplate;
import com.union.aimei.common.model.umeng.BaseUmengPushHistory;
import com.union.aimei.common.util.umeng.android.AndroidUnicast;
import com.union.aimei.common.util.umeng.ios.IosUnicast;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.union.aimei.common.util.umeng.AbstractAndroidNotification.AfterOpenAction.go_custom;


/**
 * @author houji
 * @date 2018/8/13  18:15
 */
public class UmengPushMsg {

    /**
     * 创建发送Client
     */
    private PushClient client = new PushClient();

    /**
     * 推送消息Android
     *
     * @param basePushTemplate
     * @param appKey
     * @param appMasterSecret
     * @param profiles
     * @param baseMemberDevice
     * @param token
     * @param history
     * @param sdf
     */
    private void pushMsgByAndroid(BasePushTemplate basePushTemplate, String appKey, String appMasterSecret, String profiles, BaseMemberDevice baseMemberDevice, String token, BaseUmengPushHistory history, SimpleDateFormat sdf) throws Exception {
        AndroidUnicast unicast = null;
        AndroidUnicast unicastNotificat = null;
        //android消息
        unicast = new AndroidUnicast(appKey, appMasterSecret);
        //android通知
        unicastNotificat = new AndroidUnicast(appKey, appMasterSecret);
        //推送通知的
        unicastNotificat.setDeviceToken(token);
        unicastNotificat.setDisplayType(AbstractAndroidNotification.DisplayType.NOTIFICATION);
        if (profiles.equals(PushMsgDeviceConstant.Profiles.PRO)) {
            unicastNotificat.setProductionMode();
        } else {
            unicastNotificat.setTestMode();
        }
        unicastNotificat.setDescription(basePushTemplate.getTemplateDescription());
        //android必填
        unicastNotificat.setTicker(basePushTemplate.getTemplateName());
        unicastNotificat.setTitle(basePushTemplate.getPushTitle());
        unicastNotificat.setText(basePushTemplate.getTemplateDescription());
        //自定义消息内容
        Map<String, Object> map = new HashMap<>(1);
        map.put("custom", basePushTemplate.getPushCostom());
        unicastNotificat.setCustomField(new Gson().toJson(map));
        unicastNotificat.setAfterOpenAction(go_custom);
        int bruNotifi = client.send(unicastNotificat);
        if (bruNotifi == MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            System.out.println("Android deviceToken :" + token + ",Notification sent successfully,the time:" + sdf.format(new Date()));
        } else {
            System.out.println("Android deviceToken :" + token + ",Failed sent successfully,the time:" + sdf.format(new Date()));
        }
        //推送消息的
        unicast.setDeviceToken(token);
        unicast.setDisplayType(AbstractAndroidNotification.DisplayType.MESSAGE);
        if (profiles.equals(PushMsgDeviceConstant.Profiles.PRO)) {
            unicast.setProductionMode();
        } else {
            unicast.setTestMode();
        }
        unicast.setDescription(basePushTemplate.getTemplateDescription());
        unicast.setCustomField(basePushTemplate.getPushCostom());
        unicast.setAfterOpenAction(go_custom);
        int bruMsg = client.send(unicast);
        if (bruMsg == MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            history = this.insertUmengMsg(basePushTemplate, token, 1);
        } else {
            System.out.println("Android deviceToken :" + token + ",Failed to send the message,the time:" + sdf.format(new Date()));
            history = null;
        }
    }

    /**
     * 推送消息IOS
     *
     * @param basePushTemplate
     * @param appKey
     * @param appMasterSecret
     * @param profiles
     * @param baseMemberDevice
     * @param token
     * @param history
     * @param sdf
     */
    private void pushMsgByIos(BasePushTemplate basePushTemplate, String appKey, String appMasterSecret, String profiles, BaseMemberDevice baseMemberDevice, String token, BaseUmengPushHistory history, SimpleDateFormat sdf) throws Exception {
        IosUnicast unicast = null;
        //推送消息者(0--用户 1--美容师 2--店长)
        unicast = new IosUnicast(appKey, appMasterSecret);
        //推送消息
        unicast.setDeviceToken(token);
        unicast.setAlert(basePushTemplate.getPushTitle());
        unicast.setBadge(0);
        unicast.setSound("default");
        if (profiles.equals(PushMsgDeviceConstant.Profiles.PRO)) {
            unicast.setProductionMode();
        } else {
            unicast.setTestMode();
        }
        unicast.setCustomizedField("custom", basePushTemplate.getPushCostom());
        int bruIosMsg = client.send(unicast);
        if (bruIosMsg == MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            history = this.insertUmengMsg(basePushTemplate, token, 2);
        } else {
            System.out.println("Ios deviceToken :" + token + ",Failed to send the notification,the time:" + sdf.format(new Date()));
            history = null;
        }
    }

    /**
     * 友盟推送消息记录
     *
     * @param basePushTemplate
     * @param appKey
     * @param appMasterSecret
     * @param profiles
     * @param baseMemberDevice
     * @return
     */
    public BaseUmengPushHistory pushMsg(BasePushTemplate basePushTemplate, String appKey, String appMasterSecret, String profiles, BaseMemberDevice baseMemberDevice) {
        BaseUmengPushHistory history = new BaseUmengPushHistory();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String token = baseMemberDevice.getDeviceToken();
        try {
            if (token != null && !"".equals(token)) {
                //android的token长度是44
                if (token.length() == PushMsgDeviceConstant.TokenLength.ANDROID_LENGTH) {
                    this.pushMsgByAndroid(basePushTemplate, appKey, appMasterSecret, profiles, baseMemberDevice, token, history, sdf);
                } else if (token.length() == PushMsgDeviceConstant.TokenLength.IOS_LENGTH) {
                    this.pushMsgByIos(basePushTemplate, appKey, appMasterSecret, profiles, baseMemberDevice, token, history, sdf);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return history;
    }

    /**
     * 添加umeng推送消息记录
     *
     * @param basePushTemplate
     * @param token
     * @param deviceType
     */
    public BaseUmengPushHistory insertUmengMsg(BasePushTemplate basePushTemplate, String token, Integer deviceType) {
        //友盟推送消息记录
        BaseUmengPushHistory history = new BaseUmengPushHistory();
        history.setTemplateId(basePushTemplate.getId());
        history.setMsgType(basePushTemplate.getTemplateType());
        history.setMemberId(basePushTemplate.getMemberId());
        history.setPushTitle(basePushTemplate.getPushTitle());
        history.setCustom(basePushTemplate.getPushCostom());
        history.setTarget(basePushTemplate.getTarget());
        history.setParam(basePushTemplate.getParam());
        if (basePushTemplate.getTemplateType().equals(BasePushTemplate.TemplateType.SERVICE)) {
            history.setMsgCode("service");
        } else if (basePushTemplate.getTemplateType().equals(BasePushTemplate.TemplateType.PROJECT)) {
            history.setMsgCode("project");
        } else if (basePushTemplate.getTemplateType().equals(BasePushTemplate.TemplateType.SYSTEM)) {
            history.setMsgCode("system");
        }
        history.setDeviceToken(token);
        history.setDeviceType(deviceType);
        return history;
    }


    public BasePushTemplate caseParam(SendMsgParamVo sendMsgParamVo, BasePushTemplate basePushTemplate) {
        if (sendMsgParamVo.getOrderNo() != null) {
            basePushTemplate.setPushTitle(basePushTemplate.getPushTitle().replaceAll("orderno", sendMsgParamVo.getOrderNo()));
        }
        if (sendMsgParamVo.getBeauticianName() != null) {
            basePushTemplate.setPushTitle(basePushTemplate.getPushTitle().replaceAll("beauticianname", sendMsgParamVo.getBeauticianName()));
        }
        if (sendMsgParamVo.getCourseName() != null) {
            basePushTemplate.setPushTitle(basePushTemplate.getPushTitle().replaceAll("coursename", sendMsgParamVo.getCourseName()));
        }
        if (sendMsgParamVo.getCourseTime() != null) {
            basePushTemplate.setPushTitle(basePushTemplate.getPushTitle().replaceAll("coursetime", sendMsgParamVo.getCourseTime()));
        }
        if (sendMsgParamVo.getActivityName() != null) {
            basePushTemplate.setPushTitle(basePushTemplate.getPushTitle().replaceAll("activityname", sendMsgParamVo.getActivityName()));
        }
        if (sendMsgParamVo.getActivityTime() != null) {
            basePushTemplate.setPushTitle(basePushTemplate.getPushTitle().replaceAll("activitytime", sendMsgParamVo.getActivityTime()));
        }
        basePushTemplate.setPushCostom(new Gson().toJson(sendMsgParamVo.getCustoms()));
        basePushTemplate.setMemberId(sendMsgParamVo.getMemberId());
        basePushTemplate.setTarget(sendMsgParamVo.getTarget());
        if (sendMsgParamVo.getParam() == null || "".equals(sendMsgParamVo.getParam())) {
            basePushTemplate.setParam(null);
        } else {
            basePushTemplate.setParam(new Gson().toJson(sendMsgParamVo.getParam()));
        }
        return basePushTemplate;
    }

}
