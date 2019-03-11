package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据门店ID分页查询挂靠申请列表条件
 *
 * @author liurenkai
 * @time 2018/5/22 11:06
 */
@Data
@EqualsAndHashCode
@ApiModel("根据门店ID分页查询挂靠申请列表条件")
public class AffiliatedListApplyByStoreIdVo implements Serializable {

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("挂靠类型，1-申请，2-解除")
    private Integer affiliatedType;

}
