package com.union.aimei.common.vo.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Lei
 */
@Data
@ApiModel(value = "platformOrder", description = "平台订单")
public class PlatformOrder {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 平台订单号
	 */
	@ApiModelProperty(value = "平台订单号", required = false)
	private String platformOrderNo;
	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id", required = false)
	private Long memberId;
	/**
	 * 订单状态 0-待支付1-待发货 2-待收货 3-已收货 10-完成 20-退货中 21-已退货 22-退款失败 30-已关闭
	 */
	@ApiModelProperty(value = "订单状态 订单状态 0-待支付1-待发货 2-待收货 3-已收货   10-完成   20-退货中  21-已退货  22-退款失败  30-已关闭", required = false)
	private Short status;

	/**
	 * 店铺id
	 */
	@ApiModelProperty(value = "店铺id", required = false)
	private Integer shopId;

	/**
	 * 总价格
	 */
	@ApiModelProperty(value = "总价格", required = false)
	private BigDecimal totalPrice;
	/**
	 * 商品价格
	 */
	@ApiModelProperty(value = "商品价格", required = false)
	private BigDecimal goodsPrice;
	/**
	 * 支付价格
	 */
	@ApiModelProperty(value = "支付价格", required = false)
	private BigDecimal payPrice;
	/**
	 * 折扣价格
	 */
	@ApiModelProperty(value = "折扣价格", required = false)
	private BigDecimal discountPrice;
	/**
	 * 运费
	 */
	@ApiModelProperty(value = "运费", required = false)
	private BigDecimal freightPrice;

	/**
	 * 支付时间
	 */
	@ApiModelProperty(value = "支付时间", required = false)
	private Date payTime;

	/**
	 * 订单类型
	 */
	@ApiModelProperty(value = "订单类型 1-普通商品，2-积分商品，3-购买一卡通，4-充值一卡通，5-秒杀，6-抢购", required = false)
	private Short orderType;

	/**
	 * 支付状态
	 */
	@ApiModelProperty(value = "支付状态", required = false)
	private Short payStatus;
	/**
	 * 父订单编号
	 */
	@ApiModelProperty(value = "父订单编号", required = false)
	private String parentOrderNo;
	/**
	 * 支付类型
	 */
	@ApiModelProperty(value = "支付类型", required = false)
	private Short payType;
	/**
	 * ip地址
	 */
	@ApiModelProperty(value = "ip地址", required = false)
	private String ip;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间", required = false)
	private Date createTime;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间", required = false)
	private Date updateTime;

	@ApiModelProperty(value = "用户名", required = false)
	private String memberName;
	@ApiModelProperty(value = "用户电话", required = false)
	private String memberPhone;
	@ApiModelProperty(value = "店铺名", required = false)
	private String shopName;
	@ApiModelProperty(value = "收货地址", required = false)
	private String receiveGoodsAddress;
	@ApiModelProperty(value = "订单标题", required = false)
	private String orderTitle;
	@ApiModelProperty(value = "收货人姓名", required = false)
	private String receiveUserName;
	@ApiModelProperty(value = "收货人电话", required = false)
	private String receiveUserMobile;
	@ApiModelProperty(value = "支付记录号", required = false)
	private String payRecordNo;
	@ApiModelProperty(value = "一卡通支付前金额", required = false)
	private BigDecimal oneCardBeforePrice;
	@ApiModelProperty(value = "一卡通折扣", required = false)
	private BigDecimal oneCardDiscount;
	@ApiModelProperty(value = "一卡通优惠金额", required = false)
	private BigDecimal oneCardDiscountMoney;

	@ApiModelProperty(value = "应用系统:100艾美一族商城系统; 200美容邦系统;300康美集势系统;400货栈门店;500ERP财务系统", required = false)
	private Integer appSystem;

	/**
	 * 积分
	 */
	@ApiModelProperty(value = "积分数", required = false)
	private Integer credits;


	/**
	 * 微信或支付宝交易号
	 */
	@ApiModelProperty(value = "微信或支付宝交易号(支付成功后回写)", required = false)
	private String outTransactionNo;
	/**
	 * 微信或支付宝交易状态
	 */
	@ApiModelProperty(value = "微信或支付宝交易状态(支付成功后回写)", required = false)
	private String outStatus;

	@ApiModelProperty(value = "订单商品打折前的费用", required = false)
	private BigDecimal originalPrice;

	@ApiModelProperty(value = "活动id", required = false)
	private Integer activityId;

	@ApiModelProperty(value = "发货时间", required = false)
	private Date sendTime;

	@ApiModelProperty(value = "确认收货时间", required = false)
	private Date confirmReceiveTime;

	@ApiModelProperty(value = "是否匿名购买", required = false)
	private Boolean isAnonymityBuy;

	@ApiModelProperty(value = "买家留言", required = false)
	private String memberLeaveMessage;

	@ApiModelProperty(value = "现金支付时是否需要重新输入支付密码", required = false)
	private Boolean isNeedPayPassword;

	@ApiModelProperty(value = "店铺UUID", required = false)
	private Boolean hasServiceCoupon;

}
