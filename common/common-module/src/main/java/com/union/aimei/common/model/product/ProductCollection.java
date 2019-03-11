package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目收藏
 *
 * @author liurenkai
 * @time 2018/1/26 11:05
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "项目收藏")
public class ProductCollection implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("是否收藏，1-是，0-否")
    private Boolean isCollection;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}