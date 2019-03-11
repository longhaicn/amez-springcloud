/*
Navicat MySQL Data Transfer

Source Server         : 艾美-美容邦测试数据库
Source Server Version : 50720
Source Host           : 120.79.42.13:3306
Source Database       : beautybond_store

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-04 16:49:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `store_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '店铺名称',
  `store_company_name` varchar(60) DEFAULT NULL COMMENT '店铺公司名称',
  `store_auth` tinyint(1) DEFAULT '0' COMMENT '店铺认证',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌ID',
  `brand_name` varchar(60) DEFAULT NULL COMMENT '品牌名称',
  `store_level` int(11) DEFAULT '1' COMMENT '店铺级别',
  `level_id` int(11) DEFAULT NULL COMMENT '级别ID',
  `level_name` varchar(60) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '级别名称',
  `level_logo` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '级别图标',
  `growup_value` int(11) NOT NULL DEFAULT '0' COMMENT '店铺成长值',
  `sc_id` int(11) NOT NULL DEFAULT '0' COMMENT '店铺分类 0默认 1老店 2精选门店',
  `manage_year` int(11) NOT NULL DEFAULT '0' COMMENT '经营年限',
  `store_label` varchar(255) DEFAULT NULL COMMENT '店铺标签 十年老店，五年老店',
  `special_project` varchar(255) DEFAULT NULL COMMENT '特色项目',
  `store_sales` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '店铺销量',
  `boss_user_id` int(11) DEFAULT NULL COMMENT '老板ID',
  `boss_phone` varchar(50) DEFAULT NULL COMMENT '老板手机号码',
  `boss_name` varchar(50) DEFAULT NULL COMMENT '老板账号',
  `seller_user_id` int(11) DEFAULT NULL COMMENT '店长ID',
  `seller_phone` varchar(50) DEFAULT NULL COMMENT '店长手机号码',
  `seller_name` varchar(50) DEFAULT NULL COMMENT '店长账号',
  `product_id` int(11) DEFAULT NULL COMMENT '省ID',
  `city_id` int(11) DEFAULT NULL COMMENT '市ID',
  `area_id` int(11) DEFAULT NULL COMMENT '区ID',
  `province_name` varchar(60) DEFAULT NULL COMMENT '省名称',
  `city_name` varchar(60) DEFAULT NULL COMMENT '市名称',
  `area_name` varchar(60) DEFAULT NULL COMMENT '县城市',
  `store_longitude` decimal(10,7) DEFAULT NULL COMMENT '经度，长度10位，小数点后7位',
  `store_latitude` decimal(10,7) DEFAULT NULL COMMENT '纬度，长度10位，小数点后7位',
  `store_address` varchar(200) DEFAULT NULL COMMENT '详细地区',
  `store_zip` varchar(10) DEFAULT NULL COMMENT '邮政编码',
  `store_tel` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `store_logo` varchar(200) DEFAULT NULL COMMENT '店铺LOGO',
  `store_time` varchar(30) DEFAULT NULL COMMENT '店铺营业时间',
  `store_state` tinyint(2) NOT NULL DEFAULT '2' COMMENT '店铺状态，0关闭，1开启，2待审核，3冻结',
  `store_close_info` varchar(255) DEFAULT NULL COMMENT '店铺关闭原因',
  `store_end_time` varchar(10) DEFAULT NULL COMMENT '店铺关闭时间',
  `store_sort` int(11) NOT NULL DEFAULT '0' COMMENT '店铺排序',
  `store_banner` varchar(255) DEFAULT NULL COMMENT '店铺横幅',
  `store_desccredit` float NOT NULL DEFAULT '100' COMMENT '环境满意度分数',
  `store_servicecredit` float NOT NULL DEFAULT '100' COMMENT '服务满意度分数',
  `store_keywords` varchar(255) NOT NULL DEFAULT '' COMMENT '店铺seo关键字',
  `store_description` varchar(255) NOT NULL DEFAULT '' COMMENT '店铺seo描述',
  `description` varchar(255) DEFAULT NULL COMMENT '店铺简介',
  `store_zy` varchar(255) DEFAULT NULL COMMENT '主营商品',
  `store_domain` varchar(255) DEFAULT NULL COMMENT '店铺域名',
  `store_recommend` tinyint(1) NOT NULL DEFAULT '0' COMMENT '推荐，0为否，1为是，默认为0',
  `store_theme` varchar(50) NOT NULL DEFAULT 'default' COMMENT '店铺当前主题',
  `store_credit` int(10) NOT NULL DEFAULT '0' COMMENT '店铺信用',
  `praise_rate` float NOT NULL DEFAULT '0' COMMENT '店铺好评率',
  `store_slide` varchar(255) DEFAULT NULL COMMENT '店铺幻灯片',
  `store_slide_url` varchar(255) DEFAULT NULL COMMENT '店铺幻灯片链接',
  `store_storage_alarm` int(11) unsigned NOT NULL DEFAULT '10' COMMENT '库存警报',
  `follower_total` int(11) DEFAULT '0' COMMENT '粉丝数量',
  `beautician_total` int(11) DEFAULT '0' COMMENT '美容师数量',
  `account_balance` int(11) DEFAULT '0' COMMENT '账户余额',
  `pre_income_amount` int(11) DEFAULT '0' COMMENT '预收入金额',
  `is_old` tinyint(1) DEFAULT '0' COMMENT '老店标记，1-是，0-否',
  `is_select` tinyint(1) DEFAULT '0' COMMENT '精选标记，1-是，0-否',
  `select_sort` int(11) DEFAULT NULL COMMENT '精选排序',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `store_name` (`store_name`) USING BTREE,
  KEY `sc_id` (`sc_id`) USING BTREE,
  KEY `area_id` (`area_id`) USING BTREE,
  KEY `store_state` (`store_state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=762 DEFAULT CHARSET=utf8 COMMENT='店铺';

-- ----------------------------
-- Table structure for store_beautician
-- ----------------------------
DROP TABLE IF EXISTS `store_beautician`;
CREATE TABLE `store_beautician` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `store_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店铺名称',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `member_id` int(11) DEFAULT NULL COMMENT '会员ID',
  `im_user_id` int(11) DEFAULT NULL COMMENT 'IM用户ID',
  `im_username` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'IM用户名',
  `beautician_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `beautician_nick_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `head_img_url` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `sex` tinyint(2) DEFAULT '2' COMMENT '性别，1-男，2-女',
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `work_card_no` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '工牌号',
  `birth_date` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '出生日期',
  `entry_date` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '入职日期',
  `province_id` int(11) DEFAULT NULL COMMENT '省ID',
  `city_id` int(11) DEFAULT NULL COMMENT '市ID',
  `area_id` int(11) DEFAULT NULL COMMENT '县ID',
  `province_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省名称',
  `city_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '市名称',
  `area_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '县名称',
  `address` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细地址',
  `beautician_type` tinyint(2) DEFAULT '2' COMMENT '员工类型，0-老板，1-店长，2-正式员工，3-兼职员工',
  `years` int(11) DEFAULT '0' COMMENT '从业年限',
  `beautician_status` tinyint(2) DEFAULT '1' COMMENT '状态，0-离职，1-在职，2-休息',
  `beautician_level` tinyint(2) DEFAULT '1' COMMENT '美容师等级，1-初级美容师，2-中级美容师，3-高级美容师，4-资深美容师',
  `is_service` tinyint(1) DEFAULT '0' COMMENT '客服标记，1-是，0-否',
  `is_star` tinyint(1) DEFAULT '0' COMMENT '明星标记，1-是，0-否',
  `star_sort` int(11) DEFAULT NULL COMMENT '明星排序',
  `audit_status` tinyint(2) unsigned zerofill DEFAULT '00' COMMENT '审核状态，0-待审核，1-已审核，2-不通过',
  `audit_reason` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '审核原因',
  `is_support_store` tinyint(1) DEFAULT '0' COMMENT '支持到店标记，1-是，0-否',
  `is_support_home` tinyint(1) DEFAULT '0' COMMENT '支持上门标记，1-是，0-否',
  `account_balance` int(11) DEFAULT '0' COMMENT '账户余额',
  `pre_income_amount` int(11) DEFAULT '0' COMMENT '预收入金额',
  `beautician_star` int(11) DEFAULT '20' COMMENT '美容师星级，范围为0-100',
  `satisfaction` int(11) DEFAULT '100' COMMENT '满意度，范围为0-100',
  `level_id` int(11) DEFAULT NULL COMMENT '级别ID',
  `level_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '级别名称',
  `level_logo` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '级别图标',
  `growup_value` int(11) DEFAULT '0' COMMENT '成长值',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  KEY `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=857 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='店铺美容师';

-- ----------------------------
-- Table structure for store_beautician_level
-- ----------------------------
DROP TABLE IF EXISTS `store_beautician_level`;
CREATE TABLE `store_beautician_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `level_name` varchar(60) CHARACTER SET utf8 DEFAULT NULL COMMENT '级别名称',
  `level_logo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '级别图标',
  `begin_upgrade_value` int(11) DEFAULT NULL COMMENT '开始成长值',
  `end_upgrade_value` int(11) DEFAULT NULL COMMENT '结束成长值',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1 COMMENT='美容师级别';

-- ----------------------------
-- Table structure for store_beautician_level_upgrade_log
-- ----------------------------
DROP TABLE IF EXISTS `store_beautician_level_upgrade_log`;
CREATE TABLE `store_beautician_level_upgrade_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_id` int(11) unsigned NOT NULL COMMENT '门店ID',
  `store_level_upgrade_id` int(11) unsigned NOT NULL COMMENT '门店成长会规则ID',
  `level_upgrade_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '升级规则名',
  `condition` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '当前规则所需条件',
  `value` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '当前规则的成长值',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='美容师成长值记录';

-- ----------------------------
-- Table structure for store_beautician_level_upgrade_rule
-- ----------------------------
DROP TABLE IF EXISTS `store_beautician_level_upgrade_rule`;
CREATE TABLE `store_beautician_level_upgrade_rule` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `level_upgrade_type` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '升级规则类型，1-日接单频率，2-月接单总金额，3-回复评价次数，4-好评量，5-发帖量',
  `level_upgrade_condition` int(11) unsigned DEFAULT NULL COMMENT '升级条件',
  `level_upgrade_value` int(11) unsigned DEFAULT NULL COMMENT '对应成长值',
  `sort` int(11) unsigned DEFAULT NULL COMMENT '排序',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=latin1 COMMENT='美容师成长值规则设置';

-- ----------------------------
-- Table structure for store_chain_brand
-- ----------------------------
DROP TABLE IF EXISTS `store_chain_brand`;
CREATE TABLE `store_chain_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `brand_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '品牌名称',
  `brand_logo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '品牌LOGO',
  `brand_ownership_company` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '品牌所属公司',
  `store_total` int(11) DEFAULT '0' COMMENT '门店总数',
  `product_total` int(11) DEFAULT '0' COMMENT '服务项目总数',
  `remark` text COLLATE utf8mb4_unicode_ci COMMENT '备注',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='店铺连锁品牌';

-- ----------------------------
-- Table structure for store_coupons
-- ----------------------------
DROP TABLE IF EXISTS `store_coupons`;
CREATE TABLE `store_coupons` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `store_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店铺名称',
  `coupon_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '优惠券名称',
  `issued_total` int(11) DEFAULT '0' COMMENT '发放总数',
  `received_total` int(11) DEFAULT '0' COMMENT '领取总数',
  `used_total` int(11) DEFAULT '0' COMMENT '使用总数',
  `meet_amount` int(11) DEFAULT '0' COMMENT '满足金额',
  `discount_amount` int(11) DEFAULT '0' COMMENT '优惠金额',
  `support_service_type` tinyint(2) DEFAULT '1' COMMENT '服务类型，1=全部服务，2=部分服务',
  `begin_time` timestamp NULL DEFAULT NULL COMMENT '生效时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '过期时间',
  `per_person_limit` int(11) DEFAULT '0' COMMENT '每人限领(0:无限制)',
  `expired_remind_switch` tinyint(1) DEFAULT '0' COMMENT '到期提醒开关',
  `instructions` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用说明',
  `is_received` tinyint(1) DEFAULT '1' COMMENT '领取标记，1为正常，0为领完',
  `coupon_status` tinyint(2) DEFAULT '0' COMMENT '优惠券状态，0-未开始，1-活动中，2-已结束',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=latin1 COMMENT='店铺优惠券';

-- ----------------------------
-- Table structure for store_coupons_product
-- ----------------------------
DROP TABLE IF EXISTS `store_coupons_product`;
CREATE TABLE `store_coupons_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `store_coupons_id` int(11) DEFAULT NULL COMMENT '店铺优惠券ID',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `store_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店铺名称',
  `product_id` int(11) DEFAULT NULL COMMENT '服务ID',
  `product_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '服务名称',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1098 DEFAULT CHARSET=latin1 COMMENT='店铺优惠券-服务关联';

-- ----------------------------
-- Table structure for store_coupons_received
-- ----------------------------
DROP TABLE IF EXISTS `store_coupons_received`;
CREATE TABLE `store_coupons_received` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `store_coupons_id` int(11) DEFAULT NULL COMMENT '店铺优惠券ID',
  `coupon_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '优惠券号码',
  `order_no` varchar(36) DEFAULT NULL COMMENT '订单编号',
  `used_product_id` int(11) DEFAULT NULL COMMENT '使用商品ID',
  `used_product_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用商品名称',
  `used_time` timestamp NULL DEFAULT NULL COMMENT '使用时间',
  `is_used` tinyint(1) DEFAULT '1' COMMENT '使用标记，1为正常，0为使用',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_member_id` int(11) DEFAULT NULL COMMENT '创建会员ID',
  `create_member_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建会员名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=latin1 COMMENT='店铺优惠券领取';

-- ----------------------------
-- Table structure for store_extend
-- ----------------------------
DROP TABLE IF EXISTS `store_extend`;
CREATE TABLE `store_extend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `contract` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '合同',
  `company_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公司名称',
  `business_license_number` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '营业执照号码',
  `legal_person_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '法人姓名',
  `legal_person_idcard` varchar(18) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '法人身份证号码',
  `era_bank` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业收款账号-开户银行',
  `era_area` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业收款账号-开户地区',
  `era_bank_branch` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业收款账号-支行名称',
  `era_company_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业收款账号-公司名称',
  `era_bank_card_number` varchar(21) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业收款账号-银行卡号',
  `pra_bank` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商户个人收款账号-开户银行',
  `pra_area` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商户个人收款账号-开户地区',
  `pra_bank_branch` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商户个人收款账号-支行名称',
  `pra_account_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商户个人收款账号-开户名称',
  `pra_bank_card_number` varchar(21) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商户个人收款账号-银行卡号',
  `business_license` text COLLATE utf8mb4_unicode_ci COMMENT '营业执照',
  `idcard_positive_photo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证正面照',
  `idcard_negative_photo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证反面照',
  `idcard_handheld_photo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证手持照',
  `store_door_photo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店门照',
  `store_cashier_photo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店收银台照',
  `store_in_photo` text COLLATE utf8mb4_unicode_ci COMMENT '店内照',
  `margin_payment_status` tinyint(1) DEFAULT NULL COMMENT '保证金缴纳状态',
  `payment_amount` int(11) unsigned DEFAULT '0' COMMENT '缴费金额',
  `store_area` int(11) DEFAULT NULL COMMENT '店铺面积',
  `store_honor_photo` text COLLATE utf8mb4_unicode_ci COMMENT '店铺资质和荣誉',
  `store_phote` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店铺图片',
  `other_service` text COLLATE utf8mb4_unicode_ci COMMENT '其他服务 ',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=749 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='店铺扩展';

-- ----------------------------
-- Table structure for store_extend_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `store_extend_operation_log`;
CREATE TABLE `store_extend_operation_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作内容',
  `old_value` text COLLATE utf8mb4_unicode_ci COMMENT '原值',
  `new_value` text COLLATE utf8mb4_unicode_ci COMMENT '新值',
  `operation_user_id` int(11) DEFAULT NULL COMMENT '操作人ID',
  `operation_login_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作人登录名',
  `operation_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1024 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='店铺扩展操作日志';

-- ----------------------------
-- Table structure for store_follower
-- ----------------------------
DROP TABLE IF EXISTS `store_follower`;
CREATE TABLE `store_follower` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `member_id` int(11) DEFAULT NULL COMMENT '会员ID',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COMMENT='店铺粉丝';

-- ----------------------------
-- Table structure for store_level
-- ----------------------------
DROP TABLE IF EXISTS `store_level`;
CREATE TABLE `store_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `level_name` varchar(60) CHARACTER SET utf8 DEFAULT NULL COMMENT '级别名称',
  `level_logo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '级别图标',
  `begin_upgrade_value` int(11) DEFAULT NULL COMMENT '开始成长值',
  `end_upgrade_value` int(11) DEFAULT NULL COMMENT '结束成长值',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=latin1 COMMENT='门店级别';

-- ----------------------------
-- Table structure for store_level_upgrade_log
-- ----------------------------
DROP TABLE IF EXISTS `store_level_upgrade_log`;
CREATE TABLE `store_level_upgrade_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_id` int(11) unsigned NOT NULL COMMENT '门店ID',
  `store_level_upgrade_id` int(11) unsigned NOT NULL COMMENT '门店成长会规则ID',
  `level_upgrade_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '升级规则名',
  `condition` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '当前规则所需条件',
  `value` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '当前规则的成长值',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='门店成长值记录';

-- ----------------------------
-- Table structure for store_level_upgrade_rule
-- ----------------------------
DROP TABLE IF EXISTS `store_level_upgrade_rule`;
CREATE TABLE `store_level_upgrade_rule` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `level_upgrade_type` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '升级规则类型，1-最近一次接单，2-接单频次，3-接单金额，4-评价数量，5-好评量',
  `level_upgrade_condition` int(11) unsigned DEFAULT NULL COMMENT '升级条件',
  `level_upgrade_value` int(11) unsigned DEFAULT NULL COMMENT '对应成长值',
  `sort` int(11) unsigned DEFAULT NULL COMMENT '排序',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COMMENT='门店成长值规则设置';

-- ----------------------------
-- Table structure for store_open_city
-- ----------------------------
DROP TABLE IF EXISTS `store_open_city`;
CREATE TABLE `store_open_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `city_id` int(11) DEFAULT NULL COMMENT '城市ID',
  `city_name` varchar(60) DEFAULT NULL COMMENT '城市名称',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='店铺开通城市';

-- ----------------------------
-- Table structure for store_schedule
-- ----------------------------
DROP TABLE IF EXISTS `store_schedule`;
CREATE TABLE `store_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `store_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店铺名称',
  `schedule_type` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班次类型，1-早班，2-中班，3-晚班',
  `schedule_date` date DEFAULT NULL COMMENT '排班日期',
  `working_hours` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上班时间',
  `off_working_hours` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '下班时间',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='店铺排班';

-- ----------------------------
-- Table structure for store_schedule_beautician_ref
-- ----------------------------
DROP TABLE IF EXISTS `store_schedule_beautician_ref`;
CREATE TABLE `store_schedule_beautician_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `store_schedule_id` int(11) DEFAULT NULL COMMENT '店铺排班ID',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `store_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店铺名称',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师ID',
  `beautician_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '美容师姓名',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `beautician_id` (`beautician_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='店铺排班-美容师-关联';

-- ----------------------------
-- Table structure for txc_undo_log
-- ----------------------------
DROP TABLE IF EXISTS `txc_undo_log`;
CREATE TABLE `txc_undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `xid` varchar(100) NOT NULL COMMENT '全局事务 ID',
  `branch_id` bigint(20) NOT NULL COMMENT '分支事务 ID',
  `rollback_info` longblob NOT NULL COMMENT 'LOG',
  `status` int(11) NOT NULL COMMENT '状态',
  `server` varchar(32) NOT NULL COMMENT '分支所在 DB IP',
  PRIMARY KEY (`id`),
  KEY `unionkey` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事务日志表';
