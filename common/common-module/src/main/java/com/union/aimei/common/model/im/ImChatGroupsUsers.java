package com.union.aimei.common.model.im;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * IM群组用户
 *
 * @author liurenkai
 * @time 2017/11/30 11:02
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "IM群组用户")
public class ImChatGroupsUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("群组ID")
    private Integer groupId;
    @ApiModelProperty("用户名")
    private String userName;
}