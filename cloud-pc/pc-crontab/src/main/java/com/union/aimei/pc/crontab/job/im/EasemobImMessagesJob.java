package com.union.aimei.pc.crontab.job.im;

import com.union.aimei.common.feign.im.pc.EasemobImChatMessagesFeign;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 环信IM消息任务 根据时间条件下载历史消息文件
 *
 * @author liurenkai
 * @time 2018/3/26 20:12
 */
public class EasemobImMessagesJob extends QuartzJobBean {

    @Resource
    private EasemobImChatMessagesFeign easemobImChatMessagesFeign;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, Calendar.HOUR - 1);
        String timeStr = new SimpleDateFormat("yyyyMMddHH").format(cal.getTime());
        easemobImChatMessagesFeign.exportTime(timeStr);
    }

}
