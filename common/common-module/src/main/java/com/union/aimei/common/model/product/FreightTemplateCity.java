package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 运费模板城市
 *
 * @author liurenkai
 * @time 2018/3/12 18:07
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "运费模板城市")
public class FreightTemplateCity implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("运费模板ID")
    private Integer templateId;

    @ApiModelProperty("城市ID，以“,”分隔")
    private String cityId;

    @ApiModelProperty("城市名称，以“,”分隔")
    private String cityName;

    @ApiModelProperty("首件数/首重数")
    private Integer firstNumber;

    @ApiModelProperty("首件价格/首重价格")
    private Integer firstPrice;

    @ApiModelProperty("续件数/续重数")
    private Integer continuedNumber;

    @ApiModelProperty("续件价格/续重价格")
    private Integer continuedPrice;

    @ApiModelProperty("默认标记，1-默认，0-非默认")
    private Boolean isDefault;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}