package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺销量
 *
 * @author liurenkai
 * @time 2018/3/8 17:35
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺销量")
public class StoreByStoreSalesVo implements Serializable {

    @ApiModelProperty("店铺ID")
    private Integer id;

    @ApiModelProperty("店铺销量")
    private Integer storeSales;

}
