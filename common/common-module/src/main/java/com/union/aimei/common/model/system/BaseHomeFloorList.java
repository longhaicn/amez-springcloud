package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "楼层列表数据表")
public class BaseHomeFloorList implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("楼层id")
    private Integer floorId;

    @ApiModelProperty("项目id")
    private Integer productId;

    @ApiModelProperty("项目类型 0-平台 1-门店资源")
    private Byte productType;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 是否删除 true-否
     */
    public static final Boolean IS_ENABLED_TURE = true;
    /**
     * 是否删除 false-是
     */
    public static final Boolean IS_ENABLED_FALSE = false;

    private static final long serialVersionUID = 1L;
}