package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师管理列表结果
 *
 * @author liurenkai
 * @time 2018/6/13 19:12
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师管理列表结果")
public class BeauticianListManageResVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("员工类型，0-老板，1-店长，2-全职员工，3-兼职员工")
    private Integer beauticianType;

    @ApiModelProperty("昵称")
    private String beauticianNickName;

    @ApiModelProperty("头像")
    private String headImgUrl;

    @ApiModelProperty("工牌号")
    private String workCardNo;

    @ApiModelProperty("从业年限")
    private Integer years;

    @ApiModelProperty("门店等级名称")
    private String gradeName;

    @ApiModelProperty("是否服务，0-不服务，1-服务中")
    private Boolean isOrder;

    @ApiModelProperty("挂靠状态，0-未入驻挂靠，1-已入驻，2-已挂靠，3-申请挂靠，4-申请解除挂靠，5-待平台审核")
    private Integer affiliatedStatus;

    @ApiModelProperty("挂靠ID")
    private Integer affiliatedId;

    @ApiModelProperty("解除挂靠ID")
    private Integer removeAffiliatedId;

}
