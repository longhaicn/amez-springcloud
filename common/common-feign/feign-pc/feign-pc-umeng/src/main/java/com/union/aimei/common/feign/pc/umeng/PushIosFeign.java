package com.union.aimei.common.feign.pc.umeng;

import com.union.aimei.common.feign.pc.umeng.hystrix.PushIosApiHystrix;
import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author houji
 * @date 2018/3/9  17:02
 */
@FeignClient(serviceId = "pc-umeng-service", fallback = PushIosApiHystrix.class)
public interface PushIosFeign {
    /**
     * 添加U盟第三方推送记录表
     *
     * @param baseUmengPushTemplate
     * @return
     */
    @PostMapping(value = "/pushIOS/sendNoticeForConsumer")
    ResponseMessage sendNoticeForConsumer(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate);

    /**
     * 添加U盟第三方推送记录表
     *
     * @param baseUmengPushTemplate
     * @return
     */
    @PostMapping(value = "/pushIOS/sendNoticeForBeautician")
    ResponseMessage sendNoticeForBeautician(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate);

    /**
     * 消费者付款成功
     * 推送消息
     * 门店端：推送消息给店长、及美容师
     * （提示时播报语音,语音文件2天内提供）
     *
     * @param baseUmengPushTemplate
     * @return
     */
    @PostMapping(value = "/pushIOS/sendPaySuccess")
    public ResponseMessage sendPaySuccess(BaseUmengPushTemplate baseUmengPushTemplate);


    /**
     * 用户发起退款
     * 推送消息
     * 美容师及门店端：
     * 推送消息给相应的美容师及店长、
     * 告知其去处理退款申请,链接到退款详情页
     *
     * @param baseUmengPushTemplate
     * @return
     */
    @PostMapping(value = "/pushIOS/sendNoticeRefund")
    public ResponseMessage sendNoticeRefund(BaseUmengPushTemplate baseUmengPushTemplate);

    /**
     * 买店长发布招募美容师的服务后
     * 推送消息
     * 美容师端:推送招募邀请信息给美容师
     *
     * @param baseUmengPushTemplate
     * @return
     */
    @PostMapping(value = "/pushIOS/sendNoticeRecruit")
    public ResponseMessage sendNoticeRecruit(BaseUmengPushTemplate baseUmengPushTemplate);

    /**
     * 平台审核招募通过后
     * 推送消息
     * 店长端:推送消息给店长(语音提示)
     *
     * @param baseUmengPushTemplate
     * @return
     */
    @PostMapping(value = "/pushIOS/sendNoticeFoManager")
    public ResponseMessage sendNoticeFoManager(BaseUmengPushTemplate baseUmengPushTemplate);

}
