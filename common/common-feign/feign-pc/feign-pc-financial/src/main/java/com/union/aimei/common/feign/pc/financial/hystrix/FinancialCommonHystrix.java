package com.union.aimei.common.feign.pc.financial.hystrix;

import com.union.aimei.common.feign.pc.financial.FinancialCommonFeign;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author dell
 */
@Component(value = "pc-FinancialCommonFeign")
public class FinancialCommonHystrix implements FinancialCommonFeign {

    /**
     * 批量修改美容师,店铺,平台交易流水的订单状态
     *
     * @param record
     * @return
     */
    @Override
    public ResponseMessage<Integer> updateOrderStatus(List<String> record) {
        return null;
    }
}
