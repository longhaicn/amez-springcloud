package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 上架项目选择美容师列表条件
 *
 * @author liurenkai
 * @time 2018/6/22 17:04
 */
@Data
@EqualsAndHashCode
@ApiModel("上架项目选择美容师列表条件")
public class BeauticianListSelectOnSaleProductVo implements Serializable {

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("服务类型，0-到店，1-上门")
    private Integer serverType;

}
