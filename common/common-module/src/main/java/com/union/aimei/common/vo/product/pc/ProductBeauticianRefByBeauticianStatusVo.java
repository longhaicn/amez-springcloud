package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 项目-美容师-关联（美容师状态）
 *
 * @author liurenkai
 * @time 2018/4/16 23:40
 */
@Data
@EqualsAndHashCode
@ApiModel("项目-美容师-关联（美容师状态）")
public class ProductBeauticianRefByBeauticianStatusVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("美容师状态，0-离职，1-在职，2-休息")
    private Integer beauticianStatus;

}
