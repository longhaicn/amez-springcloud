package com.union.aimei.pc.crontab.job.pay;

import com.union.aimei.common.feign.app.pay.AfterPayFeign;
import lombok.extern.apachecommons.CommonsLog;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @time 2018/6/12 16:57
 * @description
 */
@CommonsLog
public class AfterPayJob extends QuartzJobBean {



    @Resource
    private AfterPayFeign afterPayFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
             log.info("开始执行支付异常补偿定时任务");
        afterPayFeign.invokeAfterPayBusiness();
    }
}
