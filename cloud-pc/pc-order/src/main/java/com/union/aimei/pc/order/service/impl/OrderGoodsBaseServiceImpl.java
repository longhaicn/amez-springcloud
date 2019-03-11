package com.union.aimei.pc.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.feign.app.product.ProductPhysicalFeign;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import com.union.aimei.common.vo.order.LogisticsInfoVo;
import com.union.aimei.common.vo.order.OrderGoodsDetailVo;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.aimei.common.vo.order.SendInfoVo;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryVo;

import com.union.aimei.pc.order.constant.OrderConstant;
import com.union.aimei.pc.order.mapper.OrderGoodsBaseMapper;
import com.union.aimei.pc.order.mapper.OrderGoodsInfoMapper;
import com.union.aimei.pc.order.okhttp.ExpressUrl;
import com.union.aimei.pc.order.okhttp.RequestUtil;
import com.union.aimei.pc.order.service.OrderGoodsBaseService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.date.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:57
  * @description
  */
@Service("orderGoodsBaseService")
public class OrderGoodsBaseServiceImpl implements OrderGoodsBaseService {
       @Resource
       private OrderGoodsBaseMapper orderGoodsBaseMapper;
       @Resource
       private OrderGoodsInfoMapper orderGoodsInfoMapper;

       @Resource
       private ProductPhysicalFeign productPhysicalFeign;

       /**
        * 前端分页查询实物订单表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderGoodsBase 查询条件
        * @return 
        */
       @Override
       public PageInfo<OrderGoodsBase> findByPageForFront(Integer pageNo, Integer pageSize, OrderGoodsBase orderGoodsBase) {
              PageHelper.startPage(pageNo,pageSize);
              PageHelper.orderBy("add_time DESC");
              List<OrderGoodsBase> list = this.orderGoodsBaseMapper.selectListByConditions(orderGoodsBase);
              PageInfo<OrderGoodsBase> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加实物订单表
        * @param
        * @return
        */
       @Override
       public int addObj(OrderGoodsBase t) {
              return this.orderGoodsBaseMapper.insertSelective(t);
       }

       /**
        * 删除实物订单表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.orderGoodsBaseMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改实物订单表
        * @param
        * @return
        */
       @Override
       public int modifyObj(OrderGoodsBase t) {
              return this.orderGoodsBaseMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnorderGoodsBase
        */
       @Override
       public OrderGoodsBase queryObjById(int id) {
              OrderGoodsBase model=this.orderGoodsBaseMapper.selectByPrimaryKey(id);
              return model;
       }

       @Override
       public PageInfo<OrderGoodsDetailVo> queryByPage(Integer pageNo, Integer pageSize, OrderGoodsQueryVo orderGoodsQueryVo) {
              List<OrderGoodsDetailVo> allList=new ArrayList<>(10);
              if(orderGoodsQueryVo!=null){
                  String startTime=orderGoodsQueryVo.getStartAddTime();
                  String endTime=orderGoodsQueryVo.getEndAddTime();
                  if(!StringUtils.isBlank(startTime)){
                      orderGoodsQueryVo.setStartAddTime(orderGoodsQueryVo.getStartAddTime()+" 00:00:00");
                  }
                  if(!StringUtils.isBlank(endTime)){
                      orderGoodsQueryVo.setEndAddTime(orderGoodsQueryVo.getEndAddTime()+" 23:59:59");
                  }
              }
              PageHelper.startPage(pageNo,pageSize);
              List<OrderGoodsBase> orderGoodsList=orderGoodsBaseMapper.queryByConditions(orderGoodsQueryVo);
              if(!CollectionUtils.isEmpty(orderGoodsList)){
                  orderGoodsList.forEach(x->{
                         OrderGoodsDetailVo vo=new OrderGoodsDetailVo();
                         vo.setOrderGoodsBase(x);
                         List<OrderGoodsInfo> list=orderGoodsInfoMapper.queryByOrderGoodsId(x.getId());
                         vo.setGoodsInfoList(list);
                         allList.add(vo);
                  });
              }
             PageInfo<OrderGoodsDetailVo> page = new PageInfo<>(allList);
             return page;
       }

            @Override
            public ResponseMessage deliverGoods(String orderNo, String companyCode, String companyName,String deliveryOrderNo) {
                ResponseMessage res= ResponseMessageFactory.newInstance();
                OrderGoodsBase orderBase=orderGoodsBaseMapper.queryForOrderNo(orderNo);
                if(orderBase==null){
                    res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
                    res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
                }else{
                    orderBase.setExpressCompanyCode(companyCode);
                    orderBase.setExpressCompanyName(companyName);
                    orderBase.setDeliveryOrderNo(deliveryOrderNo);
                    orderBase.setDeliveryTime(new Date());
                    orderBase.setStatus(2);
                    orderGoodsBaseMapper.updateByPrimaryKeySelective(orderBase);
                }
                return res;
            }


            @Override
            public ResponseMessage<LogisticsInfoVo> queryDeliveryInfo(String orderNo) {
                ResponseMessage<LogisticsInfoVo> responseMessage=new ResponseMessage<>();
                OrderGoodsBase orderGoodsBase=orderGoodsBaseMapper.queryForOrderNo(orderNo);
                if(orderGoodsBase==null){
                    responseMessage.setCode(OrderConstant.QUERY_ORDER_IS_NOT_EXSIT);
                    responseMessage.setMessage(OrderConstant.QUERY_ORDER_IS_NOT_EXSIT_MSG);
                }else{
                    try {
                        LogisticsInfoVo vo=  getLogisticsInfo(orderGoodsBase);
                        responseMessage.setData(vo);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
               return responseMessage;
            }

            private LogisticsInfoVo getLogisticsInfo(OrderGoodsBase orderGoodsBase){
                LogisticsInfoVo logisticsInfoVo=null;
                String companyCode=orderGoodsBase.getExpressCompanyCode();
                String deliveryOrderNo=orderGoodsBase.getDeliveryOrderNo();
                String companyName=orderGoodsBase.getExpressCompanyName();
                JsonObject parm=new JsonObject();
                parm.addProperty("com",companyCode);
                parm.addProperty("num",deliveryOrderNo);
                StringBuilder sb=new StringBuilder();
                sb.append(parm.toString());
                sb.append(ExpressUrl.KEY);
                sb.append(ExpressUrl.CUSTOMER);
                String sign="";
                try {
                    sign = md5Encrypt(sb.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                JsonObject json=RequestUtil.doPost(ExpressUrl.QUERY_INTERFACE_ADDRESS,ExpressUrl.CUSTOMER,ExpressUrl.KEY,sign,parm.toString());
                if(json!=null){
                    Object stObj=json.get("status");
                    String status="";
                    String state="";
                    if(stObj!=null){
                        status=json.get("status").getAsString();
                        state=json.get("state").getAsString();
                    }
                    if(String.valueOf(HttpStatusConstant.OK.getStatus()).equals(status)){
                        Object obj=json.get("data");
                        if(obj!=null){
                            JsonArray data=json.get("data").getAsJsonArray();
                            logisticsInfoVo=new LogisticsInfoVo();
                            logisticsInfoVo.setLogisticsName(companyName);
                            logisticsInfoVo.setDeliveryNo(deliveryOrderNo);
                            logisticsInfoVo.setState(Integer.parseInt(state));
                            Gson gson=new Gson();
                            LinkedList<SendInfoVo> sendInfoVos=new LinkedList<>();
                            for(JsonElement js:data){
                                SendInfoVo sendInfoVo=gson.fromJson(js,SendInfoVo.class);
                                sendInfoVos.add(sendInfoVo);
                            }
                            logisticsInfoVo.setLinkedList(sendInfoVos);
                        }
                    }
                }
                return logisticsInfoVo;
            }


            private static String  md5Encrypt(String str)throws Exception{
                String result="";
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update((str).getBytes("UTF-8"));
                byte[] b = md5.digest();

                int i;
                StringBuffer buf = new StringBuffer("");

                for(int offset=0; offset<b.length; offset++){
                    i = b[offset];
                    if(i<0){
                        i+=256;
                    }
                    if(i<16){
                        buf.append("0");
                    }
                    buf.append(Integer.toHexString(i));
                }

                result = buf.toString().toUpperCase();
                return result;
            }


    @Override
    public ResponseMessage<OrderGoodsDetailVo> queryDetailsById(Integer id) {
        ResponseMessage<OrderGoodsDetailVo> res=new ResponseMessage<>();
           OrderGoodsBase orderGoodsBase=orderGoodsBaseMapper.selectByPrimaryKey(id);
           if(orderGoodsBase!=null){
               OrderGoodsDetailVo vo=new OrderGoodsDetailVo();
               vo.setOrderGoodsBase(orderGoodsBase);
               List<OrderGoodsInfo> list=orderGoodsInfoMapper.queryByOrderGoodsId(id);
               vo.setGoodsInfoList(list);
               res.setData(vo);
           }else{
               res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
               res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
           }
           return res;
    }


//    @Override
//    public ResponseMessage<List<OrderGoodsBase>> queryNoPayList() {
//        ResponseMessage<List<OrderGoodsBase>> res=new ResponseMessage<>();
//        List<OrderGoodsBase> list=this.orderGoodsBaseMapper.queryListPassTwDays();
//        if(!CollectionUtils.isEmpty(list)){
//            res.setData(list);
//        }else{
//            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
//            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
//        }
//        return res;
//    }

    @Override
    public ResponseMessage cancelOrderGoodsBase(Integer id) {
        ResponseMessage res= ResponseMessageFactory.newInstance();
        OrderGoodsBase orderGoodsBase=orderGoodsBaseMapper.selectByPrimaryKey(id);
        if(orderGoodsBase!=null){
            orderGoodsBase.setIsEnabled(false);
            orderGoodsBaseMapper.updateByPrimaryKeySelective(orderGoodsBase);
            List<OrderGoodsInfo> list=orderGoodsInfoMapper.queryByOrderGoodsId(id);
            if(!CollectionUtils.isEmpty(list)){
                for(OrderGoodsInfo info:list){
                    info.setIsEnabled(false);
                    orderGoodsInfoMapper.updateByPrimaryKeySelective(info);
                }
            }
        }
        return res;
    }


    @Override
    public void autoConfirmReceive() {
        OrderGoodsBase goodsBase=new OrderGoodsBase();
        goodsBase.setStatus(3);
        //查询订单状态为待收货的实物产品订单
        List<OrderGoodsBase> list=orderGoodsBaseMapper.selectListByConditions(goodsBase);
        if(!CollectionUtils.isEmpty(list)){
            for(OrderGoodsBase goods:list){
                LogisticsInfoVo vo=getLogisticsInfo(goods);
                if(vo!=null){
                    LinkedList<SendInfoVo> sendInfoVos= vo.getLinkedList();
                    if(!CollectionUtils.isEmpty(sendInfoVos)){
                        String ftTime=sendInfoVos.get(0).getFtime();
                        Date receiveTime=new Date();
                        try {
                           receiveTime= DateUtil.stringToDate(ftTime,"yyyy-MM-dd HH:mm:ss");
                        }catch (ParseException e){
                            e.printStackTrace();
                        }
                        goods.setReceiveTime(receiveTime);
                        goods.setStatus(3);
                        orderGoodsBaseMapper.updateByPrimaryKeySelective(goods);
                    }
                }
            }
        }
    }


    @Override
    public void cancelOrderGoodsBaseJob() {
        PhysicalByInventoryForBeauticianVo vo = new PhysicalByInventoryForBeauticianVo();
        List<OrderGoodsBase> goodsBaseList = orderGoodsBaseMapper.queryListPassTwDays();
        if (!CollectionUtils.isEmpty(goodsBaseList)) {
            for (OrderGoodsBase order : goodsBaseList) {
                //修改订单状态为失效
                order.setIsEnabled(false);
                orderGoodsBaseMapper.updateByPrimaryKeySelective(order);
               List<OrderGoodsInfo> oglist = orderGoodsInfoMapper.queryByOrderGoodsId(order.getId());
                List<PhysicalByInventoryVo> list = null;
                if (!CollectionUtils.isEmpty(oglist)) {
                    list = new ArrayList<>(10);
                    for (OrderGoodsInfo goods : oglist) {
                        PhysicalByInventoryVo voObj = new PhysicalByInventoryVo();
                        voObj.setProductPhysicalId(goods.getProductPhysicalId());
                        voObj.setPhysicalNumber(goods.getNums());
                        list.add(voObj);
                    }
                }
                vo.setBeauticianId(order.getBeauticianId());
                vo.setInventoryList(list);
                ResponseMessage res = productPhysicalFeign.inventoryCancelPurchaseReservationV111(vo);
                if (HttpStatusConstant.OK.getStatus() == res.getCode()) {
                    OrderGoodsBase orderGoodsBase=orderGoodsBaseMapper.selectByPrimaryKey(order.getId());
                    if(orderGoodsBase!=null){
                        orderGoodsBase.setIsEnabled(false);
                        orderGoodsBaseMapper.updateByPrimaryKeySelective(orderGoodsBase);
                        List<OrderGoodsInfo> list1=orderGoodsInfoMapper.queryByOrderGoodsId(order.getId());
                        if(!CollectionUtils.isEmpty(list1)){
                            for(OrderGoodsInfo info:list1){
                                info.setIsEnabled(false);
                                orderGoodsInfoMapper.updateByPrimaryKeySelective(info);
                            }
                        }
                    }
                }
            }
        }
    }



}