package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 产品查询
 *
 * @author liurenkai
 * @time 2018/3/5 14:16
 */
@Data
@EqualsAndHashCode
@ApiModel("产品查询")
public class ProductPhysicalBeauticianRefByFindVo implements Serializable {

    @ApiModelProperty("产品ID")
    private Integer productPhysicalId;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

}
