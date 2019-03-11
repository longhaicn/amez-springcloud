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
@ApiModel(value="常见问题分类")
public class BaseQuestionType implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("分类名称")
    private String typeName;

    @ApiModelProperty("权重值")
    private Integer weightValue;

    @ApiModelProperty("客户端类型 1-用户,2-邦女郎,3-门店")
    private Byte clientType;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}