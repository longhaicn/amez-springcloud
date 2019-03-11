package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺图片
 *
 * @author liurenkai
 * @time 2018/4/11 14:26
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺图片表")
public class StoreBanner implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    private String bannerName;
    @ApiModelProperty("图片url地址")
    private String url;

    @ApiModelProperty("链接")
    private String link;

    @ApiModelProperty("应用场景ID")
    private String sceneCode;

    @ApiModelProperty("是否有效 0无效 1有效")
    private Boolean status;

    @ApiModelProperty("创建时间")
    private Date createTime;
}