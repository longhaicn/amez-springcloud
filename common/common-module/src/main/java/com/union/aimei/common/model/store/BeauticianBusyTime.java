package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 美容师忙碌时间
 *
 * @author liurenkai
 * @time 2018/5/19 10:25
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "美容师忙碌时间")
public class BeauticianBusyTime implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("忙碌日期，yyyy-MM-dd")
    private String busyDate;

    @ApiModelProperty("忙碌时间，HH:mm，多个，分隔")
    private String busyTime;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}