package com.union.aimei.common.vo.im.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 环信返回值对象
 *
 * @author liurenkai
 * @time 2017/11/30 11:36
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "环信返回值对象")
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "访问方式")
    private String action;
    @ApiModelProperty(value = "应用")
    private String application;
    @ApiModelProperty(value = "参数")
    private Object params;
    @ApiModelProperty(value = "路径")
    private String path;
    @ApiModelProperty(value = "地址")
    private String uri;
    @ApiModelProperty(value = "实体")
    private Object entities;
    @ApiModelProperty(value = "数据")
    private Object data;
    @ApiModelProperty(value = "时间")
    private String timestamp;
    @ApiModelProperty(value = "耗时")
    private Integer duration;
    @ApiModelProperty(value = "组织")
    private String organization;
    @ApiModelProperty(value = "应用名称")
    private String applicationName;
    @ApiModelProperty(value = "如果DB中的数量大于limit,返回JSON 会携带一个字段‘cursor’,往下取数据的时候带着，就可以获取到下一页的值")
    private String cursor;
    @ApiModelProperty(value = "总数")
    private String count;

}
