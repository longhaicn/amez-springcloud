package com.union.aimei.pc.crontab.config;

import com.union.aimei.common.model.crontab.TaskInfo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 任务详情属性
 *
 * @author GaoWei
 * @time 2018/8/22 15:44
 */
@Data
@ConfigurationProperties(prefix = "com.union.crontab.job")
public class JobDetailProperties {

    private boolean isPause=true;
    private List<TaskInfo> jobTaskList;



}
