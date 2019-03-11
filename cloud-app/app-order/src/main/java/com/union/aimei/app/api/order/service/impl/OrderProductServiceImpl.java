package com.union.aimei.app.api.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderProduct;
import com.union.aimei.app.api.order.mapper.OrderProductMapper;
import com.union.aimei.app.api.order.service.OrderProductService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午1:54
  * @description
  */
@Service("orderProductService")
public class OrderProductServiceImpl implements OrderProductService {
    @Resource
    private OrderProductMapper orderProductMapper;

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
        PageHelper.startPage(pageNo, pageSize);
        List<OrderProduct> list = this.orderProductMapper.selectListByConditions(orderProduct);
        PageInfo<OrderProduct> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加订单--商品--关联
     *
     * @param orderProduct
     * @return
     */
    @Override
    public int addObj(OrderProduct orderProduct) {
        return this.orderProductMapper.insertSelective(orderProduct);
    }

    /**
     * 删除订单--商品--关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.orderProductMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改订单--商品--关联
     *
     * @param orderProduct
     * @return
     */
    @Override
    public int modifyObj(OrderProduct orderProduct) {
        return this.orderProductMapper.updateByPrimaryKeySelective(orderProduct);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderProduct
     */
    @Override
    public OrderProduct queryObjById(int id) {
        OrderProduct model = this.orderProductMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage queryByOrderNo(String orderNo) {
        ResponseMessage responseMessage=new ResponseMessage();
        OrderProduct orderProduct=orderProductMapper.queryByOrderNo(orderNo);
        if(orderProduct!=null){
            responseMessage.setData(orderProduct);
        }else{
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return responseMessage;
    }
}