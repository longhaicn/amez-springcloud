package com.union.aimei.common.vo.im.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 文本消息内容
 *
 * @author liurenkai
 * @time 2017/11/30 16:54
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "文本消息内容")
public class MsgContentTxt implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "消息类型")
    private String type = "txt";
    @ApiModelProperty(value = "消息内容")
    private String msg;
}
