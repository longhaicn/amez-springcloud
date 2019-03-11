package com.union.aimei.common.model.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务订单-退款协商记录表
 *
 * @author gaowei
 * @time 2018/8/24 10:02
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "服务订单-退款协商记录表")
public class OrderRefundsConsultRecord implements Serializable {
    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("订单退款ID")
    private Integer orderReturnId;

    @ApiModelProperty("退款申请人ID")
    private Integer applyMemberId;

    @ApiModelProperty("申请人头像")
    private String applyMemberHeadImg;

    @ApiModelProperty("申请人昵称")
    private String applyMemberNickname;

    @ApiModelProperty("申请退款时间")
    private Date applyTime;

    @ApiModelProperty("退款原因")
    private String applyReason;

    @ApiModelProperty("申请原因详细说明")
    private String applyRemark;

    @ApiModelProperty("拒绝人ID")
    private Integer refusePersonId;

    @ApiModelProperty("拒绝人头像")
    private String refusePersonHeadImg;

    @ApiModelProperty("拒绝人昵称")
    private String refusePersonNickname;

    @ApiModelProperty("拒绝时间")
    private Date refuseTime;

    @ApiModelProperty("拒绝说明")
    private String refuseRemark;

    @ApiModelProperty("拒绝凭证")
    private String refuseVoucher;

    @ApiModelProperty("是否有效(1:有效，0：无效，默认1)")
    private Boolean isEnabled;

    @ApiModelProperty("添加时间")
    private Date addTime;

    @ApiModelProperty("操作人类型(0：买家，1：卖家，2：平台)")
    private Byte operType;

    @ApiModelProperty("操作说明")
    private String operContent;

    private static final long serialVersionUID = 1L;
}