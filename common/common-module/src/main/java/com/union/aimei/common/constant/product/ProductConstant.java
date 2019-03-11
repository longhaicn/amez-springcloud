package com.union.aimei.common.constant.product;

/**
 * 项目常量
 *
 * @author liurenkai
 * @time 2018/6/7 15:19
 */
public class ProductConstant {

    /**
     * 参数 1xxx
     */
    public interface Param {

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
        int PRODUCT_COLLECTION_COLLECTIONED = 2013;
        String PRODUCT_COLLECTION_COLLECTIONED_MSG = "项目已收藏";
        int PRODUCT_COLLECTION_CANCELED = 2014;
        String PRODUCT_COLLECTION_CANCELED_MSG = "项目已取消收藏";
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
    }

    /**
     * 查询 5xxx
     */
    public interface Query {
        int EMPTY = 5001;
        String EMPTY_MSG = "查询数据为空";
        int PRODUCT_INVENTORY_NOT_ENOUGH = 5002;
        String PRODUCT_INVENTORY_NOT_ENOUGH_MSG = "项目库存不足";
        int PHYSICAL_INVENTORY_NOT_ENOUGH = 5003;
        String PHYSICAL_INVENTORY_NOT_ENOUGH_MSG = "产品库存不足";
        int FREIGHT_TEMPLATE_NOT_EXIST = 5004;
        String FREIGHT_TEMPLATE_NOT_EXIST_MSG = "运费模板不存在";
        int FREIGHT_TEMPLATE_CITY_NOT_EXIST = 5005;
        String FREIGHT_TEMPLATE_CITY_NOT_EXIST_MSG = "运费模板城市不存在";
        int PHYSICAL_NOT_EXIST = 5006;
        String PHYSICAL_NOT_EXIST_MSG = "产品不存在";
        int PRODUCT_BEAUTICIAN_REF_NOT_EXIST = 5007;
        String PRODUCT_BEAUTICIAN_REF_NOT_EXIST_MSG = "服务邀请不存在";
        int PRODUCT_NOT_STORE_ON_SALE = 5008;
        String PRODUCT_NOT_STORE_ON_SALE_MSG = "暂无店铺提供该服务";
        int PRICING_METHOD_NOT_EXIST = 5009;
        String PRICING_METHOD_NOT_EXIST_MSG = "计价方式不存在";
        int PRODUCT_ACTIVITY_NOT_EXIST = 5010;
        String PRODUCT_ACTIVITY_NOT_EXIST_MSG = "项目活动不存在";
        int PRODUCT_NULL = 5011;
        String PRODUCT_NULL_MSG = "项目为空";
        int PRODUCT_IMG_NULL = 5012;
        String PRODUCT_IMG_NULL_MSG = "项目图片为空";
        int PRODUCT_COLLECTION_COLLECTED = 5013;
        String PRODUCT_COLLECTION_COLLECTED_MSG = "项目已收藏";
        int PRODUCT_COLLECTION_CANCELED = 5014;
        String PRODUCT_COLLECTION_CANCELED_MSG = "项目已取消收藏";
        int PRODUCT_COLLECTION_NOT_COLLECTION = 5015;
        String PRODUCT_COLLECTION_NOT_COLLECTION_MSG = "您还未收藏项目";
        int BEAUTICIAN_NULL = 5016;
        String BEAUTICIAN_NULL_MSG = "美容师为空";
        int BEAUTICIAN_STORE_SELF_NOT_RIGHT = 5017;
        String BEAUTICIAN_STORE_SELF_NOT_RIGHT_MSG = "您没有权限查看门店自营项目";
        int PHYSICAL_INVENTORY_CANCEL_ORDER_RESERVATION_NOT_ENOUGH = 5018;
        String PHYSICAL_INVENTORY_CANCEL_ORDER_RESERVATION_NOT_ENOUGH_MSG = "订单可取消预约的产品库存不足";
        int PHYSICAL_INVENTORY_ORDER_CONSUMPTION_NOT_ENOUGH = 5019;
        String PHYSICAL_INVENTORY_ORDER_CONSUMPTION_NOT_ENOUGH_MSG = "订单可消耗的产品库存不足";
        int PHYSICAL_INVENTORY_PURCHASE_RESERVATION_NOT_ENOUGH = 5020;
        String PHYSICAL_INVENTORY_PURCHASE_RESERVATION_NOT_ENOUGH_MSG = "可采购预约的产品库存不够";
        int PHYSICAL_INVENTORY_PURCHASE_RESERVATION_ERROR = 5021;
        String PHYSICAL_INVENTORY_PURCHASE_RESERVATION_ERROR_MSG = "采购预约产品库存错误";
        int PHYSICAL_INVENTORY_CANCEL_PURCHASE_RESERVATION_NOT_ENOUGH = 5022;
        String PHYSICAL_INVENTORY_CANCEL_PURCHASE_RESERVATION_NOT_ENOUGH_MSG = "采购可入库的产品库存不足";
        int PHYSICAL_INVENTORY_PURCHASE_RESERVATION_STORAGE_NOT_ENOUGH = 5023;
        String PHYSICAL_INVENTORY_PURCHASE_RESERVATION_STORAGE_NOT_ENOUGH_MSG = "采购预约可入库的产品库存不足";
        int PRODUCT_APPLYED = 5024;
        String PRODUCT_APPLYED_MSG = "项目已申请";
        int PRODUCT_STORE_NULL = 5025;
        String PRODUCT_STORE_NULL_MSG = "该门店项目为空";
        int PRODUCT_OFF_SHELVES = 5026;
        String PRODUCT_OFF_SHELVES_MSG = "项目已下架";
        int PRODUCT_CATEGORY_NULL = 5027;
        String PRODUCT_CATEGORY_NULL_MSG = "项目分类为空";
        int PHYSICAL_PRODUCT_NULL = 5028;
        String PHYSICAL_PRODUCT_NULL_MSG = "该项目下产品为空";
        int FREIGHT_TEMPLATE_NAME_EXISTED = 5029;
        String FREIGHT_TEMPLATE_NAME_EXISTED_MSG = "运费模板名称已存在";
        int PHYSICAL_INVENTORY_ORDER_RESERVATION_NOT_ENOUGH = 5030;
        String PHYSICAL_INVENTORY_ORDER_RESERVATION_NOT_ENOUGH_MSG = "产品库存订单预约数不足";
    }

}
