/*
Navicat MySQL Data Transfer

Source Server         : 艾美-美容邦测试数据库
Source Server Version : 50720
Source Host           : 120.79.42.13:3306
Source Database       : beautybond_member

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-04 16:48:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `im_user_id` int(11) DEFAULT NULL COMMENT 'IM用户ID',
  `amez_uuid` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '艾美UUID',
  `im_username` varchar(60) DEFAULT NULL COMMENT 'IM用户名',
  `amez_user_id` int(11) NOT NULL COMMENT '艾美会员ID',
  `open_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '微信openId',
  `member_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '会员名称',
  `member_nickname` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '会员昵称',
  `gender` tinyint(1) DEFAULT '0' COMMENT '性别（0：男，1：女）',
  `member_img_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '会员头像地址',
  `person_signature` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '个人签名',
  `register_phone` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '注册手机号',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `member_level` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '等级',
  `device_tokens` varchar(100) DEFAULT NULL COMMENT '手机设备号(UDID)',
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `amez_user_id` (`amez_user_id`),
  UNIQUE KEY `register_phone` (`register_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=905 DEFAULT CHARSET=utf8mb4 COMMENT='美容邦用户表';

-- ----------------------------
-- Table structure for member_address
-- ----------------------------
DROP TABLE IF EXISTS `member_address`;
CREATE TABLE `member_address` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `member_id` int(11) unsigned NOT NULL COMMENT '会员id',
  `city_id` int(11) unsigned DEFAULT NULL COMMENT '城市id',
  `receiver` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货人姓名',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '手机号码',
  `regson` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '省市县地区 空格隔开',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '详细地址',
  `longitude` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '经度',
  `latitude` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '纬度',
  `is_default` int(2) DEFAULT '0' COMMENT '是否默认地址，0不是，1是',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `door_number` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '门牌号',
  `identification` int(11) DEFAULT '0' COMMENT '身份标识(0--会员 1--美容师，2--店长 默认为0)',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='会员地址';

-- ----------------------------
-- Table structure for member_bank_card
-- ----------------------------
DROP TABLE IF EXISTS `member_bank_card`;
CREATE TABLE `member_bank_card` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `member_id` int(11) DEFAULT NULL COMMENT '会员ID',
  `bankcard` varchar(50) DEFAULT NULL COMMENT '银行卡号码',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `card_no` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(50) DEFAULT NULL COMMENT '银行预留手机号码',
  `abbreviation` varchar(50) DEFAULT NULL COMMENT '银行卡所属银行拼音大写缩写(CGB)',
  `bankimage` varchar(50) DEFAULT NULL COMMENT '银行图标',
  `bankname` varchar(50) DEFAULT NULL COMMENT '银行名称',
  `bankurl` varchar(50) DEFAULT NULL COMMENT '银行卡官网网址',
  `cardname` varchar(50) DEFAULT NULL COMMENT '银行卡卡名字',
  `cardtype` varchar(50) DEFAULT NULL COMMENT '银行卡类型(银联贷记卡)',
  `enbankname` varchar(50) DEFAULT NULL COMMENT '所属银行缩写的拼音(China Guangfa Bank)',
  `is_luhn` tinyint(1) DEFAULT NULL,
  `iscreditcard` int(11) DEFAULT NULL COMMENT '信用卡类型',
  `servicephone` varchar(50) DEFAULT NULL COMMENT '银行客服电话',
  `type` tinyint(1) DEFAULT '0' COMMENT '类型(0：个人，1：公司，默认0)',
  `third_auth_status` tinyint(2) DEFAULT '0' COMMENT '第三方实名验证结果(0 --未验证 1 --验证通过 2--验证不通过)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `bankcard` (`bankcard`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COMMENT='会员银行卡表';

-- ----------------------------
-- Table structure for member_card
-- ----------------------------
DROP TABLE IF EXISTS `member_card`;
CREATE TABLE `member_card` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `style_pattern` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '样式图案',
  `issue_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '发行类型(0:品牌连锁,1:门店自营),默认0',
  `brand_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '品牌ID',
  `brand_name` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '品牌名称',
  `card_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '卡名称',
  `sell_status` tinyint(2) DEFAULT '0' COMMENT '销售状态(0:销售中,1:已下架，2：已失效)',
  `support_recharge` tinyint(1) DEFAULT '0' COMMENT '支持充值(0:支持,1:不支持)',
  `use_range` tinyint(1) DEFAULT '0' COMMENT '使用范围(0:多店,1:单店,2：全国通用),默认0',
  `card_no` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '会员卡编号',
  `store_id` int(11) DEFAULT NULL COMMENT '门店ID',
  `store_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '门店名称',
  `issue_num` int(11) unsigned DEFAULT NULL COMMENT '发行数量',
  `balance` int(11) unsigned DEFAULT '0' COMMENT '面值（以分为单位存入）',
  `discount` int(11) unsigned DEFAULT '0' COMMENT '折扣',
  `effective_type` tinyint(2) DEFAULT '0' COMMENT '有效类型(0:永久有效，1：有效日期，2：有效天数)',
  `effective_day` int(11) DEFAULT '0' COMMENT '有效天数(以天为单位)',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `use_start_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '会员卡开始使用时间',
  `expired_time` datetime DEFAULT NULL COMMENT '过期时间',
  `remark` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '说明(会员卡的介绍，使用须知)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COMMENT='会员卡';

-- ----------------------------
-- Table structure for member_card_ref
-- ----------------------------
DROP TABLE IF EXISTS `member_card_ref`;
CREATE TABLE `member_card_ref` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `member_id` int(11) DEFAULT NULL COMMENT '会员ID',
  `card_id` int(11) DEFAULT NULL COMMENT '会员卡ID',
  `member_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '会员名称',
  `member_mobile` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '会员手机号码',
  `total_balance` int(11) unsigned DEFAULT '0' COMMENT '总金额（以分为单位存入）',
  `useable_balance` int(11) unsigned DEFAULT '0' COMMENT '可用金额（以分为单位存入）',
  `frozen_balance` int(11) unsigned DEFAULT '0' COMMENT '冻结金额（以分为单位存入）',
  `is_enabled` tinyint(2) DEFAULT '0' COMMENT '使用状态(0：正常，1：被冻结，2：已作废)',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `expired_time` timestamp NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COMMENT='用户会员卡表';

-- ----------------------------
-- Table structure for member_card_template
-- ----------------------------
DROP TABLE IF EXISTS `member_card_template`;
CREATE TABLE `member_card_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `parent_group_id` int(11) DEFAULT '0' COMMENT '卡面模板分类父类id',
  `parent_group_name` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '卡面模板分类父类名称',
  `parent_group_count` int(11) DEFAULT '0' COMMENT '卡面模板父类图片数量',
  `bg_img_url` varchar(100) DEFAULT NULL COMMENT '卡面模板背景图片',
  `is_enabled` varchar(2) NOT NULL DEFAULT '0' COMMENT '软删除 0--正常 1--删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=latin1 COMMENT='会员卡卡面模板表';

-- ----------------------------
-- Table structure for member_card_trade_recode
-- ----------------------------
DROP TABLE IF EXISTS `member_card_trade_recode`;
CREATE TABLE `member_card_trade_recode` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `is_platform` tinyint(1) NOT NULL DEFAULT '0' COMMENT '售卡单位(0：平台，1：店铺)',
  `issue_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '发卡方名称',
  `member_id` int(11) DEFAULT NULL COMMENT '会员ID',
  `member_card_id` int(11) DEFAULT NULL COMMENT '会员卡ID',
  `member_card_ref_id` int(11) DEFAULT NULL COMMENT '会员拥有的会员卡ID',
  `member_card_no` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '会员卡号',
  `trade_amount` int(11) DEFAULT '0' COMMENT '交易金额（以分为单位存入）',
  `use_type` tinyint(2) DEFAULT '0' COMMENT '0:充值，1：消费(默认0),2:购卡',
  `use_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '交易时间',
  `store_id` int(11) DEFAULT NULL COMMENT '门店ID',
  `store_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '门店名称',
  `order_no` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '会员卡充值订单',
  `trade_no` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '交易流水号',
  `pay_type` tinyint(2) DEFAULT '0' COMMENT '交易类型(0:微信支付，1：支付宝支付，2：其他)',
  `pay_status` tinyint(2) DEFAULT '0' COMMENT '支付状态(0:未支付，1：已支付)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=259 DEFAULT CHARSET=utf8mb4 COMMENT='会员卡交易记录';

-- ----------------------------
-- Table structure for member_card_use_product
-- ----------------------------
DROP TABLE IF EXISTS `member_card_use_product`;
CREATE TABLE `member_card_use_product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `card_id` int(11) NOT NULL COMMENT '会员卡ID',
  `product_id` int(11) NOT NULL COMMENT '商品ID',
  `product_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '商品名称',
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3008 DEFAULT CHARSET=utf8mb4 COMMENT='会员卡适用服务表';

-- ----------------------------
-- Table structure for member_card_use_range
-- ----------------------------
DROP TABLE IF EXISTS `member_card_use_range`;
CREATE TABLE `member_card_use_range` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `card_id` int(11) DEFAULT NULL COMMENT '会员卡ID',
  `store_id` int(11) DEFAULT NULL COMMENT '可使用门店ID',
  `store_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '可使用门店名称',
  `disable` int(11) DEFAULT '0' COMMENT '是否启用 0--正常 1--门店关闭 2--卡失效',
  `card_status` tinyint(2) DEFAULT '1' COMMENT '会员卡状态：0-冻结，1-正常',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=603 DEFAULT CHARSET=utf8mb4 COMMENT='会员卡使用范围';

-- ----------------------------
-- Table structure for member_level
-- ----------------------------
DROP TABLE IF EXISTS `member_level`;
CREATE TABLE `member_level` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) unsigned NOT NULL COMMENT '会员ID',
  `grade` tinyint(10) NOT NULL DEFAULT '1' COMMENT '会员级别',
  `grade_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '会员级别名称',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员级别';

-- ----------------------------
-- Table structure for member_level_upgrade
-- ----------------------------
DROP TABLE IF EXISTS `member_level_upgrade`;
CREATE TABLE `member_level_upgrade` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `level_upgrade_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '升级规则名',
  `level_upgrade_condition` int(11) unsigned DEFAULT NULL COMMENT '升级条件',
  `level_upgrade_value` int(11) unsigned DEFAULT NULL COMMENT '对应成长值',
  `sequence` int(11) unsigned DEFAULT NULL COMMENT '排序',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员成长值规则设置';

-- ----------------------------
-- Table structure for member_level_upgrade_log
-- ----------------------------
DROP TABLE IF EXISTS `member_level_upgrade_log`;
CREATE TABLE `member_level_upgrade_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) unsigned NOT NULL COMMENT '会员ID',
  `member_level_upgrade_id` int(11) unsigned NOT NULL COMMENT '会员成长会规则ID',
  `level_upgrade_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '升级规则名',
  `condition` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '当前规则所需条件',
  `value` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '当前规则的成长值',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='会员成长值记录';

-- ----------------------------
-- Table structure for member_real_name_auth
-- ----------------------------
DROP TABLE IF EXISTS `member_real_name_auth`;
CREATE TABLE `member_real_name_auth` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `member_id` int(11) NOT NULL COMMENT '会员ID',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `id_card` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '身份证号码',
  `id_card_faced_photo` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '身份证正面照',
  `id_card_observe_phone` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '身份证反面照',
  `id_card_handheld_phone` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '身份证手持照',
  `audit_status` tinyint(2) DEFAULT '0' COMMENT '审核状态(0:待审核，1：审核通过，2：审核未通过)',
  `third_auth_status` tinyint(2) DEFAULT '0' COMMENT '第三方实名认证状态(0: 未认证 1：认证通过 2：认证不通过)',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_remark` varchar(200) DEFAULT NULL COMMENT '审核说明',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_card` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COMMENT='会员卡实名认证表';

-- ----------------------------
-- Table structure for member_withdraws
-- ----------------------------
DROP TABLE IF EXISTS `member_withdraws`;
CREATE TABLE `member_withdraws` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `member_id` int(11) NOT NULL COMMENT '会员ID',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师ID',
  `member_real_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '提现人姓名',
  `member_phone` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '提现人手机号',
  `belong_store_id` int(11) DEFAULT NULL COMMENT '所属门店ID',
  `belong_store_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '所属门店名称',
  `withdraw_amount` int(11) DEFAULT NULL COMMENT '提现申请金额',
  `tax_rate` tinyint(2) DEFAULT '3' COMMENT '税率(百分比，默认百分之3)',
  `taxation` int(11) DEFAULT '0' COMMENT '税费',
  `actual_amount` int(11) DEFAULT NULL COMMENT '实际提现金额(扣除手续费后)',
  `bank_card_id` int(11) DEFAULT NULL COMMENT '提现银行卡ID',
  `bank_card_no` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '会员银行卡号码',
  `play_amount_status` tinyint(1) DEFAULT '0' COMMENT '打款状态(0：未打款，1：已打款)',
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '提现申请时间',
  `play_amount_time` datetime DEFAULT NULL COMMENT '打款时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COMMENT='会员提现申请表';
