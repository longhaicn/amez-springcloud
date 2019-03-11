package com.union.aimei.app.api.order;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderGoodsBaseFeign;
import com.union.aimei.common.vo.order.LogisticsInfoVo;
import com.union.aimei.common.vo.order.OrderGoodsDetailVo;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gaowei
 */
@Api(tags="实物订单")
@RestController
@RequestMapping(value="orderGoodsBase")
public class OrderGoodsBaseApiController {

       @Resource
       private OrderGoodsBaseFeign orderGoodsBaseFeign;


       @ApiOperation(httpMethod="POST", value="分页查询实物订单表")
       @PostMapping(value = "/queryByPage")
       public ResponseMessage<PageInfo<OrderGoodsDetailVo>> queryByPage(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value = "pageNo",defaultValue="0") Integer pageNo,
                                                                        @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value = "pageSize",defaultValue="10") Integer pageSize,
                                                                        @ApiParam(value="查询条件")@RequestBody OrderGoodsQueryVo orderGoodsQueryVo){
              ResponseMessage<PageInfo<OrderGoodsDetailVo>> res=new ResponseMessage();
              PageInfo<OrderGoodsDetailVo> page=orderGoodsBaseFeign.queryByPage(pageNo, pageSize, orderGoodsQueryVo);
              res.setData(page);
              return res;
       }


        /**
         * 查询订单物流信息
         * @param orderNo
         * @return
         */
        @ApiOperation(httpMethod="GET", value="查询物流信息")
        @GetMapping(value = "/queryDeliveryInfo")
        public ResponseMessage<LogisticsInfoVo> queryDeliveryInfo(
                @ApiParam(value = "订单编号",defaultValue = "201803061540477770001")@RequestParam(value = "orderNo")String orderNo
        ){
            return orderGoodsBaseFeign.queryDeliveryInfo(orderNo);
        }

        /**
         * 取消订单
         * @param id
         * @return
         */
        @ApiOperation(httpMethod="GET", value="取消订单")
        @GetMapping(value = "/cancelOrderGoodsBase/{id}")
        public ResponseMessage cancelOrderGoodsBase(@PathVariable(value = "id")Integer id){
            return orderGoodsBaseFeign.cancelOrderGoodsBase(id);
        }


        /**
         * 确认收货
         * @param orderGoodsId
         * @return
         */
        @ApiOperation(httpMethod="GET", value="确认收货")
        @GetMapping(value = "/confirmReceiveGoods/{orderGoodsId}")
        public ResponseMessage confirmReceiveGoods(@PathVariable(value = "orderGoodsId") Integer orderGoodsId){
            return orderGoodsBaseFeign.confirmReceiveGoods(orderGoodsId);
        }
}