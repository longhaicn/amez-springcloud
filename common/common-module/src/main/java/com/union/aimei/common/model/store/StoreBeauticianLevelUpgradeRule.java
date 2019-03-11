package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 美容师成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "美容师成长值规则设置")
public class StoreBeauticianLevelUpgradeRule implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("升级规则类型，1-日接单频率，2-月接单总金额，3-回复评价次数，4-好评量，5-发帖量")
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