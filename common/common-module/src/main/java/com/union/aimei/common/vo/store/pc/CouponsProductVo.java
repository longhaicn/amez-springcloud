package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 优惠券-服务关联vo
 *
 * @author caizhaoming
 * @time 2018/5/20 17:59
 */
@Data
@EqualsAndHashCode
@ApiModel("优惠券-服务关联vo")
public class CouponsProductVo implements Serializable {

    @ApiModelProperty("商品id")
    private Integer productId ;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Integer isEnabled;

}
