package com.union.aimei.common.feign.pc.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.hystrix.OrderGoodsBaseApiHystrix;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.LogisticsInfoVo;
import com.union.aimei.common.vo.order.OrderGoodsDetailVo;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 实物订单
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@FeignClient(serviceId = "pc-order-service", fallback = OrderGoodsBaseApiHystrix.class)
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
     * 发货
     *
     * @param orderNo         订单编号
     * @param companyCode     快递公司编码
     * @param companyName     快递公司名称
     * @param deliveryOrderNo 快递单号
     * @return
     */
    @GetMapping("/orderGoodsBase/deliverGoods")
    ResponseMessage deliverGoods(@RequestParam(value = "orderNo") String orderNo,
                                 @RequestParam(value = "companyCode") String companyCode,
                                 @RequestParam(value = "companyName") String companyName,
                                 @RequestParam(value = "deliveryOrderNo") String deliveryOrderNo);


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
     * 查询实物订单详情
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/orderGoodsBase/queryDetailsById/{id}")
    ResponseMessage<OrderGoodsDetailVo> queryDetailsById(@PathVariable(value = "id") Integer id);

    /**
     * 查询未付款的进货订单
     *
     * @return
     */
    @GetMapping(value = "/orderGoodsBase/queryNoPayList")
    ResponseMessage<List<OrderGoodsBase>> queryNoPayList();


    /**
     * 取消订单
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/orderGoodsBase/cancelOrderGoodsBase/{id}")
    ResponseMessage cancelOrderGoodsBase(@PathVariable(value = "id") Integer id);


    /**
     * 自动确认收货
     */
    @GetMapping(value = "/orderGoodsBase/autoConfirmReceive")
    void autoConfirmReceive();


    /**
     * 实物订单12小时未付款，取消订单释放库存
     */
    @GetMapping(value = "/orderGoodsBase/cancelOrderGoodsBaseJob")
    void cancelOrderGoodsBaseJob();
}