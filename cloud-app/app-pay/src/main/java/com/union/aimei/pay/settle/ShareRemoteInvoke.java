package com.union.aimei.pay.settle;


import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.order.SubmitOrder;

import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author GaoWei
 * @time 2018/6/5 10:11
 * @description 结算对象共享远程调用
 */
@Component
public class ShareRemoteInvoke {

    @Resource
    private OrderBaseFeign orderBaseFeign;
    @Resource
    private ProductFeign productFeign;
    @Resource
    private StoreFeign storeFeign;
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;


    /**
     * 通过订单编号查询订单基础，订单美容师及订单项目信息
     * @param orderNo
     * @return
     */
    public SubmitOrder queryOrderAllInfoByOrderNo(String orderNo){
        ResponseMessage<SubmitOrder> res=orderBaseFeign.queryOrderAllInfoByOrderNo(orderNo);
        AssertUtil.isRemoteInvokeSuccess(res);
        SubmitOrder submitOrder=res.getData();
        return submitOrder;
    }

    /**
     * 查询项目信息
     * @param productId
     * @return
     */
    public Product queryProduct(int productId){
        ResponseMessage<Product> res= productFeign.findById(productId);
        AssertUtil.isRemoteInvokeSuccess(res);
        return res.getData();
    }

    /**
     * 查询店铺信息
     * @param storeId
     * @return
     */
    public Store queryStore(int storeId){
        Store store= storeFeign.queryById(storeId);
        Optional.ofNullable(store).filter(store1 -> store1!=null).orElseThrow(()->new ServerException(500,"查询为空"));
        return store;
    }

    /**
     * 查询店铺美容师
     * @param beauticianId
     * @return
     */
    public StoreBeautician queryStoreBeautician(int beauticianId){
       ResponseMessage<StoreBeautician> res=storeBeauticianFeign.findById(beauticianId);
        AssertUtil.isRemoteInvokeSuccess(res);
        return res.getData();
    }
}
