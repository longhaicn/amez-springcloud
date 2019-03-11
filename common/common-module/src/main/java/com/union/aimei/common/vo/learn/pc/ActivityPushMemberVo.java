package com.union.aimei.common.vo.learn.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 报名活动会员的vo
 *
 * @author houji
 * @create 2018-05-10 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel("报名活动会员的vo")
public class ActivityPushMemberVo implements Serializable {

    @ApiModelProperty("主键自增，活动id")
    private Integer id;

    @ApiModelProperty("主标题")
    private String mtitle;

    @ApiModelProperty("活动起始时间")
    private Date startTime;

    @ApiModelProperty("会员id")
    private Integer memberId;

    @ApiModelProperty("参加活动人员的手机")
    private String phone;

    @ApiModelProperty("联系人员的手机")
    private String contactPhone;

    @ApiModelProperty("参加人标签(0-老板，1-店长，2-全职员工，3-兼职员工，4-朋友 )")
    private Integer tag;

    @ApiModelProperty("美容师id")
    private Integer beauticianId;

    @ApiModelProperty("门店id")
    private Integer storeId;

}
