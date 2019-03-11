package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品-分类-关联
 *
 * @author liurenkai
 * @time 2018/4/11 14:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "商品-分类-关联")
public class ProductCategoryRef implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("分类I")
    private Integer categoryId;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}