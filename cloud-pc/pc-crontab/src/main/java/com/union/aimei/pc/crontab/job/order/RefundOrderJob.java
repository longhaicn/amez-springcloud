package com.union.aimei.pc.crontab.job.order;


import com.union.aimei.common.feign.pc.order.OrderBaseFeign;
import lombok.extern.apachecommons.CommonsLog;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @describe  退款订单处理定时器
 * 申请退款48小时后自动设置为退款成功
 * @time 2018/3/19,11:17
*/
@CommonsLog
public class RefundOrderJob extends QuartzJobBean {

    @Resource
    private OrderBaseFeign orderBaseFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("自动退款定时任务开始执行");
        orderBaseFeign.refundOrderTask();
    }
}
