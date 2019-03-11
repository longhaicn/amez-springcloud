package com.union.aimei.app.api.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderComment;
import com.union.aimei.common.vo.order.CommentVo;
import com.union.aimei.common.vo.order.OrderCommentAllVo;
import com.union.aimei.common.vo.order.SubmitOrderComment;
import com.union.aimei.app.api.order.service.OrderCommentService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,13:48
 */
@Api(tags = "订单评论")
@RestController
@RequestMapping(value = "orderComment")
public class OrderCommentController {
    @Resource
    private OrderCommentService orderCommentService;

    @PostMapping("/front/findByPage")
    public PageInfo<OrderComment> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                             Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                             Integer pageSize, @ApiParam(value = "查询条件")@RequestBody OrderComment orderComment) {
        return this.orderCommentService.findByPageForFront(pageNo, pageSize, orderComment);
    }

    @PostMapping("/submitComment")
    public ResponseMessage insert(@RequestBody SubmitOrderComment submitOrderComment) {
        OrderComment orderComment=submitOrderComment.getOrderComment();
        String imgUrl=submitOrderComment.getCommentImgUrlList();
        List<String> commentImgList=null;
        if(!StringUtils.isBlank(imgUrl)){
            String[] list=imgUrl.split(";");
            commentImgList= Stream.of(list).collect(Collectors.toList());
        }
        return orderCommentService.submitOrderComment(orderComment,commentImgList);
    }


    @GetMapping(value = "/cancelOrderComment/{memberId}/{orderId}")
    public ResponseMessage cancelOrderComment(
            @PathVariable(value = "memberId")Integer memberId,
            @PathVariable(value = "orderId")Integer orderId){
        return orderCommentService.cancelOrderComment(memberId, orderId);
    }

    @GetMapping(value = "/queryByOrderId/{orderId}")
    public ResponseMessage<OrderComment> queryByOrderId(@PathVariable(value = "orderId")Integer orderId){
        return orderCommentService.queryByOrderId(orderId);
    }

    @GetMapping("/queryById/{id}")
    public OrderComment queryById(@PathVariable int id) {
        return this.orderCommentService.queryObjById(id);
    }


    @GetMapping(value = "/queryCommentPage")
    public ResponseMessage<CommentVo> queryCommentPage(
            @ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
            @ApiParam(value = "店铺ID")@RequestParam(value = "storeId",required = false)Integer storeId,
            @ApiParam(value = "服务ID")@RequestParam(value = "productId",required = false)Integer productId,
            @ApiParam(value = "有图")@RequestParam(value = "hasImg",required = false)boolean hasImg,
            @ApiParam(value = "美容师ID") @RequestParam(value = "beauticianId",required = false)Integer beauticianId,
            @ApiParam(value = "服务评价等级：1：差评，2：中评,3：好评")@RequestParam(value = "productEvaluationGrade",required = false)Byte productEvaluationGrade,
            @ApiParam(value = "店铺评价等级：1：差评，2：中评,3：好评")@RequestParam(value = "storeEvaluationGrade",required = false)Byte storeEvaluationGrade,
            @ApiParam(value = "美容师评价等级：1：差评，2：中评，3：好评")@RequestParam(value = "beauticianEvaluationGrade",required = false)Byte beauticianEvaluationGrade

    ){
         return orderCommentService.queryCommentPage(pageNo,pageSize,storeId,productId,hasImg,beauticianId,productEvaluationGrade,storeEvaluationGrade,beauticianEvaluationGrade);
    }

    @PostMapping("/findByBeauticianId")
    public ResponseMessage<PageInfo<OrderCommentAllVo>> findByBeauticianIdForPage(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                  Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                  Integer pageSize, @ApiParam(value = "查询条件")@RequestBody int  beauticianId) {
        return this.orderCommentService.findByBeauticianIdForPage(pageNo, pageSize, beauticianId);
    }




}