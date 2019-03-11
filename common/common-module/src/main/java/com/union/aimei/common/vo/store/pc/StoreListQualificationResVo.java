package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店资质认证列表结果
 *
 * @author liurenkai
 * @time 2018/6/20 10:21
 */
@Data
@EqualsAndHashCode
@ApiModel("门店资质认证列表结果")
public class StoreListQualificationResVo implements Serializable {

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("法人姓名")
    private String legalPersonName;

    @ApiModelProperty("法人身份证号码")
    private String legalPersonIdcard;

    @ApiModelProperty("营业执照号码")
    private String businessLicenseNumber;

    @ApiModelProperty("资质状态，0-待提交，1-待审核，2-审核通过，3-审核不通过")
    private Integer qualificationStatus;

    @ApiModelProperty("资质提交时间")
    private Date qualificationCommitTime;

    @ApiModelProperty("资质审核时间")
    private Date qualificationAuditTime;

}