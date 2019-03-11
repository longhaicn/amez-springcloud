package com.union.aimei.app.api.order.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderProductConsumeGoodsRecord;
import com.union.aimei.app.api.order.service.OrderProductConsumeGoodsRecordService;
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
@Api(tags="订单-服务消耗实物产品记录表")
@RestController
@RequestMapping(value="/orderProductConsumeGoodsRecord")
public class OrderProductConsumeGoodsRecordController {
       @Resource
       private OrderProductConsumeGoodsRecordService orderProductConsumeGoodsRecordService;

       @PostMapping("/front/findByPage")
       public PageInfo<OrderProductConsumeGoodsRecord> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody OrderProductConsumeGoodsRecord orderProductConsumeGoodsRecord) {
              return this.orderProductConsumeGoodsRecordService.findByPageForFront(pageNo,pageSize,orderProductConsumeGoodsRecord);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody OrderProductConsumeGoodsRecord orderProductConsumeGoodsRecord) {
              return this.orderProductConsumeGoodsRecordService.addObj(orderProductConsumeGoodsRecord);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.orderProductConsumeGoodsRecordService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody OrderProductConsumeGoodsRecord orderProductConsumeGoodsRecord) {
              return this.orderProductConsumeGoodsRecordService.modifyObj(orderProductConsumeGoodsRecord);
       }

       @GetMapping("/queryById/{id}")
       public OrderProductConsumeGoodsRecord queryById(@PathVariable (value="id") int id) {
              return this.orderProductConsumeGoodsRecordService.queryObjById(id);
       }

        /**
         * 查询店铺消耗明细
         * @param storeId
         * @return
         */
        @GetMapping(value = "/queryStoreConsumeDetail")
        public ResponseMessage<PageInfo<HashMap<String,Object>>> queryStoreConsumeDetail(
                @RequestParam(value = "pageNo",defaultValue = "0")Integer pageNo,
                @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                @RequestParam(value = "storeId") Integer storeId,
                @RequestParam(value = "productId")Integer productId
                ){
            return orderProductConsumeGoodsRecordService.queryStoreConsumeDetail(pageNo,pageSize,storeId,productId);
        }

        @GetMapping(value = "/queryBeauticianConsumeDetail")
        public ResponseMessage<PageInfo<HashMap<String,Object>>> queryBeauticianConsumeDetail(
                @RequestParam(value = "pageNo",defaultValue = "0")Integer pageNo,
                @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                @RequestParam(value = "beauticianId") Integer beauticianId,
                @RequestParam(value = "productId")Integer productId
        ){
            return orderProductConsumeGoodsRecordService.queryBeauticianConsumeDetail(pageNo, pageSize, beauticianId,productId);
        }


        /**
         * 根据项目ID查询实物消耗
         * @param productId
         * @return
         */
        @GetMapping(value = "/queryByProductId/{productId}")
        public ResponseMessage<OrderProductConsumeGoodsRecord> queryByProductId(@PathVariable(value = "productId")int productId){
               return orderProductConsumeGoodsRecordService.queryByProductId(productId);
        }
}