package com.union.aimei.app.api.order.bussiness;

import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.constant.order.OrderConstant;
import com.union.aimei.common.feign.app.member.MemberFeign;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.feign.app.product.ProductProductPhysicalRefFeign;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.feign.app.store.StoreCouponsReceivedFeign;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.model.order.OrderProductConsumeGoodsRecord;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductProductPhysicalRef;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.order.SubmitOrderVo;
import com.union.aimei.common.vo.product.app.ProductIsOnSaleVo;
import com.union.aimei.common.vo.store.app.StoreCouponsReceivedByUsedVo;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author GaoWei
 * @time 2018/6/8 19:56
 * @description 项目订单校验
 */
@Component
public class OrderBaseVerify {

    @Resource
    private MemberFeign memberFeign;
    @Resource
    private StoreFeign storeFeign;
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;
    @Resource
    private ProductFeign productFeign;
    @Resource
    private ProductProductPhysicalRefFeign productProductPhysicalRefFeign;
    @Resource
    private StoreCouponsReceivedFeign storeCouponsReceivedFeign;

    /**
     * 验证提交数据，确保数据正确
     *
     * @param submitOrderVo
     * @return
     */
    public ResponseMessage<HashMap<String, Object>> verifySubmitInfo(boolean isToDoorOr, SubmitOrderVo submitOrderVo) {
        return getHashMapResponseMessage(isToDoorOr, submitOrderVo);
    }

    private ResponseMessage<HashMap<String, Object>> getHashMapResponseMessage(boolean isToDoorOr, SubmitOrderVo submitOrderVo) {
        ResponseMessage<HashMap<String, Object>> response = new ResponseMessage<>();
        HashMap<String, Object> map = new HashMap<>(16);
        //验证会员是否存在
        Integer memberId = submitOrderVo.getMemberId();
        Member member = memberFeign.queryById(memberId);
        if (member == null) {
            throw new ServerException(OrderConstant.Check.QUERY_MEMBER_FAIL,OrderConstant.Check.QUERY_MEMBER_FAIL_MSG);
        } else {
            map.put("member", member);
        }
        //验证门店是否存在
        Integer storeId = submitOrderVo.getStoreId();
        if(storeId!=null){
            Store store = this.storeFeign.queryById(storeId);
            if (store != null) {
                map.put("store", store);
            }
        }
        //验证商品是否存在或者是否下架以及是否存在实物产品
        Integer productId = submitOrderVo.getProductId();
        Product product = getProduct(storeId, productId);
        if (!isProductExist(product)) {
            response.setCode(OrderConstant.Check.PRODUCT_ISNOT_EXSIT_OR_OFFSHELF);
            response.setMessage(OrderConstant.Check.PRODUCT_ISNOT_EXSITOR_OFFSHELF_MSG);
            return response;
        } else {
            map.put("product", product);
            //查询实物产品
            List<OrderProductConsumeGoodsRecord> physicalList = getPhysicalList(productId);
            if (!CollectionUtils.isEmpty(physicalList)) {
                map.put("physicalList", physicalList);
            }
        }
        //验证美容师是否存在以及是否空闲
        ResponseMessage<StoreBeautician> beauticianRes = storeBeauticianFeign.findById(submitOrderVo.getBeauticianId());
        if (beauticianRes.getCode() != HttpStatusConstant.OK.getStatus()) {
            throw new ServerException(OrderConstant.Check.BEAUTICAIN_ISNOT_EXSIT,OrderConstant.Check.BEAUTICAIN_ISNOT_EXSIT_MSG);
        } else {
            map.put("storeBeautician", beauticianRes.getData());
        }
        //上门订单验证
        if (isToDoorOr) {
            verifyTodoor(submitOrderVo);
        }
        response.setData(map);
        return response;
    }

    /**
     * 上门订单验证
     * @param submitOrderVo
     */
    private void verifyTodoor(SubmitOrderVo submitOrderVo){
        //验证美容师及挂靠店铺是否属实
        StoreBeautician beautician = new StoreBeautician();
        beautician.setMemberId(submitOrderVo.getMemberId());
        Integer anStoreId = submitOrderVo.getAnchoredStoreId();
        if (anStoreId != null && anStoreId != 0) {
            ResponseMessage res = storeBeauticianFeign.judgeBeauticianBelongStore(submitOrderVo.getBeauticianId(), anStoreId);
            if (HttpStatusConstant.OK.getStatus() != res.getCode()) {
                throw new ServerException(OrderConstant.Check.BEAUTICIAN_HAS_NO_ANCHORED_STOREID,OrderConstant.Check.BEAUTICIAN_HAS_NO_ANCHORED_STOREID_MSG);
            }
        }
        //判断上门地址及挂靠店铺ID是否为空
        Integer addressId=submitOrderVo.getAddressId();
        if(addressId==null||addressId==0){
            throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"上门订单地址ID不能为空");
        }
        String address = submitOrderVo.getCustomerAddress();
        if (StringUtils.isBlank(address)) {
            throw new ServerException(OrderConstant.Check.CUSTOMER_ADDRESS_IS_NULL,OrderConstant.Check.CUSTOMER_ADDRESS_IS_NULL_MSG);
        }
    }


    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    public Product getProduct(Integer storeId, Integer productId) {
        Product product = null;
        if (productId != null && productId != 0) {
            ProductIsOnSaleVo vo=new ProductIsOnSaleVo();
            vo.setProductId(productId);
            vo.setStoreId(storeId);
            ResponseMessage<Product> responseMessage = productFeign.isOnSaleV111(vo);
            if (HttpStatusConstant.OK.getStatus() == responseMessage.getCode()) {
                product = responseMessage.getData();
            }
        }
        return product;
    }



    /**
     * 验证商品是否存在或者下架
     *
     * @return
     */
    public boolean isProductExist(Product product) {
        boolean isGenerate = false;
        if (product != null) {
            Integer isShelf = product.getSaleStatus();
            if (isShelf == 1) {
                isGenerate = true;
            }
        }
        return isGenerate;
    }


    /**
     * 查询实物产品信息
     * @param productId
     * @return
     */
    private List<OrderProductConsumeGoodsRecord> getPhysicalList(Integer productId) {
        List<OrderProductConsumeGoodsRecord> list = null;
        ResponseMessage<ProductProductPhysicalRef> res = productProductPhysicalRefFeign.getByProductIdV111(productId);
        if (HttpStatusConstant.OK.getStatus() == res.getCode()) {
            ProductProductPhysicalRef vo = res.getData();
            if(vo!=null){
                list=new ArrayList<>(10);
                OrderProductConsumeGoodsRecord physical = new OrderProductConsumeGoodsRecord();
                physical.setProductId(productId);
                physical.setProductPhysicalId(vo.getProductPhysicalId());
                physical.setProductPhysicalName(vo.getPhysicalName());
                physical.setConsumeNum(vo.getPhysicalNumber());
                list.add(physical);
            }
        }
        return list;
    }

    /**
     * 消耗优惠券
     * @param couponId
     * @param memberId
     * @param orderNo
     * @param productId
     * @param productName
     */
    public void consumeCoupon(Integer couponId, Integer memberId, String orderNo, Integer productId, String productName) {
        StoreCouponsReceivedByUsedVo vo = new StoreCouponsReceivedByUsedVo();
        vo.setStoreCouponsId(couponId);
        vo.setMemberId(memberId);
        vo.setOrderNo(orderNo);
        vo.setProductId(productId);
        vo.setProductName(productName);
        ResponseMessage res=storeCouponsReceivedFeign.used(vo);
        if(HttpStatusConstant.OK.getStatus()!=res.getCode()){
            throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"优惠券服务异常，请稍后重试");
        }
    }
}
