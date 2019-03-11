package com.union.aimei.pc.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderCommentImg;
import com.union.aimei.pc.order.mapper.OrderCommentImgMapper;
import com.union.aimei.pc.order.service.OrderCommentImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:57
  * @description
  */
@Service("orderCommentImgService")
public class OrderCommentImgServiceImpl implements OrderCommentImgService {
       @Resource
       private OrderCommentImgMapper orderCommentImgMapper;

       /**
        * 前端分页查询订单评论图片表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderCommentImg 查询条件
        * @return 
        */
       @Override
       public PageInfo<OrderCommentImg> findByPageForFront(Integer pageNo, Integer pageSize, OrderCommentImg orderCommentImg) {
              PageHelper.startPage(pageNo,pageSize);
              List<OrderCommentImg> list = this.orderCommentImgMapper.selectListByConditions(orderCommentImg);
              PageInfo<OrderCommentImg> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加订单评论图片表
        * @param
        * @return
        */
       @Override
       public int addObj(OrderCommentImg t) {
              return this.orderCommentImgMapper.insertSelective(t);
       }

       /**
        * 删除订单评论图片表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.orderCommentImgMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改订单评论图片表
        * @param
        * @return
        */
       @Override
       public int modifyObj(OrderCommentImg t) {
              return this.orderCommentImgMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnorderCommentImg
        */
       @Override
       public OrderCommentImg queryObjById(int id) {
              OrderCommentImg model=this.orderCommentImgMapper.selectByPrimaryKey(id);
              return model;
       }
}