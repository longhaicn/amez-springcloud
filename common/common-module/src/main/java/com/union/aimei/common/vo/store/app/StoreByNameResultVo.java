package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺（根据名称查询）
 *
 * @author liurenkai
 * @time 2018/1/10 14:14
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺（根据名称查询）")
public class StoreByNameResultVo implements Serializable {

    @ApiModelProperty("店铺索引id")
    private Integer id;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("店铺标签 十年老店，五年老店")
    private String storeLabel;

    @ApiModelProperty("特色项目")
    private String specialProject;

    @ApiModelProperty("详细地区")
    private String storeAddress;

    @ApiModelProperty("店铺横幅")
    private String storeBanner;

    @ApiModelProperty("距离,M/米为单位")
    private Long distance;
}
