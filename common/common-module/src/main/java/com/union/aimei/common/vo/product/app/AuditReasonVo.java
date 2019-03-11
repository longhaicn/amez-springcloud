package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 审核原因条件
 *
 * @author liurenkai
 * @time 2018/6/2 11:02
 */
@Data
@EqualsAndHashCode
@ApiModel("审核原因条件")
public class AuditReasonVo implements Serializable {

    @ApiModelProperty("审核原因")
    private String auditReason;

}