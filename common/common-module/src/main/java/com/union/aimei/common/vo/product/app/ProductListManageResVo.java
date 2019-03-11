package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 项目管理列表结果
 *
 * @author liurenkai
 * @time 2018/6/22 16:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("项目管理列表结果")
public class ProductListManageResVo extends ProductListDisplayResVo {

    @ApiModelProperty("上架状态，0-下架，1-上架")
    private Integer saleStatus;

    @ApiModelProperty("审核状态，0-待审核，1-已审核，2-不通过")
    private Integer auditStatus;

    @ApiModelProperty("审核原因")
    private String auditReason;

}
