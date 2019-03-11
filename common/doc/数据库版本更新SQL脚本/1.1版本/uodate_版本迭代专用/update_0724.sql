/*
 Navicat Premium Data Transfer

 Source Server         : amez
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 120.79.42.13:3306
 Source Schema         : beautybond_base

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 25/07/2018 14:57:16
*/


-- ----------------------------
-- 蔡钊铭
-- 2018-07-25
-- ----------------------------

-- beautybond_financial
ALTER TABLE `beautybond_financial`.`store_trade_detail`
MODIFY COLUMN `trade_type` int(11) NULL DEFAULT NULL COMMENT '交易类型(1-服务提成,，2-售卡奖励，3-退款' AFTER `store_id`,
MODIFY COLUMN `trade_status` int(11) NULL DEFAULT 0 COMMENT '交易状态:0未完成,1-已完成' AFTER `trade_type`,
ADD COLUMN `settlement_status` int(11) NULL DEFAULT 0 COMMENT '结算状态:0-待结算 1-已结算' AFTER `trade_status`,
MODIFY COLUMN `beautician_id` int(11) NULL DEFAULT NULL COMMENT '美容师' AFTER `settlement_status`,
MODIFY COLUMN `statistics_year` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务完成时间年份' AFTER `withdraw_amount`,
MODIFY COLUMN `statistics_year_month` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务完成时间年份月份' AFTER `statistics_year`;

ALTER TABLE `beautybond_financial`.`beautician_trade_detail`
MODIFY COLUMN `net_income` int(11) NULL DEFAULT 0 COMMENT '美容师净收入，包括上门费用' AFTER `visit_amount`;

ALTER TABLE `beautybond_financial`.`beautician_trade_detail`
ADD COLUMN `subordinate_status` tinyint(2) NULL COMMENT '店铺流水类型 0-挂靠店铺流水，1-店铺流水 ' AFTER `amount_pay`;

-- beautybond_product
ALTER TABLE `beautybond_product`.`product_beautician_ref`
ADD COLUMN `is_show` tinyint(2) NULL DEFAULT 1 COMMENT '是否展示，1-是，0-否' AFTER `is_order`;

-- beautybond_store
ALTER TABLE `beautybond_store`.`growth_rule_log`
ADD COLUMN `conndition_id` int(11) NULL DEFAULT NULL COMMENT '条件关联id' AFTER `source_id`;

ALTER TABLE `beautybond_store`.`store_beautician_level`
ADD COLUMN `star_value` int(11) NULL COMMENT '美容师星级，范围为0-100' AFTER `id`;


--高伟
-- 2018-7-9
ALTER TABLE `beautybond_order`.`order_return` CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER TABLE `beautybond_order`.`order_return` MODIFY COLUMN `remark`  text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

--2018-7-12
ALTER TABLE `beautybond_order`.`order_base`
ADD COLUMN `beautician_reply_comment_status`  tinyint(2) NULL DEFAULT 0 COMMENT '美容师回复评论状态（0：默认，1：用户已评价，美容师未回复，2：用户已评价，美容师已回复）' AFTER `status`;

--2018-7-17
ALTER TABLE `beautybond_order`.`order_base`
ADD COLUMN `coupon_id`  int(11) NULL DEFAULT NULL COMMENT '优惠券ID' AFTER `one_card_reduce`;

--2018-7-18
ALTER TABLE `beautybond_order`.`order_base` ADD one_card_discount int DEFAULT 0 NULL COMMENT '一卡通折扣（以100为基数）';
ALTER TABLE `beautybond_order`.`order_base` MODIFY COLUMN one_card_discount int DEFAULT 0 COMMENT '一卡通折扣（以100为基数）' AFTER member_card_reduce;

--2018-7-19
ALTER TABLE `beautybond_order`.`order_return` MODIFY store_id int(11) unsigned DEFAULT null  COMMENT '店铺id';
ALTER TABLE `beautybond_order`.`order_base` ALTER COLUMN beautician_reply_comment_status SET DEFAULT 0;
ALTER TABLE `beautybond_order`.`order_base` ALTER COLUMN anchored_store_id SET DEFAULT null;

--2018-7-25
ALTER TABLE `beautybond_order`.`order_comment` ADD beautician_evaluation_grade tinyint(2) DEFAULT 0 NULL COMMENT '美容师评价等级(0：未评价，1：差评，2：中评，3：好评，4：系统默认好评)';
ALTER TABLE `beautybond_order`.`order_comment` MODIFY COLUMN beautician_evaluation_grade tinyint(2) DEFAULT 0 COMMENT '美容师评价等级(0：未评价，1：差评，2：中评，3：好评，4：系统默认好评)' AFTER product_evaluation_grade;

ALTER TABLE `beautybond_order`.`order_comment` ADD beautician_id int DEFAULT null  NULL COMMENT '订单美容师ID';
ALTER TABLE`beautybond_order`.`order_comment` MODIFY COLUMN beautician_id int DEFAULT null  COMMENT '订单美容师ID' AFTER order_no;


--2018-07-27--houji
ALTER TABLE `beautybond_base`.`base_umeng_push_history`
	ADD COLUMN `target` INT(11) NULL DEFAULT NULL COMMENT '跳转类型(系统消息招募挂靠跳转参数)' AFTER `push_text`;
ALTER TABLE `beautybond_base`.`base_umeng_push_history`
	ADD COLUMN `param` VARCHAR(200) NULL DEFAULT NULL COMMENT '参数(系统消息招募挂靠内容参数)' AFTER `target`;
