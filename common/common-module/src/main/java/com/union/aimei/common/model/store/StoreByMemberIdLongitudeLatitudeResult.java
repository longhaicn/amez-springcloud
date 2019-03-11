package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author caizhaoming
 * @date 2018/4/19  16:14
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "收藏店铺的返回实体类")
public class StoreByMemberIdLongitudeLatitudeResult implements Serializable {

    @ApiModelProperty("店铺id")
    private Integer memberId;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    @ApiModelProperty(value = "店铺横幅")
    private String storeBanner;

    @ApiModelProperty(value = "店铺名称")
    private String storeName;

    @ApiModelProperty(value = "特色项目")
    private String specialProject;

     @ApiModelProperty(value = "距离，单位为 米")
    private String distance;

    @ApiModelProperty(value = "店铺标签 十年老店，五年老店")
    private String storeLabel;




}
