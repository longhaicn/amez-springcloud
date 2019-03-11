package com.union.aimei.common.model.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "会员级别")
public class MemberLevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("会员ID")
    private Integer memberId;
    @ApiModelProperty("会员级别")
    private Byte grade;
    @ApiModelProperty("会员级别名称")
    private String gradeName;
    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}