package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询店铺美容师（招募）
 *
 * @author liurenkai
 * @time 2018/3/8 10:41
 */
@Data
@EqualsAndHashCode
@ApiModel("查询店铺美容师（招募）")
public class StoreBeauticianByRecruitVo implements Serializable {

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("员工类型，0-老板，1-店长，2-正式员工，3-兼职员工")
    private Integer beauticianType;

    @ApiModelProperty("状态，0-离职，1-在职，2-休息")
    private Integer beauticianStatus;

    @ApiModelProperty("审核状态，0-待审核，1-已审核，2-不通过")
    private Integer auditStatus;

    /**
     * 员工类型，0-老板
     */
    public static final Integer BEAUTICIAN_TYPE_THE_BOSS = 0;
    /**
     * 员工类型，1-店长
     */
    public static final Integer BEAUTICIAN_TYPE_THE_MANAGER = 1;
    /**
     * 员工类型，2-正式员工
     */
    public static final Integer BEAUTICIAN_TYPE_THE_STAFF = 2;
    /**
     * 员工类型，3-兼职员工
     */
    public static final Integer BEAUTICIAN_TYPE_THE_EMPLOYEES = 3;

    /**
     * 状态，0-离职
     */
    public static final Integer BEAUTICIAN_STATUS_TYPE_DEPARTURE = 0;
    /**
     * 状态，1-在职
     */
    public static final Integer BEAUTICIAN_STATUS_TYPE_OFFICE = 1;
    /**
     * 状态，2-休息
     */
    public static final Integer BEAUTICIAN_STATUS_TYPE_REST = 2;

    /**
     * 审核状态，0-待审核
     */
    public static final Integer AUDIT_STATUS_STATUS_TYPE_REVIEW = 0;
    /**
     * 审核状态，1-已审核
     */
    public static final Integer AUDIT_STATUS_STATUS_TYPE_APPROVED = 1;
    /**
     * 审核状态，2-不通过
     */
    public static final Integer AUDIT_STATUS_STATUS_TYPENOTTHROUGH = 2;


}
