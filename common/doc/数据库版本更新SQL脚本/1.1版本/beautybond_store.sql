ALTER TABLE store ADD house_number varchar(60) COMMENT '门牌号';
ALTER TABLE store ADD settled_status tinyint(2) COMMENT '入驻状态，0-待完善资料，1-待完善资质，2-待审核，3-审核不通过，4-完成入驻' DEFAULT 0;
ALTER TABLE store ADD settled_code varchar(4) COMMENT '入驻码';
ALTER TABLE store ADD qualification_status tinyint(2) COMMENT '资质状态，0-待审核，1-审核通过，2-审核不通过' DEFAULT 0;
ALTER TABLE store ADD qualification_reason varchar(200) COMMENT '资质原因';

ALTER TABLE store_extend ADD hygienic_license varchar(200) COMMENT '卫生许可证';

-- ----------------------------
-- Table structure for store_beautician_affiliated
-- ----------------------------
DROP TABLE IF EXISTS `store_beautician_affiliated`;
CREATE TABLE `store_beautician_affiliated` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `affiliated_type` tinyint(2) DEFAULT '1' COMMENT '挂靠类型，1-申请，2-解除',
  `sponsor` tinyint(2) DEFAULT NULL COMMENT '发起方，1-美容师，2-店铺，3-平台',
  `beautician_type` tinyint(2) DEFAULT '3' COMMENT '美容师类型，0-老板，1-店长，2-正式美容师，3-兼职美容师',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `store_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店铺名称',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师ID',
  `audit_status` tinyint(2) DEFAULT '0' COMMENT '审核状态，0-待审核，1-审核通过，2-审核不通过，3-平台通过，4-平台不通过',
  `audit_reason` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核原因',
  `audit_time` timestamp NULL DEFAULT NULL COMMENT '审核时间',
  `platform_audit_time` timestamp NULL DEFAULT NULL COMMENT '平台审核时间',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1-正常，0-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='门店-美容师-挂靠';

ALTER TABLE store_beautician ADD register_status tinyint(2) COMMENT '注册状态，0-待完善资料，1-待评测，2-完成注册' DEFAULT 0;
ALTER TABLE store_beautician ADD is_order tinyint(1) COMMENT '是否接单，0-不接单，1-接单中' DEFAULT 0;
ALTER TABLE store_beautician ADD month_online_time int(11) COMMENT '本月在线时间（单位/小时）' DEFAULT 0;
ALTER TABLE store_beautician ADD label varchar(60) COMMENT '标签';
ALTER TABLE store_beautician ADD service_city_id int(11) COMMENT '服务城市ID';
ALTER TABLE store_beautician ADD service_area_id int(11) COMMENT '服务区域ID';
ALTER TABLE store_beautician ADD service_address varchar(200) COMMENT '服务地址';
ALTER TABLE store_beautician ADD service_longitude decimal(10,7) COMMENT '服务经度，长度10位，小数点后7位';
ALTER TABLE store_beautician ADD service_latitude decimal(10,7) COMMENT '服务纬度，长度10位，小数点后7位';
ALTER TABLE store_beautician ADD service_radius int(11) COMMENT '服务半径';
ALTER TABLE store_beautician ADD affiliated_status tinyint(2) COMMENT '挂靠状态，0-未入驻挂靠，1-已入驻，2-已挂靠，3-申请挂靠，4-申请解除挂靠，5-待平台审核' DEFAULT 0;
ALTER TABLE store_beautician ADD affiliated_id int(11) COMMENT '挂靠ID';
ALTER TABLE store_beautician ADD remove_affiliated_id int(11) COMMENT '解除挂靠ID';
ALTER TABLE store_beautician ADD signature varchar(200) COMMENT '签名';
ALTER TABLE store_beautician ADD start_business_hour varchar(5) COMMENT '开始营业时间，HH:mm';
ALTER TABLE store_beautician ADD end_business_hour varchar(5) COMMENT '结束营业时间，HH:mm';
ALTER TABLE store_beautician ADD workday varchar(20) COMMENT '工作日，逗号分隔';
ALTER TABLE store_beautician ADD real_name_status tinyint(2) COMMENT '实名状态，0-待审核，1-审核通过，2-审核不通过' DEFAULT 0;

-- ----------------------------
-- Table structure for beautician_busy_time
-- ----------------------------
DROP TABLE IF EXISTS `beautician_busy_time`;
CREATE TABLE `beautician_busy_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师ID',
  `busy_date` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '忙碌日期，yyyy-MM-dd',
  `busy_time` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '忙碌时间，HH:mm，多个，分隔',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `start_time` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `end_time` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `time_type` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=897 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='美容师忙碌时间';

-- ----------------------------
-- Table structure for beautician_growth_value_log
-- ----------------------------
DROP TABLE IF EXISTS `beautician_growth_value_log`;
CREATE TABLE `beautician_growth_value_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师ID',
  `growth_type` tinyint(2) DEFAULT NULL COMMENT '成长类型，1-培训课程',
  `growth_ref_id` int(11) DEFAULT NULL COMMENT '成长关联ID',
  `growth_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '成长名称',
  `growth_value` int(11) DEFAULT NULL COMMENT '成长值',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1-正常，0-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user` (`growth_value`)
) ENGINE=InnoDB AUTO_INCREMENT=924 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='美容师成长值记录';

-- ----------------------------
-- Table structure for beautician_service_scope
-- ----------------------------
DROP TABLE IF EXISTS `beautician_service_scope`;
CREATE TABLE `beautician_service_scope` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师ID',
  `scope_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '范围名称',
  `province_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省名称',
  `city_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '市名称',
  `area_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '县名称',
  `province_id` int(11) DEFAULT NULL COMMENT '省ID',
  `city_id` int(11) DEFAULT NULL COMMENT '市ID',
  `area_id` int(11) DEFAULT NULL COMMENT '县ID',
  `longitude` decimal(10,7) DEFAULT NULL COMMENT '经度，长度10位，小数点后7位',
  `latitude` decimal(10,7) DEFAULT NULL COMMENT '纬度，长度10位，小数点后7位',
  `address` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `radius` int(11) DEFAULT NULL COMMENT '半径',
  `is_select` tinyint(1) DEFAULT '0' COMMENT '是否选择，1-是，0-否',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1-正常，0-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=878 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='美容师服务范围';

-- ----------------------------
-- Table structure for beautician_business_hour
-- ----------------------------
DROP TABLE IF EXISTS `beautician_business_hour`;
CREATE TABLE `beautician_business_hour` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师ID',
  `weekday` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '周几，1-7，逗号分隔',
  `time_point` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '时间点，HH:mm',
  `is_select` tinyint(1) DEFAULT '1' COMMENT '是否选择，1-是，0-否',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `start_time` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `end_time` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `time_type` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1366 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='美容师营业时间';

-- ----------------------------
-- Table structure for store_friend
-- ----------------------------
DROP TABLE IF EXISTS `store_friend`;
CREATE TABLE `store_friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `store_id` int(11) DEFAULT NULL COMMENT '门店ID',
  `store_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '门店名称',
  `friend_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '朋友姓名',
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1-正常，0-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=943 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='门店朋友';


-- ----------------------------
-- Table structure for growth_rule
-- ----------------------------

CREATE TABLE `growth_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编码',
  `rule_type` tinyint(2) DEFAULT NULL COMMENT '成长规则类型：0-门店、1-美容师',
  `item_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '成长项名字',
  `growth_type` tinyint(5) DEFAULT '0' COMMENT '成长值类型：0-即时设置、1-间接抓取',
  `growth_value` int(11) DEFAULT '0' COMMENT '成长数值',
  `growth_calculate_type` tinyint(5) DEFAULT '0' COMMENT '成长值计算类型：0-加、1-减',
  `condition_type` tinyint(5) DEFAULT '0' COMMENT '限定条件：0-无限制、1-次数限制、2-数值限制（日、月）、3-日限制、4-月限制',
  `condition_value_number` int(11) DEFAULT NULL COMMENT '次数限制',
  `condition_value_day` int(11) DEFAULT NULL COMMENT '每日上限',
  `condition_value_month` int(11) DEFAULT NULL COMMENT '每月上限',
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '获取规则内容',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态：0-生效、1-暂停',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='成长规则';


-- ----------------------------
-- Table structure for growth_rule_log
-- ----------------------------
CREATE TABLE `growth_rule_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `rel_id` int(11) DEFAULT NULL COMMENT '外键id',
  `source_type` tinyint(2) DEFAULT NULL COMMENT '来源类型：0-门店、1-美容师',
  `source_id` int(11) DEFAULT NULL COMMENT '来源id',
  `item_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '成长项名字',
  `growth_type` tinyint(5) DEFAULT NULL COMMENT '成长值类型：0-即时设置、1-间接抓取',
  `growth_value` int(11) DEFAULT NULL COMMENT '成长数值',
  `growth_calculate_type` tinyint(5) DEFAULT NULL COMMENT '成长值计算类型：0-加、1-减',
  `condition_type` tinyint(5) DEFAULT NULL COMMENT '限定条件：0-无限制、1-次数限制、2-数值限制（日、月）、3-日限制、4-月限制',
  `condition_value_number` int(11) DEFAULT NULL COMMENT '次数限制',
  `condition_value_day` int(11) DEFAULT NULL COMMENT '每日上限',
  `condition_value_month` int(11) DEFAULT NULL COMMENT '每月上限',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='成长规则日志表';

-- 2018-06-21
ALTER TABLE store ADD qualification_commit_time TIMESTAMP NULL COMMENT '资质提交时间';
ALTER TABLE store ADD qualification_audit_time TIMESTAMP NULL COMMENT '资质审核时间';

-- 2018-06-22
alter table store_beautician add qualification_certificate text NULL COMMENT '从业证书';

-- ----------------------------
-- Table structure for store_beautician_level
-- ----------------------------
DROP TABLE IF EXISTS `store_beautician_grade`;
CREATE TABLE `store_beautician_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `grade_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '等级名称',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺id',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='店铺-美容师等级';

-- 2018-06-25
ALTER TABLE `beautybond_store`.`store_beautician`
ADD COLUMN `grade_id` int(11) NULL COMMENT '店铺-美容师等级id' AFTER `level_name`,
ADD COLUMN `grade_name` varchar(255) NULL COMMENT '店铺-美容师等级名字' AFTER `grade_id`;

-- ----------------------------
-- Table structure for store_beautician_level
-- ----------------------------
DROP TABLE IF EXISTS `beautician_follower`;
CREATE TABLE `beautician_follower` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `beautician_id` int(11) DEFAULT NULL COMMENT '美容师id',
  `member_id` int(11) DEFAULT NULL COMMENT '会员id',
  `is_follower` tinyint(2) DEFAULT NULL COMMENT '是否收藏：0-是、1-否',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='美容师粉丝表';

-- 2018-06-25
ALTER TABLE `beautybond_store`.`store_beautician`
ADD COLUMN `follower_number` int(11) NULL DEFAULT 0 COMMENT '收藏人数' AFTER `growup_value`;

-- 2018-06-27
alter table store_beautician add service_city_name varchar(60) null comment '服务城市名称';
alter table store_beautician add service_area_name varchar(60) null comment '服务区县名称';


-- 2018-07-19
ALTER TABLE `beautybond_store`.`growth_rule_log`
ADD COLUMN `conndition_id` int(11) NULL DEFAULT NULL COMMENT '条件关联id' AFTER `source_id`;

ALTER TABLE `beautybond_store`.`store_beautician_level`
ADD COLUMN `star_value` int(11) NULL COMMENT '美容师星级，范围为0-100' AFTER `id`;