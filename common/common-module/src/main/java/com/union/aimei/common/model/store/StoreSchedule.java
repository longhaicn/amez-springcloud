package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺排班
 *
 * @author liurenkai
 * @time 2017/12/25 10:50
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺排班")
public class StoreSchedule implements Serializable {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("班次类型，1-早班，2-中班，3-晚班")
    private String scheduleType;

    @ApiModelProperty("排班日期")
    private Date scheduleDate;

    @ApiModelProperty("上班时间")
    private String workingHours;

    @ApiModelProperty("下班时间")
    private String offWorkingHours;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}