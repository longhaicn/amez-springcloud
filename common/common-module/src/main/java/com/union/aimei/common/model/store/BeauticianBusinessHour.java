package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 美容师营业时间
 *
 * @author liurenkai
 * @time 2018/5/19 10:25
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "美容师营业时间")
public class BeauticianBusinessHour implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("周几，1-7，逗号分隔")
    private String weekday;

    @ApiModelProperty("时间点，HH:mm")
    private String timePoint;

    @ApiModelProperty("是否选择，1-是，0-否")
    private Boolean isSelect;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}