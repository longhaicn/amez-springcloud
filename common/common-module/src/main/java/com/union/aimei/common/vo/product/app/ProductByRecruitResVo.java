package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 招募项目结果
 *
 * @author liurenkai
 * @time 2018/5/17 16:15
 */
@Data
@EqualsAndHashCode
@ApiModel("招募项目结果")
public class ProductByRecruitResVo implements Serializable {

    @ApiModelProperty("项目-门店-关联ID")
    private Integer productStoreRefId;

    @ApiModelProperty("项目-美容师-关联ID")
    private Integer productBeauticianRefId;

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("项目类型，1-门店自营，2-品牌，3-平台自营")
    private Integer productType;

    @ApiModelProperty("项目名称")
    private String serverName;

    @ApiModelProperty("分类ID")
    private Integer categoryId;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("销售价")
    private Integer salePrice;

    @ApiModelProperty("佣金")
    private Integer commission;

    @ApiModelProperty("支持到店标记，1-是，0-否")
    private Boolean isSupportStore;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Boolean isSupportHome;

    @ApiModelProperty("发起方，1-美容师，2-门店，3-平台")
    private Integer sponsor;

    @ApiModelProperty("审核状态，0-待审核，1-审核通过，2-审核不通过")
    private Integer auditStatus;

    @ApiModelProperty("审核原因")
    private String auditReason;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("上架状态，0-下架，1-上架，2-冻结")
    private Integer saleStatus;

}
