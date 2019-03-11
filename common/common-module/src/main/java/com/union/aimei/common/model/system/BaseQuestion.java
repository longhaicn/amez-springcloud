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
@ApiModel(value="常见问题")
public class BaseQuestion implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("标题名称")
    private String questionTile;

    @ApiModelProperty("项目详情")
    private String questionContent;

    @ApiModelProperty("问题分类")
    private Byte questionTypeId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类名称")
    private String typeName;

    @ApiModelProperty("客户端类型 1-用户,2-邦女郎,3-门店")
    private Byte clientType;

}