package com.union.aimei.app.api.order.bussiness;

import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.order.SubmitProductGoodsVo;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryVo;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GaoWei
 * @time 2018/6/8 21:02
 * @description
 */
@Component
@CommonsLog
public class GenerateOrderGoodsBase {

    public List<OrderGoodsInfo> getOrderGoodsInfoList(List<PhysicalByInventoryVo> voList, List<ProductPhysical> list) {
        List<OrderGoodsInfo> orderGoodsInfoList = new ArrayList<>(10);
        for (PhysicalByInventoryVo p : voList) {
            OrderGoodsInfo orderGoodsInfo = new OrderGoodsInfo();
            orderGoodsInfo.setProductPhysicalId(p.getProductPhysicalId());
            orderGoodsInfo.setNums(p.getPhysicalNumber());
            for (ProductPhysical product : list) {
                if (p.getProductPhysicalId().intValue() == product.getId().intValue()) {
                    orderGoodsInfo.setProductPhysicalId(product.getId());
                    orderGoodsInfo.setPhysicalName(product.getPhysicalName());
                    orderGoodsInfo.setCoverImg(product.getCoverImg());
                    orderGoodsInfo.setPhysicalImg(product.getPhysicalImg());
                    orderGoodsInfo.setSalePrice(product.getSalePrice());
                    orderGoodsInfoList.add(orderGoodsInfo);
                }
            }
        }
        return orderGoodsInfoList;
    }

    public OrderGoodsBase getOrderGoodsBase(SubmitProductGoodsVo submitProductGoodsVo, StoreBeautician storeBeautician, List<ProductPhysical> physicalList) {
        OrderGoodsBase orderGoodsBase = new OrderGoodsBase();
        orderGoodsBase.setStatus(0);
        int numTotal = 0;
        int amountTotal = 0;
        List<PhysicalByInventoryVo> list = submitProductGoodsVo.getPhysicalInventoryList();
        for (PhysicalByInventoryVo x : list) {
            int id = x.getProductPhysicalId();
            numTotal += x.getPhysicalNumber();
            for (ProductPhysical physical : physicalList) {
                int goodsId = physical.getId();
                if (id == goodsId) {
                    amountTotal += physical.getSalePrice() * x.getPhysicalNumber();
                }
            }
        }
        orderGoodsBase.setNums(numTotal);
        orderGoodsBase.setAmountTotal(amountTotal + submitProductGoodsVo.getPostage().intValue());
        log.info("实物订单金额为:"+amountTotal);
        log.info("邮费为:"+submitProductGoodsVo.getPostage().intValue());
        orderGoodsBase.setBeauticianBelongStoreId(storeBeautician.getStoreId());
        orderGoodsBase.setBeauticianBelongStoreName(storeBeautician.getStoreName());
        orderGoodsBase.setBeauticianId(submitProductGoodsVo.getBeauticianId());
        orderGoodsBase.setBeauticianType(storeBeautician.getBeauticianType().byteValue());
        orderGoodsBase.setBeauticianPhone(storeBeautician.getPhone());
        orderGoodsBase.setBeauticianRealName(storeBeautician.getBeauticianName());
        orderGoodsBase.setBeauticianNickName(storeBeautician.getBeauticianNickName());
        orderGoodsBase.setAddress(submitProductGoodsVo.getAddress());
        orderGoodsBase.setAddressPhone(submitProductGoodsVo.getConsigneePhone());
        orderGoodsBase.setAddressReveiver(submitProductGoodsVo.getConsignee());
        orderGoodsBase.setPostage(submitProductGoodsVo.getPostage());
        orderGoodsBase.setRemark(submitProductGoodsVo.getRemark());
        return orderGoodsBase;
    }
}
