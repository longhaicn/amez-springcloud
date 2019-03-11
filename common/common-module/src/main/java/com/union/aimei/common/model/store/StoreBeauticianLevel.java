package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 美容师等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "美容师等级")
public class StoreBeauticianLevel implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("等级名称")
    private String levelName;

    @ApiModelProperty("美容师星级，范围为0-100")
    private Integer starValue;

    @ApiModelProperty("等级图标")
    private String levelLogo;

    @ApiModelProperty("开始成长值")
    private Integer beginUpgradeValue;

    @ApiModelProperty("结束成长值")
    private Integer endUpgradeValue;

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