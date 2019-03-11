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
@ApiModel(value = "角色表")
public class BaseRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer roleId;
    private String roleName;
    @ApiModelProperty("角色优先级")
    private Integer roleLevel;
    @ApiModelProperty("备注")
    private String roleCode;
    @ApiModelProperty("角色的创建者Id")
    private Integer createUserid;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}