/*
Navicat MySQL Data Transfer

Source Server         : 艾美-美容邦测试数据库
Source Server Version : 50720
Source Host           : 120.79.42.13:3306
Source Database       : beautybond_product

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-04 16:49:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for freight_template
-- ----------------------------
DROP TABLE IF EXISTS `freight_template`;
CREATE TABLE `freight_template` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `template_code` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模板代码',
  `template_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模板名称',
  `transport_method` tinyint(2) DEFAULT '1' COMMENT '运送方式，1-快递',
  `pricing_method` tinyint(2) unsigned DEFAULT '1' COMMENT '计价方式，1-按件数，2-按重量',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=663 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='运费模板';

-- ----------------------------
-- Table structure for freight_template_city
-- ----------------------------
DROP TABLE IF EXISTS `freight_template_city`;
CREATE TABLE `freight_template_city` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `template_id` int(11) DEFAULT NULL COMMENT '运费模板ID',
  `city_id` text COLLATE utf8mb4_unicode_ci COMMENT '城市ID，以“,”分隔',
  `city_name` text COLLATE utf8mb4_unicode_ci COMMENT '城市名称，以“,”分隔',
  `first_number` int(11) DEFAULT '0' COMMENT '首件数/首重数',
  `first_price` int(11) DEFAULT '0' COMMENT '首件价格/首重价格',
  `continued_number` int(11) DEFAULT '0' COMMENT '续件数/续重数',
  `continued_price` int(11) DEFAULT '0' COMMENT '续件价格/续重价格',
  `is_default` tinyint(1) DEFAULT '0' COMMENT '默认标记，1-默认，0-非默认',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='运费模板城市';

-- ----------------------------
-- Table structure for physical_freight_template_ref
-- ----------------------------
DROP TABLE IF EXISTS `physical_freight_template_ref`;
CREATE TABLE `physical_freight_template_ref` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `template_id` int(11) unsigned DEFAULT NULL COMMENT '运费模板ID',
  `physical_id` int(11) unsigned DEFAULT NULL COMMENT '产品ID',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品-运费模板-关联';

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `server_name` varchar(60) DEFAULT NULL COMMENT '商品名称',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `store_name` varchar(60) DEFAULT NULL COMMENT '店铺名称',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌ID',
  `brand_name` varchar(60) DEFAULT NULL COMMENT '品牌名称',
  `is_brand` tinyint(1) DEFAULT '0' COMMENT '是否品牌标记，1-品牌，0-自营',
  `label` tinyint(2) DEFAULT '0' COMMENT '商品标签，0-默认，1-推荐，2-新品',
  `appointment` int(11) DEFAULT '0' COMMENT '预约人数',
  `sale_volume` int(11) DEFAULT '0' COMMENT '销量',
  `original_price` int(11) unsigned DEFAULT '0' COMMENT '原价',
  `home_fee` int(11) DEFAULT '0' COMMENT '上门费',
  `wholesale_price` int(11) DEFAULT '0' COMMENT '批发价',
  `retail_price` int(11) DEFAULT '0' COMMENT '零售价',
  `sale_price` int(11) unsigned DEFAULT '0' COMMENT '销售价',
  `formal_beautician_commission` int(11) DEFAULT '0' COMMENT '正式美容师佣金',
  `parttime_beautician_commission` int(11) DEFAULT '0' COMMENT '兼职美容师佣金',
  `server_introduce` text COMMENT '服务介绍',
  `server_need_time` int(3) DEFAULT '0' COMMENT '服务所需耗时，分钟为单位',
  `server_content` text COMMENT '服务说明',
  `server_fit_people` varchar(255) DEFAULT NULL COMMENT '适用人群',
  `server_fit_part` varchar(255) DEFAULT NULL COMMENT '适用部位',
  `server_effect` varchar(255) DEFAULT NULL COMMENT '功效',
  `server_attention` varchar(755) DEFAULT NULL COMMENT '注意事项',
  `cover_img` varchar(255) DEFAULT NULL COMMENT '商品封面图',
  `sequence` int(11) unsigned DEFAULT NULL COMMENT '商品排序',
  `sale_status` tinyint(2) DEFAULT '0' COMMENT '上架状态，0-下架，1-上架',
  `audit_status` tinyint(2) unsigned zerofill DEFAULT '00' COMMENT '审核状态，0-待审核，1-已审核，2-不通过',
  `audit_reason` varchar(200) DEFAULT NULL COMMENT '审核原因',
  `limit_status` tinyint(3) DEFAULT '0' COMMENT '商品是否限购 0.不限购 1限购',
  `limit_quota` int(11) unsigned DEFAULT '0' COMMENT '商品限购总数量',
  `limit_buy_quota` int(11) unsigned DEFAULT '0' COMMENT '每人限购件数',
  `collection_total` int(11) DEFAULT '0' COMMENT '收藏总数',
  `is_support_store` tinyint(1) DEFAULT '0' COMMENT '支持到店标记，1-是，0-否',
  `is_support_home` tinyint(1) DEFAULT '0' COMMENT '支持上门标记，1-是，0-否',
  `is_support_wholesale` tinyint(1) DEFAULT '0' COMMENT '支持批发标记，1-是，0-否',
  `is_support_retail` tinyint(1) DEFAULT '0' COMMENT '支持零售标记，1-是，0-否',
  `is_platform` tinyint(1) DEFAULT '0' COMMENT '平台标记，1-是，0-否',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=614 DEFAULT CHARSET=utf8mb4 COMMENT='商品';

-- ----------------------------
-- Table structure for product_beautician_ref
-- ----------------------------
DROP TABLE IF EXISTS `product_beautician_ref`;
CREATE TABLE `product_beautician_ref` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(11) unsigned DEFAULT NULL COMMENT '商品ID',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `store_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店铺名称',
  `beautician_id` int(11) unsigned DEFAULT NULL COMMENT '美容师ID',
  `beautician_nick_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '美容师昵称',
  `beautician_head_img_url` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '美容师头像',
  `beautician_status` tinyint(2) DEFAULT '1' COMMENT '状态，0-离职，1-在职，2-休息',
  `member_id` int(11) DEFAULT NULL COMMENT '会员ID',
  `server_type` tinyint(2) DEFAULT '0' COMMENT '服务类型，0-到店，1-上门',
  `is_recruit` tinyint(1) DEFAULT '0' COMMENT '是否招募美容师标记，1-是，0-否',
  `is_agree` tinyint(1) DEFAULT '0' COMMENT '是否同意标记，1-是，0-否',
  `agree_status` tinyint(2) DEFAULT '0' COMMENT '同意状态，0-待处理，1-已同意，2-已拒绝',
  `agree_reason` text COLLATE utf8mb4_unicode_ci COMMENT '同意原因',
  `auth_status` tinyint(2) DEFAULT '1' COMMENT '审核状态，0-待审核，1-审核通过，2-不通过',
  `auth_reason` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核原因',
  `group_photo` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '与店铺合照',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1-正常，0-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4529 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品-美容师-关联';

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_id` int(11) unsigned DEFAULT NULL COMMENT '店铺ID',
  `category_code` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类代码，一级-CODE_XX，二级-CODE_XX_XX',
  `category_logo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类LOGO',
  `category_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `pid` int(11) unsigned DEFAULT NULL COMMENT '父类ID，0-顶级分类',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1-正常，0-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品分类';

-- ----------------------------
-- Table structure for product_category_ref
-- ----------------------------
DROP TABLE IF EXISTS `product_category_ref`;
CREATE TABLE `product_category_ref` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(11) unsigned DEFAULT NULL COMMENT '商品ID',
  `category_id` int(11) unsigned DEFAULT NULL COMMENT '分类ID',
  `category_code` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类代码',
  `category_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1-正常，0-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=622 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品-分类-关联';

-- ----------------------------
-- Table structure for product_city
-- ----------------------------
DROP TABLE IF EXISTS `product_city`;
CREATE TABLE `product_city` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `city_id` int(11) DEFAULT NULL COMMENT '城市ID',
  `city_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '城市名称',
  `product_label` tinyint(2) DEFAULT '0' COMMENT '商品标签，0-默认，1-推荐，2-新品',
  `label_sort` int(11) DEFAULT NULL COMMENT '标签排序',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=677 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品城市';

-- ----------------------------
-- Table structure for product_collection
-- ----------------------------
DROP TABLE IF EXISTS `product_collection`;
CREATE TABLE `product_collection` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(11) unsigned DEFAULT NULL COMMENT '商品ID',
  `member_id` int(11) unsigned DEFAULT NULL COMMENT '会员ID',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品收藏';

-- ----------------------------
-- Table structure for product_img
-- ----------------------------
DROP TABLE IF EXISTS `product_img`;
CREATE TABLE `product_img` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(11) unsigned DEFAULT NULL COMMENT '商品ID',
  `type` tinyint(2) DEFAULT '1' COMMENT '图片类型，1-轮播图',
  `url` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1164 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品图片';

-- ----------------------------
-- Table structure for product_physical
-- ----------------------------
DROP TABLE IF EXISTS `product_physical`;
CREATE TABLE `product_physical` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `physical_name` varchar(60) DEFAULT NULL COMMENT '产品名称',
  `physical_code` varchar(60) DEFAULT NULL COMMENT '产品编码',
  `cover_img` varchar(255) DEFAULT NULL COMMENT '封面图',
  `physical_img` text COMMENT '产品图',
  `sale_price` int(11) unsigned DEFAULT '0' COMMENT '销售价',
  `unit` varchar(10) DEFAULT NULL COMMENT '单位',
  `inventory` int(11) DEFAULT '0' COMMENT '库存数',
  `inventory_total` int(11) DEFAULT '0' COMMENT '库存总数',
  `inventory_consumable` int(11) DEFAULT '0' COMMENT '库存可消耗数',
  `inventory_order_reservation` int(11) DEFAULT '0' COMMENT '库存订单预约数',
  `inventory_warning` int(11) DEFAULT '0' COMMENT '库存预警数',
  `inventory_warning_switch` tinyint(1) DEFAULT '0' COMMENT '库存预警开关，1-开，0-关',
  `delivery_place_id` int(11) DEFAULT NULL COMMENT '发货地ID',
  `delivery_place` varchar(60) DEFAULT NULL COMMENT '发货地',
  `physical_detail` text COMMENT '产品详情',
  `sale_volume` int(11) DEFAULT '0' COMMENT '销量',
  `postage_type` tinyint(2) DEFAULT '1' COMMENT '邮费类型，1-买家承担，2-卖家包邮',
  `template_id` int(11) DEFAULT NULL COMMENT '运费模板ID',
  `weight` decimal(8,3) DEFAULT '0.000' COMMENT '重量/KG',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8mb4 COMMENT='产品';

-- ----------------------------
-- Table structure for product_physical_beautician_ref
-- ----------------------------
DROP TABLE IF EXISTS `product_physical_beautician_ref`;
CREATE TABLE `product_physical_beautician_ref` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_physical_id` int(11) unsigned DEFAULT NULL COMMENT '产品ID',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `store_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店铺名称',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师ID',
  `beautician_type` tinyint(2) DEFAULT '2' COMMENT '员工类型，0-老板，1-店长，2-正式员工，3-兼职员工',
  `beautician_nick_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '美容师昵称',
  `beautician_head_img_url` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '美容师头像',
  `inventory_total` int(11) DEFAULT '0' COMMENT '库存总数',
  `inventory_consumable` int(11) DEFAULT '0' COMMENT '库存可消耗数',
  `inventory_order_reservation` int(11) DEFAULT '0' COMMENT '库存订单预约数',
  `inventory_purchase_reservation` int(11) DEFAULT '0' COMMENT '库存采购预约数',
  `inventory_warning` int(11) DEFAULT '0' COMMENT '库存预警数',
  `inventory_warning_switch` tinyint(1) DEFAULT '0' COMMENT '库存预警开关，1-开，0-关',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品-美容师-关联';

-- ----------------------------
-- Table structure for product_physical_category_ref
-- ----------------------------
DROP TABLE IF EXISTS `product_physical_category_ref`;
CREATE TABLE `product_physical_category_ref` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_physical_id` int(11) unsigned DEFAULT NULL COMMENT '产品ID',
  `category_id` int(11) unsigned DEFAULT NULL COMMENT '分类ID',
  `category_code` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类代码',
  `category_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1-正常，0-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=252 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品-分类-关联';

-- ----------------------------
-- Table structure for product_point
-- ----------------------------
DROP TABLE IF EXISTS `product_point`;
CREATE TABLE `product_point` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(11) unsigned DEFAULT NULL COMMENT '产品ID',
  `product_earn_point` int(11) unsigned DEFAULT '0' COMMENT '产品获得的积分',
  `exchange_point` int(11) unsigned DEFAULT '0' COMMENT '全额兑换积分',
  `plus_price_point` int(11) unsigned DEFAULT '0' COMMENT '加钱购积分',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品积分';

-- ----------------------------
-- Table structure for product_price
-- ----------------------------
DROP TABLE IF EXISTS `product_price`;
CREATE TABLE `product_price` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '价格id',
  `product_id` int(11) unsigned DEFAULT NULL COMMENT '商品id',
  `value` int(11) unsigned DEFAULT NULL COMMENT '价格',
  `type` tinyint(11) unsigned DEFAULT NULL COMMENT '价格类型  1.原价 2.销售价  3.活动价',
  `refer_id` tinyint(11) unsigned DEFAULT NULL COMMENT '关联id 1.默认 2.活动id',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品价格';

-- ----------------------------
-- Table structure for product_product_physical_ref
-- ----------------------------
DROP TABLE IF EXISTS `product_product_physical_ref`;
CREATE TABLE `product_product_physical_ref` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `product_physical_id` int(11) DEFAULT NULL COMMENT '产品ID',
  `physical_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品名称',
  `physical_number` int(11) DEFAULT '0' COMMENT '产品数量',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=259 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品-产品-关联';

-- ----------------------------
-- Table structure for product_store_ref
-- ----------------------------
DROP TABLE IF EXISTS `product_store_ref`;
CREATE TABLE `product_store_ref` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(11) unsigned DEFAULT NULL COMMENT '商品ID',
  `store_id` int(11) unsigned DEFAULT NULL COMMENT '店铺ID',
  `store_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店铺名称',
  `sale_status` tinyint(2) DEFAULT '0' COMMENT '上架状态  0,下架  1,上架',
  `city_id` int(11) DEFAULT NULL COMMENT '城市ID',
  `store_longitude` decimal(10,7) DEFAULT NULL COMMENT '经度，长度10位，小数点后7位',
  `store_latitude` decimal(10,7) DEFAULT NULL COMMENT '纬度，长度10位，小数点后7位',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `product_status` tinyint(2) DEFAULT '1' COMMENT '商品状态：0-冻结，1-正常',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3426 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品-店铺-关联';
