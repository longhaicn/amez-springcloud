package com.union.aimei.common.feign.pc.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.hystrix.OrderReturnProductApiHystrix;
import com.union.aimei.common.model.order.OrderReturnProduct;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 退换货单的申请明细
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@FeignClient(serviceId = "pc-order-service", fallback = OrderReturnProductApiHystrix.class)
public interface OrderReturnProductFeign {
    /**
     * 添加退换货的申请明细
     *
     * @param orderReturnProduct
     * @return
     */
    @PostMapping(value = "/orderReturnProduct/insert")
    int insert(@RequestBody OrderReturnProduct orderReturnProduct);

    /**
     * 删除退换货的申请明细
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/orderReturnProduct/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改退换货的申请明细
     *
     * @param orderReturnProduct
     * @return
     */
    @PutMapping(value = "/orderReturnProduct/edit")
    int edit(@RequestBody OrderReturnProduct orderReturnProduct);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderReturnProduct
     */
    @GetMapping(value = "/orderReturnProduct/queryById/{id}")
    OrderReturnProduct queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询退换货的申请明细
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param orderReturnProduct 查询条件
     * @return
     */
    @PostMapping(value = "/orderReturnProduct/front/findByPage")
    PageInfo<OrderReturnProduct> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                            Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                            Integer pageSize, @RequestBody OrderReturnProduct orderReturnProduct);
}