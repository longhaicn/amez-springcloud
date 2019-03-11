package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * 退款详情VO
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "退款详情VO")
public class RefundDetailsVo {

    @ApiModelProperty(value = "退款状态1：申请中，2：审核通过，3：拒绝退款")
    private Integer returnStatus;
    @ApiModelProperty(value = "操作时间")
    private String operationTime;
    @ApiModelProperty(value = "退款编号")
    private String returnNo;
    @ApiModelProperty(value = "申请退款时间")
    private Date applyTime;
    @ApiModelProperty(value = "退款金额")
    private Integer returnAmount;
    @ApiModelProperty(value = "申请退款原因")
    private String reason;
    @ApiModelProperty(value = "拒绝退款原因")
    private String refuseReason;
    @ApiModelProperty(value = "申请退款说明")
    private String remark;
    @ApiModelProperty(value = "拒绝凭证")
    private List<String> refuseVoucher;
}
