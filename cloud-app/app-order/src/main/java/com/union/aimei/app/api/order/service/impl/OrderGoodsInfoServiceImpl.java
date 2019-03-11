package com.union.aimei.app.api.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import com.union.aimei.app.api.order.mapper.OrderGoodsInfoMapper;
import com.union.aimei.app.api.order.service.OrderGoodsInfoService;
import com.union.common.utils.CollectionUtils;
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
@Service("orderGoodsInfoService")
public class OrderGoodsInfoServiceImpl implements OrderGoodsInfoService {
       @Resource
       private OrderGoodsInfoMapper orderGoodsInfoMapper;

       /**
        * 前端分页查询实物订单产品信息表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderGoodsInfo 查询条件
        * @return 
        */
       @Override
       public PageInfo<OrderGoodsInfo> findByPageForFront(Integer pageNo, Integer pageSize, OrderGoodsInfo orderGoodsInfo) {
              PageHelper.startPage(pageNo,pageSize);
              PageHelper.orderBy("add_time desc");
              List<OrderGoodsInfo> list = this.orderGoodsInfoMapper.selectListByConditions(orderGoodsInfo);
              PageInfo<OrderGoodsInfo> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加实物订单产品信息表
        * @param
        * @return
        */
       @Override
       public int addObj(OrderGoodsInfo t) {
              return this.orderGoodsInfoMapper.insertSelective(t);
       }

       /**
        * 删除实物订单产品信息表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.orderGoodsInfoMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改实物订单产品信息表
        * @param
        * @return
        */
       @Override
       public int modifyObj(OrderGoodsInfo t) {
              return this.orderGoodsInfoMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnorderGoodsInfo
        */
       @Override
       public OrderGoodsInfo queryObjById(int id) {
              OrderGoodsInfo model=this.orderGoodsInfoMapper.selectByPrimaryKey(id);
              return model;
       }


       @Override
       public ResponseMessage<List<OrderGoodsInfo>> queryByOrderId(Integer orderId) {
              ResponseMessage<List<OrderGoodsInfo>> res=new ResponseMessage<>();
              OrderGoodsInfo orderGoodsInfo=new OrderGoodsInfo();
              orderGoodsInfo.setOrderGoodsBaseId(orderId);
              List<OrderGoodsInfo> list=orderGoodsInfoMapper.selectListByConditions(orderGoodsInfo);
              if(!CollectionUtils.isEmpty(list)){
                     res.setData(list);
              }else{
                     res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
                     res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
              }
              return res;
       }


}