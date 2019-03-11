package com.union.aimei.common.model.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 退换货单
 *
 * @author gaowei
 * @time 2018/8/24 10:02
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "退换货单")
public class OrderReturn implements Serializable {

    /**
     * 退款中
     */
    public static final int IN_RETURN = 1;
    /**
     * 退款成功
     */
    public static final int RETURN_SUCCESS = 2;
    /**
     * 退款失败
     */
    public static final int RETURN_FAIL = 3;


    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    @ApiModelProperty("退换货的订单id")
    private Integer orderId;

    @ApiModelProperty("退换货的订单号")
    private String orderNo;

    @ApiModelProperty("退款单号")
    private String refundOrderNo;

    @ApiModelProperty("会员id")
    private Integer memberId;

    @ApiModelProperty("会员名称")
    private String memberName;

    @ApiModelProperty("退换货类型，1换货，2退款")
    private Byte returnType;

    @ApiModelProperty("申请退换货的状态，1申请中，2审核通过,3:审核未通过")
    private Byte returnStatus;

    @ApiModelProperty("退货理由")
    private String reason;

    @ApiModelProperty("退款总金额")
    private Integer fee;

    @ApiModelProperty("申请时间")
    private Date applyTime;

    @ApiModelProperty("审核通过时间")
    private Date auditTime;

    @ApiModelProperty("退货物流商名称")
    private String deliveryName;

    @ApiModelProperty("退货物流单号")
    private String deliveryCode;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("修改次数(最多允许4次，默认为1)")
    private Integer updateCount;

    private static final long serialVersionUID = 1L;
}