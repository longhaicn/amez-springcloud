package com.union.aimei.common.feign.pc.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderGoodsBaseFeign;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.LogisticsInfoVo;
import com.union.aimei.common.vo.order.OrderGoodsDetailVo;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 实物订单
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@Component(value = "pc-OrderGoodsBaseFeign")
public class OrderGoodsBaseApiHystrix implements OrderGoodsBaseFeign {

    /**
     * 前端分页查询实物订单表
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param orderGoodsBase 查询条件
     * @return
     */
    @Override
    public PageInfo<OrderGoodsBase> findByPageForFront(Integer pageNo, Integer pageSize, OrderGoodsBase orderGoodsBase) {
        return null;
    }

    /**
     * 添加实物订单表
     *
     * @param orderGoodsBase
     * @return
     */
    @Override
    public int insert(OrderGoodsBase orderGoodsBase) {
        return 0;
    }

    /**
     * 删除实物订单表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改实物订单表
     *
     * @param orderGoodsBase
     * @return
     */
    @Override
    public int edit(OrderGoodsBase orderGoodsBase) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderGoodsBase
     */
    @Override
    public OrderGoodsBase queryById(int id) {
        return null;
    }


    @Override
    public PageInfo<OrderGoodsDetailVo> queryByPage(Integer pageNo, Integer pageSize, OrderGoodsQueryVo orderGoodsQueryVo) {
        return new PageInfo<>();
    }

    @Override
    public ResponseMessage deliverGoods(String orderNo, String companyCode, String companyName, String deliveryOrderNo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<LogisticsInfoVo> queryDeliveryInfo(String orderNo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<OrderGoodsDetailVo> queryDetailsById(Integer id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<OrderGoodsBase>> queryNoPayList() {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage cancelOrderGoodsBase(Integer id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public void autoConfirmReceive() {
        throw new ServerException(500, "");
    }


    @Override
    public void cancelOrderGoodsBaseJob() {
        throw new ServerException(500, "");
    }
}