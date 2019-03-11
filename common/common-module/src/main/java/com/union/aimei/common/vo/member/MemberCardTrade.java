package com.union.aimei.common.vo.member;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 *@author GaoWei
 *descrption: 会员卡交易数据模型
 *time  2017/12/16 19:48
 */
@ApiModel(value = "会员卡购卡/充值")
@Data
@EqualsAndHashCode
public class MemberCardTrade implements Serializable{
    @ApiModelProperty(value = "会员ID",required = true)
    private Integer memberId;
    @ApiModelProperty(value = "售卡单位(0:平台，1：店铺)")
    private Boolean isPlatForm;
    @ApiModelProperty(value = "会员卡ID",required = true,example="2")
    private Integer memberCardId;
    @ApiModelProperty(value = "会员拥有的会员卡记录ID")
    private Integer memberCardRefId;
    @ApiModelProperty(value = "会员卡名称",example = "丽人")
    private String memberCardName;
    @ApiModelProperty(value = "门店ID",example = "1")
    private Integer storeId;
    @ApiModelProperty(value = "门店名称",example = "罗湖店")
    private String storeName;
    @ApiModelProperty(value = "交易金额")
    private Integer amount;
    @ApiModelProperty(value = "支付方式(0:微信支付，1：支付宝，2：其他)",required = true,example = "0")
    private Byte payType;
    @ApiModelProperty(value = "用户IP地址")
    private String ipAddress;
    @ApiModelProperty(value = "会员卡交易订单编号")
    private String memberCardTradeOrderNo;
    @ApiModelProperty(value = "交易流水号")
    private String outTradeNo;
    @ApiModelProperty("使用类型：0:充值，1：消费,2:购卡。(默认0)")
    private Byte useType;
}
