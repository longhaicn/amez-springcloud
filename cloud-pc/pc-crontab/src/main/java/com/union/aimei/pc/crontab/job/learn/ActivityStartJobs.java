package com.union.aimei.pc.crontab.job.learn;

import com.union.aimei.common.feign.pc.learn.ActivityFeign;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author houji
 * @date 2018/6/15  10:05
 *
 * 活动开始前一天的短信通知调度，以及推送信息通知
 */
@Component
public class ActivityStartJobs extends QuartzJobBean {

    @Resource
    private ActivityFeign activityFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        activityFeign.pushMsgForEnterActivityMember();
    }
}
