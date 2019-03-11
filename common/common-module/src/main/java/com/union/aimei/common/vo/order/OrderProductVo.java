package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author GaoWei
 * @describe
 * @time 2018/1/30,19:19
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "订单商品VO'")
public class OrderProductVo {

    @ApiModelProperty(value = "商品ID")
    private Integer productId;
    @ApiModelProperty("商品名称")
    private String serverName;
    @ApiModelProperty("产品图片")
    private String productImg;
    @ApiModelProperty("商品单价或加钱购金额")
    private Integer productPrice;
    @ApiModelProperty("单个商品数量")
    private Integer nums;
}
