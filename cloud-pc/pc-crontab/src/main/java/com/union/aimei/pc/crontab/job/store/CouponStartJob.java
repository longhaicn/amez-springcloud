package com.union.aimei.pc.crontab.job.store;

import com.union.aimei.common.feign.pc.store.StoreCouponsFeign;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 优惠券 开始任务
 *
 * @author liurenkai
 * @time 2018/3/19 10:42
 */
@Component
public class CouponStartJob extends QuartzJobBean {

    @Resource
    private StoreCouponsFeign storeCouponsFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        storeCouponsFeign.startByScheduleTask();
    }

}
