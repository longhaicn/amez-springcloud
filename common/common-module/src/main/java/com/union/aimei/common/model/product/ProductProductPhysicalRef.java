package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目-产品-关联
 *
 * @author liurenkai
 * @time 2018/4/11 14:41
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "项目-产品-关联")
public class ProductProductPhysicalRef implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("产品ID")
    private Integer productPhysicalId;

    @ApiModelProperty("产品名称")
    private String physicalName;

    @ApiModelProperty("产品数量")
    private Integer physicalNumber;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}