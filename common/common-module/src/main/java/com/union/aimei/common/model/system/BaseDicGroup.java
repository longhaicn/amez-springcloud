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
@ApiModel(value = "数据字典表")
public class BaseDicGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @ApiModelProperty("字典名")
    private String name;
    @ApiModelProperty("字典代码")
    private String code;
    @ApiModelProperty("字典描述")
    private String description;
    @ApiModelProperty("父级id")
    private Integer parentId;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}