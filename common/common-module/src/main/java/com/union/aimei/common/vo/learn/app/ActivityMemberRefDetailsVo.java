package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author houji
 * @date 2018/5/23  17:35
 */
@Data
@EqualsAndHashCode
@ApiModel("门店或美容师报名活动详情数据vo")
public class ActivityMemberRefDetailsVo {

    @ApiModelProperty("活动id(返回的结果)")
    private Integer id;

    @ApiModelProperty("活动id(参数,必填)")
    private Integer activityId;

    @ApiModelProperty("主标题")
    private String mtitle;

    @ApiModelProperty("活动费用")
    private Integer costs;

    @ApiModelProperty("报名人员的名字")
    private String name;

    @ApiModelProperty("店铺id(参数，与beauticianId二选一)")
    private Integer storeId;

    @ApiModelProperty("美容师id(参数，与storeId二选一")
    private Integer beauticianId;

    @ApiModelProperty("用户会员id")
    private Integer memberId;

    @ApiModelProperty("联系人手机")
    private String contactPhone;

    @ApiModelProperty("交易金额（以分为单位存入）")
    private Integer tradeAmount;

    @ApiModelProperty("实际交易金额（以分为单位存入）")
    private Integer actualTradeAmount;


}
