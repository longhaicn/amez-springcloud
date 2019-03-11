package com.union.aimei.pc.financial.service;

import java.util.List;

/**
 * FinancialCommonService
 *
 * @author liufeihua
 * @date 2018/4/19 10:36
 */
public interface FinancialCommonService {
    /**
     * 更新状态
     * @param record
     * @return
     */
    int updateOrderStatus(List<String> record);
}
