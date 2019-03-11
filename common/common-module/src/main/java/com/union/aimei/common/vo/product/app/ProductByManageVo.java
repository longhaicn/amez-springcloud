package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品条件（管理）
 *
 * @author liurenkai
 * @time 2018/3/30 16:09
 */
@Data
@EqualsAndHashCode
@ApiModel("商品条件（管理）")
public class ProductByManageVo implements Serializable {

    @ApiModelProperty("商品名称")
    private String serverName;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("上架状态，0-下架，1-上架")
    private Integer saleStatus;

    @ApiModelProperty("审核状态，0-待审核，1-已审核，2-不通过")
    private Integer auditStatus;

}
