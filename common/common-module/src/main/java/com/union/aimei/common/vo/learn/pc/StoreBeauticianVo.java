package com.union.aimei.common.vo.learn.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.RandomStringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺美容师
 *
 * @author caizhaoming
 * @time 2018/3/2 17:14
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺美容师")
public class StoreBeauticianVo implements Serializable {

    /**
     * 默认昵称
     */
    public static final String DEFAULT_NICK_NAME = "邦主" + RandomStringUtils.randomNumeric(6);

    /**
     * 员工类型，0-老板
     */
    public static final int BEAUTICIAN_TYPE_BOSS = 0;
    /**
     * 员工类型，1-店长
     */
    public static final int BEAUTICIAN_TYPE_MANAGER = 1;
    /**
     * 员工类型，2-正式员工
     */
    public static final int BEAUTICIAN_TYPE_FULL_TIME = 2;
    /**
     * 员工类型，3-兼职员工
     */
    public static final int BEAUTICIAN_TYPE_PART_TIME = 3;

    /**
     * 状态，0-离职
     */
    public static final int BEAUTICIAN_STATUS_LEAVE = 0;
    /**
     * 状态，1-在职
     */
    public static final int BEAUTICIAN_STATUS_IN_SERVICE = 1;
    /**
     * 状态，2-休息
     */
    public static final int BEAUTICIAN_STATUS_REST = 2;

    /**
     * 审核状态，0-待审核
     */
    public static final int AUDIT_STATUS_WAIT_AUDIT = 0;
    /**
     * 审核状态，1-已审核
     */
    public static final int AUDIT_STATUS_AUDITED = 1;
    /**
     * 审核状态，2-不通过
     */
    public static final int AUDIT_STATUS_NOT_THROUGH = 2;

    /**
     * 注册状态，0-待完善资料
     */
    public static final int REGISTER_STATUS_INFO = 0;
    /**
     * 注册状态，1-待评测
     */
    public static final int REGISTER_STATUS_EXAM = 1;
    /**
     * 注册状态，2-完成注册
     */
    public static final int REGISTER_STATUS_PASS = 2;

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

    @ApiModelProperty("性别，1-男，2-女")
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

    @ApiModelProperty("员工类型，0-老板，1-店长，2-正式员工，3-兼职员工")
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

    @ApiModelProperty("支持到店标记，1-是，0-否")
    private Boolean isSupportStore;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Boolean isSupportHome;

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

    @ApiModelProperty("注册状态，0-待完善资料，1-待评测，2-完成注册")
    private Integer registerStatus;

    @ApiModelProperty("是否接单，0-不接单，1-接单中")
    private Boolean isOrder;

    @ApiModelProperty("本月在线时间（单位/小时）")
    private Integer monthOnlineTime;

    private static final long serialVersionUID = 1L;

}