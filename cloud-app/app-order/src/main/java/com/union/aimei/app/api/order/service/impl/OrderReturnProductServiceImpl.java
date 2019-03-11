package com.union.aimei.app.api.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderReturnProduct;
import com.union.aimei.app.api.order.mapper.OrderReturnProductMapper;
import com.union.aimei.app.api.order.service.OrderReturnProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午1:54
  * @description
  */
@Service("orderReturnProductService")
public class OrderReturnProductServiceImpl implements OrderReturnProductService {
    @Resource
    private OrderReturnProductMapper orderReturnProductMapper;

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
        PageHelper.startPage(pageNo, pageSize);
        List<OrderReturnProduct> list = this.orderReturnProductMapper.selectListByConditions(orderReturnProduct);
        PageInfo<OrderReturnProduct> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加退换货的申请明细
     *
     * @param orderReturnProduct
     * @return
     */
    @Override
    public int addObj(OrderReturnProduct orderReturnProduct) {
        return this.orderReturnProductMapper.insertSelective(orderReturnProduct);
    }

    /**
     * 删除退换货的申请明细
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.orderReturnProductMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改退换货的申请明细
     *
     * @param orderReturnProduct
     * @return
     */
    @Override
    public int modifyObj(OrderReturnProduct orderReturnProduct) {
        return this.orderReturnProductMapper.updateByPrimaryKeySelective(orderReturnProduct);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderReturnProduct
     */
    @Override
    public OrderReturnProduct queryObjById(int id) {
        OrderReturnProduct model = this.orderReturnProductMapper.selectByPrimaryKey(id);
        return model;
    }
}