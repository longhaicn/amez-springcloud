/*
Navicat MySQL Data Transfer

Source Server         : 艾美-美容邦测试数据库
Source Server Version : 50720
Source Host           : 120.79.42.13:3306
Source Database       : beautybond_order

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-04 16:49:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for express_company
-- ----------------------------
DROP TABLE IF EXISTS `express_company`;
CREATE TABLE `express_company` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `company_name` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '快递公司名称',
  `company_code` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '快递公司编码',
  `type` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '类型',
  `country_code` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '国家编码',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='快递公司信息表';

-- ----------------------------
-- Table structure for order_base
-- ----------------------------
DROP TABLE IF EXISTS `order_base`;
CREATE TABLE `order_base` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `store_id` int(11) unsigned DEFAULT NULL COMMENT '店铺id',
  `anchored_store_id` int(11) DEFAULT NULL COMMENT '挂靠店铺ID',
  `store_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '店铺名称',
  `store_phone` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '门店电话',
  `store_logo` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '店铺logo',
  `order_source` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单来源(0：app商城，1：微信商城)',
  `order_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单编号',
  `trade_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第三方交易流水号 如：微信支付流水号',
  `type` int(2) unsigned NOT NULL DEFAULT '0' COMMENT '订单类型 0.到店服务订单 1.上门服务订单',
  `status` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '订单状态,0：待付款;1:交易关闭;2:待服务;3:服务中;4:待评价;5:评价完成 ',
  `nums` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '商品总数量',
  `amount_total` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '订单总金额',
  `freight` int(11) unsigned DEFAULT '0' COMMENT '上门服务费',
  `pay_type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付方式  wechatpay、alipay，memberCardPay,oneCardPay,balancePay',
  `need_pay` int(11) DEFAULT '0' COMMENT '应付金额',
  `amount_pay` int(11) unsigned DEFAULT '0' COMMENT '实际支付金额',
  `point` int(11) unsigned DEFAULT NULL COMMENT '兑换总积分',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `return_status` int(11) unsigned DEFAULT '0' COMMENT '退换货和退款状态，0表示无申请，1退款中，2退款完成',
  `member_id` int(11) unsigned NOT NULL COMMENT '会员ID',
  `member_phone` varchar(11) CHARACTER SET utf8 DEFAULT '17704060592' COMMENT '用户手机号码',
  `member_real_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '会员姓名',
  `member_nick_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '会员昵称',
  `customer_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '上门服务顾客姓名',
  `customer_phone` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '上门服务顾客电话',
  `customer_address` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '上门服务顾客地址',
  `customer_longitude` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '上门顾客经度',
  `customer_latitude` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '上门顾客地址纬度',
  `card_id` int(11) unsigned DEFAULT NULL COMMENT '我的会员卡ID ',
  `card_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '卡券编号',
  `card_type_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '卡券类型名称',
  `preferential_amount` int(11) unsigned DEFAULT '0' COMMENT '优惠规则匹配减免金额',
  `member_card_reduce` int(11) DEFAULT '0' COMMENT '会员卡减免金额',
  `coupon_reduce` int(11) DEFAULT '0' COMMENT '优惠券减免金额',
  `amount_reduce` int(11) unsigned DEFAULT '0' COMMENT '减免总金额',
  `appointment_time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预约时间',
  `address_id` int(11) unsigned DEFAULT NULL COMMENT '收货地址ID',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细地址',
  `address_phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `address_reveiver` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人姓名',
  `address_regson` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货地址所在省市县地区信息',
  `server_start_time` datetime DEFAULT NULL COMMENT '服务开始时间',
  `server_end_time` datetime DEFAULT NULL COMMENT '服务结束时间',
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `receive_time` datetime DEFAULT NULL COMMENT '确认收货时间',
  `return_time` datetime DEFAULT NULL COMMENT '退款时间',
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `qr_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二维码',
  `verification_code` varchar(4) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '验证码',
  `actual_start_time` datetime DEFAULT NULL COMMENT '服务实际开始时间',
  `actual_end_time` datetime DEFAULT NULL COMMENT '服务实际结束时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_order_no` (`order_no`),
  UNIQUE KEY `uk_trade_no` (`trade_no`),
  KEY `idx_store_id` (`store_id`) USING BTREE,
  KEY `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1760 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单';

-- ----------------------------
-- Table structure for order_beautician
-- ----------------------------
DROP TABLE IF EXISTS `order_beautician`;
CREATE TABLE `order_beautician` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` int(11) unsigned DEFAULT NULL COMMENT '订单ID',
  `store_id` int(11) unsigned DEFAULT NULL COMMENT '店铺ID',
  `store_seller_phone` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '店长手机号码',
  `store_seller_member_id` int(11) DEFAULT NULL COMMENT '店长会员ID',
  `beautician_id` int(11) unsigned DEFAULT NULL COMMENT '美容师id',
  `beautician_im_user_id` int(11) DEFAULT NULL COMMENT '美容师IM用户ID',
  `beautician_im_user_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '美容师IM用户名称',
  `beautician_member_id` int(11) DEFAULT NULL COMMENT '美容师会员ID',
  `img_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '美容师头像地址',
  `beautician_name` varchar(255) DEFAULT NULL COMMENT '美容师名称',
  `beautician_nick_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '美容师昵称',
  `beautician_commission` int(11) DEFAULT '0' COMMENT '美容师佣金',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `type` tinyint(2) DEFAULT '2' COMMENT '类型0-老板，1-店长，2-正式员工，3-兼职员工',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1603 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='订单美容师';

-- ----------------------------
-- Table structure for order_comment
-- ----------------------------
DROP TABLE IF EXISTS `order_comment`;
CREATE TABLE `order_comment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `has_cancel` tinyint(1) DEFAULT '0' COMMENT '是否已删除过评论(0:没有删除，1：已删除)',
  `order_id` int(11) unsigned DEFAULT NULL COMMENT '订单ID',
  `store_id` int(11) unsigned DEFAULT NULL COMMENT '店铺ID',
  `store_name` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '店铺名称',
  `product_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `procut_name` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '商品名',
  `product_img` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '商品图片',
  `member_id` int(11) unsigned DEFAULT NULL COMMENT '会员ID',
  `member_name` varchar(255) DEFAULT NULL COMMENT '会员名称',
  `member_img_url` varchar(255) DEFAULT NULL COMMENT '会员头像',
  `parent_comment_id` int(11) unsigned DEFAULT NULL COMMENT '回复的评论ID',
  `parent_beautician_id` int(11) unsigned DEFAULT NULL COMMENT '回复评论的美容师id',
  `parent_beautician_name` varchar(255) DEFAULT NULL COMMENT '回复评论的美容师名称',
  `content` varchar(1500) DEFAULT '' COMMENT '评论内容',
  `reply_content` varchar(1500) CHARACTER SET utf8 DEFAULT '' COMMENT '美容师回复内容',
  `reply_time` datetime DEFAULT NULL COMMENT '美容师回复时间',
  `servicecredit` mediumint(8) NOT NULL COMMENT '服务描述相符,1-5对应页面的星星',
  `store_environment` mediumint(8) NOT NULL COMMENT '美容院环境,1-5对应页面的星星',
  `beautician_server_quality` mediumint(8) NOT NULL COMMENT '美容师服务质量,1-5对应页面的星星',
  `label_code` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '评论标签编码',
  `oper_type` int(3) DEFAULT '1' COMMENT '操作类型,1为评论，2为回复',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `is_checked` tinyint(1) NOT NULL DEFAULT '1' COMMENT '审核标识，1为已审核,0为未审核',
  `is_anonymity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否匿名，1为不匿名,0为匿名',
  `comment_num` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '回复数',
  `like_num` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '点赞数',
  `product_evaluation_grade` tinyint(2) DEFAULT '0' COMMENT '服务评价等级(0:未评价，1：差评，2：中评,3：好评，4:系统自动好评)默认0',
  `store_evaluation_grade` tinyint(2) DEFAULT '0' COMMENT '店铺评价等级(0:未评价，1：差评，2：中评,3：好评，4:系统自动好评)默认0',
  `has_img` tinyint(1) DEFAULT '0' COMMENT '是否有图(0:没有，1:有)',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='订单评论';

-- ----------------------------
-- Table structure for order_comment_img
-- ----------------------------
DROP TABLE IF EXISTS `order_comment_img`;
CREATE TABLE `order_comment_img` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) NOT NULL COMMENT '订单评论ID',
  `comment_img_url` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '订单评论图片地址',
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='订单评论图片表';

-- ----------------------------
-- Table structure for order_goods_base
-- ----------------------------
DROP TABLE IF EXISTS `order_goods_base`;
CREATE TABLE `order_goods_base` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '实物订单id',
  `order_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单编号',
  `trade_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第三方交易流水号 如：微信支付流水号',
  `status` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '订单状态0：待付款;1:待发货,2:待收货,3:已收货',
  `nums` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '商品总数量',
  `amount_total` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '订单总金额',
  `pay_type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付方式  wechatpay、alipay，memberCardPay,oneCardPay,balancePay',
  `amount_pay` int(11) unsigned DEFAULT '0' COMMENT '实际支付金额',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `beautician_belong_store_id` int(11) unsigned NOT NULL COMMENT '美容师所属门店ID',
  `beautician_belong_store_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '美容师所属门店名称',
  `beautician_id` int(11) unsigned NOT NULL COMMENT '美容师ID',
  `beautician_type` tinyint(2) DEFAULT NULL COMMENT '美容师类型(0:店长，1：兼职员工)',
  `beautician_phone` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '美容师手机号码',
  `beautician_real_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '美容师姓名',
  `beautician_nick_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '美容师昵称',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细地址',
  `address_phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货地址号码',
  `address_reveiver` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人姓名',
  `address_regson` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货地址所在省市县地区信息',
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `postage` int(11) DEFAULT '0' COMMENT '邮费',
  `express_company_code` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '快递公司编码',
  `express_company_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '快递公司名称',
  `delivery_order_no` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发货单号',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `receive_time` datetime DEFAULT NULL COMMENT '确认收货时间',
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_order_no` (`order_no`),
  UNIQUE KEY `uk_trade_no` (`trade_no`),
  KEY `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='实物订单表';

-- ----------------------------
-- Table structure for order_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `order_goods_info`;
CREATE TABLE `order_goods_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_goods_base_id` int(11) NOT NULL COMMENT '实物订单ID',
  `product_physical_id` int(11) DEFAULT NULL COMMENT '实物产品ID',
  `physical_name` varchar(60) CHARACTER SET utf8 DEFAULT NULL COMMENT '产品名称',
  `cover_img` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '封面图',
  `physical_img` text CHARACTER SET utf8 COMMENT '产品图',
  `nums` int(11) NOT NULL DEFAULT '0' COMMENT '数量',
  `sale_price` int(11) DEFAULT '0' COMMENT '单价',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='实物订单产品信息表';

-- ----------------------------
-- Table structure for order_product
-- ----------------------------
DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order_product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单商品关联ID',
  `store_id` int(11) unsigned NOT NULL COMMENT '店铺id',
  `order_id` int(11) unsigned NOT NULL COMMENT '订单id',
  `product_id` int(11) unsigned NOT NULL COMMENT '商品id',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `server_need_time` int(11) DEFAULT '0' COMMENT '服务时长(以分为单位)',
  `product_img` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品图片',
  `product_price` int(11) unsigned DEFAULT NULL COMMENT '商品单价或加钱购金额',
  `product_point` int(11) unsigned DEFAULT NULL COMMENT '产品兑换积分',
  `type` tinyint(3) DEFAULT '0' COMMENT '类型 0 默认，1 全额积分兑换 2 加钱购兑换',
  `nums` int(11) unsigned DEFAULT NULL COMMENT '单个商品数量',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1652 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单--商品--关联';

-- ----------------------------
-- Table structure for order_product_consume_goods_record
-- ----------------------------
DROP TABLE IF EXISTS `order_product_consume_goods_record`;
CREATE TABLE `order_product_consume_goods_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_id` int(11) DEFAULT NULL COMMENT '订单ID',
  `product_id` int(11) DEFAULT NULL COMMENT '服务ID',
  `product_physical_id` int(11) DEFAULT NULL COMMENT '实物产品id',
  `product_physical_name` varchar(60) CHARACTER SET utf8 DEFAULT NULL COMMENT '实物产品名称',
  `sale_price` int(11) DEFAULT NULL COMMENT '销售价格',
  `physical_code` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '产品编码',
  `cover_img` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '封面图',
  `unit` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '单位',
  `consume_num` int(11) DEFAULT NULL COMMENT '消耗数量',
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '消耗时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单-服务消耗实物产品记录表';

-- ----------------------------
-- Table structure for order_refunds_consult_record
-- ----------------------------
DROP TABLE IF EXISTS `order_refunds_consult_record`;
CREATE TABLE `order_refunds_consult_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_return_id` int(11) DEFAULT NULL COMMENT '订单退款ID',
  `apply_member_id` int(11) DEFAULT NULL COMMENT '退款申请人ID',
  `apply_member_head_img` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '申请人头像',
  `apply_member_nickname` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '申请人昵称',
  `apply_time` datetime DEFAULT NULL COMMENT '申请退款时间',
  `apply_reason` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '退款原因',
  `apply_remark` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '申请原因详细说明',
  `refuse_person_id` int(11) DEFAULT NULL COMMENT '拒绝人ID',
  `refuse_person_head_img` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '拒绝人头像',
  `refuse_person_nickname` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '拒绝人昵称',
  `refuse_time` datetime DEFAULT NULL COMMENT '拒绝时间',
  `refuse_remark` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '拒绝说明',
  `refuse_voucher` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '拒绝凭证',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '是否有效(1:有效，0：无效，默认1)',
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `oper_type` tinyint(2) DEFAULT '0' COMMENT '操作人类型(0：买家，1：卖家，2：平台)',
  `oper_content` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '操作说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='服务订单-退款协商记录表';

-- ----------------------------
-- Table structure for order_return
-- ----------------------------
DROP TABLE IF EXISTS `order_return`;
CREATE TABLE `order_return` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_id` int(11) unsigned NOT NULL COMMENT '店铺id',
  `order_id` int(11) unsigned NOT NULL COMMENT '退换货的订单id',
  `order_no` varchar(32) DEFAULT NULL COMMENT '退换货的订单号',
  `member_id` int(11) unsigned NOT NULL COMMENT '会员id',
  `member_name` varchar(50) DEFAULT NULL COMMENT '会员名称',
  `return_type` tinyint(3) NOT NULL COMMENT '退换货类型，1换货，2退款',
  `return_status` tinyint(3) DEFAULT '1' COMMENT '申请退换货的状态，1申请中，2审核通过,3:审核未通过',
  `reason` varchar(255) DEFAULT NULL COMMENT '退货理由',
  `fee` int(11) unsigned DEFAULT NULL COMMENT '退款总金额',
  `apply_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `audit_time` datetime DEFAULT NULL COMMENT '审核通过时间',
  `delivery_name` varchar(255) DEFAULT NULL COMMENT '退货物流商名称',
  `delivery_code` varchar(32) DEFAULT NULL COMMENT '退货物流单号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  `update_count` int(11) DEFAULT '1' COMMENT '修改次数(最多允许4次，默认为1)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COMMENT='退换货单';

-- ----------------------------
-- Table structure for order_return_product
-- ----------------------------
DROP TABLE IF EXISTS `order_return_product`;
CREATE TABLE `order_return_product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_id` int(11) unsigned DEFAULT NULL COMMENT '店铺id',
  `order_return_id` int(11) unsigned DEFAULT NULL COMMENT '退换货单id',
  `product_id` int(11) unsigned DEFAULT NULL COMMENT '产品id',
  `product_name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `product_img` varchar(255) DEFAULT NULL COMMENT '产品封面',
  `nums` int(11) unsigned DEFAULT NULL COMMENT '产品退货数量',
  `return_fee` varchar(255) DEFAULT NULL COMMENT '产品退款金额',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '软删除标记，1为正常，0为删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='退换货的申请明细';
