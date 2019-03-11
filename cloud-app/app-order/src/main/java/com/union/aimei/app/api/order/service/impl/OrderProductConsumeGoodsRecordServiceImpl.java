package com.union.aimei.app.api.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.model.order.OrderProductConsumeGoodsRecord;
import com.union.aimei.app.api.order.mapper.OrderProductConsumeGoodsRecordMapper;
import com.union.aimei.app.api.order.service.OrderProductConsumeGoodsRecordService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午1:54
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

       @Override
       public ResponseMessage<PageInfo<HashMap<String, Object>>> queryStoreConsumeDetail(Integer pageNo, Integer pageSize, Integer storeId,Integer productId) {
           ResponseMessage<PageInfo<HashMap<String, Object>>> res=new ResponseMessage();
           PageHelper.startPage(pageNo,pageSize);
           PageHelper.orderBy("opcg.add_time DESC");
           Map<String,Object> map=new HashMap<>(16);
           map.put("storeId",storeId);
           map.put("productId",productId);
           List<HashMap<String,Object>> list=orderProductConsumeGoodsRecordMapper.queryStoreConsumer(map);
           if(!CollectionUtils.isEmpty(list)){
               throw new ServerException(1004,"查询数据为空");
           }else{
               PageInfo<HashMap<String, Object>> page = new PageInfo<>(list);
               res.setData(page);
           }
           return res;
       }


    @Override
    public ResponseMessage<PageInfo<HashMap<String, Object>>> queryBeauticianConsumeDetail(Integer pageNo, Integer pageSize, Integer beauticianId,Integer productId) {
        ResponseMessage<PageInfo<HashMap<String, Object>>> res=new ResponseMessage();
        PageHelper.startPage(pageNo,pageSize);
        PageHelper.orderBy("opcg.add_time DESC");
        Map<String,Object> map=new HashMap<>(16);
        map.put("beauticianId",beauticianId);
        map.put("productId",productId);
        List<HashMap<String,Object>> list=orderProductConsumeGoodsRecordMapper.queryBeauticianConsumer(map);
        if(CollectionUtils.isEmpty(list)){
            throw new ServerException(1004,"查询数据为空");
        }else{
            PageInfo<HashMap<String, Object>> page = new PageInfo<>(list);
            res.setData(page);
        }
        return res;
    }

    @Override
    public ResponseMessage<OrderProductConsumeGoodsRecord> queryByProductId(int productId) {
        OrderProductConsumeGoodsRecord record=new OrderProductConsumeGoodsRecord();
        record.setProductId(productId);
        List<OrderProductConsumeGoodsRecord> list=orderProductConsumeGoodsRecordMapper.selectListByConditions(record);
        ResponseMessage<OrderProductConsumeGoodsRecord> res=new ResponseMessage<>();
        if(!CollectionUtils.isEmpty(list)){
            res.setData(list.get(0));
        }else{
            throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"查询为空");
        }
        return res;
    }
}