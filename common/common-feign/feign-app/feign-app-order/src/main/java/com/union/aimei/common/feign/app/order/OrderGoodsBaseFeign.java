package com.union.aimei.common.feign.app.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.hystrix.OrderGoodsBaseApiHystrix;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.LogisticsInfoVo;
import com.union.aimei.common.vo.order.OrderGoodsDetailVo;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.aimei.common.vo.order.SubmitProductGoodsVo;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 实物订单
 *
 * @author GaoWei
 * @time 2018/8/23 10:28
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(serviceId = "APP-ORDER-SERVICE", fallback = OrderGoodsBaseApiHystrix.class)
public interface OrderGoodsBaseFeign {
    /**
     * 添加实物订单表
     *
     * @param orderGoodsBase
     * @return
     */
    @PostMapping(value = "/orderGoodsBase/insert")
    int insert(@RequestBody OrderGoodsBase orderGoodsBase);

    /**
     * 删除实物订单表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/orderGoodsBase/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改实物订单表
     *
     * @param orderGoodsBase
     * @return
     */
    @PutMapping(value = "/orderGoodsBase/edit")
    int edit(@RequestBody OrderGoodsBase orderGoodsBase);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderGoodsBase
     */
    @GetMapping(value = "/orderGoodsBase/queryById/{id}")
    OrderGoodsBase queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询实物订单表
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param orderGoodsBase 查询条件
     * @return
     */
    @PostMapping(value = "/orderGoodsBase/front/findByPage")
    PageInfo<OrderGoodsBase> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                        Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                        Integer pageSize, @RequestBody OrderGoodsBase orderGoodsBase);

    /**
     * 根据订单编号查询实物订单信息
     *
     * @param orderNo
     * @return
     */
    @GetMapping("/orderGoodsBase/queryByOrderNo/{orderNo}")
    ResponseMessage<OrderGoodsBase> queryByOrderNo(@PathVariable(value = "orderNo") String orderNo);


    /**
     * 提交实物产品订单
     *
     * @param submitProductGoodsVo
     * @return
     */
    @PostMapping(value = "/orderGoodsBase/submitGoodsOrderBase")
    ResponseMessage<HashMap<String, Object>> submitGoodsOrderBase(@RequestBody SubmitProductGoodsVo submitProductGoodsVo);

    /**
     * 订单支付成功修改实物产品订单信息
     *
     * @param payReturnVo
     * @return
     */
    @PostMapping(value = "/orderGoodsBase/updateAfterPay")
    ResponseMessage updateOrderGoodsBaseInfoAfterPay(@RequestBody PayReturnVo payReturnVo);

    /**
     * 根据条件查询分页
     *
     * @param pageNo
     * @param pageSize
     * @param orderGoodsQueryVo
     * @return
     */
    @PostMapping(value = "/orderGoodsBase/queryByPage")
    PageInfo<OrderGoodsDetailVo> queryByPage(
            @ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @ApiParam(value = "查询条件") @RequestBody OrderGoodsQueryVo orderGoodsQueryVo);

    /**
     * 查询订单物流信息
     *
     * @param orderNo
     * @return
     */
    @GetMapping(value = "/orderGoodsBase/queryDeliveryInfo")
    ResponseMessage<LogisticsInfoVo> queryDeliveryInfo(
            @RequestParam(value = "orderNo") String orderNo
    );

    /**
     * 取消订单
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/orderGoodsBase/cancelOrderGoodsBase/{id}")
    ResponseMessage cancelOrderGoodsBase(@PathVariable(value = "id") Integer id);

    /**
     * 确认收货
     *
     * @param orderGoodsId
     * @return
     */
    @GetMapping(value = "/orderGoodsBase/confirmReceiveGoods/{orderGoodsId}")
    ResponseMessage confirmReceiveGoods(@PathVariable(value = "orderGoodsId") Integer orderGoodsId);

}