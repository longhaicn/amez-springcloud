package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 项目-美容师-关联（审核）
 *
 * @author liurenkai
 * @time 2018/3/20 17:37
 */
@Data
@EqualsAndHashCode
@ApiModel("项目-美容师-关联（审核）")
public class ProductBeauticianRefByAuthVo implements Serializable {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("审核状态，0-待审核，1-审核通过，2-不通过")
    private Integer authStatus;

    @ApiModelProperty("审核原因")
    private String authReason;

}
