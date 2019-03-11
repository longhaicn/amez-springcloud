package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据美容师ID查询门店-美容师-挂靠邀请结果
 *
 * @author liurenkai
 * @time 2018/5/21 15:02
 */
@Data
@EqualsAndHashCode
@ApiModel("根据美容师ID查询门店-美容师-挂靠邀请结果")
public class AffiliatedByBeauticianIdForInvitationResVo implements Serializable {

    @ApiModelProperty("门店-美容师-挂靠ID")
    private Integer affiliatedId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("详细地区")
    private String storeAddress;

}
