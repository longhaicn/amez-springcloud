package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 美容师订单详情安排VO
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "美容师订单详情安排VO")
public class BeauticianArrangeVo {

    @ApiModelProperty(value = "订单ID")
    private Integer orderId;

    @ApiModelProperty(value = "服务名称")
    private String productName;

    @ApiModelProperty(value = "美容师名称")
    private String beauticianName;

    @ApiModelProperty(value = "美容师头像")
    private String imgUrl;

    @ApiModelProperty(value = "服务开始时间")
    private Date serverStartTime;

    @ApiModelProperty(value = "服务结束时间")
    private Date serverEndTime;

    @ApiModelProperty(value = "订单类型0：到店，1：上门")
    private Integer type;

    @ApiModelProperty(value = "会员名称")
    private String memberPhone;


    @ApiModelProperty(value = "会员名称")
    private String memberReadName;

    @ApiModelProperty(value = "会员昵称")
    private String memberNickName;

    @ApiModelProperty(value = "上门服务客户名称")
    private String customerName;

    @ApiModelProperty(value = "上门服务电话")
    private String customerPhone;

    @ApiModelProperty(value = "上门服务地址")
    private String customerAddress;

    @ApiModelProperty(value = "IM用户ID")
    private Integer imUserId;

    @ApiModelProperty(value = "IM用户名称")
    private String imUserName;


}
