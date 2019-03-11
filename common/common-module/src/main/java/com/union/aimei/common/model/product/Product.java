package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目
 *
 * @author liurenkai
 * @time 2018/2/28 15:41
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "项目")
public class Product implements Serializable {

    /**
     * 项目类型，1-门店自营，2-品牌，3-平台自营
     */
    public static Map<Integer, String> productTypeMap = new HashMap<>(16);
    public static Map<Integer, String> serverTypeMap = new HashMap<>(16);

    static {
        productTypeMap.put(ProductType.STORE_SELF, "门店自营");
        productTypeMap.put(ProductType.BRAND, "品牌");
        productTypeMap.put(ProductType.PLATFORM_SELF, "平台自营");

        serverTypeMap.put(ServerType.STORE, "到店项目");
        serverTypeMap.put(ServerType.HOME, "上门项目");
    }

    /**
     * 项目类型，1-门店自营，2-品牌，3-平台自营
     */
    public interface ProductType {
        int STORE_SELF = 1;
        int BRAND = 2;
        int PLATFORM_SELF = 3;
    }

    /**
     * 上架状态，0-下架，1-上架，2-冻结
     */
    public interface SaleStatus {
        int OFF_SHELVES = 0;
        int ON_SALE = 1;
//        int FREEZE = 2;
    }

    /**
     * 审核状态，0-待审核，1-审核通过，2-审核不通过
     */
    public interface AuditStatus {
        int PENDING = 0;
        int PASS = 1;
        int NOT_PASS = 2;
    }

    /**
     * 服务类型，0-到店，1-上门
     */
    public interface ServerType {
        int STORE = 0;
        int HOME = 1;
    }

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

    @ApiModelProperty("全职美容师佣金")
    private Integer fulltimeCommission;

    @ApiModelProperty("'全职美容师佣金比例'")
    private Integer fulltimeCommissionRatio;

    @ApiModelProperty("'兼职美容师佣金'")
    private Integer parttimeCommission;

    @ApiModelProperty("'兼职美容师佣金比例'")
    private Integer parttimeCommissionRatio;

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

    private static final long serialVersionUID = 1L;
}