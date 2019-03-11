package com.union.aimei.common.vo.umeng;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author houji
 * @date 2018/3/17  16:10
 */
@Data
@EqualsAndHashCode
@ApiModel(value="推送消息类型表Vo")
public class UmengPushCategory implements Serializable {

    @ApiModelProperty("用户设备的token")
    private String deviceToken;

    @ApiModelProperty("用户消息的类型集合(service,project,system)")
    private List<String> list;

    @ApiModelProperty("消息已读未读状态 0--未读 1--已经读取")
    private String status;

    @ApiModelProperty("是否需要主体 0--不需要 1--需要,默认0")
    private Integer needDetail;

    @ApiModelProperty("会员的id")
    private Integer memberId;

}
