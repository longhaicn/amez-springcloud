package com.union.aimei.app.api.order.bussiness;

import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.constant.order.OrderConstant;
import com.union.aimei.common.feign.app.product.ProductPhysicalBeauticianRefFeign;
import com.union.aimei.common.feign.app.product.ProductPhysicalFeign;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.member.StoreBeauticianByPhoneResultVo;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByIdBatchVo;

import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author GaoWei
 * @time 2018/6/8 20:55
 * @description 实物产品订单验证
 */
@Component
public class OrderGoodsBaseVerify {

    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;
    @Resource
    private ProductPhysicalFeign productPhysicalFeign;
    @Resource
    private ProductPhysicalBeauticianRefFeign productPhysicalBeauticianRefFeign;

    /**
     * 1:根据美容师电话号码查询，是否允许购买实物产品
     * 2:判断实物产品是否存在以及库存是否充足
     *
     * @param beauticianPhone
     * @return
     */
    public ResponseMessage<HashMap<String, Object>> verifyIsAllowBuyProductGoods(String beauticianPhone, List<PhysicalByInventoryVo> physicals) {
        ResponseMessage<HashMap<String, Object>> response = new ResponseMessage();
        HashMap<String, Object> map = new HashMap<>(16);
        ResponseMessage<StoreBeauticianByPhoneResultVo> res = storeBeauticianFeign.findByPhoneForStore(beauticianPhone);
        //1:根据美容师电话号码查询，是否允许购买实物产品
        if (HttpStatusConstant.OK.getStatus() == res.getCode()) {
            StoreBeauticianByPhoneResultVo storeBeauticianByPhoneResultVo = res.getData();
            StoreBeautician storeBeautician = storeBeauticianByPhoneResultVo.getStoreBeautician();
            if (storeBeautician != null) {
                map.put("storeBeautician", storeBeautician);
            } else {
                response.setCode(OrderConstant.Check.BEAUTICAIN_ISNOT_EXSIT);
                response.setMessage(OrderConstant.Check.BEAUTICAIN_ISNOT_EXSIT_MSG);
                return response;
            }
        } else {
            response.setCode(OrderConstant.Check.BEAUTICAIN_ISNOT_EXSIT);
            response.setMessage(OrderConstant.Check.BEAUTICAIN_ISNOT_EXSIT_MSG);
            return response;
        }
        List<Integer> list = new ArrayList<>(10);
        physicals.forEach(x -> {
            list.add(x.getProductPhysicalId());
        });
        ProductPhysicalByIdBatchVo physical = new ProductPhysicalByIdBatchVo();
        physical.setProductPhysicalIdList(list);
        //2:判断实物产品是否存在以及库存是否充足
        ResponseMessage<List<ProductPhysical>> responseMessage = productPhysicalFeign.findListByIdBatch(physical);
        if (HttpStatusConstant.OK.getStatus() != responseMessage.getCode()) {
            response.setCode(OrderConstant.RemoteInvoke.INVOKE_GOODS_FAIL);
            response.setMessage(OrderConstant.RemoteInvoke.INVOKE_GOODS_FAIL_MESSAGE);
        } else {
            List<ProductPhysical> physicalList = responseMessage.getData();
            for (ProductPhysical x : physicalList) {
                int inventory = x.getInventoryTotal().intValue();
                int id = x.getId();
                String goodsName = x.getPhysicalName();
                for (PhysicalByInventoryVo y : physicals) {
                    int goodsId = y.getProductPhysicalId();
                    int goodsNum = y.getPhysicalNumber();
                    if (id == goodsId && inventory < goodsNum) {
                        response.setCode(OrderConstant.Check.GOODS_IS_NOT_ENOUGH);
                        response.setMessage(OrderConstant.Check.GOODS_IS_NOT_ENOUGH_MSG + ":" + goodsName);
                        return response;
                    }
                }
            }
            map.put("physicalList", physicalList);
            response.setData(map);
        }
        return response;
    }

}
