package com.union.aimei.common.feign.pc.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderBaseFeign;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.QueryNewAddOrder;
import com.union.aimei.common.vo.order.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * 订单
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@Component(value = "pc-OrderBaseFeign")
public class OrderBaseApiHystrix implements OrderBaseFeign {

    /**
     * 前端分页查询订单
     *
     * @param pageNo    分页索引
     * @param pageSize  每页显示数量
     * @param orderBase 查询条件
     * @return
     */
    @Override
    public PageInfo<OrderBase> findByPageForFront(Integer pageNo, Integer pageSize, OrderBase orderBase) {
        return null;
    }

    /**
     * 添加订单
     *
     * @param orderBase
     * @return
     */
    @Override
    public int insert(OrderBase orderBase) {
        return 0;
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改订单
     *
     * @param orderBase
     * @return
     */
    @Override
    public int edit(OrderBase orderBase) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderBase
     */
    @Override
    public OrderBase queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<HashMap<String, Object>> queryOrderDetailsInfO(Integer id) {
        return null;
    }

    @Override
    public ResponseMessage<PageInfo<OrderListVo>> queryOrderList(Integer pageSize, Integer pageNum, OrderListQueryVo orderListQueryVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage queryOrderDetailById(Integer orderId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public void updateHasCompleteOrder() {

    }

    @Override
    public void refundOrderTask(List<Integer> list) {

    }

    @Override
    public void autoGoodCommentTask() {

    }


    @Override
    public ResponseMessage<OrderInfoVo> queryOrderAllInfo(Integer orderId) {
        throw new ServerException(500, "");
    }

    @Override
    public ResponseMessage<List<OrderSendAppVo>> queryJustPreOneHourOrder(Integer id) {
        throw new ServerException(500, "");
    }

    @Override
    public ResponseMessage<List<OrderSendAppVo>> queryHalfHourOrder(Integer id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage auditOrderRefundByPlatForm(OrderBase orderBase) {
        throw new ServerException(500, "");
    }

    @Override
    public ResponseMessage<List<OrderBase>> queryInServerList() {
        throw new ServerException(500, "");
    }

    @Override
    public ResponseMessage<HashMap<String, Integer>> countOrderInfoByDays(Integer type, Integer storeId, Integer days) {
        throw new ServerException(500, "");
    }

    @Override
    public ResponseMessage<Integer> sumOrderAmountByStoreIdAndDays(StatisticsOrderVo statisticsOrderVo) {
        throw new ServerException(500, "");
    }

    @Override
    public ResponseMessage<Integer> newAddOrderNums(QueryNewAddOrder queryNewAddOrder) {
        throw new ServerException(500, "");
    }

    @Override
    public ResponseMessage<List<OrderBase>> queryAutoRefundHasOver() {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<OrderRefundDetailVo> queryOrderRefundDetails(Integer orderId) {
        throw new ServerException(500, "");
    }

    @Override
    public ResponseMessage auditOrderRefundByPlatForm(Integer orderId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public void refundOrderTask() {
        throw new ServerException(500, "");
    }

    @Override
    public void completeUpdateJob() {
        throw new ServerException(500, "");
    }

    @Override
    public void notifyPreHalfHourJob() {
        throw new ServerException(500, "");
    }
}