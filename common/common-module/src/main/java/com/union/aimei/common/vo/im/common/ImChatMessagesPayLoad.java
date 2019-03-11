package com.union.aimei.common.vo.im.common;


import com.google.gson.JsonElement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * IM聊天记录
 *
 * @author liurenkai
 * @time 2018/1/15 23:46
 */
@Data
@EqualsAndHashCode
@ApiModel("IM聊天记录有效有效载荷")
public class ImChatMessagesPayLoad implements Serializable {

    @ApiModelProperty("扩展消息")
    private JsonElement ext;

    @ApiModelProperty("消息主体")
    private JsonElement bodies;

    @ApiModelProperty("发送人")
    private String from;

    @ApiModelProperty("接收人")
    private String to;

}
