package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 产品管理查询条件
 *
 * @author liurenkai
 * @time 2018/4/3 15:20
 */
@Data
@EqualsAndHashCode
@ApiModel("产品管理查询条件")
public class PhyByManageVo implements Serializable {

    @ApiModelProperty("产品名称")
    private String physicalName;

    @ApiModelProperty("产品编码")
    private String physicalCode;

    @ApiModelProperty("分类ID")
    private Integer categoryId;

    @ApiModelProperty("分类代码")
    private String categoryCode;

}
