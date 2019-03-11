package com.union.aimei.common.feign.pc.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.hystrix.OrderCommentApiHystrix;
import com.union.aimei.common.model.order.OrderComment;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 订单评论
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@FeignClient(serviceId = "pc-order-service", fallback = OrderCommentApiHystrix.class)
public interface OrderCommentFeign {
    /**
     * 添加订单评论
     *
     * @param orderComment
     * @return
     */
    @PostMapping(value = "/orderComment/insert")
    int insert(@RequestBody OrderComment orderComment);

    /**
     * 删除订单评论
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/orderComment/deleteById/{id}")
    ResponseMessage deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改订单评论
     *
     * @param orderComment
     * @return
     */
    @PutMapping(value = "/orderComment/edit")
    int edit(@RequestBody OrderComment orderComment);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderComment
     */
    @GetMapping(value = "/orderComment/queryById/{id}")
    OrderComment queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询订单评论
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param orderComment 查询条件
     * @return
     */
    @PostMapping(value = "/orderComment/front/findByPage")
    ResponseMessage<PageInfo<OrderComment>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                       Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                       Integer pageSize, @RequestBody OrderComment orderComment);
}