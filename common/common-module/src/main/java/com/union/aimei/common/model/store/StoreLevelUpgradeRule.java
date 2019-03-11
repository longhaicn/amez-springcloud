package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2017/12/27 16:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺成长值规则设置")
public class StoreLevelUpgradeRule implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("升级规则类型，1-最近一次接单，2-接单频次，3-接单金额，4-评价数量，5-好评量")
    private String levelUpgradeType;

    @ApiModelProperty("升级条件")
    private Integer levelUpgradeCondition;

    @ApiModelProperty("对应成长值")
    private Integer levelUpgradeValue;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}