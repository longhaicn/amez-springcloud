package com.union.aimei.common.vo.financial;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "平台交易")
public class PlatformTradeDetailVo implements Serializable {

    @ApiModelProperty("交易类型(1-服务订单，2-会员卡售卡,3-会员卡充值")
    private Integer tradeType;

    @ApiModelProperty("交易状态:服务订单:1-待服务,2-服务中,3-服务完成,4-交易完成,5-退款中,6-退款完成.会员售卡和会员卡充值:1表示购卡或者充值成功")
    private Integer tradeStatus;

    @ApiModelProperty("支付方式:1-支付宝,2-微信,3-会员卡,4-一卡通,5-余额支付")
    private Integer payMethod;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("付款时间-开始")
    private Date startPayTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("付款时间-结束")
    private Date endPayTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("结算时间-开始")
    private Date settlementStartTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("结算时间-结束")
    private Date settlementEndTime;

    @ApiModelProperty("门店名字/手机号")
    private String beauticianNameAndPhone;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    private static final long serialVersionUID = 1L;
}