package com.union.aimei.app.api.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.RefundObject;
import com.union.aimei.app.api.order.service.OrderReturnService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,13:58
 */
@Api(tags = "退换货单")
@RestController
@RequestMapping(value = "orderReturn")
public class OrderReturnController {
    @Resource
    private OrderReturnService orderReturnService;

    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<OrderReturn>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                            Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                            Integer pageSize, @ApiParam(value = "查询条件")@RequestBody OrderReturn orderReturn) {
        return this.orderReturnService.findByPageForFront(pageNo, pageSize, orderReturn);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody OrderReturn orderReturn) {
        return this.orderReturnService.addObj(orderReturn);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable int id) {
        return this.orderReturnService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody OrderReturn orderReturn) {
        return this.orderReturnService.modifyObj(orderReturn);
    }

    @GetMapping("/queryById/{id}")
    public OrderReturn queryById(@PathVariable int id) {
        return this.orderReturnService.queryObjById(id);
    }


    @GetMapping("/queryReturnInfoByOrderNo/{orderNo}")
    public ResponseMessage<OrderReturn> queryByOrderNo(@PathVariable(value = "orderNo") String orderNo){
         return  orderReturnService.queryByOrderNo(orderNo);
    }

    /**
     * 根据订单号查询退款对象
     * @param orderNo
     * @return
     */
    @RequestMapping(value = "/queryRefundObject/{orderNo}",method = RequestMethod.GET)
    public ResponseMessage<RefundObject> queryRefundObject(@PathVariable(value = "orderNo") String orderNo){
         return orderReturnService.queryRefundObject(orderNo);
    }
}