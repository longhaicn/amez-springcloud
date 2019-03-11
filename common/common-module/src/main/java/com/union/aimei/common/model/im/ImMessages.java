package com.union.aimei.common.model.im;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * IM消息
 *
 * @author liurenkai
 * @time 2018/1/9 20:56
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "IM消息")
public class ImMessages implements Serializable {
    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("消息ID")
    private String msgId;

    @ApiModelProperty("消息发送时间")
    private Long sendTime;

    @ApiModelProperty("方向")
    private String direction;

    @ApiModelProperty("发送人")
    private String fromName;

    @ApiModelProperty("接收人")
    private String toName;

    @ApiModelProperty("聊天类型（chat: 单聊；gro.app.at: 群聊）")
    private String chatType;

    @ApiModelProperty("消息类型")
    private String msgType;

    @ApiModelProperty("扩展属性")
    private String ext;

    @ApiModelProperty("消息体")
    private String bodies;

    @ApiModelProperty("获取时间")
    private Long getTime;

    private static final long serialVersionUID = 1L;
}