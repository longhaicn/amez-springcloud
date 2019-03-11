package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据商品ID查询项目-产品-关联
 *
 * @author liurenkai
 * @time 2018/3/7 16:23
 */
@Data
@EqualsAndHashCode
@ApiModel("根据商品ID查询项目-产品-关联")
public class ProductProductPhysicalRefByProductIdReturnVo implements Serializable {

    @ApiModelProperty("产品ID")
    private Integer productPhysicalId;

    @ApiModelProperty("产品名称")
    private String physicalName;

    @ApiModelProperty("产品编码")
    private String physicalCode;

    @ApiModelProperty("封面图")
    private String coverImg;

    @ApiModelProperty("销售价")
    private Integer salePrice;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("产品数量")
    private Integer physicalNumber;

}
