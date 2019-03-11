package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GaoWei
 * @describe  订单推送APP相关信息
 * @time 2018/3/23,16:47
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class SendToAppVo {

    @ApiModelProperty(value = "订单ID")
    private Integer orderId;
    @ApiModelProperty(value = "会员ID")
    private Integer memberId;
    @ApiModelProperty(value = "服务所需时长")
    private Integer serverNeedTime;
    @ApiModelProperty(value = "商品图片")
    private String productImg;
    @ApiModelProperty(value = "服务名称")
    private String productName;
    @ApiModelProperty(value = "服务ID")
    private Integer productId;
    @ApiModelProperty(value = "订单类型")
    private Integer productType;
}
