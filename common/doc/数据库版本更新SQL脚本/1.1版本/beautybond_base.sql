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

 Date: 28/05/2018 14:57:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table for base_home_template
-- ----------------------------

ALTER TABLE `beautybond_base`.`base_home_template`
MODIFY COLUMN `template_code` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '模板代码 首页轮播图：INDEX_ONE、 服务类型区：CODE_XX 、  活动区 ACTIVITY_ONE、  底部导航区 BOTTOM_NAVIGATION、 导航按钮 NAVIGATION_BUTTONS：INDEX_ONE、 服务类型区：CODE_XX 、  活动区 ACTIVITY_ONE、  底部导航区 BOTTOM_NAVIGATION、 广告图 ADVERTISING_FIGURE' AFTER `id`,
MODIFY COLUMN `template_type` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '模板类型，1-顶部轮播区，2-服务类型区，3-活动区，4-商品区，5-底部导航区，6-导航按钮型区，4-商品区，5-底部导航区 ，6-导航按钮 ， 7-广告图' AFTER `template_name`;


ALTER TABLE `beautybond_base`.`base_home_template`
ADD COLUMN `area_id` int(11) NULL COMMENT '区域id' AFTER `update_time`;

ALTER TABLE `beautybond_base`.`base_home_template`
ADD COLUMN `use_type` tinyint(2) NULL COMMENT '使用类型 0-用户端，1-帮女郎，2-门店端' AFTER `update_time`;

ALTER TABLE `beautybond_base`.`base_home_template`
ADD COLUMN `show_type` tinyint(2) NULL COMMENT '是否展示 0-全部展示 1-全部不展示 2-展示上半部分 3-展示下半部分' AFTER `update_time`;

-- ----------------------------
-- Table structure for base_home_area
-- ----------------------------

CREATE TABLE `base_home_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `province_id` int(11) DEFAULT NULL COMMENT '省id',
  `city_id` int(11) DEFAULT NULL COMMENT '市id',
  `area_id` int(11) DEFAULT NULL COMMENT '区id',
  `province_name` varchar(60) DEFAULT NULL COMMENT '省名称',
  `city_name` varchar(60) DEFAULT NULL COMMENT '市名称',
  `area_name` varchar(60) DEFAULT NULL COMMENT '县城市',
  `data_type` tinyint(2) DEFAULT NULL COMMENT '数据类型 0-基本数据 1-楼层数据',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='首页区域表';

-- ----------------------------
-- Table structure for base_home_floor
-- ----------------------------

CREATE TABLE `base_home_floor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `area_id` int(11) DEFAULT NULL COMMENT '区域id',
  `jump_code` varchar(60) DEFAULT NULL COMMENT 'h5跳转页面的唯一标识',
  `index_floor_img` varchar(255) DEFAULT NULL COMMENT '首页楼层图片',
  `list_floor_img` varchar(255) DEFAULT NULL COMMENT '活动列表图片',
  `floor_type` tinyint(2) DEFAULT NULL COMMENT '类型 0-楼层 1-活动',
  `is_show` tinyint(2) DEFAULT '1' COMMENT '是否展示 0-否，1-是',
  `sort` int(3) DEFAULT '0' COMMENT '排序',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='楼层管理表';

-- ----------------------------
-- Table structure for base_home_floor_list
-- ----------------------------

CREATE TABLE `base_home_floor_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `floor_id` int(11) DEFAULT NULL COMMENT '楼层id',
  `product_id` int(11) DEFAULT NULL COMMENT '产品id',
  `product_type` tinyint(2) DEFAULT NULL COMMENT '产品类型 0-平台 1-门店资源',
  `sort` int(3) DEFAULT '0' COMMENT '排序',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='楼层列表数据表';



CREATE TABLE `base_push_template` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
	`template_type` INT(11) NULL DEFAULT '0' COMMENT '0--服务消息 1--项目消息  2--系统消息',
	`template_name` VARCHAR(50) NULL DEFAULT NULL COMMENT '模板名称',
	`template_code` VARCHAR(50) NULL DEFAULT NULL COMMENT '模板code',
	`template_content` VARCHAR(200) NULL DEFAULT NULL COMMENT '模板内容',
	`template_description` VARCHAR(200) NULL DEFAULT NULL COMMENT '模板描述',
	`push_object` INT(11) NULL DEFAULT NULL COMMENT '推送对象(0--用户 1--美容师 2--店长)',
	`member_id` INT(11) NULL DEFAULT NULL COMMENT '推送对象的会员id',
	`push_title` VARCHAR(200) NULL DEFAULT NULL COMMENT '推送标题',
	`push_costom` VARCHAR(200) NULL DEFAULT NULL COMMENT '推送自定义内容',
	`status` TINYINT(2) NULL DEFAULT '0' COMMENT '是否删除(0--正常 1--删除)',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP NULL DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`)
)
COMMENT='友盟推送消息模板(新)'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=36
;

INSERT INTO `base_push_template` VALUES ('1', '0', '用户订单付款成功', 'SERVICE_001', null, '用户订单付款成功推送消息给美容师', '1', null, '来新订单啦，请及时做好服务准备哦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('2', '0', '用户订单付款成功', 'SERVICE_002', null, '用户订单付款成功推送消息给店长', '2', null, '来新订单啦，请及时做好服务准备哦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('3', '0', '服务开始前30分钟', 'SERVICE_003', null, '服务开始前30分钟推送消息给用户', '0', null, '项目30分钟后即将开始，提前做好准备哦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('4', '0', '服务开始前30分钟', 'SERVICE_004', null, '服务开始前30分钟推送消息给美容师', '1', null, '客户的预约项目30分钟后即将开始，提前做好准备哦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('5', '0', '服务开始前30分钟', 'SERVICE_005', null, '服务开始前30分钟推送消息给店长', '2', null, '客户的预约项目30分钟后即将开始，提前做好准备哦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('6', '0', '服务完成', 'SERVICE_006', null, '服务完成推送消息给用户订单评价提醒', '0', null, '订单评价提醒，好不好，有图有真相~', '', '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('7', '0', '用户主动评价', 'SERVICE_007', null, '用户主动评价后推送消息给美容师进行查看评价', '1', null, '用户对订单进行评价了，去看看吧~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('8', '0', '用户主动评价', 'SERVICE_008', null, '用户主动评价后推送消息给店长查看评价(门店自营项目)', '2', null, '用户对订单进行评价了，去看看吧~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('9', '0', '用户发起退款', 'SERVICE_009', null, '用户发起退款推送消息给美容师进行查看', '1', null, '用户对订单发起了退款，赶紧去处理哦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('10', '0', '用户发起退款', 'SERVICE_010', null, '用户发起退款推送消息给店长进行查看(门店自营项目)', '2', null, '用户对订单发起了退款，赶紧去处理哦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('11', '0', '门店/邦女郎 同意退款', 'SERVICE_011', null, '门店/邦女郎 同意退款推送消息给用户', '0', null, '商家已同意您的退款申请，退款金额已原路退款，预计1-2个工作日到账', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('12', '0', '门店/邦女郎 拒绝退款', 'SERVICE_012', null, '门店/邦女郎 拒绝退款推送消息给用户', '0', null, '商家拒绝您的退款申请，请您在3天内与商家进行协商，超过3天，系统将自动关闭退款通道，非常抱歉哦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('13', '0', '用户撤销退款申请', 'SERVICE_013', null, '用户撤销退款申请推送消息给美容师', '1', null, '用户对订单{orderno}撤销了退款申请~', '', '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('14', '0', '用户撤销退款申请', 'SERVICE_014', null, '用户撤销退款申请推送消息给店长', '2', null, '用户对订单{orderno}撤销了退款申请~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('15', '1', '邦女郎进行项目申请操作', 'PROJECT_001', null, '邦女郎进行项目申请操作推送消息给店长', '2', null, '邦女郎-{beauticianname}，发起了项目申请，赶紧去处理~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('16', '1', '邦女郎处理门店项目邀约 （同意）', 'PROJECT_002', null, '邦女郎处理门店项目邀约 （同意）推送消息给店长', '2', null, '邦女郎-{beauticianname}，同意了门店的项目邀约', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('17', '1', '邦女郎处理门店项目邀约 （不同意）', 'PROJECT_003', null, '邦女郎处理门店项目邀约 （不同意）推送消息给店长', '2', null, '邦女郎-{beauticianname}，拒绝了门店的项目邀约', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('18', '1', '门店对邦女郎进行项目邀约', 'PROJECT_004', null, '门店对邦女郎进行项目邀约推送消息给美容师', '1', null, '门店对你进行项目邀请啦，去看看~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('19', '1', '门店处理邦女郎项目申请结果（同意）', 'PROJECT_005', null, '门店处理邦女郎项目申请结果（同意）推送消息给美容师', '1', null, '门店同意你的项目申请啦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('20', '1', '门店处理邦女郎项目申请结果（不同意）', 'PROJECT_006', null, '门店处理邦女郎项目申请结果（不同意）推送消息给美容师', '1', null, '门店拒绝了你的项目申请，试试申请其他的项目~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('21', '1', '平台处理邦女郎的课程评测', 'PROJECT_007', null, '平台处理邦女郎的课程评测推送送消息给美容师', '1', null, '恭喜你通过课程评测啦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('22', '2', '打款通知', 'SYSTEM_001', null, '后台给美容师提现申请打款推送消息给美容师', '1', null, '平台已经针对您的提现打款啦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('23', '2', '打款通知', 'SYSTEM_002', null, '后台给店铺月账单打款推送消息给店长', '2', null, '平台已经针对您的提现打款啦~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('24', '2', '邦女郎输入店铺码成功入驻门店', 'SYSTEM_003', null, '邦女郎输入店铺码成功入驻门店推送消息给店长', '2', null, '{beauticianname}已经成功入驻门店', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('25', '2', '邦女郎挂靠申请', 'SYSTEM_004', null, '邦女郎挂靠申请推送消息给店长', '2', null, '邦女郎-{beauticianname}，申请挂靠门店，赶紧去处理~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('26', '2', '邦女郎处理门店挂靠邀约', 'SYSTEM_005', null, '邦女郎处理门店挂靠邀约推送消息给店长', '2', null, '邦女郎-{beauticianname}，通过了门店挂靠邀请', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('27', '2', '邦女郎挂靠更改申请', 'SYSTEM_006', null, '邦女郎挂靠更改申请推送消息给店长', '2', null, '邦女郎-{beauticianname}，申请解除门店挂靠', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('28', '2', '门店处理邦女郎挂靠申请', 'SYSTEM_007', null, '门店处理邦女郎挂靠申请推送消息给美容师', '1', null, '邦女郎-{beauticianname}，申请解除门店挂靠', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('29', '2', '门店邀请邦女郎挂靠', 'SYSTEM_008', null, '门店邀请邦女郎挂靠推送消息给美容师', '1', null, '门店对你发起了挂靠邀约', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('30', '2', '门店处理邦女郎挂靠更改申请（同意）', 'SYSTEM_009', null, '门店处理邦女郎挂靠更改申请（同意）推送消息给美容师', '1', null, '门店同意了你的挂靠解除', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('31', '2', '门店处理邦女郎挂靠更改申请（不同意）', 'SYSTEM_010', null, '门店处理邦女郎挂靠更改申请（不同意）推送消息给美容师', '1', null, '门店拒绝了你的挂靠解除，试试联系客服吧~', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('32', '2', '平台处理邦女郎挂靠更改申请', 'SYSTEM_011', null, '平台处理邦女郎挂靠更改申请推送消息给美容师', '1', null, '平台审核通过了你的挂靠解除', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('33', '2', '培训课程开始前一天', 'SYSTEM_012', null, '培训课程开始前一天推送消息给美容师', '1', null, '请准时参加课程{coursename}，时间{coursetime}', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('34', '2', '活动开始前一天', 'SYSTEM_013', null, '活动开始前一天推送消息给美容师', '1', null, '请准时参加活动{activityname}，时间{activitytime}', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');
INSERT INTO `base_push_template` VALUES ('35', '2', '活动开始前一天', 'SYSTEM_014', null, '活动开始前一天推送消息给店长', '2', null, '请准时参加活动{activityname}，时间{activitytime}', null, '0', '2018-05-31 19:16:58', '2018-05-31 19:16:58');



ALTER TABLE `base_member_device`
	ADD COLUMN `token_online` INT NULL DEFAULT '1' COMMENT '同一个设备同一个权限用户谁在使用标识(0---不在线 1--在线，默认0)' AFTER `device_token`;

-- 2018-07-04
ALTER TABLE `beautybond_base`.`base_home_floor`
ADD COLUMN `title` varchar(60) NULL COMMENT '楼层标题名称' AFTER `jump_code`;
ALTER TABLE `beautybond_base`.`base_home_template`
MODIFY COLUMN `template_type` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '模板类型，1-顶部轮播区，2-服务类型区，3-活动区，4-商品区，5-底部导航区，6-导航按钮型区，4-商品区，5-底部导航区 ，6-导航按钮 ， 7-广告图 ，8-新人福利' AFTER `template_name`;
ALTER TABLE `beautybond_base`.`base_home_template`
MODIFY COLUMN `template_code` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '模板代码 首页轮播图：INDEX_ONE、 服务类型区：CODE_XX 、  活动区 ACTIVITY_ONE、  底部导航区 BOTTOM_NAVIGATION、 导航按钮 NAVIGATION_BUTTONS：INDEX_ONE、 服务类型区：CODE_XX 、  活动区 ACTIVITY_ONE、  底部导航区 BOTTOM_NAVIGATION、 广告图 ADVERTISING_FIGURE 、新人福利 NEW_WELFARE' AFTER `id`;


--20180720
ALTER TABLE `base_umeng_push_history`
	ADD COLUMN `target` INT(11) NULL DEFAULT NULL COMMENT '跳转类型(系统消息招募挂靠跳转参数)' AFTER `push_text`;
ALTER TABLE `base_umeng_push_history`
	ADD COLUMN `param` VARCHAR(200) NULL DEFAULT NULL COMMENT '参数(系统消息招募挂靠内容参数)' AFTER `target`;


SET FOREIGN_KEY_CHECKS = 1;