package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师-项目管理-项目详情结果
 *
 * @author liurenkai
 * @time 2018/6/1 17:56
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师-项目管理-项目详情结果")
public class ProductByDetailByManageForBeauticianResVo implements Serializable {

    @ApiModelProperty("项目-美容师-关联ID")
    private Integer productBeauticianRefId;

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("项目封面图")
    private String coverImg;

    @ApiModelProperty("项目名称")
    private String serverName;

    @ApiModelProperty("销售价")
    private Integer salePrice;

    @ApiModelProperty("佣金")
    private Integer commission;

    @ApiModelProperty("支持到店标记，1-是，0-否")
    private Boolean isSupportStore;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Boolean isSupportHome;

    @ApiModelProperty("项目类型，1-门店自营，2-品牌，3-平台自营")
    private Integer productType;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("门店地址")
    private String storeAddress;

    @ApiModelProperty("服务介绍")
    private String serverIntroduce;

    @ApiModelProperty("发起方，1-美容师，2-门店，3-平台")
    private Integer sponsor;

    @ApiModelProperty("审核状态，0-待审核，1-审核通过，2-审核不通过")
    private Integer auditStatus;

}
