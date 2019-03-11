package com.union.aimei.app.api.order.bussiness;



import com.union.aimei.common.vo.order.OrderAmountVo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GaoWei
 * @describe 计算订单价格(函数式接口:只允许一个抽象方法，默认方法和静态方法可以写)
 * @time 2018/4/23,16:13
*/
@FunctionalInterface
public  interface OrderAmount<T> {

    /**
     * 计算订单应付金额
     * @param t
     * @return
     */
    int calculate(T t);

    /**
     * 计算订单相关价格(包含订单总价，定价应付金额，会员卡打折金额)
     * @param e
     * @return
     */
      static Map<String,Integer> calculateOrderAmount(OrderAmountVo e){
        int productPrice=e.getProductPrice();
        int num=e.getNum();
        int amountTotal=productPrice*num;
        int needPay=productPrice*num;
        //使用会员卡减免的金额
        int memberCardReduce=0;
        int couponReduce=e.getCouponReduce();
        if(couponReduce>0){
            needPay=needPay-couponReduce;
        }
        int discount=e.getDisCount();
        //乘以会员卡折扣
        if(discount>0){
            int actualPay=needPay;
            needPay=(int)(Math.floor(needPay*(double)discount/100));
            memberCardReduce=actualPay-needPay;
        }
        boolean isToDoor=e.isToDoor();
        int fee=e.getFee();
        //如果是上门需要加上上门费
        if(isToDoor){
            needPay=needPay+fee;
            amountTotal=amountTotal+fee;
        }
        Map<String,Integer> map=new HashMap<>(16);
        map.put("amountTotal",amountTotal);
        map.put("needPay",needPay);
        map.put("memberCardReduce",memberCardReduce);
        return map;
    }
}
