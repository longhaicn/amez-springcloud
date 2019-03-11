package com.union.aimei.app.api.order;

import com.union.aimei.common.feign.app.order.OrderRefundsConsultRecordFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gaowei
 */
@Api(tags="服务订单-退款协商记录表")
@RestController
@RequestMapping(value="orderRefundsConsultRecord")
public class OrderRefundsConsultRecordApiController {

       @Resource
       private OrderRefundsConsultRecordFeign orderRefundsConsultRecordFeign;




       /**
        * 查询协商记录
        * @param orderNo
        * @return
        */
       @ApiOperation(httpMethod = "GET", value = "通过订单编号查询协商记录")
       @GetMapping(value = "/queryConsultRecords/{orderNo}")
       public ResponseMessage queryConsultRecords(
               @RequestParam(value = "pageNo",defaultValue = "0")Integer pageNo,
               @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
               @PathVariable(value = "orderNo") String orderNo){
              return orderRefundsConsultRecordFeign.queryConsultRecords(pageNo,pageSize,orderNo);
       }
}