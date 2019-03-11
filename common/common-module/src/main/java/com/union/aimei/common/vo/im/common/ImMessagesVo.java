package com.union.aimei.common.vo.im.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * IM消息
 *
 * @author liurenkai
 * @time 2018/1/8 20:30
 */
@Data
@EqualsAndHashCode
@ApiModel("IM消息vo")
public class ImMessagesVo implements Serializable {

    @ApiModelProperty(value = "发送人集合")
    private List<String> fromList;

    @ApiModelProperty("接收人集合")
    private List<String> toList;

}
