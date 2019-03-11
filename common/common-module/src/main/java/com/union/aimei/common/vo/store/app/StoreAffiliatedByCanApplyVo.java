package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 分页查询可挂靠申请的门店条件
 *
 * @author liurenkai
 * @time 2018/5/25 10:07
 */
@Data
@EqualsAndHashCode
@ApiModel("分页查询可挂靠申请的门店条件")
public class StoreAffiliatedByCanApplyVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("输入条件")
    private String inputCond;

}
