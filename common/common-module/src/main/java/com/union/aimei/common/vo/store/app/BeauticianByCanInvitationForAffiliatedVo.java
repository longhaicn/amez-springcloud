package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 分页查询可挂靠邀请的美容师条件
 *
 * @author liurenkai
 * @time 2018/5/21 20:25
 */
@Data
@EqualsAndHashCode
@ApiModel("分页查询可挂靠邀请的美容师条件")
public class BeauticianByCanInvitationForAffiliatedVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("输入条件")
    private String inputCond;

    @ApiModelProperty("服务类型")
    private String label;

    @ApiModelProperty("星级")
    private Integer beauticianStar;

    @ApiModelProperty("位置区域")
    private Integer areaId;

}
