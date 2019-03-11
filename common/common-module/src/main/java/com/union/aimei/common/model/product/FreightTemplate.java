package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 运费模板
 *
 * @author liurenkai
 * @time 2018/3/12 18:07
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "运费模板")
public class FreightTemplate implements Serializable {

    /**
     * 计价方式，1-按件数，2-按重量
     */
    public interface PricingMethod {
        int NUMBER = 1;
        int WEIGHT = 2;
    }

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("模板代码")
    private String templateCode;

    @ApiModelProperty("模板名称")
    private String templateName;

    @ApiModelProperty("运送方式，1-快递")
    private Integer transportMethod;

    @ApiModelProperty("计价方式，1-按件数，2-按重量")
    private Integer pricingMethod;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}