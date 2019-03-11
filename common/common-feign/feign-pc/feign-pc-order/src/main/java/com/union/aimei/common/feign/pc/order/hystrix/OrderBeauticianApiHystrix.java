package com.union.aimei.common.feign.pc.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderBeauticianFeign;
import com.union.aimei.common.model.order.OrderBeautician;
import org.springframework.stereotype.Component;

/**
 * 订单美容师
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@Component(value = "pc-OrderBeauticianFeign")
public class OrderBeauticianApiHystrix implements OrderBeauticianFeign {

    /**
     * 前端分页查询订单美容师
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param orderBeautician 查询条件
     * @return
     */
    @Override
    public PageInfo<OrderBeautician> findByPageForFront(Integer pageNo, Integer pageSize, OrderBeautician orderBeautician) {
        return null;
    }

    /**
     * 添加订单美容师
     *
     * @param orderBeautician
     * @return
     */
    @Override
    public int insert(OrderBeautician orderBeautician) {
        return 0;
    }

    /**
     * 删除订单美容师
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改订单美容师
     *
     * @param orderBeautician
     * @return
     */
    @Override
    public int edit(OrderBeautician orderBeautician) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderBeautician
     */
    @Override
    public OrderBeautician queryById(int id) {
        return null;
    }
}