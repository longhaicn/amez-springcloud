package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据忙碌日期查询美容师忙碌时间条件
 *
 * @author liurenkai
 * @time 2018/5/19 15:26
 */
@Data
@EqualsAndHashCode
@ApiModel("根据忙碌日期查询美容师忙碌时间条件")
public class BeauticianBusyTimeByBusyDateVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("忙碌日期，yyyy-MM-dd")
    private String busyDate;

}
