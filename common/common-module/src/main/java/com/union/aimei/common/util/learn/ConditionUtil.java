package com.union.aimei.common.util.learn;

import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 条件工具
 *
 * @author liurenkai
 * @time 2018/6/7 16:32
 */
public class ConditionUtil {

    /**
     * 通过美容师
     *
     * @return
     */
    public static Map<String, Object> passBeautician() {
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("beauticianAuditStatus", StoreBeautician.AuditStatus.PASS);
        condMap.put("registerStatus", StoreBeautician.RegisterStatus.PASS);
        condMap.put("realNameStatus", StoreBeautician.RealNameStatus.PASS);
        return condMap;
    }

    /**
     * 全职，兼职美容师
     *
     * @return
     */
    public static Map<String, Object> fullpartTimeBeautician() {
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeState", Store.StoreState.OPEN);
        condMap.put("auditStatus", StoreBeautician.AuditStatus.PASS);
        condMap.put("beauticianAuditStatus", StoreBeautician.AuditStatus.PASS);
        List<Integer> beauticianTypeList = new ArrayList<>(10);
        beauticianTypeList.add(StoreBeautician.BeauticianType.FULL_TIME);
        beauticianTypeList.add(StoreBeautician.BeauticianType.PART_TIME);
        condMap.put("beauticianTypeList", beauticianTypeList);
        return condMap;
    }

    /**
     * 开启中门店
     *
     * @return
     */
    public static Map<String, Object> openStore() {
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeState", Store.StoreState.OPEN);
        condMap.put("qualificationStatus", Store.QualificationStatus.PASS);
        return condMap;
    }

    /**
     * 上架服务
     */
    public static Map<String, Object> onSaleProduct() {
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productAuditStatus", Product.AuditStatus.PASS);
        condMap.put("productSaleStatus", Product.SaleStatus.ON_SALE);
        return condMap;
    }

    /**
     * 上架门店服务
     */
    public static Map<String, Object> onSaleStoreProduct() {
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productAuditStatus", Product.AuditStatus.PASS);
        condMap.put("productSaleStatus", Product.SaleStatus.ON_SALE);
        condMap.put("storeSaleStatus", Product.SaleStatus.ON_SALE);
        return condMap;
    }

}
