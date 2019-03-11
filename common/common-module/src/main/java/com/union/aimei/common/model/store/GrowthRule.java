package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "成长规则")
public class GrowthRule implements Serializable {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("编码")
    private String code;

    @ApiModelProperty("成长规则类型：0-门店、1-美容师")
    private Byte ruleType;

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

    @ApiModelProperty("获取规则内容")
    private String content;

    @ApiModelProperty("状态：0-生效、1-暂停")
    private Byte status;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;


    /**
     * 成长规则类型：0-门店、1-美容师
     */
    public interface RuleType {
        byte STORE = 0;
        byte BEAUTICIAN = 1;
    }

    /**
     * 成长值类型：0-即时设置、1-间接抓取
     */
    public interface GrowthType {
        byte INSTANTSETTINGS = 0;
        byte INDIRECTCRAWL = 1;
    }

    /**
     * 成长值计算类型：0-加、1-减
     */
    public interface GrowthCalculateType {
        byte ADD = 0;
        byte LESS = 1;
    }

    /**
     * 限定条件：0-无限制、1-次数限制、2-数值限制（日、月）、3-日限制、4-月限制
     */
    public interface ConditionType {
        byte UNLIMITED = 0;
        byte TIMESLIMIT = 1;
        byte NUMERICALLIMIT_DAY_MONTH = 2;
        byte NUMERICALLIMIT_DAY = 3;
        byte NUMERICALLIMIT_MONTH = 4;
    }

    /**
     * 状态：0-生效、1-暂停
     */
    public interface Status {
        byte EFFECTIVE = 0;
        byte TIMEOUT = 1;
    }

    /**
     * 是否删除 true-否
     */
    public static final boolean IS_ENABLED_TURE = true;
    /**
     * 是否删除 false-是
     */
    public static final boolean IS_ENABLED_FALSE = false;


    private static final long serialVersionUID = 1L;
}