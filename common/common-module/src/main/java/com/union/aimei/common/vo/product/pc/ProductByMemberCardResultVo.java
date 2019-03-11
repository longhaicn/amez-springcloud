package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品结果（会员卡）
 *
 * @author liurenkai
 * @time 2018/2/2 15:42
 */
@Data
@EqualsAndHashCode
@ApiModel("商品结果（会员卡）")
public class ProductByMemberCardResultVo implements Serializable {

    @ApiModelProperty("商品ID")
    private Integer id;

    @ApiModelProperty("商品名称")
    private String serverName;

    @ApiModelProperty("销售价")
    private Integer salePrice;
}
