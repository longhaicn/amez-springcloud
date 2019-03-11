package com.union.aimei.common.feign.app.order;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.hystrix.OrderGoodsInfoApiHystrix;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 实物订单产品信息
 *
 * @author GaoWei
 * @time 2018/8/23 10:28
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(serviceId = "APP-ORDER-SERVICE", fallback = OrderGoodsInfoApiHystrix.class)
public interface OrderGoodsInfoFeign {
    /**
     * 添加实物订单产品信息表
     *
     * @param orderGoodsInfo
     * @return
     */
    @PostMapping(value = "/orderGoodsInfo/insert")
    int insert(@RequestBody OrderGoodsInfo orderGoodsInfo);

    /**
     * 删除实物订单产品信息表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/orderGoodsInfo/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改实物订单产品信息表
     *
     * @param orderGoodsInfo
     * @return
     */
    @PutMapping(value = "/orderGoodsInfo/edit")
    int edit(@RequestBody OrderGoodsInfo orderGoodsInfo);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderGoodsInfo
     */
    @GetMapping(value = "/orderGoodsInfo/queryById/{id}")
    OrderGoodsInfo queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询实物订单产品信息表
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param orderGoodsInfo 查询条件
     * @return
     */
    @PostMapping(value = "/orderGoodsInfo/front/findByPage")
    PageInfo<OrderGoodsInfo> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                        Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                        Integer pageSize, @RequestBody OrderGoodsInfo orderGoodsInfo);

    /**
     * 根据订单ID查询实物订单产品信息
     *
     * @param orderId 订单ID
     * @return
     */
    @GetMapping(value = "/orderGoodsInfo/queryByOrderId/{orderId}")
    ResponseMessage<List<OrderGoodsInfo>> queryByOrderId(@PathVariable(value = "orderId") Integer orderId);

}