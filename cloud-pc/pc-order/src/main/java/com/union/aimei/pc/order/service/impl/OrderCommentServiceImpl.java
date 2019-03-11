package com.union.aimei.pc.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.order.OrderConstant;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderComment;
import com.union.aimei.pc.order.mapper.OrderBaseMapper;
import com.union.aimei.pc.order.mapper.OrderCommentMapper;
import com.union.aimei.pc.order.service.OrderCommentService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:57
  * @description
  */
@Service("orderCommentService")
public class OrderCommentServiceImpl implements OrderCommentService {

       @Resource
       private OrderCommentMapper orderCommentMapper;
       @Resource
       private OrderBaseMapper orderBaseMapper;

       /**
        * 前端分页查询订单评论
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderComment 查询条件
        * @return 
        */
       @Override
       public PageInfo<OrderComment> findByPageForFront(Integer pageNo, Integer pageSize, OrderComment orderComment) {
              PageHelper.startPage(pageNo, pageSize);
              PageHelper.orderBy("create_time DESC");
              List<OrderComment> list = this.orderCommentMapper.selectListByConditions(orderComment);
              PageInfo<OrderComment> page = new PageInfo<>(list);
              if (!CollectionUtils.isEmpty(page.getList())){
                  for(OrderComment comment:page.getList()){
                      List<String> imgList = orderCommentMapper.queryOrderCommentImgList(comment.getId());
                      if (!CollectionUtils.isEmpty(imgList)) {
                          comment.setOrderCommentImgList(imgList);
                      }
                  }
              }
              return page;
       }
       /**
        * 添加订单评论
        * @param
        * @return
        */
       @Override
       public int addObj(OrderComment t) {
              return this.orderCommentMapper.insertSelective(t);
       }

       /**
        * 删除订单评论
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.orderCommentMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改订单评论
        * @param
        * @return
        */
       @Override
       public int modifyObj(OrderComment t) {
              return this.orderCommentMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnorderComment
        */
       @Override
       public OrderComment queryObjById(int id) {
              OrderComment model=this.orderCommentMapper.selectByPrimaryKey(id);
              return model;
       }


       @Override
       public ResponseMessage cancelOrderComment(int orderId) {
           ResponseMessage res= ResponseMessageFactory.newInstance();
           OrderBase order=orderBaseMapper.selectByPrimaryKey(orderId);
           if(order!=null){
               OrderComment orderComment=orderCommentMapper.queryByOrderId(order.getId());
               if(orderComment!=null){
                   orderComment.setIsEnabled(false);
                   orderComment.setHasCancel(true);
                   orderCommentMapper.updateByPrimaryKeySelective(orderComment);
                   order.setBeauticianReplyCommentStatus((byte)0);
                   orderBaseMapper.updateByPrimaryKeySelective(order);
               }else{
                   res.setCode(OrderConstant.Query.HAS_NO_COMMENT);
                   res.setMessage(OrderConstant.Query.HAS_NO_COMMEN_MSG);
               }
           }else{
               throw new ServerException(500,"查询不到订单信息");
           }
           return res;
       }
}