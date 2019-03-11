/*
 Navicat Premium Data Transfer

 Source Server         : amez
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 120.79.42.13:3306
 Source Schema         : beautybond_learn

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 12/06/2018 13:34:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `mtitle` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '主标题',
  `stitle` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '副标题',
  `type` int(11) NULL DEFAULT 0 COMMENT '活动类型(0-- 美容师 1--门店端)',
  `icon` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '活动小图标',
  `publisher` int(11) NULL DEFAULT 0 COMMENT '发布者(0--平台 1--门店，默认平台)',
  `description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '活动详细说明',
  `banner_img` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '置顶banner图',
  `top_status` tinyint(4) NULL DEFAULT 0 COMMENT '是否置顶(0--不置顶 1--置顶，默认0)',
  `weight_top` int(11) NULL DEFAULT NULL COMMENT '置顶帖权重值',
  `province_id` int(11) NULL DEFAULT NULL COMMENT '省id',
  `province_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '省名称',
  `city_id` int(11) NULL DEFAULT NULL COMMENT '市id',
  `city_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '市名称',
  `district_id` int(11) NULL DEFAULT NULL COMMENT '区id',
  `district_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '区名称',
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '活动详细地址',
  `enterstart_time` timestamp(0) NULL DEFAULT NULL COMMENT '活动报名起始时间',
  `enterend_time` timestamp(0) NULL DEFAULT NULL COMMENT '活动报名结束时间',
  `start_time` timestamp(0) NULL DEFAULT NULL COMMENT '活动起始时间',
  `end_time` timestamp(0) NULL DEFAULT NULL COMMENT '活动结束时间',
  `weekday_start` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '活动时间(周几)',
  `day_length` int(11) NULL DEFAULT NULL COMMENT '活动时长(天)',
  `hour_length` int(11) NULL DEFAULT NULL COMMENT '活动时长(小时)',
  `costs` int(11) NULL DEFAULT NULL COMMENT '活动费用',
  `attentions` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '注意事项',
  `limited` int(11) NULL DEFAULT NULL COMMENT '人数限制',
  `conditions` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '报名条件',
  `growth_value` int(11) NULL DEFAULT NULL COMMENT '活动成长值',
  `tag` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标签',
  `status` int(11) NULL DEFAULT 0 COMMENT '活动状态(0--创建未开启 1--活动报名中  2--活动进行中 3--活动结束，默认0)',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '活动表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for activity_member_ref
-- ----------------------------
DROP TABLE IF EXISTS `activity_member_ref`;
CREATE TABLE `activity_member_ref`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `activity_id` int(11) NULL DEFAULT NULL COMMENT '活动id',
  `memeber_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `sex` tinyint(1) NULL DEFAULT 0 COMMENT '性别(0--女 1--男)',
  `tag` int(11) NULL DEFAULT 0 COMMENT '参加人标签(0-老板，1-店长，2-全职员工，3-兼职员工，4-朋友 )',
  `contact_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系人手机号',
  `store_id` int(11) NULL DEFAULT NULL COMMENT '店铺id',
  `store_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '店铺名称',
  `trade_ref_id` int(11) NULL DEFAULT NULL COMMENT '支付交易记录refid',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  `weekday_entry` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '报名周几',
  `weekday_end` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '完成周几',
  `status` tinyint(4) NULL DEFAULT 0 COMMENT '状态(0--已经报名 1--以完成 2--报名未成功)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户活动表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `topic_id` int(11) NULL DEFAULT NULL COMMENT '题目ID',
  `answer_code` int(11) NULL DEFAULT NULL COMMENT '答案代码',
  `answer` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '答案',
  `is_right` tinyint(1) NULL DEFAULT NULL COMMENT '1-正确，0-错误',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `is_enabled` tinyint(1) NULL DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '答案' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `article_type` tinyint(4) NULL DEFAULT 0 COMMENT '0--邦女郎 1--门店，默认0',
  `mtitle` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文章标题',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '小图标',
  `main_img` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文章图片',
  `article_tag` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文章标签',
  `top_status` tinyint(4) NULL DEFAULT 0 COMMENT '0--不置顶 1--首页置顶，默认0',
  `weight_top` int(11) NULL DEFAULT NULL COMMENT '置顶权重值(值越大，列表排序越靠前)',
  `release_status` int(11) NULL DEFAULT 0 COMMENT '发布状态 0--未发布 1--发布  2--下线 3--删除(软删除)',
  `article_detail` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '文章详情',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `release_time` timestamp(0) NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '文章' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `registration_begin` timestamp(0) NULL DEFAULT NULL COMMENT '报名开始时间',
  `registration_end` timestamp(0) NULL DEFAULT NULL COMMENT '报名结束时间',
  `cover_img` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程封面图',
  `course_attention` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '培训的注意事项',
  `course_code` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程编码',
  `before_course_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '前置课程ids',
  `before_course_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '前置课程names',
  `course_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程名字',
  `course_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '培训内容',
  `course_label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程标签，有多个用 , 分割',
  `training_begin` timestamp(0) NULL DEFAULT NULL COMMENT '培训开始时间',
  `training_end` timestamp(0) NULL DEFAULT NULL COMMENT '培训结束时间',
  `training_hours` int(11) NULL DEFAULT NULL COMMENT '培训小时',
  `training_day` int(11) NULL DEFAULT NULL COMMENT '培训天数',
  `growth_value` int(11) NULL DEFAULT 0 COMMENT '成长值',
  `training_expenses` int(11) NULL DEFAULT 0 COMMENT '培训费用',
  `is_free` tinyint(1) NULL DEFAULT 0 COMMENT '是否免费，0-免费，1-收费',
  `training_allow_number` int(11) NULL DEFAULT 0 COMMENT '允许报名的人数',
  `is_restrict` tinyint(1) NULL DEFAULT 0 COMMENT '是否有人数限制，0-无限制，1-有限制',
  `course_status` tinyint(1) NULL DEFAULT 0 COMMENT '课程状态 （0-未发布、1-已发布）',
  `training_status` tinyint(2) NULL DEFAULT 0 COMMENT '培训状态 （0-未开始、1-进行中、2-已结束）',
  `province_id` int(11) NULL DEFAULT NULL COMMENT '省id',
  `city_id` int(11) NULL DEFAULT NULL COMMENT '市id',
  `area_id` int(11) NULL DEFAULT NULL COMMENT '区id',
  `province_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '省名称',
  `city_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '市名称',
  `area_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '县城市',
  `store_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '详细地区',
  `store_longitude` decimal(10, 7) NULL DEFAULT NULL COMMENT '经度，长度10位，小数点后7位',
  `store_latitude` decimal(10, 7) NULL DEFAULT NULL COMMENT '纬度，长度10位，小数点后7位',
  `training_out_number` int(11) NULL DEFAULT 0 COMMENT '报名超出的人数',
  `training_count_number` int(11) NULL DEFAULT 0 COMMENT '已报名的人数统计',
  `training_review_number` int(11) NULL DEFAULT 0 COMMENT '已评测的人数统计',
  `is_condition` tinyint(1) NULL DEFAULT 0 COMMENT '是否有门槛 0-否 1-是',
  `is_enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `permissions_sort` int(11) NULL DEFAULT 0 COMMENT '权重排序，数值越高拍越前',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 74 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_beautician_ref
-- ----------------------------
DROP TABLE IF EXISTS `course_beautician_ref`;
CREATE TABLE `course_beautician_ref`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `trade_ref_id` int(11) NOT NULL COMMENT '支付交易记录refid',
  `course_id` int(11) NOT NULL COMMENT '课程id',
  `beautician_id` int(11) NOT NULL COMMENT '美容师id',
  `member_id` int(11) NOT NULL COMMENT '会员id',
  `beautician_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学员名字',
  `mobile_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `gender` tinyint(1) NULL DEFAULT 0 COMMENT '性别，0-男、1-女',
  `school_roll` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学籍号',
  `evaluate_score` int(11) NULL DEFAULT NULL COMMENT '评测分数',
  `evaluate_answer` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '评测答案（中间用小写逗号分隔开）',
  `evaluate_time` timestamp(0) NULL DEFAULT NULL COMMENT '评测时间',
  `beauti_training_end` timestamp(0) NULL DEFAULT NULL COMMENT '美容师培训通过的结束时间',
  `learning_status` tinyint(2) NULL DEFAULT 0 COMMENT '学习通过状态（0-未通过、1-已通过）',
  `sign_status` tinyint(2) NULL DEFAULT 1 COMMENT '签到状态（0-未签到、1-已签到）',
  `is_training_out` tinyint(1) NULL DEFAULT 0 COMMENT '是否为超出的人数 0-否 1-是',
  `is_scheduling` tinyint(1) NULL DEFAULT 0 COMMENT '是否做了保存美容师项目开通权限的操作(针对已学习完) 0-否 1-是',
  `is_enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 126 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '课程-美容师-关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `course_evaluate`;
CREATE TABLE `course_evaluate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `course_id` int(11) NULL DEFAULT NULL COMMENT '课程id',
  `questions_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '题目',
  `questions_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '选项1',
  `questions_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '选项2',
  `questions_three` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '选项3',
  `questions_four` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '选项4',
  `answer` tinyint(2) NULL DEFAULT NULL COMMENT '答案(0-A，1-B，2-C，3-D)',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `is_enabled` tinyint(1) NULL DEFAULT 1 COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 347 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '课程试题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_product_ref
-- ----------------------------
DROP TABLE IF EXISTS `course_product_ref`;
CREATE TABLE `course_product_ref`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `course_id` int(11) NULL DEFAULT NULL COMMENT '课程id',
  `server_id` int(11) NULL DEFAULT NULL COMMENT '服务id',
  `server_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '服务名称',
  `server_type_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '服务类型名字',
  `is_support_home` tinyint(1) NULL DEFAULT NULL COMMENT '支持上门标记，1-是，0-否',
  `is_enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 244 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '课程适用的服务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exam_paper
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper`;
CREATE TABLE `exam_paper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `beautician_id` int(11) NULL DEFAULT NULL COMMENT '美容师ID',
  `paper_id` int(11) NULL DEFAULT NULL COMMENT '试卷ID',
  `exam_score` int(11) NULL DEFAULT NULL COMMENT '考试分数',
  `score_code` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '分数等级代码',
  `score_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '分数等级名称',
  `score_desc` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '分数等级描述',
  `is_pass` tinyint(1) NULL DEFAULT NULL COMMENT '1-及格，0-未及格',
  `is_enabled` tinyint(1) NULL DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '考试试卷' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exam_paper_answer
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper_answer`;
CREATE TABLE `exam_paper_answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `exam_paper_topic_id` int(11) NULL DEFAULT NULL COMMENT '考试试卷题目ID',
  `answer_id` int(11) NULL DEFAULT NULL COMMENT '答案ID',
  `answer_code` int(11) NULL DEFAULT NULL COMMENT '答案代码',
  `answer` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '答案',
  `is_right` tinyint(1) NULL DEFAULT NULL COMMENT '是否正确，1-正确，0-错误',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `is_select` tinyint(1) NULL DEFAULT NULL COMMENT '是否选择，1-选择，0-未选择',
  `is_enabled` tinyint(1) NULL DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '考试试卷答案' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exam_paper_topic
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper_topic`;
CREATE TABLE `exam_paper_topic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `exam_paper_id` int(11) NULL DEFAULT NULL COMMENT '考试试卷ID',
  `paper_topic_id` int(11) NULL DEFAULT NULL COMMENT '试卷题目ID',
  `topic` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '题目',
  `topic_type` int(11) NULL DEFAULT NULL COMMENT '题目类型，1-单选题 ，2-多选题',
  `score` int(11) NULL DEFAULT NULL COMMENT '分数',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `is_right` tinyint(1) NULL DEFAULT NULL COMMENT '1-正确，0-错误',
  `is_enabled` tinyint(1) NULL DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '考试试卷题目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for faq
-- ----------------------------
DROP TABLE IF EXISTS `faq`;
CREATE TABLE `faq`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '分类ID',
  `question` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '问题',
  `answer` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '答案',
  `is_enabled` tinyint(1) NULL DEFAULT 1 COMMENT '1-正常，0-删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '常见问题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for faq_catetory
-- ----------------------------
DROP TABLE IF EXISTS `faq_catetory`;
CREATE TABLE `faq_catetory`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category_code` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '分类代码',
  `category_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '分类名称',
  `pid` int(11) NULL DEFAULT NULL COMMENT '0-顶级分类',
  `is_enabled` tinyint(1) NULL DEFAULT 1 COMMENT '1-正常，0-删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '常见问题分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for learn_condition
-- ----------------------------
DROP TABLE IF EXISTS `learn_condition`;
CREATE TABLE `learn_condition`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `source_id` int(11) NULL DEFAULT NULL COMMENT '源id',
  `source_type` tinyint(2) NULL DEFAULT NULL COMMENT '类型 0-课程 1-活动(美容师) 2-活动(店铺)',
  `condition_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '条件名字描述',
  `conditional_data` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '条件判断（固定值直接录入，指定值用 , 区分，区间值用 - 区分）',
  `conditional_according` tinyint(2) NULL DEFAULT NULL COMMENT '判断依据，0-并且，1-或者，2-不等，3-以上，4-以下',
  `conditional_type` tinyint(2) NULL DEFAULT NULL COMMENT '条件类型，0-认证美容师，1-兼职美容师，2-全职美容师，3-有挂靠门店 ，4-等级(美容师) ，5-星级 ， 6认证门店 ， 7-等级(店铺)',
  `is_enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 228 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '门槛条件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for learn_img
-- ----------------------------
DROP TABLE IF EXISTS `learn_img`;
CREATE TABLE `learn_img`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `source_type` int(11) NULL DEFAULT 0 COMMENT '学习图片的类型 0--活动 1--课程 2--文章，默认0',
  `source_id` int(11) NULL DEFAULT NULL COMMENT '来源id',
  `img_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图片url',
  `main_status` tinyint(4) NULL DEFAULT 0 COMMENT '0--正常图片  1--主图片，默认0',
  `broadcast_status` tinyint(4) NULL DEFAULT 0 COMMENT '0--不是轮播图 1--选为轮播图，默认0',
  `sort` int(11) NULL DEFAULT NULL COMMENT '轮播图排序',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 432 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '学习图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for learn_trade_recode
-- ----------------------------
DROP TABLE IF EXISTS `learn_trade_recode`;
CREATE TABLE `learn_trade_recode`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `source_id` int(11) NULL DEFAULT NULL COMMENT '来源id',
  `source_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '来源名字',
  `source_type` tinyint(2) NULL DEFAULT NULL COMMENT '来源类型 0-课程 ， 1-活动',
  `source_rel_id` int(11) NULL DEFAULT NULL COMMENT '来源关联id',
  `pay_type` tinyint(2) NULL DEFAULT NULL COMMENT '支付类型 0-微信、1-支付宝、2-银联、3-他人支付',
  `pay_status` tinyint(1) NULL DEFAULT 0 COMMENT '支付状态，0-未支付 1-已支付',
  `trade_amount` int(11) NULL DEFAULT 0 COMMENT '交易金额（以分为单位存入）',
  `actual_trade_amount` int(11) NULL DEFAULT 0 COMMENT '实际交易金额（以分为单位存入）',
  `order_no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '订单号',
  `trade_no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '交易流水号',
  `is_enabled` tinyint(4) NOT NULL DEFAULT 1 COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员的id',
  `beautician_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学员名字',
  `mobile_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别，0-男、1-女',
  `beautician_id` int(11) NULL DEFAULT NULL COMMENT '美容师id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 211 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '交易记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `paper_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '试卷名称',
  `paper_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '试卷说明',
  `topic_num` int(11) NULL DEFAULT NULL COMMENT '题目数',
  `total_score` int(11) NULL DEFAULT NULL COMMENT '总分数',
  `pass_score` int(11) NULL DEFAULT NULL COMMENT '及格分数',
  `paper_duration` int(11) NULL DEFAULT NULL COMMENT '单位/分',
  `paper_status` int(11) NULL DEFAULT 0 COMMENT '试卷状态，0-未使用，1-使用中，2-已作废',
  `is_enabled` tinyint(1) NULL DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '试卷' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for paper_topic
-- ----------------------------
DROP TABLE IF EXISTS `paper_topic`;
CREATE TABLE `paper_topic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `paper_id` int(11) NULL DEFAULT NULL COMMENT '试卷ID',
  `topic_id` int(11) NULL DEFAULT NULL COMMENT '题目ID',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `is_enabled` tinyint(1) NULL DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '试卷题目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `paper_id` int(11) NULL DEFAULT NULL COMMENT '试卷ID',
  `topic` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '题目',
  `topic_type` int(11) NULL DEFAULT NULL COMMENT '题目类型，1-单选题 ，2-多选题',
  `score` int(11) NULL DEFAULT NULL COMMENT '分数',
  `is_enabled` tinyint(1) NULL DEFAULT NULL COMMENT '1-正常，0-删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '题目' ROW_FORMAT = Dynamic;


ALTER TABLE `beautybond_learn`.`course_beautician_ref`
MODIFY COLUMN `learning_status` tinyint(2) NULL DEFAULT 2 COMMENT '学习通过状态（0-未通过、1-已通过、2-初始化状态）' AFTER `beauti_training_end`;


ALTER TABLE `activity_member_ref`
	ADD COLUMN `beautician_id` INT(11) NULL DEFAULT NULL COMMENT '美容师id' AFTER `memeber_id`;

alter table beautybond_learn.article add sub_heading varchar(50) comment '副标题'

ALTER TABLE `beautybond_learn`.`course`
MODIFY COLUMN `course_status` tinyint(2) NULL DEFAULT 0 COMMENT '课程状态 （0-未发布、1-已发布、2-已撤回）' AFTER `is_restrict`;



ALTER TABLE `activity`
	ADD COLUMN `entered_sum` INT(11) NULL DEFAULT '0' COMMENT '已经报名的人数' AFTER `limited`,


SET FOREIGN_KEY_CHECKS = 1;
