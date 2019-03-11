package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 美容师服务范围
 *
 * @author liurenkai
 * @time 2018/5/19 10:25
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "美容师服务范围")
public class BeauticianServiceScope implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("范围名称")
    private String scopeName;

    @ApiModelProperty("省名称")
    private String provinceName;

    @ApiModelProperty("市名称")
    private String cityName;

    @ApiModelProperty("县名称")
    private String areaName;

    @ApiModelProperty("省ID")
    private Integer provinceId;

    @ApiModelProperty("市ID")
    private Integer cityId;

    @ApiModelProperty("县ID")
    private Integer areaId;

    @ApiModelProperty("经度，长度10位，小数点后7位")
    private BigDecimal longitude;

    @ApiModelProperty("纬度，长度10位，小数点后7位")
    private BigDecimal latitude;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("半径")
    private Integer radius;

    @ApiModelProperty("是否选择，1-是，0-否")
    private Boolean isSelect;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}