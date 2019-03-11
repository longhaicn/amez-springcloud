package com.union.aimei.app.api.crontab.service.jobs;

import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * HelloJobs
 * 
 * @author liufeihua
 * @date 2018/1/18 10:51
 */
@Component
public class HelloJobs {

    public void execute() throws JobExecutionException {
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // TODO 具体的业务逻辑:
        System.out.println("Hellow Quartz! 执行时间:"+sf.format(calender.getTime()));
    }
}
