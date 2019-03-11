package com.union.aimei.common.vo.order;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author GaoWei
 * @describe 订单发送APP消息VO
 * @time 2018/3/19,17:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSendAppVo {

    /**
     * 发送主题类型
     */
    public static class SendType{

        /**
         * 用户
         */
        public static final int CUSTOMER=1;
        /**
         * 美容师
         */
        public static final int BEAUTICIAN=2;
        /**
         * 店长
         */
        public static final int STORE_SELLER=3;

    }

    @ApiModelProperty(value = "订单ID")
    private Integer orderId;
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "服务开始时间")
    private Date serverStartTime;
    @ApiModelProperty(value = "店长手机号码")
    private String storeSellerPhone;
    @ApiModelProperty(value = "店长会员ID")
    private Integer storeSellerMemberId;
    @ApiModelProperty(value = "美容师ID")
    private Integer beauticianId;
    @ApiModelProperty(value = "美容师会员ID")
    private Integer beauticianMemberId;
    @ApiModelProperty(value = "美容师手机号码")
    private String beauticianPhone;
    @ApiModelProperty(value = "会员ID")
    private Integer memberId;
    @ApiModelProperty(value = "会员姓名")
    private String memberName;
    @ApiModelProperty(value = "会员手机号码")
    private String memberPhone;
    @ApiModelProperty(value = "上面服务顾客手机号码")
    private String customerPhone;
    @ApiModelProperty(value = "上门顾客姓名")
    private String customerName;
    @ApiModelProperty(value = "服务所需时长")
    private Integer serverNeedTime;
    @ApiModelProperty(value = "服务图片")
    private String productImg;
    @ApiModelProperty(value = "服务名称")
    private String productName;
    @ApiModelProperty(value = "产品ID")
    private Integer productId;
    @ApiModelProperty(value = "订单类型(0到店，1上门)")
    private Integer productType;
}
