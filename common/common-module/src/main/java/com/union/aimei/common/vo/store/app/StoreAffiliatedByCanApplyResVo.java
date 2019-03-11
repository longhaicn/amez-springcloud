package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 分页查询可挂靠申请的门店结果
 *
 * @author liurenkai
 * @time 2018/5/25 10:21
 */
@Data
@EqualsAndHashCode
@ApiModel("分页查询可挂靠申请的门店结果")
public class StoreAffiliatedByCanApplyResVo implements Serializable {

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("门店地址，省名称+市名称+县名称+详细地区+门牌号")
    private String storeAddress;

}
