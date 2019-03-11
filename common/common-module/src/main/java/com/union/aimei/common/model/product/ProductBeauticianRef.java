package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/3/1 17:35
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "项目-美容师-关联")
public class ProductBeauticianRef implements Serializable {

    /**
     * 招募标题格式化
     */
    public static final String RECRUIT_TITLE_FORMAT = "亲爱的,你接收到来自%s的兼职服务邀请";

    /**
     * 发起方，1-美容师，2-门店，3-平台
     */
    public interface Sponsor {
        int BEAUTICIAN = 1;
        int STORE = 2;
        int PLATFORM = 3;
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
     * 是否展示，1-是，0-否
     */
    public interface IsShow {
        int SHOW = 1;
        int HIDDEN = 0;
    }

    public ProductBeauticianRef(ProductBeauticianRef productBeauticianRef) {
        this.id = productBeauticianRef.id;
        this.productId = productBeauticianRef.productId;
        this.storeId = productBeauticianRef.storeId;
        this.storeName = productBeauticianRef.storeName;
        this.beauticianId = productBeauticianRef.beauticianId;
        this.serverType = productBeauticianRef.serverType;
        this.isRecruit = productBeauticianRef.isRecruit;
        this.isEnabled = productBeauticianRef.isEnabled;
        this.createTime = productBeauticianRef.createTime;
        this.updateTime = productBeauticianRef.updateTime;
    }

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("发起方，1-美容师，2-门店，3-平台")
    private Integer sponsor;

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("服务类型，0-到店，1-上门")
    private Integer serverType;

    @ApiModelProperty("是否招募美容师标记，1-是，0-否")
    private Boolean isRecruit;

    @ApiModelProperty("审核状态，0-待审核，1-审核通过，2-审核不通过")
    private Integer auditStatus;

    @ApiModelProperty("审核原因")
    private String auditReason;

    @ApiModelProperty("是否选择，1-是，0-否")
    private Boolean isSelect;

    @ApiModelProperty("是否接单，1-是，0-否")
    private Boolean isOrder;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("是否展示，1-是，0-否")
    private Integer isShow;

    private static final long serialVersionUID = 1L;
}