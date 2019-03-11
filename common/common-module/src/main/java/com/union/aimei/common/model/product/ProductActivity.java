package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目活动
 *
 * @author liurenkai
 * @time 2018/5/14 10:35
 */
@Data
@EqualsAndHashCode
@ApiModel("项目活动")
public class ProductActivity implements Serializable {
    @ApiModelProperty("商品ID")
    private Integer id;

    @ApiModelProperty("活动代码")
    private String activityCode;

    @ApiModelProperty("活动名称")
    private String activityName;

    @ApiModelProperty("商品封面图")
    private String coverImg;

    @ApiModelProperty("活动描述")
    private String activityDesc;

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("城市名称")
    private String cityName;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("是否精选，1-是，0-否")
    private Boolean isSelect;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}