package com.union.aimei.common.feign.app.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.hystrix.OrderReturnApiHystrix;
import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.RefundObject;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,10:52
 */
@FeignClient(serviceId = "APP-ORDER-SERVICE", fallback = OrderReturnApiHystrix.class)
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
     * @param orderReturn 查询条
     * @return
     */
    @PostMapping(value = "/orderReturn/front/findByPage")
    ResponseMessage<PageInfo<OrderReturn>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                      Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                      Integer pageSize, @RequestBody OrderReturn orderReturn);

    /**
     * 通过订单编号查询
     * @param orderNo
     * @return
     */
    @GetMapping("/orderReturn/queryReturnInfoByOrderNo/{orderNo}")
    ResponseMessage<OrderReturn> queryReturnInfoByOrderNo(@PathVariable(value = "orderNo") String orderNo);

    /**
     * 通过订单编号查询退款信息
     * @param orderNo
     * @return
     */
    @RequestMapping(value = "/orderReturn/queryRefundObject/{orderNo}",method = RequestMethod.GET)
    ResponseMessage<RefundObject> queryRefundObject(@PathVariable(value = "orderNo")String orderNo);


}