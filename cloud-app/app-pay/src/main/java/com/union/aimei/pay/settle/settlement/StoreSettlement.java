package com.union.aimei.pay.settle.settlement;

import com.union.aimei.common.feign.app.financial.StoreSubordinateTradeDetailFeign;
import com.union.aimei.common.feign.app.financial.StoreTradeDetailFeign;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.model.order.OrderProduct;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.pay.settle.SettleUtil;
import com.union.common.utils.ResponseMessage;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @time 2018/6/4 18:26
 * @description 店铺结算对象
 */
@Component
@CommonsLog
public class StoreSettlement{


    @Resource
    private StoreTradeDetailFeign storeTradeDetailFeign;
    @Resource
    private StoreSubordinateTradeDetailFeign storeSubordinateTradeDetailFeign;
    @Resource
    private StoreFeign storeFeign;


    /**
     *  结算店铺
     * @param productType 项目类型
     * @param orderType 订单类型
     * @param beauticianRelation 美容师关系(0:自由美容师(未入驻且未挂靠)，1：兼职美容师(已挂靠)2：正式美容师(已入驻))
     * @param beauticianCommission 美容师佣金
     * @param netCome 店铺佣金
     * @param orderBase 订单基础信息
     * @param orderBeautician 订单美容师信息
     * @param orderProduct 订单商品信息
     * @param storePhone 店铺号码
     */
    public void executeSettlement(int productType, int orderType, int beauticianRelation, int beauticianCommission, int netCome, OrderBase orderBase, OrderBeautician orderBeautician, OrderProduct orderProduct, String storePhone) throws Exception{
        int beauticianType=orderBeautician.getType();
        log.info("美容师类型："+beauticianType);
        log.info("美容师状态："+beauticianRelation);
        //自由美容师没有流水也没有业绩
        if (beauticianRelation==0){
            return;
        }
        //兼职美容师有挂靠门店纳入业绩考核（不计入店铺流水）
        boolean isTrue=beauticianRelation==2&&beauticianType==3;
        if(isTrue){
            log.info("添加挂靠门店业绩");
            //添加店铺业绩记录
            addStoreCalculateRecord(beauticianCommission,netCome,storePhone,orderBase,orderBeautician,orderProduct);
        }else{
            log.info("添加店铺流水");
            StoreTradeDetail storeTradeDetail = new StoreTradeDetail();
            storeTradeDetail.setStoreId(orderBeautician.getStoreId());
            storeTradeDetail.setBeauticianId(orderBeautician.getBeauticianId());
            storeTradeDetail.setStoreName(orderBase.getStoreName());
            storeTradeDetail.setBeauticianName(orderBeautician.getBeauticianName());
            storeTradeDetail.setOrderNo(orderBase.getOrderNo());
            storeTradeDetail.setTradeType(1);
            storeTradeDetail.setPayTime(orderBase.getPayTime());
            storeTradeDetail.setTradeStatus(0);
            storeTradeDetail.setStorePhone(storePhone);
            storeTradeDetail.setTotalAmount(orderBase.getAmountTotal());
            int disCountAmount = orderBase.getCouponReduce().intValue() + orderBase.getMemberCardReduce().intValue();
            storeTradeDetail.setDiscountsAmount(disCountAmount);
            storeTradeDetail.setActualPay(orderBase.getAmountPay());
            storeTradeDetail.setMemberDeduct(beauticianCommission);
            storeTradeDetail.setNetAmount(netCome);
            if(orderBase.getPayType()!=null){
                storeTradeDetail.setPayMethod(SettleUtil.changePayTypeToInt(orderBase.getPayType()));
            }
            storeTradeDetail.setProductPrice(orderProduct.getProductPrice());
            storeTradeDetail.setProductName(orderProduct.getProductName());
            ResponseMessage res=storeTradeDetailFeign.insertSelectiveV110(storeTradeDetail);
            log.info("添加店铺佣金："+res);
        }


    }


    /**
     * 添加店铺业绩流水记录
     * @param beauticianCommission
     * @param storeCommission
     * @param storePhone
     * @param orderBase
     * @param orderBeautician
     * @param orderProduct
     */
    private void addStoreCalculateRecord(int beauticianCommission,int storeCommission,String  storePhone,OrderBase orderBase,OrderBeautician orderBeautician,OrderProduct orderProduct) {
        StoreSubordinateTradeDetail detail=new StoreSubordinateTradeDetail();
        detail.setStoreId(orderBase.getAnchoredStoreId());
        Store store=storeFeign.queryById(orderBase.getAnchoredStoreId());
        if(store!=null){
            detail.setStoreName(store.getStoreName());
            detail.setStorePhone(store.getSellerPhone());
        }
        detail.setBeauticianId(orderBeautician.getBeauticianId());
        detail.setBeauticianName(orderBeautician.getBeauticianName()==null?orderBeautician.getBeauticianNickName():orderBeautician.getBeauticianName());
        detail.setOrderNo(orderBase.getOrderNo());
        detail.setTradeType(1);
        detail.setPayTime(orderBase.getPayTime());
        detail.setTradeStatus(0);
        detail.setTotalAmount(orderBase.getAmountTotal());
        detail.setDiscountsAmount(orderBase.getAmountReduce());
        detail.setProductPrice(orderProduct.getProductPrice());
        detail.setProductDiscount(0);
        detail.setProductName(orderProduct.getProductName());
        detail.setActualPay(orderBase.getAmountPay());
        detail.setMemberDeduct(beauticianCommission);
        detail.setNetAmount(storeCommission);
        detail.setPayMethod(SettleUtil.changePayTypeToInt(orderBase.getPayType()));
        detail.setPayRate(0);
        storeSubordinateTradeDetailFeign.insertSelectiveV110(detail);
        log.info("添加店铺业绩表：");
    }
}
