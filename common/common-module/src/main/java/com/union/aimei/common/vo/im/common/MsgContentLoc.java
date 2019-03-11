package com.union.aimei.common.vo.im.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 地理位置消息内容
 *
 * @author liurenkai
 * @time 2017/11/30 11:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "地理位置消息内容")
public class MsgContentLoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键ID")
    private String type = "loc";
    @ApiModelProperty("地址")
    private String addr;
    @ApiModelProperty("纬度")
    private Double lat;
    @ApiModelProperty("经度")
    private Double lng;
}