package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-25 11:43
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺-美容师等级")
public class StoreBeauticianGrade implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("等级名称")
    private String gradeName;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 是否删除 true-否
     */
    public static final boolean IS_ENABLED_TURE = true;
    /**
     * 是否删除 false-是
     */
    public static final boolean IS_ENABLED_FALSE = false;

    private static final long serialVersionUID = 1L;
}