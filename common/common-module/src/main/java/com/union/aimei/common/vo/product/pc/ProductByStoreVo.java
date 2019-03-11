package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询商品条件（店铺）
 *
 * @author liurenkai
 * @time 2018/4/20 10:50
 */
@Data
@EqualsAndHashCode
@ApiModel("查询商品条件（店铺）")
public class ProductByStoreVo implements Serializable {

    @ApiModelProperty("商品ID")
    private Integer id;

    @ApiModelProperty("商品名称")
    private String serverName;

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

    @ApiModelProperty("商品标签，0-默认，1-推荐，2-新品")
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

    @ApiModelProperty("商品封面图")
    private String coverImg;

    @ApiModelProperty("商品排序")
    private Integer sequence;

    @ApiModelProperty("上架状态，0-下架，1-上架")
    private Integer saleStatus;

    @ApiModelProperty("审核状态，0-待审核，1-已审核，2-不通过")
    private Integer auditStatus;

    @ApiModelProperty("审核原因")
    private String auditReason;

    @ApiModelProperty("商品是否限购 0.不限购 1限购")
    private Integer limitStatus;

    @ApiModelProperty("商品限购总数量")
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

    @ApiModelProperty("城市ID")
    private Integer cityId;
    
    @ApiModelProperty("商品状态：0-冻结，1-正常")
    private Integer productStatus;

}
