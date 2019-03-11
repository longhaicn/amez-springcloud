

-- 2018-6-27
ALTER TABLE `order_comment`
ADD COLUMN `order_no`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '订单编号' AFTER `order_id`;

ALTER TABLE `order_return`
ADD COLUMN `refund_order_no`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '退款单号' AFTER `order_no`;

ALTER TABLE `order_base`
ADD COLUMN `one_card_reduce`  int(11) NULL DEFAULT 0 COMMENT '一卡通减免金额' AFTER `member_card_reduce`;


ALTER TABLE `order_refunds_consult_record`
MODIFY COLUMN `refuse_voucher`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '拒绝凭证' AFTER `refuse_remark`;


ALTER TABLE `order_product`
MODIFY COLUMN `store_id`  int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '店铺id' AFTER `id`;


ALTER TABLE `order_goods_base`
MODIFY COLUMN `beautician_belong_store_id`  int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '美容师所属门店ID' AFTER `pay_time`;



-- 2018-7-9
ALTER TABLE order_return CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER TABLE order_return MODIFY COLUMN `remark`  text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

--2018-7-12
ALTER TABLE `order_base`
ADD COLUMN `beautician_reply_comment_status`  tinyint(2) NULL DEFAULT 0 COMMENT '美容师回复评论状态（0：默认，1：用户已评价，美容师未回复，2：用户已评价，美容师已回复）' AFTER `status`;

--2018-7-17
ALTER TABLE `order_base`
ADD COLUMN `coupon_id`  int(11) NULL DEFAULT NULL COMMENT '优惠券ID' AFTER `one_card_reduce`;

--2018-7-18
ALTER TABLE order_base ADD one_card_discount int DEFAULT 0 NULL COMMENT '一卡通折扣（以100为基数）';
ALTER TABLE order_base MODIFY COLUMN one_card_discount int DEFAULT 0 COMMENT '一卡通折扣（以100为基数）' AFTER member_card_reduce;

--2018-7-19
ALTER TABLE order_return MODIFY store_id int(11) unsigned DEFAULT null  COMMENT '店铺id';
ALTER TABLE order_base ALTER COLUMN beautician_reply_comment_status SET DEFAULT 0;
ALTER TABLE order_base ALTER COLUMN anchored_store_id SET DEFAULT null;

--2018-7-25
ALTER TABLE order_comment ADD beautician_evaluation_grade tinyint(2) DEFAULT 0 NULL COMMENT '美容师评价等级(0：未评价，1：差评，2：中评，3：好评，4：系统默认好评)';
ALTER TABLE order_comment MODIFY COLUMN beautician_evaluation_grade tinyint(2) DEFAULT 0 COMMENT '美容师评价等级(0：未评价，1：差评，2：中评，3：好评，4：系统默认好评)' AFTER product_evaluation_grade;

ALTER TABLE order_comment ADD beautician_id int DEFAULT null  NULL COMMENT '订单美容师ID';
ALTER TABLE order_comment MODIFY COLUMN beautician_id int DEFAULT null  COMMENT '订单美容师ID' AFTER order_no;



--2018-08-10
ALTER TABLE order_base MODIFY beautician_reply_comment_status tinyint(2) DEFAULT '0' COMMENT '美容师回复评论状态（0：默认，1：用户已评价，美容师未回复，2：用户已评价，美容师已回复，3：系统默认好评）';
ALTER TABLE order_base MODIFY beautician_reply_comment_status tinyint(2) DEFAULT '0' COMMENT '美容师回复评论状态（0：用户未评价或删除评价，1：用户已评价，美容师未回复，2：用户已评价，美容师已回复，3：系统默认好评）';