package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 门店资质审核条件
 *
 * @author liurenkai
 * @time 2018/6/6 11:30
 */
@Data
@EqualsAndHashCode
@ApiModel("门店资质审核条件")
public class StoreByQualificationAuditVo implements Serializable {

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("资质状态，true-审核通过，false-审核不通过")
    private Boolean qualificationStatus;

    @ApiModelProperty("资质原因")
    private String qualificationReason;

}
