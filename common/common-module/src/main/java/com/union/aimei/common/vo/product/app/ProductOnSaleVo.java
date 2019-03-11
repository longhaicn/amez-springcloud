package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 项目上架条件
 *
 * @author liurenkai
 * @time 2018/3/6 17:28
 */
@Data
@EqualsAndHashCode
@ApiModel("项目上架条件")
public class ProductOnSaleVo implements Serializable {

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("上门费")
    private Integer homeFee;

    @ApiModelProperty(value = "到店美容师集合")
    private List<Integer> storeBeauticianIdList;

    @ApiModelProperty(value = "上门美容师集合")
    private List<Integer> homeBeauticianIdList;

}