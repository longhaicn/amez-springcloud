package com.union.aimei.common.vo.learn.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 门槛数据vo
 *
 * @author caizhaoming
 * @create 2018-05-17 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel("门槛数据vo")
public class LearnConditionVo implements Serializable {

    @ApiModelProperty("条件类型，0-认证美容师，1-兼职美容师，2-全职美容师，3-有挂靠门店 ，4-等级(美容师) ，5-星级 ， 6认证门店 ， 7-等级(店铺)")
    private Byte type;

    @ApiModelProperty("参数值，等级则传id，星级传1~5")
    private String values;

    @ApiModelProperty("参数值名字，等级等级的名字，星级则传星级的名字")
    private String names;

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


}
