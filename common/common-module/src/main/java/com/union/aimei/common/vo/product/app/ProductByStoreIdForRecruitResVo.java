package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据门店ID查询招募项目结果
 *
 * @author liurenkai
 * @time 2018/5/22 11:50
 */
@Data
@EqualsAndHashCode
@ApiModel("根据门店ID查询招募项目结果")
public class ProductByStoreIdForRecruitResVo implements Serializable {

    @ApiModelProperty("项目-门店-关联ID")
    private Integer productStoreRefId;

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("项目名称")
    private String serverName;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("支持到店标记，1-是，0-否")
    private Boolean isSupportStore;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Boolean isSupportHome;

    @ApiModelProperty("销售价")
    private Integer salePrice;

    @ApiModelProperty("兼职美容师佣金")
    private Integer parttimeCommission;

    @ApiModelProperty("待处理申请")
    private Integer pendingApplyCount;

    @ApiModelProperty("门店名称")
    private String storeName;

}
