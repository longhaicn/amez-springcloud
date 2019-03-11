package com.union.aimei.common.feign.pc.financial;

import com.union.aimei.common.feign.pc.financial.hystrix.FinancialCommonHystrix;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(name = "pc-financial-service", fallback = FinancialCommonHystrix.class)
public interface FinancialCommonFeign {

    /**
     * 批量修改美容师,店铺,平台交易流水的订单状态
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/financialCommons/updateOrderStatus", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<Integer> updateOrderStatus(@RequestBody List<String> record);
}