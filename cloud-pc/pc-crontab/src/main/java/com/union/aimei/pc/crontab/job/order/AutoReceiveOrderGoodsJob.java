package com.union.aimei.pc.crontab.job.order;


import com.union.aimei.common.feign.pc.order.OrderGoodsBaseFeign;
import lombok.extern.apachecommons.CommonsLog;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @describe 实物产品订单收货确认定时器
 * @time 2018/3/27,13:50
*/
@CommonsLog
public class AutoReceiveOrderGoodsJob extends QuartzJobBean {

    @Resource
    private OrderGoodsBaseFeign orderGoodsBaseFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("自动收货定时任务开始执行");
        orderGoodsBaseFeign.autoConfirmReceive();
    }
}
