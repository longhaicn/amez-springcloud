package com.union.aimei.app.api.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.LogisticsInfoVo;
import com.union.aimei.common.vo.order.OrderGoodsDetailVo;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.aimei.common.vo.order.SubmitProductGoodsVo;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.aimei.app.api.order.service.OrderGoodsBaseService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
  * @author GaoWei
  * @Date 18-8-13 下午1:46
  * @description
  */
@Api(tags="实物订单表")
@RestController
@RequestMapping(value="orderGoodsBase")
public class OrderGoodsBaseController {
       @Resource
       private OrderGoodsBaseService orderGoodsBaseService;


       @PostMapping(value = "/queryByPage")
       public PageInfo<OrderGoodsDetailVo> queryByPage(
               @ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value = "pageNo",defaultValue="0") Integer pageNo,
               @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value = "pageSize",defaultValue="10") Integer pageSize,
               @ApiParam(value="查询条件")@RequestBody OrderGoodsQueryVo orderGoodsQueryVo){
              return orderGoodsBaseService.queryByPage(pageNo,pageSize,orderGoodsQueryVo);
       }


       @GetMapping("/queryById/{id}")
       public OrderGoodsBase queryById(@PathVariable (value="id") int id) {
              return this.orderGoodsBaseService.queryObjById(id);
       }

       @GetMapping("/queryByOrderNo/{orderNo}")
       public ResponseMessage<OrderGoodsBase> queryByOrderNo(@PathVariable(value = "orderNo")String orderNo){
              return  orderGoodsBaseService.queryByOrderNo(orderNo);
       }

       /**
        * 提交实物产品订单
        * @param
        * @return
        */
       @PostMapping(value = "/submitGoodsOrderBase")
       public ResponseMessage<HashMap<String,Object>> submitGoodsOrderBase(@RequestBody SubmitProductGoodsVo submitProductGoodsVo){
              return orderGoodsBaseService.submitGoodsOrderBase(submitProductGoodsVo);
       }

       /**
        * 订单支付成功修改实物产品订单信息
        */
       @PostMapping(value = "/updateAfterPay")
       public ResponseMessage updateOrderGoodsBaseInfoAfterPay(@RequestBody PayReturnVo payReturnVo
                                            ){
              return orderGoodsBaseService.updateOrderGoodsBaseInfoAfterPay(payReturnVo.getOrderNo(), payReturnVo.getPayType(), payReturnVo.getTradeNo(), payReturnVo.getAmountPay());
       }


       /**
        * 查询订单物流信息
        * @param   orderNo
        * @return
        */
       @GetMapping(value = "/queryDeliveryInfo")
       public ResponseMessage<LogisticsInfoVo> queryDeliveryInfo(
               @RequestParam(value = "orderNo")String orderNo){
              return orderGoodsBaseService.queryDeliveryInfo(orderNo);
       }

        /**
         * 确认收货
         * @param orderGoodsId
         * @return
         */
        @GetMapping(value = "/confirmReceiveGoods/{orderGoodsId}")
        public ResponseMessage confirmReceiveGoods(@PathVariable(value = "orderGoodsId") Integer orderGoodsId){
              return orderGoodsBaseService.confirmReceiveGoods(orderGoodsId);
       }

        /**
         * 取消订单
         * @param id
         * @return
         */
        @GetMapping(value = "/cancelOrderGoodsBase/{id}")
        public ResponseMessage cancelOrderGoodsBase(@PathVariable(value = "id")Integer id){
               return orderGoodsBaseService.cancelOrderGoodsBase(id);
        }
}