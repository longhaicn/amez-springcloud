package com.union.aimei.common.feign.pc.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderReturnProductFeign;
import com.union.aimei.common.model.order.OrderReturnProduct;
import org.springframework.stereotype.Component;

/**
 * 退换货单的申请明细
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@Component(value = "pc-OrderReturnProductFeign")
public class OrderReturnProductApiHystrix implements OrderReturnProductFeign {

    /**
     * 前端分页查询退换货的申请明细
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param orderReturnProduct 查询条件
     * @return
     */
    @Override
    public PageInfo<OrderReturnProduct> findByPageForFront(Integer pageNo, Integer pageSize, OrderReturnProduct orderReturnProduct) {
        return null;
    }

    /**
     * 添加退换货的申请明细
     *
     * @param orderReturnProduct
     * @return
     */
    @Override
    public int insert(OrderReturnProduct orderReturnProduct) {
        return 0;
    }

    /**
     * 删除退换货的申请明细
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改退换货的申请明细
     *
     * @param orderReturnProduct
     * @return
     */
    @Override
    public int edit(OrderReturnProduct orderReturnProduct) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderReturnProduct
     */
    @Override
    public OrderReturnProduct queryById(int id) {
        return null;
    }
}