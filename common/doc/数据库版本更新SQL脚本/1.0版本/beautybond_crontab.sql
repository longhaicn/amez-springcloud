/*
Navicat MySQL Data Transfer

Source Server         : 艾美-美容邦测试数据库
Source Server Version : 50720
Source Host           : 120.79.42.13:3306
Source Database       : beautybond_crontab

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-04 16:48:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '定时任务Id',
  `job_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '定时任务名称',
  `job_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'job唯一代码',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `job_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '定时任务完整类名称',
  `job_method` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '定时任务方法名称',
  `job_state` tinyint(5) NOT NULL DEFAULT '0' COMMENT '常job状态,1正常运行，2运行异',
  `job_type` tinyint(5) DEFAULT '0' COMMENT '客户端类型:0-pc端,1-app端',
  `cron_expression` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '定时任务的Corn表达式',
  `is_enable` tinyint(5) DEFAULT NULL COMMENT '是否启用，1启用，0禁用',
  `is_concurrent` tinyint(5) NOT NULL DEFAULT '0' COMMENT '能否并发运行，1可以，0不可以',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='定时任务表';
