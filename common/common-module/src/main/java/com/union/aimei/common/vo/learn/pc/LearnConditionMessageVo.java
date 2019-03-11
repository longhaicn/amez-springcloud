package com.union.aimei.common.vo.learn.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 判断数据信息通知vo
 *
 * @author caizhaoming
 * @create 2018-05-18 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel("判断数据信息通知vo")
public class LearnConditionMessageVo implements Serializable {

    @ApiModelProperty("条件名字描述")
    private String conditionName;

    @ApiModelProperty("判断结果")
    private Boolean result;

    @ApiModelProperty("条件类型，0-认证美容师，1-兼职美容师，2-全职美容师，3-有挂靠门店 ，4-等级(美容师) ，5-星级 ， 6认证门店 ， 7-等级(店铺)")
    private Byte conditionalType;


}
