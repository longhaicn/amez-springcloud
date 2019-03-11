package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店成长值记录
 *
 * @author liurenkai
 * @time 2018/4/11 14:26
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "门店成长值记录")
public class StoreLevelUpgradeLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("门店ID")
    private Integer storeId;
    @ApiModelProperty("门店成长会规则ID")
    private Integer storeLevelUpgradeId;
    @ApiModelProperty("升级规则名")
    private String levelUpgradeName;
    @ApiModelProperty("当前规则所需条件")
    private Integer condition;
    @ApiModelProperty("当前规则的成长值")
    private Integer value;
    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}