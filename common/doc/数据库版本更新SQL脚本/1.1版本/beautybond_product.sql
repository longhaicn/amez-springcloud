ALTER TABLE product ADD product_type tinyint(2) COMMENT '项目类型，1-门店自营，2-品牌，3-平台自营';
ALTER TABLE product ADD fulltime_commission int(11) COMMENT '全职美容师佣金' DEFAULT 0;
ALTER TABLE product ADD fulltime_commission_ratio int(11) COMMENT '全职美容师佣金比例' DEFAULT 0;
ALTER TABLE product ADD parttime_commission int(11) COMMENT '兼职美容师佣金' DEFAULT 0;
ALTER TABLE product ADD parttime_commission_ratio int(11) COMMENT '兼职美容师佣金比例' DEFAULT 0;
ALTER TABLE product ADD is_course tinyint(1) COMMENT '是否包含课程';

-- ----------------------------
-- Table structure for product_collection
-- ----------------------------
DROP TABLE IF EXISTS `product_collection`;
CREATE TABLE `product_collection` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(11) unsigned DEFAULT NULL COMMENT '项目ID',
  `member_id` int(11) unsigned DEFAULT NULL COMMENT '会员ID',
  `is_collection` tinyint(1) DEFAULT '1' COMMENT '是否收藏，1-是，0-否',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1-正常，0-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品收藏';

-- ----------------------------
-- Table structure for product_activity
-- ----------------------------
DROP TABLE IF EXISTS `product_activity`;
CREATE TABLE `product_activity` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `activity_code` varchar(60) DEFAULT NULL COMMENT '活动代码',
  `activity_name` varchar(60) DEFAULT NULL COMMENT '活动名称',
  `cover_img` varchar(255) DEFAULT NULL COMMENT '商品封面图',
  `activity_desc` text COMMENT '活动描述',
  `city_id` int(11) DEFAULT NULL COMMENT '城市ID',
  `city_name` varchar(60) DEFAULT NULL COMMENT '城市名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `is_select` tinyint(1) DEFAULT NULL COMMENT '是否精选，1-是，0-否',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1-正常，0-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=644 DEFAULT CHARSET=utf8mb4 COMMENT='商品活动';

ALTER TABLE product_beautician_ref ADD sponsor tinyint(2) COMMENT '发起方，1-美容师，2-门店，3-平台';
ALTER TABLE product_beautician_ref ADD is_select tinyint(1) COMMENT '是否选择，1-是，0-否' DEFAULT 1;
ALTER TABLE product_beautician_ref ADD is_order tinyint(1) COMMENT '是否接单，1-是，0-否' DEFAULT 1;


-- ----------------------------
-- Table structure for physical_category
-- ----------------------------
CREATE TABLE `physical_category` (
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品分类';

-- ----------------------------
-- Table structure for physical_category_ref
-- ----------------------------
CREATE TABLE `physical_category_ref` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `physical_id` int(11) unsigned DEFAULT NULL COMMENT '产品ID',
  `category_id` int(11) unsigned DEFAULT NULL COMMENT '产品分类ID',
  `category_code` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类代码',
  `category_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1-正常，0-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=726 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品-产品分类-关联';


-- 2018-07-20

ALTER TABLE `beautybond_product`.`product_beautician_ref`
ADD COLUMN `is_show` tinyint(2) NULL DEFAULT 1 COMMENT '是否展示，1-是，0-否' AFTER `is_order`;

