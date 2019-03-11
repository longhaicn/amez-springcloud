package com.union.aimei.pay.settle.settlement;

import com.union.aimei.common.feign.app.financial.PlatformTradeDetailFeign;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
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
 * @description 平台结算对象
 */
@Component
@CommonsLog
public class PlatformSettlement{


    @Resource
    private PlatformTradeDetailFeign platformTradeDetailFeign;


    /**
     * 添加平台流水记录
     * @param beauticianCommission
     * @param netCome
     * @param platFormIncome
     * @param orderBase
     * @param orderBeautician
     * @param orderProduct
     * @param store
     */
    public void executeSettlement(int beauticianCommission, int netCome, int platFormIncome, OrderBase orderBase, OrderBeautician orderBeautician, OrderProduct orderProduct, Store store)throws Exception{
        PlatformTradeDetail platDetail=new PlatformTradeDetail();
        platDetail.setOrderNumber(orderBase.getOrderNo());
        platDetail.setTransactionSerialNumber(orderBase.getTradeNo());
        platDetail.setPayTime(orderBase.getPayTime());
        platDetail.setTradeType(1);
        int orderStatus=orderBase.getStatus();
        platDetail.setTradeStatus(orderStatus==2?0:(orderStatus==5?1:0));
        platDetail.setOrderAmount(orderBase.getAmountTotal());
        platDetail.setActuallyAmount(orderBase.getAmountPay());
        platDetail.setBeauticianCommission(beauticianCommission);
        platDetail.setStoreNetIncome(netCome);
        platDetail.setPlatformCommission(platFormIncome);
        if(orderBase.getPayType()!=null){
            platDetail.setPayMethod(SettleUtil.changePayTypeToInt(orderBase.getPayType()));
        }
        platDetail.setStoreId(orderBase.getStoreId());
        platDetail.setStoreName(orderBase.getStoreName());
        if(store!=null){
            platDetail.setStorePhone(store.getSellerPhone());
            platDetail.setStoreBboss(store.getBossName()==null?"":store.getBossName());
        }
        platDetail.setBeauticianPhone(orderBeautician.getMobile());
        platDetail.setBeauticianId(orderBeautician.getBeauticianId());
        platDetail.setBeauticianName(orderBeautician.getBeauticianName());
        platDetail.setBuyersNickname(orderBase.getMemberRealName());
        platDetail.setBuyersPhone(orderBase.getMemberPhone());
        platDetail.setServiceName(orderProduct.getProductName());
        platDetail.setUnitPrice(orderProduct.getProductPrice());
        platDetail.setCoupons(orderBase.getCouponReduce());
        platDetail.setMembershipCardDiscount(orderBase.getMemberCardReduce());
        platDetail.setTotalPrice(orderBase.getAmountTotal());
        platDetail.setOneCartoonPreferential(orderBase.getOneCardReduce());
        ResponseMessage res=platformTradeDetailFeign.insertSelectiveV110(platDetail);
        log.info("添加平台流水："+res);
    }
}
