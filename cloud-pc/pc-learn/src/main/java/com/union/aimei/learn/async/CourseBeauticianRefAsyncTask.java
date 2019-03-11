package com.union.aimei.learn.async;

import com.google.gson.JsonObject;
import com.union.aimei.common.constant.base.SmsConstant;
import com.union.aimei.common.feign.pc.product.ProductBeauticianRefFeign;
import com.union.aimei.common.feign.pc.system.SendSmsFeign;
import com.union.aimei.common.feign.pc.umeng.BasePushTemplateFeign;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.model.learn.CourseProductRef;
import com.union.aimei.common.vo.learn.pc.BeauticianParamVo;
import com.union.aimei.common.vo.learn.pc.CourseBeauticianRefResultVo;
import com.union.aimei.common.vo.learn.pc.CourseParamVo;
import com.union.aimei.common.vo.learn.pc.UpdateBeauticianVo;
import com.union.aimei.common.vo.product.pc.CoursePassProductVo;
import com.union.aimei.common.vo.product.pc.ProductBeauticianRefCoursePassVo;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.common.vo.umeng.templatecode.ProjectPushCodeEnum;
import com.union.aimei.common.vo.umeng.templatecode.SystemPushCodeEnum;
import com.union.aimei.learn.mapper.CourseBeauticianRefMapper;
import com.union.aimei.learn.mapper.CourseMapper;
import com.union.aimei.learn.mapper.CourseProductRefMapper;
import com.union.common.utils.date.DateUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课程-美容师 异步信息推送类
 *
 * @author caizhaoming
 * @create 2018-06-26 1:03
 **/
@Component
public class CourseBeauticianRefAsyncTask {

    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;

    @Resource
    private ProductBeauticianRefFeign productBeauticianRefFeign;

    @Resource
    private SendSmsFeign sendSmsFeign;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private CourseBeauticianRefMapper courseBeauticianRefMapper;

    @Resource
    private CourseProductRefMapper courseProductRefMapper;


    /**
     * 推送已通过人员的信息
     *
     * @param updateBeauticianVo
     */
    @Async
    public void sendMessageByLearYes(UpdateBeauticianVo updateBeauticianVo) {
        CourseParamVo courseParamVo = new CourseParamVo();
        courseParamVo.setRefIdList(updateBeauticianVo.getBeauticianIdList());
        List<CourseBeauticianRefResultVo> courseBeauticianRefResultVoList = this.courseMapper.findIsAboutToBeginCourse(courseParamVo);
        List<SendMsgParamVo> sendMegList = new ArrayList<>(10);
        courseBeauticianRefResultVoList.forEach(x -> {
            String courseTime = x.getTrainingBegin().substring(0, x.getTrainingBegin().length() - 2);
            Map<String, Object> customMap = new HashMap<>(4);
            customMap.put("type", SendMsgParamVo.COURSE_TYPE);
            customMap.put("id", x.getCourseId());
            customMap.put("name", x.getCourseName());
            customMap.put("time", courseTime);
            SendMsgParamVo sendMsgParamVo = new SendMsgParamVo();
            sendMsgParamVo.setTemplateCode(ProjectPushCodeEnum.PLATFORM_AGREE_COURSE_TO_BEAUTICIAN.getValue());
            sendMsgParamVo.setMemberId(x.getMemberId());
            sendMsgParamVo.setCustoms(customMap);
            sendMegList.add(sendMsgParamVo);
        });
        this.basePushTemplateFeign.sendMessage(sendMegList);
    }

    /**
     * 保存已经通过培训的美容师项目
     *
     * @param updateBeauticianVo
     */
    @Async
    public void setCoursePass(UpdateBeauticianVo updateBeauticianVo) {
        //获取已通过的美容师报名数据
        BeauticianParamVo beauticianParamVo = new BeauticianParamVo();
        beauticianParamVo.setIdList(updateBeauticianVo.getBeauticianIdList());
        beauticianParamVo.setIsEnabled(CourseBeauticianRef.IS_ENABLED_TURE);
        List<CourseBeauticianRef> courseBeauticianRefList = this.courseBeauticianRefMapper.selectPageListByConditions(beauticianParamVo);
        //获取美容师集合
        List<Integer> beauticianIdList = new ArrayList();
        courseBeauticianRefList.forEach(x -> beauticianIdList.add(x.getBeauticianId()));
        //获取课程下所指定的项目
        CourseProductRef courseProductRef = new CourseProductRef();
        courseProductRef.setCourseId(updateBeauticianVo.getCourseId());
        courseProductRef.setIsEnabled(CourseProductRef.IS_ENABLED_TURE);
        List<CourseProductRef> courseProductRefList = this.courseProductRefMapper.selectListByConditions(courseProductRef);
        //获取项目集合
        List<CoursePassProductVo> productList = new ArrayList<>(10);
        courseProductRefList.forEach(x -> {
            CoursePassProductVo coursePassProductVo = new CoursePassProductVo();
            coursePassProductVo.setProductId(x.getServerId());
            coursePassProductVo.setServerType(x.getIsSupportHome() ? 1 : 0);
            productList.add(coursePassProductVo);
        });
        //保存到美容师-项目-课程关联表
        ProductBeauticianRefCoursePassVo productBeauticianRefCoursePassVo = new ProductBeauticianRefCoursePassVo();
        productBeauticianRefCoursePassVo.setBeauticianIdList(beauticianIdList);
        productBeauticianRefCoursePassVo.setProductList(productList);
        this.productBeauticianRefFeign.coursePassV111(productBeauticianRefCoursePassVo);
        //批量更新
        UpdateBeauticianVo updateBatch = new UpdateBeauticianVo();
        updateBatch.setBeauticianIdList(updateBeauticianVo.getBeauticianIdList());
        updateBatch.setIsScheduling(CourseBeauticianRef.IS_SCHEDULING_YES);
        this.courseBeauticianRefMapper.updateBatch(updateBatch);
    }

    /**
     * 课程前一天发送短信给美容师
     */
    @Async
    public void findIsAboutToBeginCourseSendMessage() {
        //查询需要发送短信提醒的数据
        CourseParamVo courseParamVo = new CourseParamVo();
        courseParamVo.setTrainingBeginStart(DateUtil.todayFirstDate());
        courseParamVo.setTrainingBeginEnd(DateUtil.todayLastDate());
        List<CourseBeauticianRefResultVo> courseBeauticianRefResultVoList = this.courseMapper.findIsAboutToBeginCourse(courseParamVo);

        //发送短信list
        List<SmsMessageVo> sendSmsList = new ArrayList<>(10);
        //推送信息list
        List<SendMsgParamVo> sendMegList = new ArrayList<>(10);

        courseBeauticianRefResultVoList.forEach(x -> {

            String courseTime = x.getTrainingBegin().substring(0, x.getTrainingBegin().length() - 2);

            JsonObject json = new JsonObject();
            json.addProperty("name", x.getCourseName().substring(0, 5));
            json.addProperty("time", courseTime);
            SmsMessageVo beauVo = new SmsMessageVo();
            beauVo.setPhone(x.getMobilePhone());
            beauVo.setSmsCode(SmsConstant.JOIN_TRAINING_COURSE_NOTIFY_CUSTOMER.getSmsCode());
            beauVo.setSmsContent(json.toString());
            sendSmsList.add(beauVo);

            Map<String, Object> customMap = new HashMap<>(4);
            customMap.put("type", SendMsgParamVo.COURSE_ONE_DAY_TYPE);
            customMap.put("id", x.getCourseId());
            customMap.put("name", x.getCourseName());
            customMap.put("time", courseTime);
            SendMsgParamVo sendMsgParamVo = new SendMsgParamVo();
            sendMsgParamVo.setTemplateCode(SystemPushCodeEnum.COURSE_BEFORE_TO_BEAUTICIAN.getValue());
            sendMsgParamVo.setCourseName(x.getCourseName());
            sendMsgParamVo.setCourseTime(courseTime);
            sendMsgParamVo.setMemberId(x.getMemberId());
            sendMsgParamVo.setCustoms(customMap);
            sendMegList.add(sendMsgParamVo);
        });
        this.sendSmsFeign.sendSmsCodeList(sendSmsList);
        this.basePushTemplateFeign.sendMessage(sendMegList);
    }
}
