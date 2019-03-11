package com.union.aimei.pc.crontab.job.learn;

import com.union.aimei.common.feign.pc.learn.CourseFeign;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 课程开始前一天的短信通知调度，以及推送信息通知
 *
 * @author caizhaoming
 * @create 2018-06-11 15:35
 **/
@Component
public class CourseStartJobs extends QuartzJobBean {

    @Resource
    private CourseFeign courseFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        this.courseFeign.findIsAboutToBeginCourse();
    }

}
