package com.union.aimei.common.vo.order;


import com.union.aimei.common.model.order.OrderRefundsConsultRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author GaoWei
 * @describe 订单退款详情VO
 * @time 2018/3/20,14:07
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "订单退款详情VO")
public class OrderRefundDetailVo {

    @ApiModelProperty(value = "申请退款时间")
    private Date applyRefundTime;
    @ApiModelProperty(value = "卖家处理时间")
    private Date auditTime;
    @ApiModelProperty(value = "退款成功时间")
    private Date successRefundTime;
    @ApiModelProperty(value = "退款订单号")
    private String orderNo;
    @ApiModelProperty(value = "退款状态，1申请中，2审核通过,3:审核未通过")
    private Byte returnStatus;
    @ApiModelProperty(value = "买家姓名")
    private String memberName;
    @ApiModelProperty(value = "买家电话号码")
    private String memberPhone;
    @ApiModelProperty(value = "退款金额")
    private Integer refundAmount;
    @ApiModelProperty(value = "退款原因")
    private String reason;
    @ApiModelProperty(value = "服务名称")
    private String productName;
    @ApiModelProperty(value = "服务图片")
    private String productImg;
    @ApiModelProperty(value = "服务价格")
    private Integer productPrice;
    @ApiModelProperty(value = "订单总金额")
    private Integer amountTotal;
    @ApiModelProperty(value = "订单类型(0:到店，1：上门(附带上门费))")
    private Integer orderType;
    @ApiModelProperty(value = "优惠价减免金额")
    private Integer couponReduce;
    @ApiModelProperty(value = "会员卡打折")
    private Integer memberCardReduce;
    @ApiModelProperty(value = "实付金额")
    private Integer actualPay;
    @ApiModelProperty(value = "门店名称")
    private String storeName;
    @ApiModelProperty(value = "老板姓名")
    private String storeBossName;
    @ApiModelProperty(value = "老板手机")
    private String storeBossPhone;
    @ApiModelProperty(value = "门店地址")
    private String storeAddress;
    @ApiModelProperty(value = "服务美容师姓名")
    private String serverBeauticianName;
    @ApiModelProperty(value = "协商记录")
    private List<OrderRefundsConsultRecord> list;

}
