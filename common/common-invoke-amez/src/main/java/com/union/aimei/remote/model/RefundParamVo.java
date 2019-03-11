package com.union.aimei.remote.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
  * @author GaoWei
  * @Date 18-8-13 下午4:04
  * @description
  */
@ApiModel(value = "余额/一卡通退款实体类")
@Data
public class RefundParamVo implements Serializable {

	private static final long serialVersionUID = 4898874700451204710L;
	
	@ApiModelProperty(value = "会员UUID",required = true)
	private String uuid;
	
	@ApiModelProperty(value = "订单号,需要填写原支付订单号",required = true)
	private String orderNo;
	
	@ApiModelProperty(value = "退款单号,必须保证唯一性",required = true)
	private String refundNo;
	
	@ApiModelProperty(value = "退款支付类型 3 一卡通退款,4 余额退款")
	private Integer refundPayType;
	
	@ApiModelProperty(value = "退款类型为一卡通退款时必填，需要填写原订单扣款时的一卡通ID")
	private Long oneCardId;
	
	@ApiModelProperty(value = "退款金额,单位元, 最小金额为0.01元",required = true)
	private BigDecimal refundFee;
	
	
	@ApiModelProperty(value = "退款原因",required = true)
	private String refundReason;
	
	@ApiModelProperty(value = "应用编号")
	private Integer appSystem;

	@ApiModelProperty(value = "会员ID")
	private Long memberId;

}
