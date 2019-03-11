package com.union.aimei.common.vo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 提交服务订单订单VO
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "提交服务订单订单VO")
public class SubmitOrderVo {
    @ApiModelProperty(value = "会员ID", required = true, example = "12")
    private Integer memberId;
    @ApiModelProperty(value = "会员拥有的会员卡Id")
    private Integer memberCardRefId;
    @ApiModelProperty(value = "店铺Id", required = true, example = "3")
    private Integer storeId;
    @ApiModelProperty(value = "挂靠店铺ID")
    private Integer anchoredStoreId;
    @ApiModelProperty(value = "美容师ID", required = true, example = "1")
    private Integer beauticianId;
    @ApiModelProperty(value = "商品ID", required = true, example = "1")
    private Integer productId;
    @ApiModelProperty(value = "商品数量", required = true, example = "1")
    private Integer num;
    @ApiModelProperty(value = "订单类型 0.到店服务订单 1.上门服务订单", required = true, example = "0")
    private Integer type;
    @ApiModelProperty(value = "服务开始时间", required = true, example = "2017-12-22 15:18:55")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date serverStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "服务结束时间", required = true, example = "2017-12-22 17:18:55")
    private Date serverEndTime;
    @ApiModelProperty("服务时长(以分为单位)")
    private Integer serverNeedTime;
    @ApiModelProperty(value = "领取优惠券的ID")
    private Integer receiveCouponId;
    @ApiModelProperty(value = "优惠券ID")
    private Integer couponId;
    @ApiModelProperty(value = "会员卡ID")
    private Integer memberCardId;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "上门服务地址ID")
    private Integer addressId;
    @ApiModelProperty(value = "上门服务地址")
    private String customerAddress;
    @ApiModelProperty("上门服务顾客姓名")
    private String customerName;
    @ApiModelProperty("上门服务顾客电话")
    private String customerPhone;
    @ApiModelProperty("上门服务费")
    private Integer freight;

}
