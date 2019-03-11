package com.union.aimei.common.model.learn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "文章")
public class Article implements Serializable {
    @ApiModelProperty("主键自增")
    private Integer id;

    @ApiModelProperty("0--邦女郎 1--门店，默认0")
    private Byte articleType;

    @ApiModelProperty("文章标题")
    private String mtitle;

    @ApiModelProperty("副标题")
    private String subHeading;

    @ApiModelProperty("小图标")
    private String icon;

    @ApiModelProperty("文章图片")
    private String mainImg;

    @ApiModelProperty("文章标签")
    private String articleTag;

    @ApiModelProperty("0--不置顶 1--首页置顶，默认0")
    private Byte topStatus;

    @ApiModelProperty("置顶权重值(值越大，列表排序越靠前)")
    private Integer weightTop;

    @ApiModelProperty("发布状态 0--未发布 1--发布  2--下线")
    private Integer releaseStatus;

    @ApiModelProperty("文章详情")
    private String articleDetail;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("发布时间")
    private Date releaseTime;

    @ApiModelProperty("文章主图片")
    private String mainImgURL;

    @ApiModelProperty("文章主图片")
    private List imgURLList;


    private static final long serialVersionUID = 1L;
}