package com.union.aimei.pc.crontab.config;

import com.union.aimei.common.model.crontab.TaskInfo;
import com.union.aimei.pc.crontab.service.TaskService;
import com.union.common.utils.CollectionUtils;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 初始化加载
 *
 * @author GaoWei
 * @time 2018/8/22 15:44
 */
@Component
@CommonsLog
public class CrontabRunner implements ApplicationRunner, Ordered {

    @Resource
    private JobDetailBean jobDetailBean;
    @Resource
    private TaskService taskService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        List<TaskInfo> list=jobDetailBean.jobTaskList();
        if(CollectionUtils.isEmpty(list)){
           log.error("请在yml文件中添加任务");
           return;
        }
        List<TaskInfo> taskList=taskService.getList();

        //数据库表不存在任务则全部添加
        if(CollectionUtils.isEmpty(taskList)){
            log.info("数据库不存在定时任务，执行全新添加操作");
            for (TaskInfo job:list){
                taskService.addJob(job);
            }
        }else {
            log.info("数据库存在定时任务，执行检查及添加更新操作");
            //判断是否存在，存在则修改，不存在则添加
            for(TaskInfo info:taskList){
                String dbGroupName=info.getJobGroup();
                String dbJobName=info.getJobName();
                for(TaskInfo task:list){
                    boolean isTrue=dbGroupName.equals(task.getJobGroup())&&dbJobName.equals(task.getJobName());
                    if(isTrue){
                        taskService.edit(task);
                    }else{
                        taskService.addJob(task);
                    }
                }
            }
        }
//        taskService.pauseAll();
    }



    @Override
    public int getOrder() {
        return 2;
    }
}
