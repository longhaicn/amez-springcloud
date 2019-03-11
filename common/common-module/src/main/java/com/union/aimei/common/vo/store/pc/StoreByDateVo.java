package com.union.aimei.common.vo.store.pc;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 店铺vo 增加日期限定查询
 *
 * @author caizhaoming
 * @time 2018/05/07
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺vo 增加日期限定查询")
public class StoreByDateVo implements Serializable {

    /**
     * 店铺状态：关闭
     */
    public static final int STORE_STATE_CLOSE = 0;
    /**
     * 店铺状态：开启
     */
    public static final int STORE_STATE_OPEN = 1;
    /**
     * 店铺状态：待审核
     */
    public static final int STORE_STATE_BE_AUDITED = 2;
    /**
     * 店铺状态：冻结
     */
    public static final int STORE_STATE_FREEZE = 3;

    @ApiModelProperty("地图坐标（非数据库字段）")
    private BaiDuMapApi.Point point;

    @ApiModelProperty("距离，M/米为单位（非数据库字段）")
    private Long distance;

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("店铺公司名称")
    private String storeCompanyName;

    @ApiModelProperty("店铺认证")
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

    @ApiModelProperty("店铺成长值")
    private Integer growupValue;

    @ApiModelProperty("经营年限")
    private Integer manageYear;

    @ApiModelProperty("店铺标签 十年老店，五年老店")
    private String storeLabel;

    @ApiModelProperty("特色项目")
    private String specialProject;

    @ApiModelProperty("店铺销量")
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

    @ApiModelProperty("店铺LOGO")
    private String storeLogo;

    @ApiModelProperty("店铺营业时间")
    private String storeTime;

    @ApiModelProperty("店铺状态，0关闭，1开启，2待审核，3冻结")
    private Integer storeState;

    @ApiModelProperty("店铺关闭原因")
    private String storeCloseInfo;

    @ApiModelProperty("店铺关闭时间")
    private String storeEndTime;

    @ApiModelProperty("店铺排序")
    private Integer storeSort;

    @ApiModelProperty("店铺横幅")
    private String storeBanner;

    @ApiModelProperty("环境满意度分数")
    private Float storeDesccredit;

    @ApiModelProperty("服务满意度分数")
    private Float storeServicecredit;

    @ApiModelProperty("店铺seo关键字")
    private String storeKeywords;

    @ApiModelProperty("店铺seo描述")
    private String storeDescription;

    @ApiModelProperty("店铺简介")
    private String description;

    @ApiModelProperty("主营商品")
    private String storeZy;

    @ApiModelProperty("店铺域名")
    private String storeDomain;

    @ApiModelProperty("推荐，0为否，1为是，默认为0")
    private Boolean storeRecommend;

    @ApiModelProperty("店铺当前主题")
    private String storeTheme;

    @ApiModelProperty("店铺信用")
    private Integer storeCredit;

    @ApiModelProperty("店铺好评率")
    private Float praiseRate;

    @ApiModelProperty("店铺幻灯片")
    private String storeSlide;

    @ApiModelProperty("店铺幻灯片链接")
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

    @ApiModelProperty("创建时间筛选开始")
    private String createTimeBegin;

    @ApiModelProperty("创建时间筛选结束")
    private String createTimeEnd;

    private static final long serialVersionUID = 1L;
}
