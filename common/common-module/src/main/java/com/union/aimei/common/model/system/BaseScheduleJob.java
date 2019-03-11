package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "定时任务表")
public class BaseScheduleJob implements Serializable {

    /**
     * 暂停
     */
    public static final byte JOB_STATE_PAUSE = 0;
    /**
     * 正常
     */
    public static final byte JOB_STATE_NORMAL = 1;
    /**
     * 异常
     */
    public static final byte JOB_STATE_EXCEPTION = 2;
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("定时任务Id")
    private Integer id;
    @ApiModelProperty("定时任务名称")
    private String jobName;
    @ApiModelProperty("job唯一代码")
    private String jobCode;
    private String description;
    @ApiModelProperty("定时任务完整类名称")
    private String jobClass;
    @ApiModelProperty("定时任务方法名称")
    private String jobMethod;
    @ApiModelProperty("常job状态,1正常运行，2运行异")
    private Byte jobState;
    @ApiModelProperty("定时任务的Corn表达式")
    private String cronExpression;
    @ApiModelProperty("是否启用，1启用，0禁用")
    private Byte isEnable;
    @ApiModelProperty("能否并发运行，1可以，0不可以")
    private Byte isConcurrent;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}