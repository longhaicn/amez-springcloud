package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 根据门店ID查询挂靠结果
 *
 * @author liurenkai
 * @time 2018/5/22 10:26
 */
@Data
@EqualsAndHashCode
@ApiModel("根据门店ID查询挂靠结果")
public class AffiliatedByStoreIdResVo implements Serializable {

    @ApiModelProperty("挂靠ID")
    private Integer affiliatedId;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("昵称")
    private String beauticianNickName;

    @ApiModelProperty("头像")
    private String headImgUrl;

    @ApiModelProperty("从业年限")
    private Integer years;

    @ApiModelProperty("美容师星级，范围为0-100")
    private Integer beauticianStar;

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("服务区县名称")
    private String serviceAreaName;

    @ApiModelProperty("服务地址")
    private String serviceAddress;

    @ApiModelProperty("审核状态，0-待审核，1-审核通过，2-审核不通过，3-平台通过，4-平台不通过")
    private Integer auditStatus;

    @ApiModelProperty("审核原因")
    private String auditReason;

    @ApiModelProperty("创建时间")
    private Date createTime;

}
