package com.union.aimei.common.model.learn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "门槛条件表")
public class LearnCondition implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("源id")
    private Integer sourceId;

    @ApiModelProperty("类型 0-课程 1-活动(美容师) 2-(店铺)")
    private Byte sourceType;

    @ApiModelProperty("条件名字描述")
    private String conditionName;

    @ApiModelProperty("条件判断（固定值直接录入，指定值用 , 区分，区间值用 - 区分）")
    private String conditionalData;

    @ApiModelProperty("判断依据，0-并且，1-或者，2-不等，3-以上，4-以下")
    private Byte conditionalAccording;

    @ApiModelProperty("条件类型，0-认证美容师，1-兼职美容师，2-全职美容师，3-有挂靠门店 ，4-等级(美容师) ，5-星级 ， 6认证门店 ， 7-等级(店铺)")
    private Byte conditionalType;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 类型 0-课程
     */
    public static final byte SOURCE_TYPE_COURSE = 0 ;
    /**
     * 类型 1-活动
     */
    public static final byte SOURCE_TYPE_ACTIVE = 1 ;
    /**
     * 类型 2-(店铺)
     */
    public static final byte SOURCE_TYPE_ACTIVE_STOCK = 2 ;


    /**
     * 是否删除 true-否
     */
    public static final boolean IS_ENABLED_TURE = true ;
    /**
     * 是否删除 false-是
     */
    public static final boolean IS_ENABLED_FALSE = false ;

    /**
     * 条件类型，0-认证美容师
     */
    public static final byte CERTIFIED_BEAUTICIAN = 0;
    /**
     * 条件类型，1-兼职美容师
     */
    public static final byte PART_TIME_BEAUTICIAN = 1;
    /**
     * 条件类型，2-全职美容师
     */
    public static final byte FULL_TIME_BEAUTICIAN = 2;
    /**
     * 条件类型，3-有挂靠门店
     */
    public static final byte STORE = 3;
    /**
     * 条件类型，4-等级
     */
    public static final byte LEVEL = 4;
    /**
     * 条件类型，5-星级
     */
    public static final byte STAR = 5;

    /**
     * 条件类型，6-认证门店
     */
    public static final byte CERTIFIED_STORE = 6;

    /**
     * 条件类型，7-等级(店铺)
     */
    public static final byte LEVEL_SOTCK = 7;

    /**
     * 判断依据，0-并且
     */
    public static final byte CONDITIONAL_ACCORDING_AND = 0;
    /**
     * 判断依据，1-或者
     */
    public static final byte CONDITIONAL_ACCORDING_OR = 1;
    /**
     * 判断依据，2-不等
     */
    public static final byte CONDITIONAL_ACCORDING_NOT = 2;
    /**
     * 判断依据，3-以上
     */
    public static final byte CONDITIONAL_ACCORDING_UP = 3;
    /**
     * 判断依据，4-以下
     */
    public static final byte CONDITIONAL_ACCORDING_DOWN = 4;


    private static final long serialVersionUID = 1L;
}