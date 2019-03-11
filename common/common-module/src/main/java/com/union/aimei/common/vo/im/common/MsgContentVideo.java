package com.union.aimei.common.vo.im.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 视频消息内容
 *
 * @author liurenkai
 * @time 2017/11/30 11:04
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "视频消息内容")
public class MsgContentVideo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("消息类型")
    private String type = "video";
    @ApiModelProperty("视频文件名称")
    private String fileName;
    @ApiModelProperty("成功上传视频缩略图返回的UUID")
    private String thumb;
    @ApiModelProperty("视频播放长度")
    private Integer length;
    @ApiModelProperty("成功上传视频文件后返回的secret")
    private String secret;
    @ApiModelProperty("视频文件大小")
    private Integer fileLength;
    @ApiModelProperty("成功上传视频缩略图后返回的secret")
    private String thumbSecret;
    @ApiModelProperty("成功上传视频文件返回的UUID")
    private String url;
}