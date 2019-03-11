package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 根据优惠券id获取的服务
 *
 * @author caizhaoming
 * @time 2018/04/18 16:41
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "根据优惠券id获取的服务")
public class ProductByCouponsIdVo implements Serializable {


    @ApiModelProperty(value = "服务id列表")
    private List<StoreCouponsProductDetailResultVo> couponsIdDetailVoList ;


}
