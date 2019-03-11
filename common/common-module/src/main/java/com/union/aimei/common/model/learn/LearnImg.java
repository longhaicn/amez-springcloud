package com.union.aimei.common.model.learn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "学习图片")
public class LearnImg implements Serializable {
    @ApiModelProperty("主键自增")
    private Integer id;

    @ApiModelProperty("学习图片的类型 0--活动 1--课程，默认0")
    private Integer sourceType;

    @ApiModelProperty("来源id")
    private Integer sourceId;

    @ApiModelProperty("图片url")
    private String imgUrl;

    @ApiModelProperty("0--正常图片  1--主图片，默认0")
    private Byte mainStatus;

    @ApiModelProperty("0--不是轮播图 1--选为轮播图，默认0")
    private Byte broadcastStatus;

    @ApiModelProperty("轮播图排序")
    private Integer sort;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    /**
     * 主图排序 1-主图排倒序
     */
    public static final Byte MAIN_STATUS_SORT_DESC = 1;

    /**
     * 图片的类型 1-课程
     */
    public static final Integer SOURCE_TYPE_COURSE = 1;
    /**
     * 图片的类型 0-活动
     */
    public static final Integer SOURCE_TYPE_ACTIVITY = 0;

    /**
     * 1-主图
     */
    public static final Byte MAIN_STATUS_MAIN = 1;

    /**
     * 0-子图
     */
    public static final Byte MAIN_STATUS_SLAVE = 0;

    private static final long serialVersionUID = 1L;
}