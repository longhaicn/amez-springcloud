package com.union.aimei.common.model.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ApiModel(value = "订单商品")
/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,10:46
 */
public class OrderProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("订单商品关联ID")
    private Integer id;
    @ApiModelProperty("店铺id")
    private Integer storeId;
    @ApiModelProperty("订单id")
    private Integer orderId;
    @ApiModelProperty("商品id")
    private Integer productId;
    @ApiModelProperty("服务时长(以分为单位)")
    private Integer serverNeedTime;
    @ApiModelProperty("商品名称")
    private String productName;
    @ApiModelProperty("产品图片")
    private String productImg;
    @ApiModelProperty("商品单价或加钱购金额")
    private Integer productPrice;
    @ApiModelProperty("产品兑换积分")
    private Integer productPoint;
    @ApiModelProperty("类型 0 默认，1 全额积分兑换 2 加钱购兑换")
    private Byte type;
    @ApiModelProperty("单个商品数量")
    private Integer nums;
    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;
}