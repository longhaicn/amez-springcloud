package com.union.aimei.common.feign.pc.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderRefundsConsultRecordFeign;
import com.union.aimei.common.model.order.OrderRefundsConsultRecord;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务订单-退款协商记录
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@Component(value = "pc-OrderRefundsConsultRecordFeign")
public class OrderRefundsConsultRecordApiHystrix implements OrderRefundsConsultRecordFeign {

    /**
     * 前端分页查询服务订单-退款协商记录表
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页显示数量
     * @param orderRefundsConsultRecord 查询条件
     * @return
     */
    @Override
    public PageInfo<OrderRefundsConsultRecord> findByPageForFront(Integer pageNo, Integer pageSize, OrderRefundsConsultRecord orderRefundsConsultRecord) {
        return null;
    }

    /**
     * 添加服务订单-退款协商记录表
     *
     * @param orderRefundsConsultRecord
     * @return
     */
    @Override
    public int insert(OrderRefundsConsultRecord orderRefundsConsultRecord) {
        return 0;
    }

    /**
     * 删除服务订单-退款协商记录表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改服务订单-退款协商记录表
     *
     * @param orderRefundsConsultRecord
     * @return
     */
    @Override
    public int edit(OrderRefundsConsultRecord orderRefundsConsultRecord) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderRefundsConsultRecord
     */
    @Override
    public OrderRefundsConsultRecord queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<List<OrderRefundsConsultRecord>> queryByOrderId(Integer orderId) {
        return HystrixResponse.invokeFail();
    }
}