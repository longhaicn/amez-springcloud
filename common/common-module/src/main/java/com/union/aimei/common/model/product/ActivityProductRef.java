package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动-项目-关联
 *
 * @author liurenkai
 * @time 2018/5/14 10:36
 */
@Data
@EqualsAndHashCode
@ApiModel("活动-项目-关联")
public class ActivityProductRef implements Serializable {
    @ApiModelProperty("商品ID")
    private Integer id;

    @ApiModelProperty("活动ID")
    private Integer activityId;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}