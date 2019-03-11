package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liufeihua
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "操作权限表")
public class BaseOperator implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("页面按钮的操作Id")
    private Integer operId;
    @ApiModelProperty("页面按钮的操作名称")
    private String operName;
    @ApiModelProperty("页面按钮的操作码")
    private String operCode;
    @ApiModelProperty("页面按钮的操作地址")
    private String operUrl;
    @ApiModelProperty("角色id")
    private Integer roleId;
    @ApiModelProperty("操作属于哪个菜单页面的Id")
    private Integer menuId;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}