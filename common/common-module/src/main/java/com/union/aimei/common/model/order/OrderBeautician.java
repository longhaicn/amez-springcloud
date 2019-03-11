package com.union.aimei.common.model.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单美容师
 *
 * @author gaowei
 * @time 2018/8/24 10:02
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "订单美容师")
public class OrderBeautician implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("订单ID")
    private Integer orderId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店长手机号码")
    private String storeSellerPhone;

    @ApiModelProperty("店长会员ID")
    private Integer storeSellerMemberId;

    @ApiModelProperty("美容师id")
    private Integer beauticianId;

    @ApiModelProperty("美容师IM用户ID")
    private Integer beauticianImUserId;

    @ApiModelProperty("美容师IM用户名称")
    private String beauticianImUserName;

    @ApiModelProperty("美容师会员ID")
    private Integer beauticianMemberId;

    @ApiModelProperty("美容师头像地址")
    private String imgUrl;

    @ApiModelProperty("美容师名称")
    private String beauticianName;

    @ApiModelProperty("美容师昵称")
    private String beauticianNickName;

    @ApiModelProperty("美容师佣金")
    private Integer beauticianCommission;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("类型0-老板，1-店长，2-正式员工，3-兼职员工")
    private Byte type;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}