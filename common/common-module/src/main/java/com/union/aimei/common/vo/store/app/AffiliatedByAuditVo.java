package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 审核门店-美容师-挂靠
 *
 * @author liurenkai
 * @time 2018/5/21 17:32
 */
@Data
@EqualsAndHashCode
@ApiModel("审核门店-美容师-挂靠")
public class AffiliatedByAuditVo implements Serializable {

    @ApiModelProperty("门店-美容师-挂靠ID")
    private Integer affiliatedId;

    @ApiModelProperty("审核状态，0-待审核，1-当前门店同意，2-挂靠门店同意，3-平台同意")
    private Integer auditStatus;

    @ApiModelProperty("审核原因")
    private String auditReason;

}