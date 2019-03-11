package com.union.aimei.common.model.store;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 门店
 *
 * @author liurenkai
 * @time 2018/1/12 19:09
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "门店")
public class Store implements Serializable {

    /**
     * 平台
     */
    public static final int ID_PLATEFORM = -1;

    /**
     * 门店状态，0-关闭，1-开启，2-待审核，3-冻结
     */
    public interface StoreState {
        int CLOSE = 0;
        int OPEN = 1;
        int BE_AUDITED = 2;
        int FREEZE = 3;
    }

    /**
     * 入驻状态，0-待完善资料，1-待审核，2-审核通过，3-审核不通过
     */
    public interface SettledStatus {
        int WAIT_IMPROVE = 0;
        int PENDING = 1;
        int PASS = 2;
        int NO_PASS = 3;
    }

    /**
     * 资质状态，0-待提交，1-待审核，2-审核通过，3-审核不通过
     */
    public interface QualificationStatus {
        int WAIT_COMMIT = 0;
        int PENDING = 1;
        int PASS = 2;
        int NOT_PASS = 3;
    }

    @ApiModelProperty("地图坐标（非数据库字段）")
    private BaiDuMapApi.Point point;

    @ApiModelProperty("距离，M/米为单位（非数据库字段）")
    private Long distance;

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("门店公司名称")
    private String storeCompanyName;

    @ApiModelProperty("门店认证")
    private Boolean storeAuth;

    @ApiModelProperty("品牌ID")
    private Integer brandId;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("级别ID")
    private Integer levelId;

    @ApiModelProperty("级别名称")
    private String levelName;

    @ApiModelProperty("级别图标")
    private String levelLogo;

    @ApiModelProperty("门店成长值")
    private Integer growupValue;

    @ApiModelProperty("经营年限")
    private Integer manageYear;

    @ApiModelProperty("门店标签 十年老店，五年老店")
    private String storeLabel;

    @ApiModelProperty("特色项目")
    private String specialProject;

    @ApiModelProperty("门店销量")
    private Integer storeSales;

    @ApiModelProperty("老板ID")
    private Integer bossUserId;

    @ApiModelProperty("老板手机号码")
    private String bossPhone;

    @ApiModelProperty("老板账号")
    private String bossName;

    @ApiModelProperty("店长ID")
    private Integer sellerUserId;

    @ApiModelProperty("店长手机号码")
    private String sellerPhone;

    @ApiModelProperty("店长账号")
    private String sellerName;

    @ApiModelProperty("省ID")
    private Integer productId;

    @ApiModelProperty("市ID")
    private Integer cityId;

    @ApiModelProperty("区ID")
    private Integer areaId;

    @ApiModelProperty("省名称")
    private String provinceName;

    @ApiModelProperty("市名称")
    private String cityName;

    @ApiModelProperty("县城市")
    private String areaName;

    @ApiModelProperty("经度，长度10位，小数点后7位")
    private BigDecimal storeLongitude;

    @ApiModelProperty("纬度，长度10位，小数点后7位")
    private BigDecimal storeLatitude;

    @ApiModelProperty("详细地区")
    private String storeAddress;

    @ApiModelProperty("门牌号")
    private String houseNumber;

    @ApiModelProperty("邮政编码")
    private String storeZip;

    @ApiModelProperty("电话号码")
    private String storeTel;

    @ApiModelProperty("门店LOGO")
    private String storeLogo;

    @ApiModelProperty("门店营业时间")
    private String storeTime;

    @ApiModelProperty("门店状态，0关闭，1开启，2待审核，3冻结")
    private Integer storeState;

    @ApiModelProperty("门店关闭原因")
    private String storeCloseInfo;

    @ApiModelProperty("门店关闭时间")
    private String storeEndTime;

    @ApiModelProperty("门店排序")
    private Integer storeSort;

    @ApiModelProperty("门店横幅")
    private String storeBanner;

    @ApiModelProperty("环境满意度分数")
    private Float storeDesccredit;

    @ApiModelProperty("服务满意度分数")
    private Float storeServicecredit;

    @ApiModelProperty("门店seo关键字")
    private String storeKeywords;

    @ApiModelProperty("门店seo描述")
    private String storeDescription;

    @ApiModelProperty("门店简介")
    private String description;

    @ApiModelProperty("主营商品")
    private String storeZy;

    @ApiModelProperty("门店域名")
    private String storeDomain;

    @ApiModelProperty("推荐，0为否，1为是，默认为0")
    private Boolean storeRecommend;

    @ApiModelProperty("门店当前主题")
    private String storeTheme;

    @ApiModelProperty("门店信用")
    private Integer storeCredit;

    @ApiModelProperty("门店好评率")
    private Float praiseRate;

    @ApiModelProperty("门店幻灯片")
    private String storeSlide;

    @ApiModelProperty("门店幻灯片链接")
    private String storeSlideUrl;

    @ApiModelProperty("库存警报")
    private Integer storeStorageAlarm;

    @ApiModelProperty("粉丝数量")
    private Integer followerTotal;

    @ApiModelProperty("美容师数量")
    private Integer beauticianTotal;

    @ApiModelProperty("账户余额")
    private Integer accountBalance;

    @ApiModelProperty("预收入金额")
    private Integer preIncomeAmount;

    @ApiModelProperty("老店标记，1-是，0-否")
    private Boolean isOld;

    @ApiModelProperty("精选标记，1-是，0-否")
    private Boolean isSelect;

    @ApiModelProperty("精选排序")
    private Integer selectSort;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("入驻状态，0-待完善资料，1-待审核，2-审核通过，3-审核不通过")
    private Integer settledStatus;

    @ApiModelProperty("入驻码")
    private String settledCode;

    @ApiModelProperty("资质状态，0-待提交，1-待审核，2-审核通过，3-审核不通过")
    private Integer qualificationStatus;

    @ApiModelProperty("资质原因")
    private String qualificationReason;

    @ApiModelProperty("资质提交时间")
    private Date qualificationCommitTime;

    @ApiModelProperty("资质审核时间")
    private Date qualificationAuditTime;

    private static final long serialVersionUID = 1L;


}
