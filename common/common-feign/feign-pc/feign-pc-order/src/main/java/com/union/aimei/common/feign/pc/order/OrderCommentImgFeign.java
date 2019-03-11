package com.union.aimei.common.feign.pc.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.hystrix.OrderCommentImgApiHystrix;
import com.union.aimei.common.model.order.OrderCommentImg;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 订单评论图片
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@FeignClient(serviceId = "pc-order-service", fallback = OrderCommentImgApiHystrix.class)
public interface OrderCommentImgFeign {
    /**
     * 添加订单评论图片表
     *
     * @param orderCommentImg
     * @return
     */
    @PostMapping(value = "/orderCommentImg/insert")
    int insert(@RequestBody OrderCommentImg orderCommentImg);

    /**
     * 删除订单评论图片表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/orderCommentImg/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改订单评论图片表
     *
     * @param orderCommentImg
     * @return
     */
    @PutMapping(value = "/orderCommentImg/edit")
    int edit(@RequestBody OrderCommentImg orderCommentImg);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderCommentImg
     */
    @GetMapping(value = "/orderCommentImg/queryById/{id}")
    OrderCommentImg queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询订单评论图片表
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param orderCommentImg 查询条件
     * @return
     */
    @PostMapping(value = "/orderCommentImg/front/findByPage")
    PageInfo<OrderCommentImg> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                         Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                         Integer pageSize, @RequestBody OrderCommentImg orderCommentImg);
}