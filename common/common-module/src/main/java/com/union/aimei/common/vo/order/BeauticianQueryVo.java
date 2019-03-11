package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 美容师查询订单VO
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "美容师查询订单VO")
public class BeauticianQueryVo {

    @ApiModelProperty(value = "美容师ID")
    private Integer beauticianId;
    @ApiModelProperty(value = "美容师姓名")
    private String beauticianName;
    @ApiModelProperty(value = "美容师手机号码")
    private String beauticianPhone;
    @ApiModelProperty("美容师回复评论状态（0：默认，1：用户已评价，美容师未回复，2：用户已评价，美容师已回复，3：系统默认好评）")
    private Integer beauticianReplyCommentStatus;
    @ApiModelProperty(value = "订单类型0：到店，1：上门")
    private Integer type;
    @ApiModelProperty(value = "订单状态")
    private Integer status;
    @ApiModelProperty(value = "退款状态")
    private Integer returnStatus;
 }

