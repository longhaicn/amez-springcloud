package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 新增美容师营业时间条件
 *
 * @author liurenkai
 * @time 2018/5/24 3:09
 */
@Data
@EqualsAndHashCode
@ApiModel("新增美容师营业时间条件")
public class BeauticianBusinessHourByAddVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    @ApiModelProperty("工作日，1-7，多个逗号分隔")
    private String workday;

}