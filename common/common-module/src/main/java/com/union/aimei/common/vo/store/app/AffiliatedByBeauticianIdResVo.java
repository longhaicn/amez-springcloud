package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据美容师ID查询挂靠结果
 *
 * @author liurenkai
 * @time 2018/5/24 4:41
 */
@Data
@EqualsAndHashCode
@ApiModel("根据美容师ID查询挂靠结果")
public class AffiliatedByBeauticianIdResVo implements Serializable {

    @ApiModelProperty("挂靠状态，0-未入驻挂靠，1-已入驻，2-已挂靠，3-申请挂靠，4-申请解除，5-待平台审核")
    private Integer affiliatedStatus;

    @ApiModelProperty("挂靠ID")
    private Integer affiliatedId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("门店地址")
    private String storeAddress;

}