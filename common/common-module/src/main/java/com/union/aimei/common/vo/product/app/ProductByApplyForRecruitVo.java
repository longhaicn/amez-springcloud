package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 申请招募详情条件
 *
 * @author liurenkai
 * @time 2018/5/17 21:22
 */
@Data
@EqualsAndHashCode
@ApiModel("申请招募详情条件")
public class ProductByApplyForRecruitVo implements Serializable {

    @ApiModelProperty("项目-门店-关联ID")
    private Integer productStoreRefId;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

}
