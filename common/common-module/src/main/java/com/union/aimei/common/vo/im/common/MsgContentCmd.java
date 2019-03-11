package com.union.aimei.common.vo.im.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 透传消息内容
 *
 * @author liurenkai
 * @time 2017/11/30 11:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "透传消息内容")
public class MsgContentCmd implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("消息类型")
    private String type = "cmd";
    @ApiModelProperty("功能")
    private String action;
}