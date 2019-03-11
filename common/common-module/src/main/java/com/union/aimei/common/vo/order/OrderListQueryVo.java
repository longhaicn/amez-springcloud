package com.union.aimei.common.vo.order;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author GaoWei
 * @describe  订单管理查询Vo
 * @time 2018/1/28,14:33
*/
@Data
@EqualsAndHashCode
@ApiModel(value = "订单管理查询Vo")
public class OrderListQueryVo {

    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
    @ApiModelProperty("订单类型 0.到店服务订单 1.上门服务订单")
    private Integer type;
    @ApiModelProperty(value = "订单来源(0:APP商城,1:微信商城)")
    private Integer orderSource;
    @ApiModelProperty("订单状态0：待付款;1:交易关闭;2:待服务;4:服务中;5:待评价;6:评价完成")
    private Integer status;
    @ApiModelProperty(value = "订单退款状态0：未申请，1：已申请，2：退款完成，3：退款失败")
    private Integer returnStatus;
    @ApiModelProperty("订单编号")
    private String orderNo;
    @ApiModelProperty(value = "店铺ID")
    private Integer storeId;
    @ApiModelProperty("店铺名称")
    private String storeName;
    @ApiModelProperty("会员姓名")
    private String memberRealName;
    @ApiModelProperty("会员手机号码")
    private String phone;
}
