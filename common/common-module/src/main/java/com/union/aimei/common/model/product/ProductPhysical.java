package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品
 *
 * @author liurenkai
 * @time 2018/3/2 15:13
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "产品")
public class ProductPhysical implements Serializable {

    /**
     * 邮费类型，1-买家承担，2-卖家包邮
     */
    public interface PostageType {
        int BUYER = 1;
        int SELLER = 2;
    }

    @ApiModelProperty("产品ID")
    private Integer id;

    @ApiModelProperty("产品名称")
    private String physicalName;

    @ApiModelProperty("产品编码")
    private String physicalCode;

    @ApiModelProperty("封面图")
    private String coverImg;

    @ApiModelProperty("产品图")
    private String physicalImg;

    @ApiModelProperty("销售价")
    private Integer salePrice;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("库存总数")
    private Integer inventoryTotal;

    @ApiModelProperty("库存可消耗数")
    private Integer inventoryConsumable;

    @ApiModelProperty("库存订单预约数")
    private Integer inventoryOrderReservation;

    @ApiModelProperty("库存预警数")
    private Integer inventoryWarning;

    @ApiModelProperty("库存预警开关，1-开，0-关")
    private Boolean inventoryWarningSwitch;

    @ApiModelProperty("发货地ID")
    private Integer deliveryPlaceId;

    @ApiModelProperty("发货地")
    private String deliveryPlace;

    @ApiModelProperty("产品详情")
    private String physicalDetail;

    @ApiModelProperty("销量")
    private Integer saleVolume;

    @ApiModelProperty("邮费类型，1-买家承担，2-卖家包邮")
    private Integer postageType;

    @ApiModelProperty("运费模板ID")
    private Integer templateId;

    @ApiModelProperty("重量/KG")
    private BigDecimal weight;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}