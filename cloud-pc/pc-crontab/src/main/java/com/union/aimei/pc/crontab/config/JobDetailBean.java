package com.union.aimei.pc.crontab.config;

import com.union.aimei.common.model.crontab.TaskInfo;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;

/**
 * 任务详情
 *
 * @author GaoWei
 * @time 2018/8/22 15:44
 */
@Configuration
@EnableConfigurationProperties(JobDetailProperties.class)
public class JobDetailBean {

    @Resource
    private JobDetailProperties jobDetailProperties;

    @Bean
    public List<TaskInfo> jobTaskList(){
        return jobDetailProperties.getJobTaskList();
    }

    @Bean
    public boolean isPause(){
        return jobDetailProperties.isPause();
    }

}
