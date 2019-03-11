package com.union.aimei.common.feign.pc.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.hystrix.OrderReturnApiHystrix;
import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.OrderRefundListVo;
import com.union.aimei.common.vo.order.OrderRefundQueryVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 退换货单
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@FeignClient(serviceId = "pc-order-service", fallback = OrderReturnApiHystrix.class)
public interface OrderReturnFeign {
    /**
     * 添加退换货单
     *
     * @param orderReturn
     * @return
     */
    @PostMapping(value = "/orderReturn/insert")
    int insert(@RequestBody OrderReturn orderReturn);

    /**
     * 删除退换货单
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/orderReturn/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改退换货单
     *
     * @param orderReturn
     * @return
     */
    @PutMapping(value = "/orderReturn/edit")
    int edit(@RequestBody OrderReturn orderReturn);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderReturn
     */
    @GetMapping(value = "/orderReturn/queryById/{id}")
    OrderReturn queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询退换货单
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param orderReturn 查询条件
     * @return
     */
    @PostMapping(value = "/orderReturn/front/findByPage")
    PageInfo<OrderReturn> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                     Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                     Integer pageSize, @RequestBody OrderReturn orderReturn);

    /**
     * 根据订单ID查询退换货单
     *
     * @param orderId 订单ID
     * @return
     */
    @GetMapping("/orderReturn/queryByOrderId/{orderId}")
    ResponseMessage<OrderReturn> queryByOrderId(@PathVariable(value = "orderId") Integer orderId);

    /**
     * 分页查询退换货单
     *
     * @param pageNo             分页索引
     * @param pageSize           每页数量
     * @param orderRefundQueryVo 查询条件
     * @return
     */
    @PostMapping(value = "/orderReturn/queryForPage")
    ResponseMessage<PageInfo<OrderRefundListVo>> queryForPage(
            @ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0", value = "pageNo") Integer pageNo,
            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10", value = "pageSize")
                    Integer pageSize, @ApiParam(value = "查询条件") @RequestBody OrderRefundQueryVo orderRefundQueryVo
    );
}