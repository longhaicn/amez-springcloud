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
@ApiModel(value = "按钮权限")
public class BaseBtnMenus implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @ApiModelProperty("按钮名字")
    private String btnName;
    @ApiModelProperty("描述")
    private String btnDesc;
    private Integer btnCode;
    private Integer btnIndex;
    private String operCode;
    private Date createTime;
    private Date updateTime;
    private String remarks;
}