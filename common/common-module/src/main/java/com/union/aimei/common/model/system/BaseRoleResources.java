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
@ApiModel(value = "角色权限表")
public class BaseRoleResources implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @ApiModelProperty("角色Id")
    private Integer roleId;
    @ApiModelProperty("菜单Id")
    private Integer menuId;
    @ApiModelProperty("操作Id")
    private Integer operId;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}