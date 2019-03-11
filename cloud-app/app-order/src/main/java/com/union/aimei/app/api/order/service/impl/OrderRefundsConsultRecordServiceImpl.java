package com.union.aimei.app.api.order.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderRefundsConsultRecord;
import com.union.aimei.app.api.order.mapper.OrderRefundsConsultRecordMapper;
import com.union.aimei.app.api.order.service.OrderRefundsConsultRecordService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午1:54
  * @description
  */
@Service("orderRefundsConsultRecordService")
public class OrderRefundsConsultRecordServiceImpl implements OrderRefundsConsultRecordService {
       @Resource
       private OrderRefundsConsultRecordMapper orderRefundsConsultRecordMapper;

       /**
        * 前端分页查询服务订单-退款协商记录表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderRefundsConsultRecord 查询条件
        * @return 
        */
       @Override
       public PageInfo<OrderRefundsConsultRecord> findByPageForFront(Integer pageNo, Integer pageSize, OrderRefundsConsultRecord orderRefundsConsultRecord) {
              PageHelper.startPage(pageNo,pageSize);
              List<OrderRefundsConsultRecord> list = this.orderRefundsConsultRecordMapper.selectListByConditions(orderRefundsConsultRecord);
              PageInfo<OrderRefundsConsultRecord> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加服务订单-退款协商记录表
        * @param
        * @return
        */
       @Override
       @TxTransaction
       @Transactional(rollbackFor = Exception.class)
       public int addObj(OrderRefundsConsultRecord t) {
              return this.orderRefundsConsultRecordMapper.insertSelective(t);
       }

       /**
        * 删除服务订单-退款协商记录表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.orderRefundsConsultRecordMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改服务订单-退款协商记录表
        * @param
        * @return
        */
       @Override
       public int modifyObj(OrderRefundsConsultRecord t) {
              return this.orderRefundsConsultRecordMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnorderRefundsConsultRecord
        */
       @Override
       public OrderRefundsConsultRecord queryObjById(int id) {
              OrderRefundsConsultRecord model=this.orderRefundsConsultRecordMapper.selectByPrimaryKey(id);
              return model;
       }


       @Override
       public ResponseMessage queryConsultRecords(Integer pageNo,Integer pageSize,String orderNo) {
              ResponseMessage res=new ResponseMessage();
              PageHelper.startPage(pageNo,pageSize);
              List<OrderRefundsConsultRecord> list=orderRefundsConsultRecordMapper.queryByOrderNo(orderNo);
              if(!CollectionUtils.isEmpty(list)){
                  PageInfo<OrderRefundsConsultRecord> page = new PageInfo<>(list);
                  res.setData(page);
              }else{
                  res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
                  res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
              }
              return res;
       }
}