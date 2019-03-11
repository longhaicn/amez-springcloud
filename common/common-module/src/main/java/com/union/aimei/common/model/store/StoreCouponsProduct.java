package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2017/12/22 16:17
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "优惠券-服务-关联")
public class StoreCouponsProduct implements Serializable {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("店铺优惠券ID")
    private Integer storeCouponsId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("服务ID")
    private Integer productId;

    @ApiModelProperty("服务名称")
    private String productName;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}