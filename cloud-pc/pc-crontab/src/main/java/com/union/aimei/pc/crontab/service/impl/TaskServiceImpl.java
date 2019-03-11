package com.union.aimei.pc.crontab.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.crontab.TaskInfo;
import com.union.aimei.pc.crontab.service.TaskService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.exception.ServerException;
import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @author GaoWei
 * @time 2018/6/14 14:29
 * @description
 */
@Service
public class TaskServiceImpl implements TaskService {


    private Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired(required=false)
    private Scheduler scheduler;


    /**
     *  所有任务列表
     * @return
     */
    @Override
    public PageInfo<TaskInfo> list(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<TaskInfo> list = getList();
        PageInfo<TaskInfo> page=new PageInfo<>(list);
        return page;
    }

    private String getNowTime(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        return localTime;
    }

    @Override
    public List<TaskInfo> getList(){
        List<TaskInfo> list = new ArrayList<>(10);
        try {
            for(String groupJob: scheduler.getJobGroupNames()){
                for(JobKey jobKey: scheduler.getJobKeys(GroupMatcher.<JobKey>groupEquals(groupJob))){
                    List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                    for (Trigger trigger: triggers) {
                        Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                        JobDetail jobDetail = scheduler.getJobDetail(jobKey);

                        String cronExpression = "", createTime = "";

                        if (trigger instanceof CronTrigger) {
                            CronTrigger cronTrigger = (CronTrigger) trigger;
                            cronExpression = cronTrigger.getCronExpression();
                        }
                        TaskInfo info = new TaskInfo();
                        info.setJobName(jobKey.getName());
                        info.setJobGroup(jobKey.getGroup());
                        info.setJobDescription(jobDetail.getDescription());
                        info.setJobStatus(triggerState.name());
                        info.setCronExpression(cronExpression);
                        info.setCreateTime(getNowTime());
                        list.add(info);
                    }
                }
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 添加任务
     * @param info
     */
    @Override
    public void addJob(TaskInfo info) {
        String jobName = info.getJobName(),
                jobGroup = info.getJobGroup(),
                cronExpression = info.getCronExpression(),
                jobDescription = info.getJobDescription(),
                createTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        try {
            if (checkExists(jobName, jobGroup)) {
                return;
            }

            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);

            CronScheduleBuilder schedBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withDescription(createTime).withSchedule(schedBuilder).build();


            Class<? extends Job> clazz = (Class<? extends Job>)Class.forName(jobName);
            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(jobKey).withDescription(jobDescription).build();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException | ClassNotFoundException e) {
            logger.error("添加任务：类名不存在或执行表达式错误,exception:{}",e.getMessage());
        }
    }

    /**
     * 编辑任务
     * @param info
     */
    @Override
    public void edit(TaskInfo info) {
        String jobName = info.getJobName(),
                jobGroup = info.getJobGroup(),
                cronExpression = info.getCronExpression(),
                jobDescription = info.getJobDescription(),
                createTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        try {
            if (!checkExists(jobName, jobGroup)) {
                throw new ServerException(500,"编辑任务失败");
            }
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            JobKey jobKey = new JobKey(jobName, jobGroup);
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withDescription(createTime).withSchedule(cronScheduleBuilder).build();

            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            jobDetail.getJobBuilder().withDescription(jobDescription);
            HashSet<Trigger> triggerSet = new HashSet<>();
            triggerSet.add(cronTrigger);
            scheduler.scheduleJob(jobDetail, triggerSet, true);
        } catch (SchedulerException e) {
            logger.error("编辑任务：类名不存在或执行表达式错误,exception:{}",e.getMessage());
        }
    }

    /**
     * 删除任务
     * @param jobName
     * @param jobGroup
     */
    @Override
    public void delete(String jobName, String jobGroup) {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.pauseTrigger(triggerKey);
                scheduler.unscheduleJob(triggerKey);
                logger.info("delete job, triggerKey:{},jobGroup:{}, jobName:{}", triggerKey ,jobGroup, jobName);
            }
        } catch (SchedulerException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 暂停任务
     * @param jobName
     * @param jobGroup
     */
    @Override
    public void pause(String jobName, String jobGroup) {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.pauseTrigger(triggerKey);
                logger.info("pause job success, triggerKey:{},jobGroup:{}, jobName:{}", triggerKey ,jobGroup, jobName);
            }
        } catch (SchedulerException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 全部暂停
     */
    @Override
    public void pauseAll() {
        List<TaskInfo> list=getList();
        if(!CollectionUtils.isEmpty(list)){
            list.forEach(task->{
                pause(task.getJobName(),task.getJobGroup());
            });
        }

    }

    /**
     * 全部重启
     */
    @Override
    public void resumeAll() {
        List<TaskInfo> list=getList();
        if(!CollectionUtils.isEmpty(list)){
            list.forEach(task->{
                resume(task.getJobName(),task.getJobGroup());
            });
        }
    }

    /**
     * 重启任务
     * @param jobName
     * @param jobGroup
     */
    @Override
    public void resume(String jobName, String jobGroup) {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);

        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.resumeTrigger(triggerKey);
                logger.info("resume job success,triggerKey:{},jobGroup:{}, jobName:{}", triggerKey ,jobGroup, jobName);
            }
        } catch (SchedulerException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 验证是否存在
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    @Override
    public boolean checkExists(String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        return scheduler.checkExists(triggerKey);
    }
}
