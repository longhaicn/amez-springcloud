package com.union.aimei.pc.crontab.job.order;


import com.union.aimei.common.feign.pc.order.OrderBaseFeign;
import lombok.extern.apachecommons.CommonsLog;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @describe 待评价订单七天自动好评
 * @time 2018/3/19,16:08
*/
@CommonsLog
public class AutoGoodCommentJob extends QuartzJobBean {

    @Resource
    private OrderBaseFeign orderBaseFeign;


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("七天自动好评定时任务开始执行");
        orderBaseFeign.autoGoodCommentTask();
    }
}
