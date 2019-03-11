package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺、美容师成长值vo
 *
 * @author caizhaoming
 * @create 2018-06-21 13:50
 **/
@Data
@EqualsAndHashCode
@ApiModel("店铺、美容师成长值vo")
public class GrowthRuleVo implements Serializable {

    @ApiModelProperty("成长值code")
    private String code;

    @ApiModelProperty("成长规则类型：0-门店、1-美容师")
    private Byte ruleType;

    @ApiModelProperty("来源id：美容师id、门店id")
    private Integer sourceId;

    @ApiModelProperty("获取成长值id：课程id、活动id")
    private Integer obtainId;

    @ApiModelProperty("条件关联id")
    private Integer connditionId;

    public interface RuleTypes {
        byte STORE = 0;
        byte BEAUTICIAN = 1;
    }

}
