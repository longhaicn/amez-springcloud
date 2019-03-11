package com.union.aimei.common.model.financial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value="佣金设置")
public class CommissionSetting implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("名称")
    private String commissionName;

    @ApiModelProperty("佣金比例编码")
    private String commissionCode;

    @ApiModelProperty("类型")
    private Byte commissionType;

    @ApiModelProperty("费率")
    private Integer commissionRate;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}