package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "数据字典子项表")
public class BaseDicGroupItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @ApiModelProperty("字典id")
    private Integer groupId;
    @ApiModelProperty("字典子项代码")
    private String code;
    @ApiModelProperty("字典子项值")
    private String value;
    @ApiModelProperty("字典子项名称")
    private String name;
    @ApiModelProperty("字典子项描述")
    private String description;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}