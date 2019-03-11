package com.union.aimei.common.feign.app.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderReturnFeign;
import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.RefundObject;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 退换货单
 *
 * @author GaoWei
 * @time 2018/8/23 10:28
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "app-OrderReturnFeign")
public class OrderReturnApiHystrix implements OrderReturnFeign {

    /**
     * 前端分页查询退换货单
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param orderReturn 查询条件
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<OrderReturn>> findByPageForFront(Integer pageNo, Integer pageSize, OrderReturn orderReturn) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加退换货单
     *
     * @param orderReturn
     * @return
     */
    @Override
    public int insert(OrderReturn orderReturn) {
        return 0;
    }

    /**
     * 删除退换货单
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改退换货单
     *
     * @param orderReturn
     * @return
     */
    @Override
    public int edit(OrderReturn orderReturn) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderReturn
     */
    @Override
    public OrderReturn queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<OrderReturn> queryReturnInfoByOrderNo(String orderNo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<RefundObject> queryRefundObject(String orderNo) {
        return HystrixResponse.invokeFail();
    }
}