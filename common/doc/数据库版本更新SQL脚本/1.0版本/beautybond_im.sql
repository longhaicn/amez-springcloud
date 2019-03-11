/*
Navicat MySQL Data Transfer

Source Server         : 艾美-美容邦测试数据库
Source Server Version : 50720
Source Host           : 120.79.42.13:3306
Source Database       : beautybond_im

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-04 16:48:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for im_chat_groups
-- ----------------------------
DROP TABLE IF EXISTS `im_chat_groups`;
CREATE TABLE `im_chat_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `easemob_group_id` varchar(50) DEFAULT NULL COMMENT '群组ID',
  `name` varchar(50) DEFAULT NULL COMMENT '群组名称',
  `description` varchar(200) DEFAULT NULL COMMENT '群组描述',
  `is_public` char(1) DEFAULT NULL COMMENT '群组类型：true：公开群，false：私有群',
  `membersonly` char(1) DEFAULT NULL COMMENT '加入群组是否需要群主或者群管理员审批。true：是，false：否',
  `allowinvites` char(1) DEFAULT NULL COMMENT '是否允许群成员邀请别人加入此群。 true：允许群成员邀请人加入此群，false：只有群主才可以往群里加人',
  `maxusers` int(11) DEFAULT NULL COMMENT '群成员上限，创建群组的时候设置，可修改',
  `affiliations_count` int(11) DEFAULT NULL COMMENT '现有成员总数',
  `owner` varchar(50) DEFAULT NULL COMMENT '群主的环信 ID',
  `invite_need_confirm` char(1) DEFAULT NULL COMMENT '邀请加群，被邀请人是否需要确认。如果是true，表示邀请加群需要被邀请人确认；如果是false，表示不需要被邀请人确认，直接将被邀请人加入群。 该字段的默认值为true。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='IM群组';

-- ----------------------------
-- Table structure for im_chat_groups_users
-- ----------------------------
DROP TABLE IF EXISTS `im_chat_groups_users`;
CREATE TABLE `im_chat_groups_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` int(11) DEFAULT NULL COMMENT '群组ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='IM群组用户';

-- ----------------------------
-- Table structure for im_messages
-- ----------------------------
DROP TABLE IF EXISTS `im_messages`;
CREATE TABLE `im_messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `msg_id` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '消息ID',
  `send_time` bigint(13) DEFAULT NULL COMMENT '消息发送时间',
  `direction` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '方向',
  `from_name` varchar(60) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '发送人',
  `to_name` varchar(60) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '接收人',
  `chat_type` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '聊天类型（chat: 单聊；groupchat: 群聊）',
  `msg_type` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '消息类型',
  `ext` text CHARACTER SET utf8mb4 COMMENT '扩展属性',
  `bodies` text CHARACTER SET utf8mb4 COMMENT '消息体',
  `get_time` bigint(13) DEFAULT NULL COMMENT '获取时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='IM消息';

-- ----------------------------
-- Table structure for im_messages_audio
-- ----------------------------
DROP TABLE IF EXISTS `im_messages_audio`;
CREATE TABLE `im_messages_audio` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `url` varchar(200) DEFAULT NULL COMMENT '地址',
  `file_name` varchar(50) DEFAULT NULL COMMENT '文件名',
  `length` int(11) DEFAULT NULL COMMENT '时长',
  `secret` varchar(50) DEFAULT NULL COMMENT '秘钥',
  `file_length` int(11) DEFAULT NULL COMMENT '语音附件大小（单位：字节）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='IM语音消息';

-- ----------------------------
-- Table structure for im_messages_cmd
-- ----------------------------
DROP TABLE IF EXISTS `im_messages_cmd`;
CREATE TABLE `im_messages_cmd` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `action` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='IM透传消息';

-- ----------------------------
-- Table structure for im_messages_file
-- ----------------------------
DROP TABLE IF EXISTS `im_messages_file`;
CREATE TABLE `im_messages_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `url` varchar(200) DEFAULT NULL COMMENT '地址',
  `file_name` varchar(50) DEFAULT NULL COMMENT '文件名',
  `secret` varchar(50) DEFAULT NULL COMMENT '秘钥',
  `file_length` int(11) DEFAULT NULL COMMENT '文件附件大小（单位：字节）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='IM文件消息';

-- ----------------------------
-- Table structure for im_messages_img
-- ----------------------------
DROP TABLE IF EXISTS `im_messages_img`;
CREATE TABLE `im_messages_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `url` varchar(200) DEFAULT NULL COMMENT '地址',
  `file_name` varchar(50) DEFAULT NULL COMMENT '文件名',
  `secret` varchar(50) DEFAULT NULL COMMENT '秘钥',
  `width` int(11) DEFAULT NULL COMMENT '宽度',
  `height` int(11) DEFAULT NULL COMMENT '高度',
  `file_length` int(11) DEFAULT NULL COMMENT '图片附件大小（单位：字节）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='IM图片消息';

-- ----------------------------
-- Table structure for im_messages_loc
-- ----------------------------
DROP TABLE IF EXISTS `im_messages_loc`;
CREATE TABLE `im_messages_loc` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `addr` varchar(200) DEFAULT NULL COMMENT '地址',
  `lat` double(11,5) DEFAULT NULL COMMENT '纬度',
  `lng` double(11,5) DEFAULT NULL COMMENT '经度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='IM地理位置消息';

-- ----------------------------
-- Table structure for im_messages_txt
-- ----------------------------
DROP TABLE IF EXISTS `im_messages_txt`;
CREATE TABLE `im_messages_txt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `msg` varchar(2000) DEFAULT NULL COMMENT '消息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='IM文本消息';

-- ----------------------------
-- Table structure for im_messages_video
-- ----------------------------
DROP TABLE IF EXISTS `im_messages_video`;
CREATE TABLE `im_messages_video` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `url` varchar(200) DEFAULT NULL COMMENT '地址',
  `file_name` varchar(50) DEFAULT NULL COMMENT '文件名',
  `length` int(11) DEFAULT NULL COMMENT '时长',
  `secret` varchar(50) DEFAULT NULL COMMENT '秘钥',
  `file_length` int(11) DEFAULT NULL COMMENT '视频附件大小（单位：字节）',
  `thumb` varchar(200) DEFAULT NULL COMMENT '缩略图',
  `thumb_secret` varchar(50) DEFAULT NULL COMMENT '缩略图秘钥',
  `thumb_width` int(11) DEFAULT NULL COMMENT '视频缩略图宽度',
  `thumb_height` int(11) DEFAULT NULL COMMENT '视频缩略图高度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='IM视频消息';

-- ----------------------------
-- Table structure for im_users
-- ----------------------------
DROP TABLE IF EXISTS `im_users`;
CREATE TABLE `im_users` (
  `id` int(36) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uuid` varchar(60) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '环信ID',
  `username` varchar(60) DEFAULT NULL COMMENT '用户名',
  `password` varchar(60) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '密码',
  `type` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '类型，user-用户',
  `online_status` tinyint(2) DEFAULT '0' COMMENT '在线状态，0-离线，1-在线',
  `activated` tinyint(1) DEFAULT NULL COMMENT '是否激活',
  `created` bigint(13) DEFAULT NULL COMMENT '创建时间',
  `modified` bigint(13) DEFAULT NULL COMMENT '修改时间',
  `get_time` bigint(13) DEFAULT NULL COMMENT '获取时间',
  `result_cursor` varchar(60) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '结果集的指针（直到没有这个字段，说明已经到最后一页）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1488 DEFAULT CHARSET=utf8 COMMENT='IM用户';

-- ----------------------------
-- Table structure for im_users_blocks
-- ----------------------------
DROP TABLE IF EXISTS `im_users_blocks`;
CREATE TABLE `im_users_blocks` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `block_name` varchar(50) DEFAULT NULL COMMENT '黑名单用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='IM用户黑名单';

-- ----------------------------
-- Table structure for im_users_friends
-- ----------------------------
DROP TABLE IF EXISTS `im_users_friends`;
CREATE TABLE `im_users_friends` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `friend_name` varchar(50) DEFAULT NULL COMMENT '好友用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='IM用户好友';
