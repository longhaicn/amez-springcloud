package com.union.aimei.common.vo.pay;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author bruce 
 * 
 */
@ApiModel(value = "余额/一卡通退款实体类")
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

	@ApiModelProperty(value = "会员id")
	private Long memberId;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getRefundNo() {
		return refundNo;
	}

	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}

	public Integer getRefundPayType() {
		return refundPayType;
	}

	public void setRefundPayType(Integer refundPayType) {
		this.refundPayType = refundPayType;
	}

	public BigDecimal getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public Integer getAppSystem() {
		return appSystem;
	}

	public void setAppSystem(Integer appSystem) {
		this.appSystem = appSystem;
	}

	public Long getOneCardId() {
		return oneCardId;
	}

	public void setOneCardId(Long oneCardId) {
		this.oneCardId = oneCardId;
	}
}
