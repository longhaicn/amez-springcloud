package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author GaoWei
 * @describe 审核订单退款VO
 * @time 2018/3/9,20:54
*/
@Data
@EqualsAndHashCode
@ApiModel(value = "审核订单退款VO")
public class AuditRefundVo {

    @ApiModelProperty(value = "是否同意(0:同意，1：拒绝)")
    private boolean isAgree;
    @ApiModelProperty(value = "员工美容师ID")
    private Integer beauticianId;
    @ApiModelProperty(value = "店长的美容师ID")
    private Integer storeOwnerBeauticianId;
    @ApiModelProperty(value = "订单ID")
    private Integer orderId;
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "拒绝原因")
    private String refuseReason;
    @ApiModelProperty(value = "拒绝凭证")
    private String refuseVoucher;


}
