package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 根据商品分页查询领取的优惠券返回结果（提交订单）
 *
 * @author liurenkai
 * @time 2018/4/18 15:10
 */
@Data
@EqualsAndHashCode
@ApiModel("根据商品分页查询领取的优惠券返回结果（提交订单）")
public class CouponsByProductForOrderResVo implements Serializable {

    @ApiModelProperty("优惠券ID")
    private Integer id;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("优惠券名称")
    private String couponName;

    @ApiModelProperty("发放总数")
    private Integer issuedTotal;

    @ApiModelProperty("领取总数")
    private Integer receivedTotal;

    @ApiModelProperty("使用总数")
    private Integer usedTotal;

    @ApiModelProperty("满足金额")
    private Integer meetAmount;

    @ApiModelProperty("优惠金额")
    private Integer discountAmount;

    @ApiModelProperty("服务类型，1=全部服务，2=部分服务")
    private Integer supportServiceType;

    @ApiModelProperty("生效时间")
    private Date beginTime;

    @ApiModelProperty("过期时间")
    private Date endTime;

    @ApiModelProperty("每人限领(0:无限制)")
    private Integer perPersonLimit;

    @ApiModelProperty("到期提醒开关")
    private Boolean expiredRemindSwitch;

    @ApiModelProperty("使用说明")
    private String instructions;

    @ApiModelProperty("领取标记，1为正常，0为领完")
    private Boolean isReceived;

    @ApiModelProperty("优惠券状态，0-未开始，1-活动中，2-已结束")
    private Integer couponStatus;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("优惠券领取ID")
    private Integer receivedId;

    @ApiModelProperty("优惠券号码")
    private String couponNumber;

}
