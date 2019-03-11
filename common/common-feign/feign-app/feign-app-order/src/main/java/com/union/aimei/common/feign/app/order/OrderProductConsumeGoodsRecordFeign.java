package com.union.aimei.common.feign.app.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.hystrix.OrderProductConsumeGoodsRecordhystrix;
import com.union.aimei.common.model.order.OrderProductConsumeGoodsRecord;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * 订单-服务消耗实物产品记录
 *
 * @author GaoWei
 * @time 2018/8/23 10:28
 */
@FeignClient(serviceId = "APP-ORDER-SERVICE", fallback = OrderProductConsumeGoodsRecordhystrix.class)
public interface OrderProductConsumeGoodsRecordFeign {

    /**
     * 根据项目ID查询实物消耗
     *
     * @param productId
     * @return
     */
    @GetMapping(value = "/orderProductConsumeGoodsRecord/queryByProductId/{productId}")
    ResponseMessage<OrderProductConsumeGoodsRecord> queryByProductId(@PathVariable(value = "productId") int productId);

    /**
     * 查询店铺消耗明细
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param storeId   门店ID
     * @param productId 项目ID
     * @return
     */
    @GetMapping(value = "/orderProductConsumeGoodsRecord/queryStoreConsumeDetail")
    ResponseMessage<PageInfo<HashMap<String, Object>>> queryStoreConsumeDetail(
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "storeId") Integer storeId,
            @RequestParam(value = "productId") Integer productId);

    /**
     * 查询美容师消耗明细
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @param productId    项目ID
     * @return
     */
    @GetMapping(value = "/orderProductConsumeGoodsRecord/queryBeauticianConsumeDetail")
    ResponseMessage<PageInfo<HashMap<String, Object>>> queryBeauticianConsumeDetail(
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "beauticianId") Integer beauticianId,
            @RequestParam(value = "productId") Integer productId
    );

}
