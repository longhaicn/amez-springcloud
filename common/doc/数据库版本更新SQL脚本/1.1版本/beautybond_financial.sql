


-- ----------------------------
-- store_trade_statistics
-- ----------------------------
ALTER TABLE `beautybond_financial`.`store_trade_statistics`
ADD COLUMN `reconciliation_type` tinyint(2) NULL DEFAULT 0 COMMENT '对账流水状态 0-初始状态（无按钮），1-对账确认，2-提现申请，3-提交提现申请，4-已提现' AFTER `on_net_income`;

ALTER TABLE `beautybond_financial`.`store_trade_statistics`
ADD COLUMN `reconciliation_amount` int(11) NULL COMMENT '对账金额' AFTER `on_net_income`;

ALTER TABLE `beautybond_financial`.`store_trade_statistics`
MODIFY COLUMN `play_status` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '打款状态:0未打款,1-已打款' AFTER `reconciliation_type`;

ALTER TABLE `beautybond_financial`.`store_trade_statistics`
MODIFY COLUMN `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' AFTER `statistics_year_month`,
MODIFY COLUMN `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间' AFTER `create_time`;

ALTER TABLE `beautybond_financial`.`store_trade_statistics`
MODIFY COLUMN `play_status` int(11) NULL DEFAULT 0 COMMENT '打款状态:0未打款,1-已打款' AFTER `reconciliation_type`;

-- ----------------------------
-- storeship_withdrawal
-- ----------------------------

ALTER TABLE `beautybond_financial`.`storeship_withdrawal`
CHANGE COLUMN `type_name` `withdrawal_amount` int(0) NULL DEFAULT NULL COMMENT '提现金额' AFTER `store_id`,
CHANGE COLUMN `remaining_balance` `remaining_amount` int(0) NULL DEFAULT NULL COMMENT '剩下余额' AFTER `withdrawal_amount`,
ADD COLUMN `arrive_time` timestamp(0) NULL DEFAULT NULL COMMENT '到账时间' AFTER `withdrawal_status`,
MODIFY COLUMN `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' AFTER `statistics_year_month`,
MODIFY COLUMN `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间' AFTER `create_time`;
ALTER TABLE `beautybond_financial`.`storeship_withdrawal`
MODIFY COLUMN `number_bank_slip` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流水单号' AFTER `remaining_amount`;


-- ----------------------------
-- beautician_trade_detail
-- ----------------------------

ALTER TABLE `beautybond_financial`.`beautician_trade_detail`
ADD COLUMN `beautician_type` tinyint(2) NULL COMMENT '美容师类型，0-兼职，1-全职' AFTER `beautician_phone`;

ALTER TABLE `beautybond_financial`.`beautician_trade_detail`
MODIFY COLUMN `beautician_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '美容师名字' AFTER `store_name`;

ALTER TABLE `beautybond_financial`.`beautician_trade_detail`
MODIFY COLUMN `trade_type` int(11) NULL DEFAULT NULL COMMENT '交易类型(1-服务订单提成,2-提现,3-退款)' AFTER `order_no`;

ALTER TABLE `beautybond_financial`.`beautician_trade_detail`
MODIFY COLUMN `trade_status` int(11) NULL DEFAULT 0 COMMENT '交易状态:0-未完成,1-已完成' AFTER `pay_time`,
MODIFY COLUMN `play_amount_status` tinyint(4) NULL DEFAULT 0 COMMENT '打款状态(0：未打款，1：已打款)' AFTER `play_amount_time`;

ALTER TABLE `beautybond_financial`.`beautician_trade_detail`
MODIFY COLUMN `bank_name` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行名称' AFTER `actual_amount`;

DROP TABLE IF EXISTS `store_subordinate_trade_detail`;
CREATE TABLE `store_subordinate_trade_detail` (
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
) ENGINE=InnoDB AUTO_INCREMENT=631 DEFAULT CHARSET=utf8 COMMENT='店铺挂靠流水';

DROP TABLE IF EXISTS `storeship_withdrawal`;
CREATE TABLE `storeship_withdrawal` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_id` int(11) DEFAULT NULL COMMENT '商店id',
  `withdrawal_amount` int(11) DEFAULT NULL COMMENT '提现金额',
  `remaining_amount` int(11) DEFAULT NULL COMMENT '剩下余额',
  `number_bank_slip` varchar(120) DEFAULT NULL COMMENT '流水单号',
  `bank` varchar(120) DEFAULT NULL COMMENT '开户行',
  `user_name` varchar(120) DEFAULT NULL COMMENT '户名',
  `account_number` varchar(64) DEFAULT NULL COMMENT '账号',
  `withdrawal_status` tinyint(4) DEFAULT NULL COMMENT '提现状态 1-没到帐,2-已到帐',
  `arrive_time` timestamp NULL DEFAULT NULL COMMENT '到账时间',
  `statistics_year` varchar(24) DEFAULT NULL COMMENT '统计时间年份',
  `statistics_year_month` varchar(24) DEFAULT NULL COMMENT '统计时间年份月份',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remarks` varchar(120) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='店铺提现';


alter table beautybond_financial.commission_setting add commission_code varchar(64) comment '佣金比例编码';



-- ----------------------------
-- 2018-06-29
-- ----------------------------
ALTER TABLE `beautybond_financial`.`beautician_trade_detail`
ADD COLUMN `amount_pay` int(11) NULL DEFAULT NULL COMMENT '实际支付金额' AFTER `remarks`;


-- ----------------------------
-- 2018-07-13
-- ----------------------------
ALTER TABLE `beautybond_financial`.`store_trade_detail`
MODIFY COLUMN `trade_type` int(11) NULL DEFAULT NULL COMMENT '交易类型(1-服务提成,，2-售卡奖励，3-退款' AFTER `store_id`,
MODIFY COLUMN `trade_status` int(11) NULL DEFAULT 0 COMMENT '交易状态:0未完成,1-已完成' AFTER `trade_type`,
ADD COLUMN `settlement_status` int(11) NULL DEFAULT 0 COMMENT '结算状态:0-待结算 1-已结算' AFTER `trade_status`,
MODIFY COLUMN `beautician_id` int(11) NULL DEFAULT NULL COMMENT '美容师' AFTER `settlement_status`,
MODIFY COLUMN `statistics_year` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务完成时间年份' AFTER `withdraw_amount`,
MODIFY COLUMN `statistics_year_month` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务完成时间年份月份' AFTER `statistics_year`;

-- ----------------------------
-- 2018-07-25
-- ----------------------------
ALTER TABLE `beautybond_financial`.`beautician_trade_detail`
MODIFY COLUMN `net_income` int(11) NULL DEFAULT 0 COMMENT '美容师净收入，包括上门费用' AFTER `visit_amount`;

ALTER TABLE `beautybond_financial`.`beautician_trade_detail`
ADD COLUMN `subordinate_status` tinyint(2) NULL COMMENT '店铺流水类型 0-挂靠店铺流水，1-店铺流水 ' AFTER `amount_pay`;


-- ----------------------------
-- 2018-08-06
-- ----------------------------

ALTER TABLE `beautybond_financial`.`store_trade_detail`
MODIFY COLUMN `statistics_year` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务时间年份' AFTER `withdraw_amount`,
MODIFY COLUMN `statistics_year_month` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务时间年份月份' AFTER `statistics_year`;



-- ----------------------------
-- 2018-08-23
-- ----------------------------
ALTER TABLE `beautybond_financial`.`store_trade_detail`
MODIFY COLUMN `settlement_time` datetime(0) NULL DEFAULT NULL COMMENT '结算时间(最终完成服务时间)' AFTER `reimburse_amount`;
ALTER TABLE `beautybond_financial`.`store_subordinate_trade_detail`
MODIFY COLUMN `settlement_time` datetime(0) NULL DEFAULT NULL COMMENT '结算时间(最终完成服务时间)' AFTER `reimburse_amount`;
ALTER TABLE `beautybond_financial`.`beautician_trade_detail`
MODIFY COLUMN `settlement_time` datetime(0) NULL DEFAULT NULL COMMENT '结算时间(最终完成服务时间)' AFTER `pay_rate`;