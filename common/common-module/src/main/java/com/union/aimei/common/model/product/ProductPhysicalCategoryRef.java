package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品-分类-关联
 *
 * @author liurenkai
 * @time 2018/3/14 19:37
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "产品-分类-关联")
public class ProductPhysicalCategoryRef implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("产品ID")
    private Integer productPhysicalId;

    @ApiModelProperty("分类ID")
    private Integer categoryId;

    @ApiModelProperty("分类代码")
    private String categoryCode;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}