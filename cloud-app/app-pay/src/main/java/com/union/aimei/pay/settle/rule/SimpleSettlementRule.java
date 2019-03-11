package com.union.aimei.pay.settle.rule;

import com.union.aimei.common.constant.financial.CommissionEnum;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.pay.SettlementVo;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GaoWei
 * @time 2018/6/5 14:14
 * @description 店铺自营结算规则
 */
@Component
@CommonsLog
public class SimpleSettlementRule implements SettlementRule {
    /**
     * 一卡通支付
     */
    public static final int ONE_CARD_PAY=4;

    @Resource
    private RateComponent rateComponent;

    @Override
    public Map<String, Integer> calculateCommission(SettlementVo settlementVo) {
        int amountPay=settlementVo.getAmountPay();
        log.info("计算收益实际支付金额："+amountPay);
        int productType=settlementVo.getProductType();
        int beauticianId=settlementVo.getBeauticianId();
        int productId=settlementVo.getProductId();
        int payType=settlementVo.getPayType();
        int ferigt=settlementVo.getFrieht();
        double oneCardDiscount=settlementVo.getOneCardDiscount();
        int beauticianType=settlementVo.getBeauticianType();
        String rateType=CommissionEnum.PLATFORM.getType();
        int rate=rateComponent.getPlatformRate(rateType);
        log.info("平台佣金比例为："+rate);
        int actuMoney=0;
        if(payType== ONE_CARD_PAY ){
           //一卡通支付
            log.info("上门费用："+ferigt);
            log.info("一卡通折扣："+oneCardDiscount/100);
            actuMoney=(int)Math.round(amountPay-(ferigt*oneCardDiscount/100));
            log.info("一卡通结算金额"+actuMoney);
        }else{
            actuMoney=amountPay-ferigt;
        }
        double s=(double)rate/100;
        int platformCommission=(int)Math.floor(actuMoney*s);
        log.info("平台提成为："+platformCommission);
        int beauticianCommission=getBeauticianCommssion(oneCardDiscount,productType,beauticianId,beauticianType,productId,actuMoney,platformCommission,ferigt,payType);
        int storeCommission=amountPay-beauticianCommission-platformCommission;
        log.info("店铺提成为："+storeCommission);
        Map<String,Integer> map=new HashMap<>(16);
        map.put("beauticianCommission",beauticianCommission);
        map.put("platformCommission",platformCommission);
        map.put("storeCommission",storeCommission);
        return map;
    }



    /**
     * 根据项目类型，获取美容师所得佣金
     * @param oneCardDiscount 一卡通折扣
     * @param productType 项目类型1：门店自营，2：品牌，3：平台自营
     * @param beauticianId 美容师ID
     * @param beautyType 美容师类型 2全职,3兼职
     * @param productId 项目ID
     * @param actuPay 实际支付金额
     * @param platformCom 平台佣金
     * @param  feight 上门费
     * @return
     */
    private int getBeauticianCommssion(double oneCardDiscount,int productType,int beauticianId,int beautyType,
                                       int productId,int actuPay,int platformCom,int feight,int payType ){
        log.info("美容师实际计算金额："+actuPay);
        int beauticianCom=0;
        //门店自营
        if(productType==Product.ProductType.STORE_SELF ||productType==Product.ProductType.BRAND) {
            int beauticianRate = rateComponent.getBeauticianRate(beauticianId, productId);
            log.info("门店自营项目正式美容师佣金比例为：" + beauticianRate);
            double b = (double) beauticianRate / 100;
            int fixCommission = (int) Math.floor(actuPay * b);
            beauticianCom = fixCommission;
        }
       else if(productType==Product.ProductType.PLATFORM_SELF){
            int acturalFeight=0;
            if(payType== ONE_CARD_PAY){
                acturalFeight= (int)Math.floor(feight*(oneCardDiscount/100));
            }else{
                acturalFeight=feight;
            }
            //平台自营
            if(beautyType==StoreBeautician.BeauticianType.FULL_TIME){
                int beauticianRate = rateComponent.getBeauticianRate(beauticianId, productId);
                log.info("平台自营项目正式美容师佣金比例为：" + beauticianRate);
                double beauRate = (double) beauticianRate / 100;
                double str;
                if(payType== ONE_CARD_PAY){
                    str=actuPay*beauRate;
                }else{
                    str=actuPay*beauRate;
                }
                log.info("美容师固定金额"+str);
                int fixCommission = (int) Math.floor(str);
                log.info("美容师计算上门费"+acturalFeight);
                beauticianCom = fixCommission+acturalFeight;
            }else if(beautyType==StoreBeautician.BeauticianType.PART_TIME){
                if(payType== ONE_CARD_PAY){
                    beauticianCom=actuPay - platformCom+acturalFeight;
                }else {
                    beauticianCom = actuPay - platformCom + feight;
                }
            }
        }
        log.info("美容师佣金为："+beauticianCom);
        return beauticianCom;
    }

    public static void main(String[] args) {
        double result=(26000-1000)*88.0/100;
        System.out.println(result);
    }

}
