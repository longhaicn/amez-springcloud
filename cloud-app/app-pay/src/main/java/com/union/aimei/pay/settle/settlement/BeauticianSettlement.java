package com.union.aimei.pay.settle.settlement;


import com.union.aimei.common.feign.app.financial.BeauticianTradeDetailFeign;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.model.order.OrderProduct;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.pay.settle.SettleUtil;
import com.union.common.utils.ResponseMessage;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @time 2018/6/4 18:19
 * @description 美容师结算对象
 */
@Component
@CommonsLog
public class BeauticianSettlement{


    @Resource
    private BeauticianTradeDetailFeign beauticianTradeDetailFeign;

    public void executeSettlement(int beauticianCommission, int platformCommission, int storeCommission, OrderBase orderBase, OrderBeautician orderBeautician, OrderProduct orderProduct, Product product)throws Exception{
        BeauticianTradeDetail beauDetail=new BeauticianTradeDetail();
        beauDetail.setStoreId(orderBase.getStoreId());
        beauDetail.setBeauticianId(orderBeautician.getBeauticianId());
        beauDetail.setStoreName(orderBase.getStoreName());
        beauDetail.setBeauticianName(orderBeautician.getBeauticianName());
        beauDetail.setProductNumber(orderProduct.getNums());
        beauDetail.setProductPrice(orderProduct.getProductPrice());
        beauDetail.setPlatformAmount(platformCommission);
        beauDetail.setStoreAmoun(storeCommission);
        beauDetail.setOrderNo(orderBase.getOrderNo());
        beauDetail.setTradeType(1);
        beauDetail.setBeauticianType(orderBeautician.getType().intValue()==2?1:(orderBeautician.getType().intValue()==3?0:1));
        beauDetail.setPayTime(orderBase.getPayTime());
        beauDetail.setProductName(orderProduct.getProductName());
        beauDetail.setAmountPay(orderBase.getAmountPay());
        beauDetail.setTradeStatus(0);
        int freight=orderBase.getFreight();
        beauDetail.setIncome(beauticianCommission-freight);
        beauDetail.setVisitAmount(freight);
        beauDetail.setNetIncome(beauticianCommission);
        log.info("支付方式为:"+orderBase.getPayType());
        if(orderBase.getPayType()!=null){
            beauDetail.setPayMethod(SettleUtil.changePayTypeToInt(orderBase.getPayType()));
        }
        ResponseMessage res=beauticianTradeDetailFeign.insertSelectiveV110(beauDetail);
        log.info("添加美容师流水："+res);
    }
}
