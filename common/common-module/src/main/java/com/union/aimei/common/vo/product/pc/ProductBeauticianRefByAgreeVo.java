package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 项目-美容师-关联（同意）
 *
 * @author liurenkai
 * @time 2018/3/20 17:37
 */
@Data
@EqualsAndHashCode
@ApiModel("项目-美容师-关联（同意）")
public class ProductBeauticianRefByAgreeVo implements Serializable {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("同意状态，0-待处理，1-已同意，2-已拒绝")
    private Integer agreeStatus;

    @ApiModelProperty("同意原因")
    private String agreeReason;

    @ApiModelProperty("与店铺合照")
    private String groupPhoto;

}
