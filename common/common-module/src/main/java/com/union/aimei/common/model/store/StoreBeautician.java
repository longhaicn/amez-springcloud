package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 门店美容师
 *
 * @author liurenkai
 * @time 2018/3/2 17:14
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "门店美容师")
public class StoreBeautician implements Serializable {

    /**
     * 美容师类型，0-老板，1-店长，2-全职美容师，3-兼职美容师，4-朋友（storeFriend中的数据,storeBeautician中不存在数据）
     */
    public interface BeauticianType {
        int BOSS = 0;
        int MANAGER = 1;
        int FULL_TIME = 2;
        int PART_TIME = 3;
        int FRIEND = 4;
    }

    /**
     * 美容师状态，0-离职，1-在职，2-休息（作废  2018-06-11）
     */
    public interface BeauticianStatus {
        int LEAVE = 0;
        int IN_SERVICE = 1;
        int REST = 2;
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
     * 注册状态，0-待完善资料，1-待审核，2-审核通过，3-审核不通过
     */
    public interface RegisterStatus {
        int WAIT_IMPROVE = 0;
        int PENGDING = 1;
        int PASS = 2;
        int NOT_PASS = 3;
    }

    /**
     * 挂靠状态，0-未入驻挂靠，1-已入驻，2-已挂靠，3-申请挂靠，4-申请解除挂靠，5-待平台审核
     */
    public interface AffiliatedStatus {
        int PENGING = 0;
        int SETTLED = 1;
        int AFFILIATED = 2;
        int APPLY_AFFILIATED = 3;
        int APPLY_REMOVE_AFFILIATED = 4;
        int PENDING_PLATFORM_AUDIT = 5;
    }

    /**
     * 实名状态，0-待提交，1-待审核，2-审核通过，3-审核不通过
     */
    public interface RealNameStatus {
        int WAIT_COMMIT = 0;
        int PENGING = 1;
        int PASS = 2;
        int NOT_PASS = 3;
    }

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("IM用户ID")
    private Integer imUserId;

    @ApiModelProperty("IM用户名")
    private String imUsername;

    @ApiModelProperty("姓名")
    private String beauticianName;

    @ApiModelProperty("昵称")
    private String beauticianNickName;

    @ApiModelProperty("头像")
    private String headImgUrl;

    @ApiModelProperty("性别，0-男，1-女")
    private Integer sex;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("工牌号")
    private String workCardNo;

    @ApiModelProperty("出生日期")
    private String birthDate;

    @ApiModelProperty("入职日期")
    private String entryDate;

    @ApiModelProperty("省ID")
    private Integer provinceId;

    @ApiModelProperty("市ID")
    private Integer cityId;

    @ApiModelProperty("县ID")
    private Integer areaId;

    @ApiModelProperty("省名称")
    private String provinceName;

    @ApiModelProperty("市名称")
    private String cityName;

    @ApiModelProperty("县名称")
    private String areaName;

    @ApiModelProperty("详细地址")
    private String address;

    @ApiModelProperty("员工类型，0-老板，1-店长，2-全职员工，3-兼职员工")
    private Integer beauticianType;

    @ApiModelProperty("从业年限")
    private Integer years;

    @ApiModelProperty("状态，0-离职，1-在职，2-休息")
    private Integer beauticianStatus;

    @ApiModelProperty("美容师等级，1-初级美容师，2-中级美容师，3-高级美容师，4-资深美容师")
    private Integer beauticianLevel;

    @ApiModelProperty("客服标记，1-是，0-否")
    private Boolean isService;

    @ApiModelProperty("明星标记，1-是，0-否")
    private Boolean isStar;

    @ApiModelProperty("明星排序")
    private Integer starSort;

    @ApiModelProperty("审核状态，0-待审核，1-已审核，2-不通过")
    private Integer auditStatus;

    @ApiModelProperty("审核原因")
    private String auditReason;

    @ApiModelProperty("是否到店，1-是，0-否")
    private Boolean isStore;

    @ApiModelProperty("是否上门，1-是，0-否")
    private Boolean isHome;

    @ApiModelProperty("账户余额")
    private Integer accountBalance;

    @ApiModelProperty("预收入金额")
    private Integer preIncomeAmount;

    @ApiModelProperty("美容师星级，范围为0-100")
    private Integer beauticianStar;

    @ApiModelProperty("满意度，范围为0-100")
    private Integer satisfaction;

    @ApiModelProperty("级别ID")
    private Integer levelId;

    @ApiModelProperty("级别名称")
    private String levelName;

    @ApiModelProperty("级别图标")
    private String levelLogo;

    @ApiModelProperty("成长值")
    private Integer growupValue;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("注册状态，0-待完善资料，1-待审核，2-审核通过，3-审核不通过")
    private Integer registerStatus;

    @ApiModelProperty("是否服务，0-不服务，1-服务中")
    private Boolean isOrder;

    @ApiModelProperty("本月在线时间（单位/小时）")
    private Integer monthOnlineTime;

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("服务城市ID")
    private Integer serviceCityId;

    @ApiModelProperty("服务城市名称")
    private String serviceCityName;

    @ApiModelProperty("服务区县ID")
    private Integer serviceAreaId;

    @ApiModelProperty("服务区县ID")
    private String serviceAreaName;

    @ApiModelProperty("服务地址")
    private String serviceAddress;

    @ApiModelProperty("服务经度")
    private BigDecimal serviceLongitude;

    @ApiModelProperty("服务纬度")
    private BigDecimal serviceLatitude;

    @ApiModelProperty("服务半径")
    private Integer serviceRadius;

    @ApiModelProperty("挂靠状态，0-未入驻挂靠，1-已入驻，2-已挂靠，3-申请挂靠，4-申请解除挂靠，5-待平台审核")
    private Integer affiliatedStatus;

    @ApiModelProperty("挂靠ID")
    private Integer affiliatedId;

    @ApiModelProperty("解除挂靠ID")
    private Integer removeAffiliatedId;

    @ApiModelProperty("签名")
    private String signature;

    @ApiModelProperty("开始营业时间，HH:mm")
    private String startBusinessHour;

    @ApiModelProperty("结束营业时间，HH:mm")
    private String endBusinessHour;

    @ApiModelProperty("工作日，逗号分隔")
    private String workday;

    @ApiModelProperty("是否支持到店，1-是，0-否")
    private Boolean isSupportStore;

    @ApiModelProperty("是否支持上门，1-是，0-否")
    private Boolean isSupportHome;

    @ApiModelProperty("实名状态，0-待提交，1-待审核，2-审核通过，3-审核不通过")
    private Integer realNameStatus;

    @ApiModelProperty("从业证书")
    private String qualificationCertificate;

    @ApiModelProperty("门店等级ID")
    private Integer gradeId;

    @ApiModelProperty("门店等级名称")
    private String gradeName;

    @ApiModelProperty("收藏人数")
    private Integer followerNumber;

    private static final long serialVersionUID = 1L;

}