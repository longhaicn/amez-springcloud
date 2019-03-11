package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实物订单产品信息VO
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "实物订单产品信息VO")
public class OrderGoodsInfoVo {

    @ApiModelProperty("实物产品ID")
    private Integer productPhysicalId;

    @ApiModelProperty("数量")
    private Integer nums;
}
