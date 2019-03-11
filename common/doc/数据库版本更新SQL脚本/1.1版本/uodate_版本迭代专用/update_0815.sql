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

 Date: 15/08/2018 14:57:16
*/



--2018-7-25
ALTER TABLE `beautybond_order`.`order_comment` ADD beautician_evaluation_grade tinyint(2) DEFAULT 0 NULL COMMENT '美容师评价等级(0：未评价，1：差评，2：中评，3：好评，4：系统默认好评)';
ALTER TABLE `beautybond_order`.`order_comment` MODIFY COLUMN beautician_evaluation_grade tinyint(2) DEFAULT 0 COMMENT '美容师评价等级(0：未评价，1：差评，2：中评，3：好评，4：系统默认好评)' AFTER product_evaluation_grade;

ALTER TABLE `beautybond_order`.`order_comment` ADD beautician_id int DEFAULT null  NULL COMMENT '订单美容师ID';
ALTER TABLE `beautybond_order`.`order_comment` MODIFY COLUMN beautician_id int DEFAULT null  COMMENT '订单美容师ID' AFTER order_no;



--2018-08-10
ALTER TABLE `beautybond_order`.`order_base` MODIFY beautician_reply_comment_status tinyint(2) DEFAULT '0' COMMENT '美容师回复评论状态（0：默认，1：用户已评价，美容师未回复，2：用户已评价，美容师已回复，3：系统默认好评）';
ALTER TABLE `beautybond_order`.`order_base` MODIFY beautician_reply_comment_status tinyint(2) DEFAULT '0' COMMENT '美容师回复评论状态（0：用户未评价或删除评价，1：用户已评价，美容师未回复，2：用户已评价，美容师已回复，3：系统默认好评）';

