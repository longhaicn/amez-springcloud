/*
Navicat MySQL Data Transfer

Source Server         : 艾美-美容邦测试数据库
Source Server Version : 50720
Source Host           : 120.79.42.13:3306
Source Database       : beautybond_base

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-04 16:47:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_app_update_version
-- ----------------------------
DROP TABLE IF EXISTS `base_app_update_version`;
CREATE TABLE `base_app_update_version` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version_code` int(11) DEFAULT NULL COMMENT '版本号',
  `version_name` varchar(12) DEFAULT NULL COMMENT '版本名字',
  `update_content` varchar(120) DEFAULT NULL COMMENT '描述',
  `update_url` varchar(255) DEFAULT NULL COMMENT 'apk路径',
  `app_system_type` int(11) DEFAULT NULL COMMENT 'app系统类型:1-安卓,2-ios',
  `app_client_type` int(11) DEFAULT NULL COMMENT 'app客户端类型:1-门店端,2-用户端,3-美容师端',
  `forced` int(11) DEFAULT '1' COMMENT '强制或者手动更新:1-强制更新,2-手动更新',
  `ignore_update` int(11) DEFAULT '1' COMMENT '是否忽更新:1-不忽略,2忽略',
  `md5` varchar(255) DEFAULT NULL COMMENT 'md5',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='升级表';

-- ----------------------------
-- Table structure for base_attachment
-- ----------------------------
DROP TABLE IF EXISTS `base_attachment`;
CREATE TABLE `base_attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_path` varchar(255) DEFAULT NULL COMMENT '附件保存路径',
  `file_name` varchar(255) DEFAULT NULL COMMENT '附件名称',
  `file_rename` varchar(255) DEFAULT NULL COMMENT '文件重命名',
  `file_suffix` varchar(255) DEFAULT NULL COMMENT '文件后缀',
  `file_size` double DEFAULT NULL COMMENT '文件大小，单位是字节',
  `file_url` varchar(500) DEFAULT NULL COMMENT '文件连接路径',
  `file_save_des` int(3) DEFAULT '1' COMMENT '文件保存的目标地，1本地保存，2远程服务器保存',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6045 DEFAULT CHARSET=utf8 COMMENT='方案附件表';

-- ----------------------------
-- Table structure for base_btn_menus
-- ----------------------------
DROP TABLE IF EXISTS `base_btn_menus`;
CREATE TABLE `base_btn_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `btn_name` varchar(64) DEFAULT NULL COMMENT '按钮名字',
  `btn_desc` varchar(64) DEFAULT NULL COMMENT '描述',
  `btn_code` int(11) DEFAULT NULL,
  `btn_index` int(11) DEFAULT NULL,
  `oper_code` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remarks` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8 COMMENT='按钮权限';

-- ----------------------------
-- Table structure for base_dic_group
-- ----------------------------
DROP TABLE IF EXISTS `base_dic_group`;
CREATE TABLE `base_dic_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '字典名',
  `code` varchar(100) DEFAULT NULL COMMENT '字典代码',
  `description` varchar(255) DEFAULT NULL COMMENT '字典描述',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='数据字典表';

-- ----------------------------
-- Table structure for base_dic_group_item
-- ----------------------------
DROP TABLE IF EXISTS `base_dic_group_item`;
CREATE TABLE `base_dic_group_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL COMMENT '字典id',
  `code` varchar(100) DEFAULT NULL COMMENT '字典子项代码',
  `value` varchar(255) DEFAULT NULL COMMENT '字典子项值',
  `name` varchar(100) DEFAULT NULL COMMENT '字典子项名称',
  `description` varchar(255) DEFAULT NULL COMMENT '字典子项描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='数据字典子项表';

-- ----------------------------
-- Table structure for base_home_template
-- ----------------------------
DROP TABLE IF EXISTS `base_home_template`;
CREATE TABLE `base_home_template` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '首页模板ID',
  `template_code` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '模板代码',
  `template_name` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '模板名称',
  `template_type` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '模板类型，1-顶部轮播区，2-服务类型区，3-活动区，4-商品区，5-底部导航区',
  `template_content` text COLLATE utf8_bin COMMENT '模板内容',
  `sort` int(3) DEFAULT '0' COMMENT '排序',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='首页模板';

-- ----------------------------
-- Table structure for base_logs
-- ----------------------------
DROP TABLE IF EXISTS `base_logs`;
CREATE TABLE `base_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(60) DEFAULT NULL COMMENT '账号名称',
  `department_name` varchar(60) DEFAULT NULL COMMENT '部门名称',
  `login_time` date DEFAULT NULL COMMENT '登录时间',
  `is_login` tinyint(1) DEFAULT NULL COMMENT '是否登录成功1成功,0失败',
  `login_ip` varchar(255) DEFAULT NULL COMMENT '登录Ip地址',
  `remarks` varchar(120) DEFAULT NULL COMMENT '操作内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Table structure for base_member_device
-- ----------------------------
DROP TABLE IF EXISTS `base_member_device`;
CREATE TABLE `base_member_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `member_id` int(11) DEFAULT NULL COMMENT '会员id，登陆人员的id',
  `device_system` int(11) DEFAULT '0' COMMENT '设备所属用户权限：0--用户端  1 --美容师端 2--店长端，默认0',
  `device_type` int(2) DEFAULT NULL COMMENT '会员手机类型 1--android系统 2--ios系统',
  `device_token` varchar(100) DEFAULT NULL COMMENT 'umeng集成token',
  `token_online` int(11) DEFAULT '1' COMMENT '同一个设备同一个权限用户谁在使用标识(0---不在线 1--在线，默认0)',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=latin1 COMMENT='会员设备码表';

-- ----------------------------
-- Table structure for base_menu
-- ----------------------------
DROP TABLE IF EXISTS `base_menu`;
CREATE TABLE `base_menu` (
  `menu_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '菜单Id',
  `parent_id` int(10) DEFAULT NULL COMMENT '父类菜单Id',
  `menu_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单类型',
  `menu_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单名称',
  `menu_code` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单栏目代码',
  `menu_url` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单请求地址',
  `sort_no` int(3) DEFAULT '0' COMMENT '菜单排序号',
  `menu_logo` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单logo图标',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='基础菜单表';

-- ----------------------------
-- Table structure for base_operator
-- ----------------------------
DROP TABLE IF EXISTS `base_operator`;
CREATE TABLE `base_operator` (
  `oper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '页面按钮的操作Id',
  `oper_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '页面按钮的操作名称',
  `oper_code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '页面按钮的操作码',
  `oper_url` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '页面按钮的操作地址',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) DEFAULT NULL COMMENT '操作属于哪个菜单页面的Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='操作权限表';

-- ----------------------------
-- Table structure for base_region
-- ----------------------------
DROP TABLE IF EXISTS `base_region`;
CREATE TABLE `base_region` (
  `region_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '父级Id',
  `region_name` varchar(120) NOT NULL DEFAULT '' COMMENT '地区名',
  `region_type` tinyint(1) NOT NULL DEFAULT '2' COMMENT '地区类型 0国家 1省份 2城市 3区',
  `agency_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `region_sn` varchar(20) NOT NULL COMMENT '地区简写',
  `buildin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否系统内建',
  `lastchanged` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`region_id`),
  KEY `parent_id` (`parent_id`),
  KEY `region_type` (`region_type`),
  KEY `agency_id` (`agency_id`),
  KEY `region_sn` (`region_sn`)
) ENGINE=InnoDB AUTO_INCREMENT=990136 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='地区';

-- ----------------------------
-- Table structure for base_role
-- ----------------------------
DROP TABLE IF EXISTS `base_role`;
CREATE TABLE `base_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `role_level` int(2) DEFAULT '0' COMMENT '角色优先级',
  `role_code` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `create_userid` int(11) DEFAULT NULL COMMENT '角色的创建者Id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `uk_role_name` (`role_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表';

-- ----------------------------
-- Table structure for base_role_operator
-- ----------------------------
DROP TABLE IF EXISTS `base_role_operator`;
CREATE TABLE `base_role_operator` (
  `role_id` int(11) DEFAULT NULL COMMENT '角色Id',
  `menu_id` int(11) DEFAULT NULL COMMENT '权限Id',
  `oper_id` int(11) DEFAULT NULL COMMENT '操作Id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色权限表';

-- ----------------------------
-- Table structure for base_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `base_role_resources`;
CREATE TABLE `base_role_resources` (
  `role_id` int(11) DEFAULT NULL COMMENT '角色Id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单Id',
  `oper_id` int(11) DEFAULT NULL COMMENT '操作Id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3029 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色权限表';

-- ----------------------------
-- Table structure for base_schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `base_schedule_job`;
CREATE TABLE `base_schedule_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '定时任务Id',
  `job_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '定时任务名称',
  `job_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'job唯一代码',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `job_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '定时任务完整类名称',
  `job_method` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '定时任务方法名称',
  `job_state` tinyint(5) NOT NULL DEFAULT '0' COMMENT '常job状态,1正常运行，2运行异',
  `cron_expression` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '定时任务的Corn表达式',
  `is_enable` tinyint(5) DEFAULT NULL COMMENT '是否启用，1启用，0禁用',
  `is_concurrent` tinyint(5) NOT NULL DEFAULT '0' COMMENT '能否并发运行，1可以，0不可以',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='定时任务表';

-- ----------------------------
-- Table structure for base_sms_history
-- ----------------------------
DROP TABLE IF EXISTS `base_sms_history`;
CREATE TABLE `base_sms_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sms_name` varchar(120) DEFAULT NULL COMMENT '短信名称',
  `sms_code` varchar(255) DEFAULT NULL COMMENT '短信编码',
  `sms_template` varchar(500) DEFAULT NULL COMMENT '短信模板',
  `sms_content` varchar(500) DEFAULT NULL COMMENT '短信内容',
  `sms_type` tinyint(4) DEFAULT NULL COMMENT '短信类型(0验证码,1短信通知,2短信推广)',
  `receive_phone` varchar(11) DEFAULT NULL COMMENT '接收短信的手机号码',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `response_message` varchar(240) DEFAULT NULL COMMENT '返回状态码解释',
  `response_code` varchar(64) DEFAULT NULL COMMENT '返回状态码',
  `RequestId` varchar(64) DEFAULT NULL COMMENT '	请求ID',
  `BizId` varchar(64) DEFAULT NULL COMMENT '发送回执ID,可根据该ID查询具体的发送状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1740 DEFAULT CHARSET=utf8 COMMENT='已发送的短信历史表';

-- ----------------------------
-- Table structure for base_sms_template
-- ----------------------------
DROP TABLE IF EXISTS `base_sms_template`;
CREATE TABLE `base_sms_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sms_name` varchar(120) DEFAULT NULL COMMENT '短信名称',
  `sms_code` varchar(255) DEFAULT NULL COMMENT '短信编码',
  `sms_template` varchar(500) DEFAULT NULL COMMENT '短信模板',
  `sms_type` tinyint(4) DEFAULT NULL COMMENT '短信类型(0验证码,1短信通知,2短信推广)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `remarks` varchar(240) DEFAULT NULL COMMENT '备注',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='短信模板表';

-- ----------------------------
-- Table structure for base_umeng_push_history
-- ----------------------------
DROP TABLE IF EXISTS `base_umeng_push_history`;
CREATE TABLE `base_umeng_push_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `template_id` int(11) DEFAULT NULL COMMENT '模板Id',
  `device_token` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '发送设备token',
  `device_type` int(11) DEFAULT '0' COMMENT '1--android系统 2--ios系统',
  `msg_type` int(11) DEFAULT '0' COMMENT '消息类型(0--服务通知  1--招募通知 2--活动通知)',
  `msg_code` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户消息的类型集合(service,recruit,activity)',
  `member_id` int(11) DEFAULT NULL COMMENT '会员的id',
  `push_ticker` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '必填，通知栏通知信息',
  `push_title` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '必填，通知标题',
  `push_text` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '必填，通知文字描述',
  `custom` varchar(2000) CHARACTER SET utf8 DEFAULT NULL COMMENT '自定义内容',
  `forward_type` varchar(10) DEFAULT NULL COMMENT '跳转类型(0---app原生  1---html5)',
  `forward_url` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '跳转页面url',
  `read_status` varchar(2) CHARACTER SET utf8 DEFAULT '0' COMMENT '读取状态 0--未读取 1--已读取 2--删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1170 DEFAULT CHARSET=latin1 COMMENT='友盟消息推送记录';

-- ----------------------------
-- Table structure for base_umeng_push_template
-- ----------------------------
DROP TABLE IF EXISTS `base_umeng_push_template`;
CREATE TABLE `base_umeng_push_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `send_type` int(11) DEFAULT NULL COMMENT '推送类型(0--服务通知  1--招募通知 2--活动通知)',
  `receiver_type` int(11) DEFAULT NULL COMMENT '接收消息者(1--店长 2-- 用户 3--美容师)',
  `push_ticker` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '必填，通知栏通知信息',
  `push_title` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '必填，通知标题',
  `push_text` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '必填，通知内容',
  `member_id` int(11) DEFAULT NULL COMMENT '会员id',
  `device_token` varchar(100) DEFAULT NULL COMMENT '推送手机得device_token',
  `push_time` varchar(50) DEFAULT NULL COMMENT '推送时间。(如果是定时，填写需要推送得时间)格式 yyyy-MM-dd HH:mm:ss',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='U盟第三方推送模板表';

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `mobile_phone` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_disabled` tinyint(11) DEFAULT '0' COMMENT '是否禁用 0启用 1禁用',
  `user_type` varchar(11) DEFAULT 'admin' COMMENT '前台用户：front,后台用户:admin',
  `last_login_time` timestamp NULL DEFAULT NULL,
  `expir_etime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_login_name` (`login_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=873 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for base_user_role
-- ----------------------------
DROP TABLE IF EXISTS `base_user_role`;
CREATE TABLE `base_user_role` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `right_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`right_id`),
  KEY `idx_user_id` (`user_id`) USING BTREE,
  KEY `idx_role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=953 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色关联表';
