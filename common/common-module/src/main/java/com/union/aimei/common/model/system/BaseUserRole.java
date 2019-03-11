package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "用户角色关联表")
public class BaseUserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer rightId;
    private Integer userId;
    private Integer roleId;
    private Date createTime;
}