package com.union.aimei.common.feign.app.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderGoodsInfoFeign;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 实物订单产品信息
 *
 * @author GaoWei
 * @time 2018/8/23 10:28
 */
@Component(value = "app-OrderGoodsInfoFeign")
public class OrderGoodsInfoApiHystrix implements OrderGoodsInfoFeign {

    /**
     * 前端分页查询实物订单产品信息表
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param orderGoodsInfo 查询条件
     * @return
     */
    @Override
    public PageInfo<OrderGoodsInfo> findByPageForFront(Integer pageNo, Integer pageSize, OrderGoodsInfo orderGoodsInfo) {
        return null;
    }

    /**
     * 添加实物订单产品信息表
     *
     * @param orderGoodsInfo
     * @return
     */
    @Override
    public int insert(OrderGoodsInfo orderGoodsInfo) {
        return 0;
    }

    /**
     * 删除实物订单产品信息表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改实物订单产品信息表
     *
     * @param orderGoodsInfo
     * @return
     */
    @Override
    public int edit(OrderGoodsInfo orderGoodsInfo) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderGoodsInfo
     */
    @Override
    public OrderGoodsInfo queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<List<OrderGoodsInfo>> queryByOrderId(Integer orderId) {
        return HystrixResponse.invokeFail();
    }
}