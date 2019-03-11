package com.union.aimei.pc.crontab.job.financial;

import com.union.aimei.common.feign.pc.financial.StoreTradeStatisticsFeign;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * 店铺流水统计允许对账确认调度
 *
 * @author caizhaoming
 * @date 2018/6/6 13:52
 */
@Component
public class StoreTradeStatisticsButtonJobs extends QuartzJobBean {

    @Autowired
    private StoreTradeStatisticsFeign storeTradeStatisticsFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        this.storeTradeStatisticsFeign.storeTradeStatisticsButtonJobs();
    }

}
