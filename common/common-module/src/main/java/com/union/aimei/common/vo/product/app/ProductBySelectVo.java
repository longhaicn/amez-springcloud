package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 精选商品条件
 *
 * @author liurenkai
 * @time 2018/4/27 15:59
 */
@Data
@EqualsAndHashCode
@ApiModel("精选商品条件")
public class ProductBySelectVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

}
