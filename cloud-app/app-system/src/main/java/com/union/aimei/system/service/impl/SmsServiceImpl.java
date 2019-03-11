package com.union.aimei.system.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.union.aimei.common.model.system.BaseSmsHistory;
import com.union.aimei.common.model.system.BaseSmsTemplate;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.system.config.Constant;
import com.union.aimei.system.service.BaseSmsHistoryService;
import com.union.aimei.system.service.BaseSmsTemplateService;
import com.union.aimei.system.service.SmsService;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.RandomUtil;
import com.union.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * SmsServiceImpl
 *
 * @author liufeihua
 * @date 2018/1/18 13:57
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Value(value="${ali.available}")
    private boolean smsAvailable = false;

    /**
     * 产品名称:云通信短信API产品,开发者无需替换
     */
    static final String PRODUCT = "Dysmsapi";
    /**
     * 产品域名,开发者无需替换
     */
    static final String DOMAIN = "dysmsapi.aliyuncs.com";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RedisService redisService;
    @Autowired
    BaseSmsHistoryService smsHistoryService;
    @Autowired
    BaseSmsTemplateService templateService;
    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    @Value("${ali.sms.accessKeyId}")
    String accessKeyId;
    @Value("${ali.sms.accessKeySecret}")
    String accessKeySecret;

    @Value("${ali.sms.signName}")
    String signName;


    @Override
    public String sendSmsCode(SmsMessageVo smsMessageVo) throws ClientException {

        //1.初始化
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(smsMessageVo.getPhone());
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(smsMessageVo.getSmsCode());
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为


        //2.先判断是短信验证码还是推广短信或者是营销短信
        BaseSmsTemplate t = new BaseSmsTemplate();
        t.setSmsCode(smsMessageVo.getSmsCode());
        PageInfo<BaseSmsTemplate> baseSmsTemplatePageInfo = templateService.selectListByConditions(0, 10, t);

        List<BaseSmsTemplate> list = baseSmsTemplatePageInfo.getList();
        AssertUtil.isTrue(list.size() > 0, "短信模板不存在", Constant.SMS_IS_NOT_EXIT);

        BaseSmsTemplate template = list.get(0);

        HashMap<String, Object> requestParams = new HashMap<>(1);
        //生成验证码
        String radom = null;
        BaseSmsHistory history = new BaseSmsHistory();
        //发送短信验证码
        if (template.getSmsType() == 0) {

            radom = RandomUtil.verificationCode();
            requestParams.put("code", radom);
            String toJson = new Gson().toJson(requestParams);
            request.setTemplateParam(toJson);
            history.setSmsContent(toJson);
            //发送推广短信
        } else if (template.getSmsType() == 1) {
            if (smsMessageVo.getSmsContent() != null && !"".equals(smsMessageVo.getSmsContent())) {
                request.setTemplateParam(smsMessageVo.getSmsContent());
            }
            history.setSmsContent(smsMessageVo.getSmsContent());
        }

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //调用阿里云发送短信接口， 此处可能会抛出异常，注意catch
        logger.info("开关："+smsAvailable);
        if (smsAvailable) {
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            history.setRequestid(sendSmsResponse.getRequestId());
            history.setResponseCode(sendSmsResponse.getCode());
            history.setResponseMessage(sendSmsResponse.getMessage());
            history.setBizid(sendSmsResponse.getBizId());
        }


        //3.记录已发的短信
        history.setSmsName(template.getSmsName());
        history.setSmsCode(template.getSmsCode());
        history.setSmsTemplate(template.getSmsTemplate());
        history.setSmsType(template.getSmsType());
        history.setSendTime(new Date());
        history.setReceivePhone(smsMessageVo.getPhone());

        smsHistoryService.insertSelective(history);

        //如果是验证码需要缓存起来
        if (template.getSmsType() == 0) {
            final String key = smsMessageVo.getPhone();
            //5分钟失效
            redisService.setStr(key, radom, 5 * 60 * 1000L);
            logger.debug(redisService.getStr(smsMessageVo.getPhone()));
        }
//        return sendSmsResponse;
        return radom;
    }


    /**
     * 批量发送短信
     *
     * @param list
     */
    @Override
    public void sendSmsCodeList(List<SmsMessageVo> list) throws ClientException {
        for (SmsMessageVo vo : list) {
            this.sendSmsCode(vo);
        }
    }
}
