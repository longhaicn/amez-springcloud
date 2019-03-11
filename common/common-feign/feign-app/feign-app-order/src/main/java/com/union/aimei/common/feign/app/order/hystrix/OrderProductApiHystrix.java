package com.union.aimei.common.feign.app.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderProductFeign;
import com.union.aimei.common.model.order.OrderProduct;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 订单-项目-关联
 *
 * @author GaoWei
 * @time 2018/8/23 10:28
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "app-OrderProductFeign")
public class OrderProductApiHystrix implements OrderProductFeign {

    /**
     * 前端分页查询订单--商品--关联
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param orderProduct 查询条件
     * @return
     */
    @Override
    public PageInfo<OrderProduct> findByPageForFront(Integer pageNo, Integer pageSize, OrderProduct orderProduct) {
        return null;
    }

    /**
     * 添加订单--商品--关联
     *
     * @param orderProduct
     * @return
     */
    @Override
    public int insert(OrderProduct orderProduct) {
        return 0;
    }

    /**
     * 删除订单--商品--关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改订单--商品--关联
     *
     * @param orderProduct
     * @return
     */
    @Override
    public int edit(OrderProduct orderProduct) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderProduct
     */
    @Override
    public OrderProduct queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<OrderProduct> queryByOrderNo(String orderNo) {
        return HystrixResponse.invokeFail();
    }
}