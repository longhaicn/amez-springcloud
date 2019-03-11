package com.union.aimei.common.constant.store;

/**
 * 门店常量
 *
 * @author liurenkai
 * @time 2018/6/7 15:19
 */
public class StoreConstant {

    /**
     * 参数 1xxx
     */
    public interface Param {
        int PARSE_DATE_TIME_ERROR = 1001;
        String PARSE_DATE_TIME_ERROR_MSG = "解析时间错误";
    }

    /**
     * 保存 2xxx
     */
    public interface Save {
        int STORE_COUPONS_DISABLED = 2004;
        String STORE_COUPONS_DISABLED_MSG = "优惠券已删除";
        int STORE_COUPONS_OVER = 2005;
        String STORE_COUPONS_OVER_MSG = "优惠券活动已结束";
        int STORE_COUPONS_NOT_STARTED = 2006;
        String STORE_COUPONS_NOT_STARTED_MSG = "优惠券活动未开始";
        int STORE_COUPONS_RECEIVED_END = 2007;
        String STORE_COUPONS_RECEIVED_END_MSG = "优惠券已领完";
        int STORE_COUPONS_RECEIVED_LIMIT = 2008;
        String STORE_COUPONS_RECEIVED_LIMIT_MSG = "优惠券已限领";
        int STORE_COUPONS_RECEIVED_DISABLED = 2009;
        String STORE_COUPONS_RECEIVED_DISABLED_MSG = "领取的优惠券已删除";
        int STORE_COUPONS_RECEIVED_USED = 2010;
        String STORE_COUPONS_RECEIVED_USED_MSG = "领取的优惠券已使用";
        int STORE_COUPONS_RECEIVED_NOT_EXIST = 2011;
        String STORE_COUPONS_RECEIVED_NOT_EXIST_MSG = "没有领取的优惠券";
        int STORE_COUPONS_RECEIVED_SUCCESS = 2012;
        String STORE_COUPONS_RECEIVED_SUCCESS_MSG = "优惠券领取成功";
        int COLLECTION_STORE = 2013 ;
        String COLLECTION_STORE_MSG = "收藏的店铺失效" ;
        int COLLECTION_NULL_STORE = 2014 ;
        String COLLECTION_NULL_STORE_MSG = "无效店铺" ;
    }

    /**
     * 删除 3xxx
     */
    public interface Remove {

    }

    /**
     * 更新 4xxx
     */
    public interface Update {
        int FAIL = 4001;
        String FAIL_MSG = "更新门店失败";
        int STORE_CLOSEED = 4002;
        String STORE_CLOSEED_MSG = "门店已关闭";
        int STORE_BE_AUDITED = 4003;
        String STORE_BE_AUDITED_MSG = "门店待审核";
        int STORE_OPENED = 4004;
        String STORE_OPENED_MSG = "门店已开启";
        int STORE_FERRZEED = 4005;
        String STORE_FERRZEED_MSG = "门店已冻结";
        int STORE_STATE_NOT_EXIST = 4006;
        String STORE_STATE_NOT_EXIST_MSG = "门店状态";
        int STORE_SELECT_LIMIT = 4007;
        String STORE_SELECT_LIMIT_MSG = "精选门店数量已达上限";
        int BEAUTICIAN_STAR_LIMIT = 4008;
        String BEAUTICIAN_STAR_LIMIT_MSG = "明星美容师数量已达上限";
    }

    /**
     * 查询 5xxx
     */
    public interface Query {
        int FRIEND_NULL = 5001;
        String FRIEND_NULL_MSG = "朋友为空";
        int STORE_FRIEND_NULL = 5002;
        String STORE_FRIEND_NULL_MSG = "该门店朋友为空";
        int FOCUS = 5003;
        String FOCUS_MSG = "已收藏该门店";
        int CANCELLED_FOCUS = 5004;
        String CANCELLED_FOCUS_MSG = "已取消收藏该门店";
        int COUPONS_NULL = 5006;
        String COUPONS_NULL_MSG = "优惠券为空";
        int STORE_SERVICE_NULL = 5009;
        String STORE_SERVICE_NULL_MSG = "该门店暂无客服";
        int BEAUTICIAN_BUSINESS_HOUR_NULL = 5013;
        String BEAUTICIAN_BUSINESS_HOUR_NULL_MSG = "美容师营业时间为空";
        int BEAUTICIAN_BUSY_TIME_NULL = 5014;
        String BEAUTICIAN_BUSY_TIME_NULL_MSG = "美容师忙碌时间为空";
        int BEAUTICIAN_SERVICE_SCOPE_NULL = 5015;
        String BEAUTICIAN_SERVICE_SCOPE_NULL_MSG = "美容师服务范围为空";
        int STORE_SETTLED_CODE_NULL = 5016;
        String STORE_SETTLED_CODE_NULL_MSG = "无效的门店码";
        int AFFILIATED_APPLY_PENDING_EXIST = 5017;
        String AFFILIATED_APPLY_PENDING_EXIST_MSG = "你已申请了门店挂靠";
        int PRODUCT_NOT_BEANUTICIAN_SERVICE = 5017;
        String PRODUCT_NOT_BEANUTICIAN_SERVICE_MSG = "该项目暂无美容师服务";
        int BEAUTICIAN_MANAGER_NULL = 5018;
        String BEAUTICIAN_MANAGER_NULL_MSG = "店长为空";
        int AFFILIATED_NULL = 5019;
        String AFFILIATED_NULL_MSG = "挂靠为空";
        int AFFILIATED_STATUS_CHANGED = 5020;
        String AFFILIATED_STATUS_CHANGED_MSG = "挂靠状态已变更";
        int BEAUTICIAN_CANNOT_INVINATION = 5021;
        String BEAUTICIAN_CANNOT_INVINATION_MSG = "该美容师不能邀请";
        int BEAUTICIAN_INVINATION_EXIST = 5022;
        String BEAUTICIAN_INVINATION_EXIST_MSG = "你已邀请了该美容师";
        int BEAUTICIAN_LEVEL_EXIST = 5023;
        String BEAUTICIAN_LEVEL_EXIST_MSG = "美容师等级为空";

        int EMPTY = 5001;
        String EMPTY_MSG = "查询门店为空";
        int PRODUCT_EMPTY = 5002;
        String PRODUCT_EMPTY_MSG = "查询门店商品为空";
        int IS_FOCUS = 5003;
        String IS_FOCUS_MSG = "会员已收藏该门店";
        int STORE_EXTEND_NULL = 5004;
        String STORE_EXTEND_NULL_MSG = "门店扩展信息为空";
        int STORE_BEAUTICIAN_LEAVED = 5004;
        String STORE_BEAUTICIAN_LEAVED_MSG = "美容师已离职";
        int STORE_CLOSEED = 5005;
        String STORE_CLOSEED_MSG = "门店已关闭";
        int STORE_BE_AUDITED = 5006;
        String STORE_BE_AUDITED_MSG = "门店待审核";
        int STORE_FERRZEED = 5007;
        String STORE_FERRZEED_MSG = "门店已冻结";
        int BEAUTICIAN_PHONE_EXIST = 5008;
        String BEAUTICIAN_PHONE_EXIST_MSG = "手机号已存在";
        int BEAUTICIAN_NULL = 5009;
        String BEAUTICIAN_NULL_MSG = "美容师为空";
        int STORE_SELLER_EXIST = 5010;
        String STORE_SELLER_EXIST_MSG = "店长已存在";
        int BEAUTICIAN_STORE_MANAGER_NULL = 5011;
        String BEAUTICIAN_STORE_MANAGER_NULL_MSG = "该门店店长为空";
        int STORE_NULL = 5012;
        String STORE_NULL_MSG = "门店为空";
        int STORE_DISABLED = 5013;
        String STORE_DISABLED_MSG = "门店已删除";
        int BOSS_USER_STORE_NOT_EXIST = 5014;
        String BOSS_USER_STORE_NOT_EXIST_MSG = "该老板暂无门店";
        int BEAUTICIAN_REGISTER_STATUS_ERROR = 5015;
        String BEAUTICIAN_REGISTER_STATUS_ERROR_MSG = "美容师注册状态错误";
        int BEAUTICIAN_REGISTER_STATUS_INFO = 5016;
        String BEAUTICIAN_REGISTER_STATUS_INFO_MSG = "美容师待完善资料";
        int BEAUTICIAN_REGISTER_STATUS_EXAM = 5017;
        String BEAUTICIAN_REGISTER_STATUS_EXAM_MSG = "美容师待评测";
        int BEAUTICIAN_AUDIT_STATUS_ERROR = 5018;
        String BEAUTICIAN_AUDIT_STATUS_ERROR_MSG = "美容师审核状态错误";
        int BEAUTICIAN_AUDIT_STATUS_WAIT_AUDIT = 5019;
        String BEAUTICIAN_AUDIT_STATUS_WAIT_AUDIT_MSG = "美容师待审核";
        int BEAUTICIAN_AUDIT_STATUS_NOT_THROUGH = 5020;
        String BEAUTICIAN_AUDIT_STATUS_NOT_THROUGH_MSG = "美容师未通过审核";
        int BEAUTICIAN_STATUS_LEAVED = 5021;
        String BEAUTICIAN_STATUS_LEAVED_MSG = "美容师已离职";
        int AFFILIATED_TYPE_ERROR = 5023;
        String AFFILIATED_TYPE_ERROR_MSG = "挂靠类型错误";
        int AFFILIATED_STATUTS_CHANGED = 5024;
        String AFFILIATED_STATUTS_CHANGED_MSG = "挂靠状态已变更";
        int STORE_QUALIFICATION_STATUS_CHANGED = 5025;
        String STORE_QUALIFICATION_STATUS_CHANGED_MSG = "门店资质状态已变更";
        int BEAUTICIAN_WORK_CARD_NO_EXIST = 5026;
        String BEAUTICIAN_WORK_CARD_NO_EXIST_MSG = "工牌号已存在";
        int STORE_SELLER_PHONE_EXIST = 5027;
        String STORE_SELLER_PHONE_EXIST_MSG = "店长手机号已存在";
        int STORE_CHAIN_BRAND_NULL = 5028;
        String STORE_CHAIN_BRAND_NULL_MSG = "门店连锁品牌为空";
        int COUPONS_STORE_NULL = 5029;
        String COUPONS_STORE_NULL_MSG = "该门店暂无优惠券";
        int BEAUTICIAN_STORE_FULL_TIME_NULL = 5030;
        String BEAUTICIAN_STORE_FULL_TIME_NULL_MSG = "该门店暂无全职美容师";
        int STORE_MANAGER_ERROR = 5031;
        String STORE_MANAGER_ERROR_MSG = "门店店长数据错误";
        int BEAUTICIAN_NEARBY_NULL = 5032;
        String BEAUTICIAN_NEARBY_NULL_MSG = "附近美容师为空";
        int BEAUTICIAN_BUSINESS_HOUR_THAT_DAY_RESTED = 5033;
        String BEAUTICIAN_BUSINESS_HOUR_THAT_DAY_RESTED_MSG = "美容师当天休息";
        int STORE_OPEN_CITY_NULL = 5034;
        String STORE_OPEN_CITY_NULL_MSG = "门店开通城市为空";
    }

}
