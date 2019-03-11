package com.union.aimei.pc.crontab.job.learn;

import com.union.aimei.common.feign.pc.learn.CourseFeign;
import com.union.common.utils.ResponseMessage;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 执行更新课程状态的任务调度
 *
 * @author caizhaoming
 * @create 2018-05-21 15:35
 **/
@Component
public class CourseJobs extends QuartzJobBean {

    @Resource
    private CourseFeign courseFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        ResponseMessage responseMessage = this.courseFeign.updateSchedulingV110();
        //System.out.println ("课程状态更新结果：" + responseMessage.getCode ());
    }

}
