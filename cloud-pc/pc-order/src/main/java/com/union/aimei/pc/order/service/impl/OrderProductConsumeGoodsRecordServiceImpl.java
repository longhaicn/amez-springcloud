package com.union.aimei.pc.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderProductConsumeGoodsRecord;
import com.union.aimei.pc.order.mapper.OrderProductConsumeGoodsRecordMapper;
import com.union.aimei.pc.order.service.OrderProductConsumeGoodsRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:57
  * @description
  */
@Service("orderProductConsumeGoodsRecordService")
public class OrderProductConsumeGoodsRecordServiceImpl implements OrderProductConsumeGoodsRecordService {
       @Resource
       private OrderProductConsumeGoodsRecordMapper orderProductConsumeGoodsRecordMapper;

       /**
        * 前端分页查询订单-服务消耗实物产品记录表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderProductConsumeGoodsRecord 查询条件
        * @return 
        */
       @Override
       public PageInfo<OrderProductConsumeGoodsRecord> findByPageForFront(Integer pageNo, Integer pageSize, OrderProductConsumeGoodsRecord orderProductConsumeGoodsRecord) {
              PageHelper.startPage(pageNo,pageSize);
              List<OrderProductConsumeGoodsRecord> list = this.orderProductConsumeGoodsRecordMapper.selectListByConditions(orderProductConsumeGoodsRecord);
              PageInfo<OrderProductConsumeGoodsRecord> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加订单-服务消耗实物产品记录表
        * @param
        * @return
        */
       @Override
       public int addObj(OrderProductConsumeGoodsRecord t) {
              return this.orderProductConsumeGoodsRecordMapper.insertSelective(t);
       }

       /**
        * 删除订单-服务消耗实物产品记录表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.orderProductConsumeGoodsRecordMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改订单-服务消耗实物产品记录表
        * @param
        * @return
        */
       @Override
       public int modifyObj(OrderProductConsumeGoodsRecord t) {
              return this.orderProductConsumeGoodsRecordMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnorderProductConsumeGoodsRecord
        */
       @Override
       public OrderProductConsumeGoodsRecord queryObjById(int id) {
              OrderProductConsumeGoodsRecord model=this.orderProductConsumeGoodsRecordMapper.selectByPrimaryKey(id);
              return model;
       }
}