package com.union.aimei.common.feign.app.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderGoodsBaseFeign;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.LogisticsInfoVo;
import com.union.aimei.common.vo.order.OrderGoodsDetailVo;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.aimei.common.vo.order.SubmitProductGoodsVo;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 实物订单
 *
 * @author GaoWei
 * @time 2018/8/23 10:28
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "app-OrderGoodsBaseFeign")
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
    public ResponseMessage<OrderGoodsBase> queryByOrderNo(String orderNo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<HashMap<String, Object>> submitGoodsOrderBase(SubmitProductGoodsVo submitProductGoodsVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateOrderGoodsBaseInfoAfterPay(PayReturnVo payReturnVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public PageInfo<OrderGoodsDetailVo> queryByPage(Integer pageNo, Integer pageSize, OrderGoodsQueryVo orderGoodsQueryVo) {
        return new PageInfo<>();
    }

    @Override
    public ResponseMessage<LogisticsInfoVo> queryDeliveryInfo(String orderNo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage cancelOrderGoodsBase(Integer id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage confirmReceiveGoods(Integer orderGoodsId) {
        return HystrixResponse.invokeFail();
    }
}