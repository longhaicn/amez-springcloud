package com.union.aimei.common.vo.order;

import com.union.aimei.common.model.order.OrderRefundsConsultRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 修改退款申请VO
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "修改退款申请VO")
public class UpdateRefundApplyVo {

    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "退款原因")
    private String reason;
    @ApiModelProperty(value = "退款说明")
    private String remark;
    @ApiModelProperty(value = "订单退款协商记录")
    OrderRefundsConsultRecord orderRefundsConsultRecord;
}
