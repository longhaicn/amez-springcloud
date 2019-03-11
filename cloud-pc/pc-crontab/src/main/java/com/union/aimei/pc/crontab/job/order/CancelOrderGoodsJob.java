package com.union.aimei.pc.crontab.job.order;


import com.union.aimei.common.feign.pc.order.OrderGoodsBaseFeign;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @describe 实物订单12小时未付款，取消订单释放库存
 * @time 2018/3/19,16:05
*/
public class CancelOrderGoodsJob extends QuartzJobBean {

    @Resource
    private OrderGoodsBaseFeign orderGoodsBaseFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        orderGoodsBaseFeign.cancelOrderGoodsBaseJob();
    }
}
