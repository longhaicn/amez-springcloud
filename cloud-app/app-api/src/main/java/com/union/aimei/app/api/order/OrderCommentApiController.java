package com.union.aimei.app.api.order;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderCommentFeign;
import com.union.aimei.common.model.order.OrderComment;
import com.union.aimei.common.vo.order.CommentVo;
import com.union.aimei.common.vo.order.OrderCommentAllVo;
import com.union.aimei.common.vo.order.SubmitOrderComment;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.RequestConstant;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:23
 */
@Api(tags = "订单评论")
@RestController
@RequestMapping(value = "orderComment")
public class OrderCommentApiController {
    @Resource
    private OrderCommentFeign orderCommentFeign;

    /**
     * 分页查询
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param orderComment 查询条件
     * @return ResponseMessage<OrderComment>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询订单评论")
    @PostMapping("/front/findByPage")
    public ResponseMessage<OrderComment> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                    Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                    Integer pageSize, @ApiParam(value = "查询条件")@RequestBody OrderComment orderComment) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<OrderComment> page = orderCommentFeign.findByPageForFront(pageNo, pageSize, orderComment);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 提交订单评论
     *
     * @param
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "提交订单评论",notes = "订单ID，会员ID，评论类型必传(类型为2时，传订单ID，美容师ID，美容师姓名及回复类型)，其他根据需要传")
    @PostMapping("/submitOrderComment")
    public ResponseMessage<OrderComment> insert(@RequestBody SubmitOrderComment submitOrderComment) {
        ResponseMessage responseMessage=new ResponseMessage();
        if(submitOrderComment==null){
            responseMessage.setCode(RequestConstant.PARAM_EMPTY);
            responseMessage.setMessage(RequestConstant.PARAM_EMPTY_MSG);
        }else{
            OrderComment orderComment=submitOrderComment.getOrderComment();
            if(orderComment!=null){
                Integer orderId=orderComment.getOrderId();
                Integer operType=orderComment.getOperType();
                if(orderId==null||operType==null){
                    responseMessage.setCode(RequestConstant.PARAM_LOST);
                    responseMessage.setMessage(RequestConstant.PARAM_LOST_MSG);
                }else {
                    responseMessage = orderCommentFeign.insert(submitOrderComment);
                }
            }else{
                responseMessage.setCode(RequestConstant.PARAM_LOST);
                responseMessage.setMessage(RequestConstant.PARAM_LOST_MSG);
            }

        }
        return responseMessage;
    }



    @ApiOperation(httpMethod = "GET", value = "查询店铺或服务评价数量")
    @GetMapping(value = "/queryCommentPage")
    public ResponseMessage<CommentVo> queryCommentPage(
            @ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo",defaultValue = "0") Integer pageNo,
            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
            @ApiParam(value = "店铺ID")@RequestParam(value = "storeId",required = false)Integer storeId,
            @ApiParam(value = "服务ID")@RequestParam(value = "productId",required = false)Integer productId,
            @ApiParam(value = "有图")@RequestParam(value = "hasImg",required = false)boolean hasImg,
            @ApiParam(value = "美容师ID") @RequestParam(value = "beauticianId",required = false)Integer beauticianId,
            @ApiParam(value = "服务评价等级：1：差评，2：中评,3：好评")@RequestParam(value = "productEvaluationGrade",required = false)Byte productEvaluationGrade,
            @ApiParam(value = "店铺评价等级：1：差评，2：中评,3：好评")@RequestParam(value = "storeEvaluationGrade",required = false)Byte storeEvaluationGrade,
            @ApiParam(value = "美容师评价等级：1：差评，2：中评，3：好评")@RequestParam(value = "beauticianEvaluationGrade",required = false)Byte beauticianEvaluationGrade

    ){
        return orderCommentFeign.queryCommentPage(pageNo, pageSize, storeId, productId, hasImg,beauticianId, productEvaluationGrade, storeEvaluationGrade,beauticianEvaluationGrade);
    }


    @ApiOperation(httpMethod = "POST", value = "根据美容师ID查询订单评论分页")
    @PostMapping("/findByBeauticianId")
    public ResponseMessage<PageInfo<OrderCommentAllVo>> findByBeauticianIdForPage(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                                          Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                                          Integer pageSize, @ApiParam(value = "查询条件")@RequestBody int  beauticianId){
        return orderCommentFeign.findByBeauticianIdForPage(pageNo, pageSize, beauticianId);
    }

    /**
     * 删除订单评论
     * @param memberId
     * @param orderId
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "删除订单评论")
    @GetMapping(value = "/cancelOrderComment/{memberId}/{orderId}")
    ResponseMessage cancelOrderComment(
            @PathVariable(value = "memberId")Integer memberId,
            @PathVariable(value = "orderId")Integer orderId){
        return orderCommentFeign.cancelOrderComment(memberId, orderId);
    }


    /**
     * 通过订单ID查询评论
     * @param orderId
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据订单ID查询订单评论信息")
    @GetMapping(value = "/queryByOrderId/{orderId}")
    ResponseMessage<OrderComment> queryByOrderId(@PathVariable(value = "orderId")Integer orderId){
        return orderCommentFeign.queryByOrderId(orderId);
    }

}