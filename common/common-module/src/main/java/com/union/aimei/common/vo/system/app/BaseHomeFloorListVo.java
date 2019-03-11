package com.union.aimei.common.vo.system.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 楼层列表数据vo
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "楼层列表数据vo")
public class BaseHomeFloorListVo implements Serializable {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("楼层id")
    private Integer floorId;

    @ApiModelProperty("项目id")
    private Integer productId;

    @ApiModelProperty("项目类型 0-平台 1-门店资源")
    private Byte productType;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("项目名称")
    private String productName;

    @ApiModelProperty("项目分类")
    private String productClass;

    @ApiModelProperty("销售价")
    private Integer salePrice;

    @ApiModelProperty("原价")
    private Integer originalPrice;

    @ApiModelProperty("项目封面图")
    private String coverImg;

    @ApiModelProperty("支持到店标记，1-是，0-否")
    private Boolean isSupportStore;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Boolean isSupportHome;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("商品id集合")
    private List<Integer> productIdList;

    private static final long serialVersionUID = 1L;
}