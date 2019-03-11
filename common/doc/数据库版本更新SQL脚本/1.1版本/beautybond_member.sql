

-- ----------------------------
-- Table structure for member_withdraws
-- ----------------------------
ALTER TABLE `beautybond_member`.`member_withdraws`
ADD COLUMN `trade_detail_id` int(11) NULL COMMENT '美容师流水id' AFTER `beautician_id`,
ADD COLUMN `expect_amount_time` timestamp(0) NULL DEFAULT NULL COMMENT '预计打款时间' AFTER `play_amount_time`;

ALTER TABLE `beautybond_member`.`member_real_name_auth`
ADD COLUMN `other_related_certificates` VARCHAR(1500) NULL DEFAULT NULL COMMENT '邦女郎(其他相关证书)' AFTER `id_card_handheld_phone`;


ALTER TABLE `beautybond_member`.`member_real_name_auth`
ADD COLUMN `phone` VARCHAR(20) NULL DEFAULT NULL COMMENT '手机号码' AFTER `id_card`;

---20180720
ALTER TABLE `member_bank_card`
	ADD COLUMN `bankname_branch` VARCHAR(50) NULL DEFAULT NULL COMMENT '开户银行支行名称' AFTER `bankname`;
