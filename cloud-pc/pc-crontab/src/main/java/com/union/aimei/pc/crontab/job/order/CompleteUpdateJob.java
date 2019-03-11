package com.union.aimei.pc.crontab.job.order;


import com.union.aimei.common.feign.pc.order.OrderBaseFeign;
import lombok.extern.apachecommons.CommonsLog;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;


/**
 * @author GaoWei
 * @describe  订单验证完成后，计算时间更改状态为待评价,更改交易流水状态为已完成
 * @time 2018/3/16,16:10
*/
@CommonsLog
public class CompleteUpdateJob extends QuartzJobBean {


    @Resource
    private OrderBaseFeign orderBaseFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("项目订单完成自己触发定时任务运行");
        orderBaseFeign.completeUpdateJob();
    }


}
