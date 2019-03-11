package com.union.aimei.common.model.crontab;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author GaoWei
 * @time 2018/6/14 14:25
 * @description
 */
@Data
@ApiModel(value = "任务信息")
public class TaskInfo {

    @ApiModelProperty(value = "主键ID(不用传)")
    private int id = 0;

    @ApiModelProperty(value = "任务名称(定时任务的实现类全路径，eg：com.union.aimei.pc.crontab.job.order.AfterPayJob")
    private String jobName;

    @ApiModelProperty(value = "任务分组")
    private String jobGroup;

    @ApiModelProperty(value = "任务描述")
    private String jobDescription;

    @ApiModelProperty(value = "任务状态",notes = "STATE_BLOCKED 	4   阻塞"+
            "STATE_COMPLETE 	2   完成"+
            "STATE_ERROR 	3   错误"+
            "STATE_NONE 	-1   不存在"+
            "STATE_NORMAL 	0  正常"+
            "STATE_PAUSED 	1  暂停")
    private String jobStatus;

    @ApiModelProperty(value = "任务表达式(cron表达式),eg:每十秒：0/10 * * * * ?")
    private String cronExpression;

    @ApiModelProperty(value = " 创建时间(不用传)")
    private String createTime;

}
