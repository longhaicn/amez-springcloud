package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店-美容师-挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:09
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "门店-美容师-挂靠")
public class StoreBeauticianAffiliated implements Serializable {

    /**
     * 挂靠类型，1-申请，2-解除
     */
    public interface AffiliatedType {
        int APPLY = 1;
        int REMOVE = 2;
    }

    /**
     * 发起方，1-美容师，2-门店，3-平台
     */
    public interface Sponsor {
        int BEAUTICIAN = 1;
        int STORE = 2;
        int PLATFORM = 3;
    }
    
    /**
     * 审核状态，0-待审核，1-审核通过，2-审核不通过，3-平台通过，4-平台不通过
     */
    public interface AuditStatus {
        int PENDING = 0;
        int PASS = 1;
        int NOT_PASS = 2;
        int PLATFORM_PASS = 3;
        int PLATFORM_NOT_PASS = 4;
    }
    
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("挂靠类型，1-申请，2-解除")
    private Integer affiliatedType;

    @ApiModelProperty("发起方，1-美容师，2-门店，3-平台")
    private Integer sponsor;

    @ApiModelProperty("美容师类型，0-老板，1-店长，2-全职美容师，3-兼职美容师")
    private Integer beauticianType;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("审核状态，0-待审核，1-审核通过，2-审核不通过，3-平台通过，4-平台不通过")
    private Integer auditStatus;

    @ApiModelProperty("审核原因")
    private String auditReason;

    @ApiModelProperty("审核时间")
    private Date auditTime;

    @ApiModelProperty("平台审核时间")
    private Date platformAuditTime;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}