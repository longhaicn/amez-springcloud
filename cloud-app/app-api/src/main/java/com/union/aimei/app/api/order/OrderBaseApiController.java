package com.union.aimei.app.api.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.feign.app.order.OrderGoodsBaseFeign;
import com.union.aimei.common.feign.app.order.OrderProductConsumeGoodsRecordFeign;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.vo.order.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:35
 */
@Api(tags = "订单")
@RestController
@RequestMapping(value = "orderBase")
public class OrderBaseApiController {
    @Resource
    private OrderBaseFeign orderBaseFeign;
    @Resource
    private OrderGoodsBaseFeign orderGoodsBaseFeign;
    @Resource
    private OrderProductConsumeGoodsRecordFeign orderProductConsumeGoodsRecordFeign;


    /**
     * 分页查询
     *
     * @param pageNo    分页索引
     * @param pageSize  每页显示数量
     * @param orderBase 查询条件
     * @return ResponseMessage<OrderBase>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询订单",notes = "status为-1时，查询全部状态，包含待付款。查询退款全部状态时returnStatus传100，其他根据数据模型传递")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<HashMap<String,Object>>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                 Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                 Integer pageSize, @ApiParam(value = "查询条件") @RequestBody OrderBase orderBase) {
        return orderBaseFeign.findByPageForFront(pageNo, pageSize, orderBase);
    }


    /**
     * 根据传入订单ID查询订单详情
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询订单详情")
    @GetMapping("/queryOrderDetailsInfO/{id}")
    public ResponseMessage<HashMap<String, Object>> queryOrderDetailsInfO(@PathVariable(value = "id") Integer id) {
        return orderBaseFeign.queryOrderDetailsInfO(id);
    }

    /**
     * 提交项目订单
     *
     * @param
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "提交项目订单", notes = "数据模型标注optional的根据需要传，其他必传！上门订单挂靠门店ID必传")
    @PostMapping("/submitOrder")
    public ResponseMessage<HashMap<String, Object>> submitProductOrder(@RequestBody SubmitOrderVo submitOrderVo) {
        return orderBaseFeign.submitProductOrder(submitOrderVo);
    }


    /**
     * 提交实物产品订单
     * @param
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "提交实物产品订单", notes = "只有店长和兼职美容师才能提交，根据模型传递必传数据")
    @PostMapping(value = "/submitGoodsOrderBase")
    public ResponseMessage<HashMap<String,Object>> submitProductGoodsOrder(@RequestBody SubmitProductGoodsVo submitProductGoodsVo){
        return  orderGoodsBaseFeign.submitGoodsOrderBase(submitProductGoodsVo);
    }



    /**
     * 验证二维码，数字码
     * @param isStoreOwner 是否店长(0:店长，1：美容师)
     * @param storeId 店铺ID
     * @param beauticianId 美容师ID
     * @param orderNo 订单编号
     * @param verificationCode 数字验证码
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "验证二维码")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "isStoreOwner",required = false,value = "是否店长(0:是店长，1：美容师)",paramType = "query"),
            @ApiImplicitParam(dataType = "string",name = "mobile",required = true,value = "手机号码",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "storeId",required = false,value = "店铺ID",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "beauticianId",required = true,value = "美容师ID",paramType = "query"),
            @ApiImplicitParam(dataType = "string",name = "orderNo",required = true,value = "订单编号",paramType = "query"),
            @ApiImplicitParam(dataType = "string",name = "verificationCode",required = true,value = "数字验证码",paramType = "query"),
    })
    @GetMapping(value = "/verifyCode")
    public ResponseMessage verifyCode(
            @RequestParam(value = "isStoreOwner",required = false)Integer isStoreOwner,
            @RequestParam(value = "mobile")String mobile,
            @RequestParam(value = "storeId",required = false)Integer storeId,
            @RequestParam(value = "beauticianId")Integer beauticianId,
            @RequestParam(value = "orderNo") String orderNo,
            @RequestParam(value = "verificationCode") String verificationCode) {
        return orderBaseFeign.verificationByCode(isStoreOwner,mobile,storeId,beauticianId,orderNo, verificationCode);
    }


    /**
     * 根据订单编号查询订单信息
     * @param orderNo
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "通过订单查询订单信息")
    @GetMapping(value = "/queryByOrder")
    public OrderBase queryByOrderNo(@RequestParam(value = "orderNo") String orderNo){
        return orderBaseFeign.queryByOrderNo(orderNo);
    }


    /**
     * 申请退款
     *
     * @param orderNo 订单编号
     * @param reason  理由
     * @param remark  备注
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "提交退款申请")
    @GetMapping(value = "/refund")
    @ApiImplicitParams(
            {@ApiImplicitParam(dataType = "String",name="orderNo",value = "订单编号(必须21位)",required = true,paramType = "query"),
                    @ApiImplicitParam(dataType = "String",name = "reason",value = "原因",paramType = "query"),
             @ApiImplicitParam(dataType = "String",name = "remark",value = "说明",paramType = "query")})
    public ResponseMessage refund(@RequestParam(name = "orderNo",value = "orderNo") String orderNo,
                                  @RequestParam(name="reason",value = "reason") String reason,
                                  @RequestParam(name="remark",value = "remark",required = false) String remark
                                  ) {
        return orderBaseFeign.refund(orderNo, reason, remark);
    }




    /**
     * 修改退款申请
     * @param orderNo 订单编号
     * @param reason  原因
     * @param remark  备注
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "修改退款申请")
    @ApiImplicitParams(
            {@ApiImplicitParam(dataType = "String",name="orderNo",value = "订单编号(必须21位)",required = true,paramType = "query"),
                    @ApiImplicitParam(dataType = "String",name = "reason",value = "原因",paramType = "query"),
                    @ApiImplicitParam(dataType = "String",name = "remark",value = "说明",paramType = "query")})
    @GetMapping(value = "/updateRefundApplication")
    public ResponseMessage updateRefundApplication(@RequestParam(value = "orderNo") String orderNo,
                                                   @RequestParam(value = "reason")String reason,
                                                   @RequestParam(value = "remark",required = false)String remark){
        return orderBaseFeign.updateRefundApplication(orderNo, reason, remark);
    }


    /**
     * 撤销退款申请
     * @param orderId 订单Id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "撤销退款申请")
    @GetMapping(value = "/cancelRefundApply/{orderId}")
    public ResponseMessage cancelRefundApply(@PathVariable(value = "orderId") Integer orderId){
        return orderBaseFeign.cancelRefundApply(orderId);
    }

    /**
     * 审核退款申请
     * @param auditRefundVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "审核订单退款(仅限该订单美容师及其所在门店店长允许操作)")
    @PostMapping(value = "/auditOrderRefund")
    public ResponseMessage auditOrderRefund(@RequestBody AuditRefundVo auditRefundVo){
        return orderBaseFeign.auditRefundApply(auditRefundVo);
    }




     /** 查询退款详情
     * @param orderNo
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询退款详情")
    @GetMapping(value = "/queryRefundDetails/{orderNo}")
    public ResponseMessage<RefundDetailsVo> queryRefundDetails(@PathVariable(value = "orderNo")String orderNo){
        return orderBaseFeign.queryRefundDetails(orderNo);
    }


    /**
     * 调换订单美容师
     * @param orderNo 订单号码
     * @param beauticianId 原美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "调换订单美容师")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "orderNo",required = true,value = "订单编号",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "beauticianId",required = true,value = "美容师ID",paramType = "query")
    })
    @Deprecated
    @GetMapping(value = "changeOrderBeautician")
    public ResponseMessage changeOrderBeautician(@RequestParam(value = "orderNo") String orderNo,@RequestParam(value = "beauticianId") Integer beauticianId){
        return  orderBaseFeign.changeOrderBeautician(orderNo,beauticianId);
    }


    /**
     * 美容师端根据条件搜索订单
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "！--美容师端查询服务订单--！")
    @PostMapping(value = "/queryByCondition")
    public ResponseMessage<PageInfo<HashMap<String,Object>>> queryByCondition(
            @RequestParam(value = "pageNo",defaultValue = "0")Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
            @RequestBody BeauticianQueryVo beauticianQueryVo){
        ResponseMessage<PageInfo<HashMap<String,Object>>> res=new ResponseMessage<>();
        PageInfo<HashMap<String,Object>> page=orderBaseFeign.queryByCondition(pageNo, pageSize, beauticianQueryVo);
        res.setData(page);
        return res;
    }


    /**
     * 查询店铺消耗明细
     * @param storeId
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "storeId",required = true,value = "店铺ID",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "productId",required = true,value = "服务ID",paramType = "query")
    })
    @ApiOperation(httpMethod = "GET", value = "查询店铺消耗明细,传店铺ID及服务ID")
    @GetMapping(value = "/queryStoreConsumeDetail")
    public ResponseMessage<PageInfo<HashMap<String,Object>>> queryStoreConsumeDetail(
            @RequestParam(value = "pageNo",defaultValue = "0")Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
            @RequestParam(value = "storeId") Integer storeId,
            @RequestParam(value = "productId")Integer productId){
            return orderProductConsumeGoodsRecordFeign.queryStoreConsumeDetail(pageNo, pageSize, storeId,productId);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "beauticianId",required = true,value = "美容师ID",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "productId",required = true,value = "服务ID",paramType = "query")
    })
    @ApiOperation(httpMethod = "GET", value = "查询美容师消耗明细及服务ID")
    @GetMapping(value = "/queryBeauticianConsumeDetail")
    public ResponseMessage<PageInfo<HashMap<String,Object>>> queryBeauticianConsumeDetail(
            @RequestParam(value = "pageNo",defaultValue = "0")Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
            @RequestParam(value = "beauticianId") Integer beauticianId,
            @RequestParam(value = "productId")Integer productId
    ){
        return   orderProductConsumeGoodsRecordFeign.queryBeauticianConsumeDetail(pageNo, pageSize, beauticianId,productId);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "orderId",required = true,value = "订单ID",paramType = "path"),
    })
    @ApiOperation(httpMethod = "GET", value = "查询订单退款失败信息")
    @GetMapping(value = "/queryOrderRefundFailInfo/{orderId}")
    public ResponseMessage<HashMap<String,Object>> queryOrderRefundFailInfo(@PathVariable(value = "orderId")Integer orderId){
          return orderBaseFeign.queryOrderRefundFailInfo(orderId);
    }






}