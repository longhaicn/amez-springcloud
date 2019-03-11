/*
Navicat MySQL Data Transfer

Source Server         : 艾美-美容邦测试数据库
Source Server Version : 50720
Source Host           : 120.79.42.13:3306
Source Database       : beautybond_financial

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-04 16:48:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for beautician_trade_detail
-- ----------------------------
DROP TABLE IF EXISTS `beautician_trade_detail`;
CREATE TABLE `beautician_trade_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易流水id',
  `store_id` int(11) DEFAULT NULL COMMENT '门店ID',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师',
  `store_name` varchar(64) DEFAULT NULL COMMENT '门店名称',
  `beautician_name` varchar(64) DEFAULT NULL,
  `beautician_phone` varchar(64) DEFAULT NULL COMMENT '美容师电话',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单编号',
  `trade_type` int(11) DEFAULT NULL COMMENT '交易类型(1-服务订单提成,2-提现)',
  `product_name` varchar(64) DEFAULT NULL COMMENT '服务名称',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `trade_status` int(11) DEFAULT NULL COMMENT '交易状态:0-未完成,1-已完成',
  `income` int(11) DEFAULT '0' COMMENT '服务提成',
  `visit_amount` int(11) DEFAULT '0' COMMENT '上门费用',
  `net_income` int(11) DEFAULT '0' COMMENT '净收入',
  `pay_method` int(11) DEFAULT NULL COMMENT '支付方式',
  `pay_rate` int(11) DEFAULT NULL COMMENT '支付比率',
  `settlement_time` datetime DEFAULT NULL COMMENT '结算时间',
  `reimburse_amount` int(11) DEFAULT '0' COMMENT '退款金额',
  `reimburse_time` datetime DEFAULT NULL COMMENT '退款时间',
  `withdraw_amount` int(11) DEFAULT '0' COMMENT '提现申请金额',
  `taxation` int(11) DEFAULT '0' COMMENT '提现手续费',
  `actual_amount` int(11) DEFAULT '0' COMMENT '''实际提现金额(扣除手续费后)'',',
  `bank_name` varchar(24) DEFAULT NULL,
  `bank_branch` varchar(24) DEFAULT NULL COMMENT '银行支行',
  `bank_card_no` varchar(30) DEFAULT NULL COMMENT '会员银行卡号码',
  `add_time` datetime DEFAULT NULL COMMENT '提现申请时间',
  `ready_play_amount_time` datetime DEFAULT NULL COMMENT '预打款时间',
  `play_amount_time` datetime DEFAULT NULL COMMENT '打款时间',
  `play_amount_status` tinyint(4) DEFAULT NULL COMMENT '打款状态(0：未打款，1：已打款)',
  `statistics_year` varchar(24) DEFAULT NULL COMMENT '统计时间年份',
  `statistics_year_month` varchar(24) DEFAULT NULL COMMENT '统计时间年份月份',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(120) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=467 DEFAULT CHARSET=utf8 COMMENT='美容师流水';

-- ----------------------------
-- Table structure for commission_setting
-- ----------------------------
DROP TABLE IF EXISTS `commission_setting`;
CREATE TABLE `commission_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `commission_name` varchar(240) DEFAULT NULL COMMENT '名称',
  `commission_rate` int(11) DEFAULT NULL COMMENT '费率',
  `remarks` varchar(240) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='佣金设置';

-- ----------------------------
-- Table structure for notification_notice
-- ----------------------------
DROP TABLE IF EXISTS `notification_notice`;
CREATE TABLE `notification_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `notice_content` varchar(500) DEFAULT NULL COMMENT '公告内容',
  `notice_status` int(11) DEFAULT NULL COMMENT '公告状态,0-公告中,1-已停止',
  `notice_start_time` datetime DEFAULT NULL COMMENT '公告开始时间',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `used_type` int(11) DEFAULT NULL COMMENT '客服端',
  `notice_end_time` datetime DEFAULT NULL COMMENT '公告结束时间',
  `remarks` varchar(240) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='通知公告';

-- ----------------------------
-- Table structure for platform_trade_detail
-- ----------------------------
DROP TABLE IF EXISTS `platform_trade_detail`;
CREATE TABLE `platform_trade_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易流水id',
  `order_number` varchar(64) DEFAULT NULL COMMENT '订单号',
  `transaction_serial_number` varchar(64) DEFAULT NULL COMMENT '交易流水号',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `trade_type` int(11) DEFAULT '0' COMMENT '交易类型(1-服务订单，2-会员卡售卡,3-会员卡充值',
  `trade_status` int(11) DEFAULT '0' COMMENT '交易状态:0-未完成,1-已完成',
  `order_amount` int(11) DEFAULT '0' COMMENT '订单金额',
  `actually_amount` int(11) DEFAULT '0' COMMENT '实付金额',
  `beautician_commission` int(11) DEFAULT '0' COMMENT '美容师提成',
  `store_net_income` int(11) DEFAULT '0' COMMENT '门店净收入',
  `settlement_amount` int(11) DEFAULT '0' COMMENT '结算金额',
  `platform_commission` int(11) DEFAULT '0' COMMENT '平台佣金',
  `pay_method` int(11) unsigned DEFAULT '0' COMMENT '支付方式:1-支付宝,2-微信,3-会员卡,4-一卡通,5-余额支付',
  `pay_rate` int(11) DEFAULT '0' COMMENT '支付比率',
  `settlement_time` datetime DEFAULT NULL COMMENT '结算时间',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺id',
  `store_name` varchar(64) DEFAULT NULL COMMENT '门店名字',
  `store_phone` varchar(64) DEFAULT NULL COMMENT '门店电话',
  `store_bboss` varchar(64) DEFAULT NULL COMMENT '门店老板',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师id',
  `beautician_name` varchar(64) DEFAULT NULL COMMENT '美容师名字',
  `beautician_phone` varchar(64) DEFAULT NULL COMMENT '美容师电话',
  `buyers_nickname` varchar(64) DEFAULT NULL COMMENT '买家名字',
  `buyers_phone` varchar(64) DEFAULT NULL COMMENT '买家手机',
  `service_name` varchar(64) DEFAULT NULL COMMENT '服务名称',
  `unit_price` int(11) DEFAULT '0' COMMENT '单价',
  `coupons` int(11) DEFAULT '0' COMMENT '优惠券优惠',
  `membership_card_discount` int(11) DEFAULT '0' COMMENT '会员卡优惠',
  `one_cartoon_preferential` int(11) DEFAULT '0' COMMENT '一卡通优惠',
  `membershi_card` varchar(64) DEFAULT NULL COMMENT '会员卡',
  `card_content` varchar(250) DEFAULT NULL COMMENT '卡内容',
  `face_value` int(11) DEFAULT '0' COMMENT '面值',
  `sell_card_channel_reward` int(11) DEFAULT '0' COMMENT '售卡渠道奖励',
  `total_price` int(11) DEFAULT '0' COMMENT '总价',
  `statistics_year` varchar(64) DEFAULT NULL COMMENT '统计时间年份',
  `statistics_year_month` varchar(64) DEFAULT NULL COMMENT '统计时间年份月份',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(120) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=544 DEFAULT CHARSET=utf8 COMMENT='平台交易流水';

-- ----------------------------
-- Table structure for store_trade_detail
-- ----------------------------
DROP TABLE IF EXISTS `store_trade_detail`;
CREATE TABLE `store_trade_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易流水id',
  `store_id` int(11) DEFAULT NULL COMMENT '门店ID',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师',
  `store_phone` varchar(24) DEFAULT '123456789' COMMENT '店铺注册的手机号码',
  `store_name` varchar(64) DEFAULT NULL COMMENT '门店名称',
  `beautician_name` varchar(64) DEFAULT NULL COMMENT '美容师名字',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单编号',
  `trade_type` int(11) DEFAULT NULL COMMENT '交易类型(1-服务提成,，2-售卡奖励，3-退款',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `trade_status` int(11) DEFAULT NULL COMMENT '交易状态:0未完成,1-已完成',
  `total_amount` int(11) DEFAULT '0' COMMENT '订单总金额',
  `discounts_amount` int(11) DEFAULT '0' COMMENT '优惠金额',
  `product_price` int(11) DEFAULT '0' COMMENT '服务单价',
  `product_discount` int(11) DEFAULT '0' COMMENT '商品打折折扣',
  `product_name` varchar(64) DEFAULT NULL COMMENT '服务名称',
  `card_price` int(11) DEFAULT '0',
  `card_discount` int(11) DEFAULT '0' COMMENT '会员卡打折折扣',
  `card_name` varchar(64) DEFAULT NULL,
  `actual_pay` int(11) DEFAULT NULL COMMENT '消费者实付',
  `incentive` int(11) DEFAULT '0' COMMENT '销售奖励',
  `member_deduct` int(11) DEFAULT '0' COMMENT '员工提成',
  `net_amount` int(11) DEFAULT '0' COMMENT '净收入',
  `pay_method` int(11) DEFAULT NULL COMMENT '支付方式',
  `pay_rate` int(11) DEFAULT NULL COMMENT '支付比率',
  `settle_amount` int(11) DEFAULT '0' COMMENT '结算金额',
  `reimburse_amount` int(11) DEFAULT '0' COMMENT '退款金额',
  `settlement_time` datetime DEFAULT NULL COMMENT '结算时间',
  `reimburse_time` datetime DEFAULT NULL COMMENT '退款时间',
  `withdraw_amount` int(11) DEFAULT '0' COMMENT '提现申请金额',
  `statistics_year` varchar(24) DEFAULT NULL COMMENT '统计时间年份',
  `statistics_year_month` varchar(24) DEFAULT NULL COMMENT '统计时间年份月份',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(120) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=551 DEFAULT CHARSET=utf8 COMMENT='店铺流水';

-- ----------------------------
-- Table structure for store_trade_statistics
-- ----------------------------
DROP TABLE IF EXISTS `store_trade_statistics`;
CREATE TABLE `store_trade_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `store_name` varchar(64) DEFAULT NULL COMMENT '门店名称',
  `store_phone` varchar(24) DEFAULT NULL COMMENT '门店电话',
  `monthly_order_quantity` int(11) DEFAULT NULL COMMENT '月订单总量',
  `total_sales_this_month` int(11) DEFAULT NULL COMMENT '本月销售总额',
  `service_order` int(11) DEFAULT NULL COMMENT '已服务订单',
  `service_order_amount` int(11) DEFAULT NULL COMMENT '已服务订单金额',
  `order_completed` int(11) DEFAULT NULL COMMENT '已完成订单数',
  `order_completed_amount` int(11) DEFAULT NULL COMMENT '已完成订单总金额',
  `refund_order` int(11) DEFAULT NULL COMMENT '退款订单数',
  `refund_order_amount` int(11) DEFAULT NULL COMMENT '退款总金额',
  `card_number` int(11) DEFAULT NULL COMMENT '会员卡售卡数量',
  `sell_card_rewards` int(11) DEFAULT NULL COMMENT '售卡奖励',
  `on_net_income` int(11) DEFAULT NULL COMMENT '月净收入',
  `play_status` int(11) unsigned DEFAULT NULL COMMENT '打款状态:0未打款,1-已打款',
  `play_time` datetime DEFAULT NULL COMMENT '打款时间',
  `statistics_year` varchar(24) DEFAULT NULL COMMENT '统计时间年份',
  `statistics_year_month` varchar(24) DEFAULT NULL COMMENT '统计时间年份月份',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(120) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='店铺流水统计';
