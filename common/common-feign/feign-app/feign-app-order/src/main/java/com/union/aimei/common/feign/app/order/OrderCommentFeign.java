package com.union.aimei.common.feign.app.order;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.hystrix.OrderCommentApiHystrix;
import com.union.aimei.common.model.order.OrderComment;
import com.union.aimei.common.vo.order.CommentVo;
import com.union.aimei.common.vo.order.OrderCommentAllVo;
import com.union.aimei.common.vo.order.OrderCommentVo;
import com.union.aimei.common.vo.order.SubmitOrderComment;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,10:52
 */
@FeignClient(serviceId = "APP-ORDER-SERVICE", fallback = OrderCommentApiHystrix.class)
public interface OrderCommentFeign {


//    /**
//     * 修改订单评论
//     *
//     * @param orderComment
//     * @return
//     */
//    @PutMapping(value = "/orderComment/edit")
//    int edit(@RequestBody OrderComment orderComment);

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
    PageInfo<OrderComment> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                      Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                      Integer pageSize, @RequestBody OrderComment orderComment);

    /**
     * 通过订单ID查询订单评论及多图片
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "/orderComment/queryCommentAndImg/{orderId}")
    ResponseMessage<List<OrderCommentVo>> getOrderCommentAndImg(@PathVariable(value = "orderId") Integer orderId);


    /**
     * 提交订单评论
     *
     * @param submitOrderComment
     * @return
     */
    @PostMapping("/orderComment/submitComment")
    ResponseMessage insert(@RequestBody SubmitOrderComment submitOrderComment);

    /**
     * 删除订单评论
     *
     * @param memberId
     * @param orderId
     * @return
     */
    @GetMapping(value = "/orderComment/cancelOrderComment/{memberId}/{orderId}")
    ResponseMessage cancelOrderComment(
            @PathVariable(value = "memberId") Integer memberId,
            @PathVariable(value = "orderId") Integer orderId);


    /**
     * 通过订单ID查询评论
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "/orderComment/queryByOrderId/{orderId}")
    ResponseMessage<OrderComment> queryByOrderId(@PathVariable(value = "orderId") Integer orderId);


    /**
     * 查询订单评价记录数
     *
     * @param pageNo
     * @param pageSize
     * @param storeId
     * @param productId
     * @param hasImg
     * @param productEvaluationGrade
     * @param storeEvaluationGrade
     * @param beauticianEvaluationGrade
     * @param beauticianId
     * @return
     */
    @GetMapping(value = "/orderComment/queryCommentPage")
    ResponseMessage<CommentVo> queryCommentPage(
            @ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @ApiParam(value = "店铺ID") @RequestParam(value = "storeId", required = false) Integer storeId,
            @ApiParam(value = "服务ID") @RequestParam(value = "productId", required = false) Integer productId,
            @ApiParam(value = "有图") @RequestParam(value = "hasImg", required = false) boolean hasImg,
            @ApiParam(value = "美容师ID") @RequestParam(value = "beauticianId", required = false) Integer beauticianId,
            @ApiParam(value = "服务评价等级：1：差评，2：中评,3：好评") @RequestParam(value = "productEvaluationGrade", required = false) Byte productEvaluationGrade,
            @ApiParam(value = "店铺评价等级：1：差评，2：中评,3：好评") @RequestParam(value = "storeEvaluationGrade", required = false) Byte storeEvaluationGrade,
            @ApiParam(value = "美容师评价等级：1：差评，2：中评，3：好评") @RequestParam(value = "beauticianEvaluationGrade", required = false) Byte beauticianEvaluationGrade

    );

    /**
     * 查询美容师评论分页(包含未回复)
     *
     * @param pageNo
     * @param pageSize
     * @param beauticianId
     * @return
     */
    @PostMapping("/orderComment/findByBeauticianId")
    ResponseMessage<PageInfo<OrderCommentAllVo>> findByBeauticianIdForPage(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                                   Integer pageNo,
                                                                           @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                   Integer pageSize, @ApiParam(value = "查询条件") @RequestBody int beauticianId);

}