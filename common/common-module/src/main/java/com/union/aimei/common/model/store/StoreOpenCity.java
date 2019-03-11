package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店开通城市
 *
 * @author liurenkai
 * @time 2018/1/13 14:06
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "门店开通城市")
public class StoreOpenCity implements Serializable {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("市ID")
    private Integer cityId;

    @ApiModelProperty("市名称")
    private String cityName;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}