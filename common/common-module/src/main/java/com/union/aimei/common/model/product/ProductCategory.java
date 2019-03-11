package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品分类
 *
 * @author liurenkai
 * @time 2018/4/11 14:23
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "商品分类")
public class ProductCategory implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("分类代码，一级-CODE_XX，二级-CODE_XX_XX")
    private String categoryCode;

    @ApiModelProperty("分类logo")
    private String categoryLogo;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("父类ID，0-顶级分类")
    private Integer pid;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}