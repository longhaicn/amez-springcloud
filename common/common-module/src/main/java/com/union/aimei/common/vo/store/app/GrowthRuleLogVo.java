package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询成长值日志vo
 *
 * @author caizhaoming
 * @create 2018-06-21 13:50
 **/
@Data
@EqualsAndHashCode
@ApiModel("查询成长值日志vo")
public class GrowthRuleLogVo implements Serializable {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("外键id")
    private Integer relId;

    @ApiModelProperty("来源类型：0-门店、1-美容师")
    private Byte sourceType;

    @ApiModelProperty("条件关联id")
    private Integer connditionId;

    @ApiModelProperty("来源id")
    private Integer sourceId;

    @ApiModelProperty("成长项名字")
    private String itemName;

    @ApiModelProperty("成长值类型：0-即时设置、1-间接抓取")
    private Byte growthType;

    @ApiModelProperty("成长数值")
    private Integer growthValue;

    @ApiModelProperty("成长值计算类型：0-加、1-减")
    private Byte growthCalculateType;

    @ApiModelProperty("限定条件：0-无限制、1-次数限制、2-数值限制（日、月）、3-日限制、4-月限制")
    private Byte conditionType;

    @ApiModelProperty("次数限制")
    private Integer conditionValueNumber;

    @ApiModelProperty("每日上限")
    private Integer conditionValueDay;

    @ApiModelProperty("每月上限")
    private Integer conditionValueMonth;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("创建时间-开始")
    private String startCreateTime;

    @ApiModelProperty("创建时间-结束")
    private String endCreateTime;


}
