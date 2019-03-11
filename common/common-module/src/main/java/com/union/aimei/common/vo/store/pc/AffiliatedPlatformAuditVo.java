package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 平台审核挂靠条件
 *
 * @author liurenkai
 * @time 2018/6/5 18:06
 */
@Data
@EqualsAndHashCode
@ApiModel("平台审核挂靠条件")
public class AffiliatedPlatformAuditVo implements Serializable {

    @ApiModelProperty("挂靠ID")
    private Integer affiliatedId;

    @ApiModelProperty("审核状态，true-审核通过，false-审核不通过")
    private Boolean auditStatus;

    @ApiModelProperty("审核原因")
    private String auditReason;

}
