package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实物订单查询vo
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@EqualsAndHashCode
@ApiModel
public class OrderGoodsQueryVo {

    @ApiModelProperty(value = "开始下单时间")
    private String startAddTime;
    @ApiModelProperty(value = "结束下单时间")
    private String endAddTime;
    @ApiModelProperty(value = "订单状态")
    private Integer status;
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "收货人姓名")
    private String consigneeName;
    @ApiModelProperty(value = "收货人手机号码")
    private String consigneePhone;
    @ApiModelProperty(value = "美容师ID")
    private String beauticianId;
    @ApiModelProperty(value = "美容师手机号码")
    private String beauticianPhone;
}
