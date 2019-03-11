package com.union.aimei.common.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目-分类-关联数据vo
 *
 * @author caizhaoming
 * @create 2018-05-24 14:13
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "项目-分类-关联数据vo")
public class ProductByCategoryRefVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("项目ID")
    private Integer id;

    @ApiModelProperty("项目名称")
    private String serverName;

    @ApiModelProperty("项目类型，1-门店自营，2-品牌，3-平台自营")
    private Integer productType;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("品牌ID")
    private Integer brandId;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("是否品牌标记，1-品牌，0-自营")
    private Boolean isBrand;

    @ApiModelProperty("项目标签，0-默认，1-推荐，2-新品")
    private Integer label;

    @ApiModelProperty("预约人数")
    private Integer appointment;

    @ApiModelProperty("销量")
    private Integer saleVolume;

    @ApiModelProperty("原价")
    private Integer originalPrice;

    @ApiModelProperty("上门费")
    private Integer homeFee;

    @ApiModelProperty("批发价")
    private Integer wholesalePrice;

    @ApiModelProperty("零售价")
    private Integer retailPrice;

    @ApiModelProperty("销售价")
    private Integer salePrice;

    @ApiModelProperty("正式美容师佣金")
    private Integer formalBeauticianCommission;

    @ApiModelProperty("兼职美容师佣金")
    private Integer parttimeBeauticianCommission;

    @ApiModelProperty("服务介绍")
    private String serverIntroduce;

    @ApiModelProperty("服务所需耗时，分钟为单位")
    private Integer serverNeedTime;

    @ApiModelProperty("服务说明")
    private String serverContent;

    @ApiModelProperty("适用人群")
    private String serverFitPeople;

    @ApiModelProperty("适用部位")
    private String serverFitPart;

    @ApiModelProperty("功效")
    private String serverEffect;

    @ApiModelProperty("注意事项")
    private String serverAttention;

    @ApiModelProperty("项目封面图")
    private String coverImg;

    @ApiModelProperty("项目排序")
    private Integer sequence;

    @ApiModelProperty("上架状态，0-下架，1-上架")
    private Integer saleStatus;

    @ApiModelProperty("审核状态，0-待审核，1-已审核，2-不通过")
    private Integer auditStatus;

    @ApiModelProperty("审核原因")
    private String auditReason;

    @ApiModelProperty("项目是否限购 0.不限购 1限购")
    private Integer limitStatus;

    @ApiModelProperty("项目限购总数量")
    private Integer limitQuota;

    @ApiModelProperty("每人限购件数")
    private Integer limitBuyQuota;

    @ApiModelProperty("收藏总数")
    private Integer collectionTotal;

    @ApiModelProperty("支持到店标记，1-是，0-否")
    private Boolean isSupportStore;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Boolean isSupportHome;

    @ApiModelProperty("支持批发标记，1-是，0-否")
    private Boolean isSupportWholesale;

    @ApiModelProperty("支持零售标记，1-是，0-否")
    private Boolean isSupportRetail;

    @ApiModelProperty("平台标记，1-是，0-否")
    private Boolean isPlatform;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("是否允许招募，1-允许，0-不允许")
    private Boolean isAllowRecruit;

    @ApiModelProperty("申请招募总数")
    private Integer applyRecruitTotal;

    @ApiModelProperty("招募总数")
    private Integer recruitTotal;

    @ApiModelProperty("是否包含课程，1-是，0-否")
    private Boolean isCourse;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("分类id")
    private Integer categoryId;


}
