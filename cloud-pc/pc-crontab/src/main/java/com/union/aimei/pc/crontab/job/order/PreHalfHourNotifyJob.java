package com.union.aimei.pc.crontab.job.order;


import com.union.aimei.common.feign.pc.order.OrderBaseFeign;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @describe 订单开始前半小时提醒用户及美容师
 * @time 2018/3/26,15:47
*/
public class PreHalfHourNotifyJob extends QuartzJobBean {

    @Resource
    private OrderBaseFeign orderBaseFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        orderBaseFeign.notifyPreHalfHourJob();
    }
}
