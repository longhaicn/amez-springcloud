package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/3/2 15:28
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "产品-美容师-关联")
public class ProductPhysicalBeauticianRef implements Serializable {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("产品ID")
    private Integer productPhysicalId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("员工类型，0-老板，1-店长，2-正式员工，3-兼职员工")
    private Integer beauticianType;

    @ApiModelProperty("美容师昵称")
    private String beauticianNickName;

    @ApiModelProperty("美容师头像")
    private String beauticianHeadImgUrl;

    @ApiModelProperty("库存总数")
    private Integer inventoryTotal;

    @ApiModelProperty("库存可消耗数")
    private Integer inventoryConsumable;

    @ApiModelProperty("库存订单预约数")
    private Integer inventoryOrderReservation;

    @ApiModelProperty("库存采购预约数")
    private Integer inventoryPurchaseReservation;

    @ApiModelProperty("库存预警数")
    private Integer inventoryWarning;

    @ApiModelProperty("库存预警开关，1-开，0-关")
    private Boolean inventoryWarningSwitch;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}