package com.union.aimei.common.model.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "会员地址")
public class MemberAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("地址id")
    private Integer id;
    @ApiModelProperty("会员id")
    private Integer memberId;
    @ApiModelProperty("城市id")
    private Integer cityId;
    @ApiModelProperty("收货人姓名")
    private String receiver;
    @ApiModelProperty("手机号码")
    private String phone;
    @ApiModelProperty("省市县地区 空格隔开")
    private String regson;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("经度")
    private String longitude;
    @ApiModelProperty("纬度")
    private String latitude;
    @ApiModelProperty("是否默认地址，0不是，1是")
    private Integer isDefault;
    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;
    @ApiModelProperty("门牌号")
    private String doorNumber;
    @ApiModelProperty("身份标识(0--会员 1--美容师，2--店长 默认为0)")
    private Integer identification;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}