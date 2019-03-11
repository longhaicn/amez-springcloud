package com.union.aimei.common.model.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ApiModel(value = "退换货的申请明细")
/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,10:46
 */
public class OrderReturnProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("店铺id")
    private Integer storeId;
    @ApiModelProperty("退换货单id")
    private Integer orderReturnId;
    @ApiModelProperty("产品id")
    private Integer productId;
    @ApiModelProperty("产品名称")
    private String productName;
    @ApiModelProperty("产品封面")
    private String productImg;
    @ApiModelProperty("产品退货数量")
    private Integer nums;
    @ApiModelProperty("产品退款金额")
    private String returnFee;
    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;
}