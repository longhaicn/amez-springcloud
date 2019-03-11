package com.union.aimei.pc.financial.controller;

import com.union.aimei.pc.financial.service.FinancialCommonService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @author dell
 */
@Api(tags = "交易流水的共同操作", description = "api")
@RestController
@RequestMapping("/financialCommons")
public class FinancialCommonController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FinancialCommonService financialCommonService;


    @ApiOperation("批量修改美容师,店铺,平台交易流水的订单状态")
    @RequestMapping(value = "/updateOrderStatus", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateOrderStatus(@RequestBody List<String> record) {
        financialCommonService.updateOrderStatus(record);
        return new ResponseMessage<>();
    }


}