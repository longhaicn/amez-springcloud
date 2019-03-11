package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 美容师粉丝
 *
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "美容师粉丝")
public class BeauticianFollower implements Serializable {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("是否关注，true-已关注，false-未关注")
    private Boolean isFollower;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}