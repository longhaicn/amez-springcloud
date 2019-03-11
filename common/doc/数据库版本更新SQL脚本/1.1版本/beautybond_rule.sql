
-- ----------------------------
-- Table structure for rule_action
-- ----------------------------
DROP TABLE IF EXISTS `rule_action`;
CREATE TABLE `rule_action` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `item_id` int(11) DEFAULT NULL COMMENT '规则项ID',
  `action_code` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '行为代码',
  `action_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '行为名称',
  `is_enabled` tinyint(1) DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='规则行为';

-- ----------------------------
-- Table structure for rule_category
-- ----------------------------
DROP TABLE IF EXISTS `rule_category`;
CREATE TABLE `rule_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category_code` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类代码',
  `caregory_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `pid` int(11) DEFAULT NULL COMMENT '父级ID',
  `is_enabled` tinyint(1) DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='规则分类';

-- ----------------------------
-- Table structure for rule_item
-- ----------------------------
DROP TABLE IF EXISTS `rule_item`;
CREATE TABLE `rule_item` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `template_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `item_code` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项代码',
  `item_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项名称',
  `is_enabled` tinyint(1) DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='规则项';

-- ----------------------------
-- Table structure for rule_level
-- ----------------------------
DROP TABLE IF EXISTS `rule_level`;
CREATE TABLE `rule_level` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `item_id` int(11) DEFAULT NULL COMMENT '规则项ID',
  `level_code` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '等级代码',
  `level_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '等级名称',
  `level_logo` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '等级LOGO',
  `start_level_value` int(11) DEFAULT NULL COMMENT '开始等级值',
  `end_level_value` int(11) DEFAULT NULL COMMENT '结束等级值',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `is_enabled` tinyint(1) DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='规则等级';

-- ----------------------------
-- Table structure for rule_strategy
-- ----------------------------
DROP TABLE IF EXISTS `rule_strategy`;
CREATE TABLE `rule_strategy` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `action_id` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '行为ID',
  `start_strategy_cond` int(11) DEFAULT NULL COMMENT '开始策略条件',
  `end_strategy_cond` int(11) DEFAULT NULL COMMENT '结束策略条件',
  `strategy_value` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '策略值',
  `is_enabled` tinyint(1) DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='规则策略';

-- ----------------------------
-- Table structure for rule_template
-- ----------------------------
DROP TABLE IF EXISTS `rule_template`;
CREATE TABLE `rule_template` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `category_id` int(11) DEFAULT NULL COMMENT '分类ID',
  `template_code` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模板代码',
  `template_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模板名称',
  `is_enabled` tinyint(1) DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='规则模板';
