package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 分页查询招募项目可邀请的美容师条件
 *
 * @author liurenkai
 * @time 2018/5/22 14:43
 */
@Data
@EqualsAndHashCode
@ApiModel("分页查询招募项目可邀请的美容师条件")
public class BeauticianByCanInvitationForRecruitVo implements Serializable {

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("输入条件，美容师昵称/手机号")
    private String inputCond;

    @ApiModelProperty("服务类型")
    private String label;

    @ApiModelProperty("美容师星级")
    private Integer beauticianStar;

    @ApiModelProperty("位置区域")
    private Integer areaId;

}
