package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师（审核）
 *
 * @author liurenkai
 * @time 2018/3/26 17:30
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师（审核）")
public class StoreBeauticianByAuditVo implements Serializable {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("审核状态，0-待审核，1-已审核，2-不通过")
    private Integer auditStatus;

    @ApiModelProperty("审核原因")
    private String auditReason;

}
