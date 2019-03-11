package com.union.aimei.common.feign.pc.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.hystrix.OrderBeauticianApiHystrix;
import com.union.aimei.common.model.order.OrderBeautician;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 订单美容师
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@FeignClient(serviceId = "pc-order-service", fallback = OrderBeauticianApiHystrix.class)
public interface OrderBeauticianFeign {
    /**
     * 添加订单美容师
     *
     * @param orderBeautician
     * @return
     */
    @PostMapping(value = "/orderBeautician/insert")
    int insert(@RequestBody OrderBeautician orderBeautician);

    /**
     * 删除订单美容师
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/orderBeautician/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改订单美容师
     *
     * @param orderBeautician
     * @return
     */
    @PutMapping(value = "/orderBeautician/edit")
    int edit(@RequestBody OrderBeautician orderBeautician);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderBeautician
     */
    @GetMapping(value = "/orderBeautician/queryById/{id}")
    OrderBeautician queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询订单美容师
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param orderBeautician 查询条件
     * @return
     */
    @PostMapping(value = "/orderBeautician/front/findByPage")
    PageInfo<OrderBeautician> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                         Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                         Integer pageSize, @RequestBody OrderBeautician orderBeautician);
}