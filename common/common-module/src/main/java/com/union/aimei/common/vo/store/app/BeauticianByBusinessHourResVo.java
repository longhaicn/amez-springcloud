package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师营业时间结果
 *
 * @author liurenkai
 * @time 2018/6/8 16:35
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师营业时间结果")
public class BeauticianByBusinessHourResVo implements Serializable {

    @ApiModelProperty("开始营业时间，HH:mm")
    private String startBusinessHour;

    @ApiModelProperty("结束营业时间，HH:mm")
    private String endBusinessHour;

    @ApiModelProperty("工作日，逗号分隔")
    private String workday;

}
