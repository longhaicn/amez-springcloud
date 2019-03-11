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
@ApiModel(value = "会员卡交易记录")
public class MemberCardTradeRecode implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("发行单位(0：平台，1：店铺)")
    private Boolean isPlatform;
    @ApiModelProperty("发卡方名称")
    private String issueName;
    @ApiModelProperty("会员ID")
    private Integer memberId;
    @ApiModelProperty("会员卡ID")
    private Integer memberCardId;
    @ApiModelProperty("会员拥有的会员卡ID")
    private Integer memberCardRefId;
    @ApiModelProperty("会员卡号")
    private String memberCardNo;
    @ApiModelProperty("交易金额（以分为单位存入）")
    private Integer tradeAmount;
    @ApiModelProperty("0:充值，1：消费(默认0),2:购卡")
    private Byte useType;
    @ApiModelProperty("交易时间")
    private Date useTime;
    @ApiModelProperty("门店ID")
    private Integer storeId;
    @ApiModelProperty("门店名称")
    private String storeName;
    @ApiModelProperty("会员卡充值订单")
    private String orderNo;
    @ApiModelProperty("交易流水号")
    private String tradeNo;
    @ApiModelProperty("交易类型(0:微信支付，1：支付宝支付，2：其他)")
    private Byte payType;
    @ApiModelProperty("支付状态(0:未支付，1：已支付)")
    private Byte payStatus;
}