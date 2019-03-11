package com.union.aimei.pc.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.pc.order.mapper.OrderBeauticianMapper;
import com.union.aimei.pc.order.service.OrderBeauticianService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:57
  * @description
  */
@Service("orderBeauticianService")
public class OrderBeauticianServiceImpl implements OrderBeauticianService {
       @Resource
       private OrderBeauticianMapper orderBeauticianMapper;

       /**
        * 前端分页查询订单美容师
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderBeautician 查询条件
        * @return 
        */
       @Override
       public PageInfo<OrderBeautician> findByPageForFront(Integer pageNo, Integer pageSize, OrderBeautician orderBeautician) {
              PageHelper.startPage(pageNo,pageSize);
              List<OrderBeautician> list = this.orderBeauticianMapper.selectListByConditions(orderBeautician);
              PageInfo<OrderBeautician> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加订单美容师
        * @param
        * @return
        */
       @Override
       public int addObj(OrderBeautician t) {
              return this.orderBeauticianMapper.insertSelective(t);
       }

       /**
        * 删除订单美容师
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.orderBeauticianMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改订单美容师
        * @param
        * @return
        */
       @Override
       public int modifyObj(OrderBeautician t) {
              return this.orderBeauticianMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnorderBeautician
        */
       @Override
       public OrderBeautician queryObjById(int id) {
              OrderBeautician model=this.orderBeauticianMapper.selectByPrimaryKey(id);
              return model;
       }
}