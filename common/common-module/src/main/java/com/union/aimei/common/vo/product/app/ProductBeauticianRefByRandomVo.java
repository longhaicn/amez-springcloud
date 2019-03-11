package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 随机查询项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/3/7 20:07
 */
@Data
@EqualsAndHashCode
@ApiModel("随机查询项目-美容师-关联")
public class ProductBeauticianRefByRandomVo implements Serializable {

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("服务类型")
    private Integer serverType;

}
