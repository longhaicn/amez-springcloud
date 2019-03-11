package com.union.aimei.pc.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.OrderRefundListVo;
import com.union.aimei.common.vo.order.OrderRefundQueryVo;
import com.union.aimei.pc.order.mapper.OrderReturnMapper;
import com.union.aimei.pc.order.service.OrderReturnService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:57
  * @description
  */
@Service("orderReturnService")
public class OrderReturnServiceImpl implements OrderReturnService {
       @Resource
       private OrderReturnMapper orderReturnMapper;

       /**
        * 前端分页查询退换货单
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderReturn 查询条件
        * @return 
        */
       @Override
       public PageInfo<OrderReturn> findByPageForFront(Integer pageNo, Integer pageSize, OrderReturn orderReturn) {
              PageHelper.startPage(pageNo,pageSize);
              List<OrderReturn> list = this.orderReturnMapper.selectListByConditions(orderReturn);
              PageInfo<OrderReturn> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加退换货单
        * @param
        * @return
        */
       @Override
       public int addObj(OrderReturn t) {
              return this.orderReturnMapper.insertSelective(t);
       }

       /**
        * 删除退换货单
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.orderReturnMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改退换货单
        * @param
        * @return
        */
       @Override
       public int modifyObj(OrderReturn t) {
              return this.orderReturnMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnorderReturn
        */
       @Override
       public OrderReturn queryObjById(int id) {
              OrderReturn model=this.orderReturnMapper.selectByPrimaryKey(id);
              return model;
       }

       @Override
       public ResponseMessage<OrderReturn> queryByOrderId(Integer orderId) {
              ResponseMessage<OrderReturn> res=new ResponseMessage<>();
              OrderReturn orderReturn=orderReturnMapper.queryByOrderId(orderId);
              if(orderReturn!=null){
                     res.setData(orderReturn);
              }else{
                  res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
                  res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
              }
              return res;
       }

    @Override
    public ResponseMessage<PageInfo<OrderRefundListVo>> queryForPage(Integer pageNo, Integer pageSize, OrderRefundQueryVo orderRefundQueryVo) {
           ResponseMessage<PageInfo<OrderRefundListVo>> res=new ResponseMessage<>();
           PageHelper.startPage(pageNo,pageSize);
           List<OrderRefundListVo> list=orderReturnMapper.queryByConditions(orderRefundQueryVo);
           PageInfo<OrderRefundListVo> page = new PageInfo<>(list);
           res.setData(page);
           return res;
    }
}