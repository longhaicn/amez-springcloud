package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店朋友
 *
 * @author liurenkai
 * @time 2018/6/7 14:50
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "门店朋友")
public class StoreFriend implements Serializable {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("朋友姓名")
    private String friendName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}