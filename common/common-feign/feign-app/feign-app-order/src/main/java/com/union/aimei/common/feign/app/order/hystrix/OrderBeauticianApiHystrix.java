package com.union.aimei.common.feign.app.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderBeauticianFeign;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.vo.order.BeauticianArrangeVo;
import com.union.aimei.common.vo.order.BeauticianBusyTimeVo;
import com.union.aimei.common.vo.order.BeauticianReserved;
import com.union.aimei.common.vo.order.ChooseBeauticianListVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,10:59
 */
@Component(value = "app-OrderBeauticianFeign")
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

    @Override
    public ResponseMessage<PageInfo<BeauticianReserved>> reservedBoard(Integer pageNo, Integer pageSize, Integer storeId, String chooseTime) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianArrangeVo>> beauticianArrange(Integer pageNo, Integer pageSize, Integer storeId, Integer id, String chooseTime) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<BeauticianBusyTimeVo>> queryBeauticianBusyTime(ChooseBeauticianListVo chooseBeauticianListVo) throws ParseException {
        return HystrixResponse.invokeFail();
    }



    @Override
    public ResponseMessage<OrderBeautician> queryByOrderId(Integer orderId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Integer>> queryBeauticianChooseTimeTimeForBusy(ChooseBeauticianListVo chooseBeauticianListVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<OrderBeautician> queryByOrderNo(String orderNo) {
        return HystrixResponse.invokeFail();
    }
}