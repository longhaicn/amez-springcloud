package com.union.aimei.app.api.order.bussiness;

import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.constant.order.OrderConstant;
import com.union.aimei.common.feign.app.member.MemberAddressFeign;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.feign.app.store.StoreCouponsFeign;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.model.member.MemberAddress;
import com.union.aimei.common.model.member.MemberCardRef;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.model.order.OrderProduct;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.vo.order.OrderAmountVo;
import com.union.aimei.common.vo.order.SubmitOrderVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.StringUtil;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author GaoWei
 * @time 2018/6/8 20:11
 * @description 构造订单业务所需实体类
 */
@Component
public class GenerateOrderBase {

    @Resource
    private MemberAddressFeign memberAddressFeign;
    @Resource
    private StoreCouponsFeign storeCouponsFeign;
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;


    /**
     * 构造订单基础对象
     *
     * @param submitOrderVo
     * @return
     */
    public ResponseMessage<OrderBase> generateOrderBase(boolean isToDoorOr, SubmitOrderVo submitOrderVo, Member member, Store store, Product product, MemberCardRef memberCardRef) {
        return getOrderBaseResponseMessage(isToDoorOr, submitOrderVo, member, store, product);
    }

    private ResponseMessage<OrderBase> getOrderBaseResponseMessage(boolean isToDoorOr, SubmitOrderVo submitOrderVo, Member member, Store store, Product product) {
        ResponseMessage<OrderBase> responseMessage = new ResponseMessage<>();
        OrderBase orderBase = new OrderBase();
        orderBase.setMemberId(submitOrderVo.getMemberId());
        orderBase.setStoreId(submitOrderVo.getStoreId());
        orderBase.setRemark(submitOrderVo.getRemark());
        orderBase.setAnchoredStoreId(submitOrderVo.getAnchoredStoreId());
        if (!isToDoorOr) {
            orderBase.setStoreName(store.getStoreName());
            orderBase.setStorePhone(store.getStoreTel());
            orderBase.setStoreLogo(store.getStoreBanner()==null?"":store.getStoreBanner());
            orderBase.setAddress(store.getStoreAddress());
            orderBase.setAddressPhone(store.getStoreTel());
            StringBuilder sb = new StringBuilder();
            sb.append(StringUtil.trimNull(store.getProvinceName()));
            sb.append(StringUtil.trimNull(store.getCityName()));
            sb.append(StringUtil.trimNull(store.getAreaName()));
            sb.append(StringUtil.trimNull(store.getStoreAddress()));
            orderBase.setAddressRegson(sb.toString());
        } else {
            Integer addressId=submitOrderVo.getAddressId();
            orderBase.setAddressId(addressId);
            MemberAddress memberAddress=memberAddressFeign.queryById(addressId);
            if(memberAddress!=null){
                orderBase.setCustomerLongitude(memberAddress.getLongitude());
                orderBase.setCustomerLatitude(memberAddress.getLatitude());
            }else{
                throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"查询地址异常");
            }
            orderBase.setCustomerName(submitOrderVo.getCustomerName());
            orderBase.setCustomerPhone(submitOrderVo.getCustomerPhone());
            orderBase.setCustomerAddress(submitOrderVo.getCustomerAddress());
            orderBase.setAnchoredStoreId(submitOrderVo.getAnchoredStoreId());
            orderBase.setFreight(submitOrderVo.getFreight());
        }
        orderBase.setType(submitOrderVo.getType());
        orderBase.setNums(submitOrderVo.getNum());
        Integer memberId = submitOrderVo.getMemberId();
        orderBase.setMemberPhone(member.getRegisterPhone());
        orderBase.setMemberRealName(member.getMemberName());
        orderBase.setMemberNickName(member.getMemberNickname());
        //设置会员信息
        orderBase.setMemberId(memberId);
        orderBase.setServerStartTime(submitOrderVo.getServerStartTime());
        orderBase.setServerEndTime(submitOrderVo.getServerEndTime());
        //消耗优惠券
        Integer recieveCouponId = submitOrderVo.getReceiveCouponId();
        int couponReduceAmount=0;
        if (recieveCouponId != null && recieveCouponId > 0) {
            orderBase.setCouponId(recieveCouponId);
            //优惠券信息
            Integer couponId = submitOrderVo.getCouponId();
            if (couponId != null && couponId > 0) {
                ResponseMessage res = storeCouponsFeign.findById(couponId);
                if (HttpStatusConstant.OK.getStatus() == res.getCode()) {
                    StoreCoupons storeCoupons = (StoreCoupons) res.getData();
                    couponReduceAmount= storeCoupons.getDiscountAmount();
                    orderBase.setCouponReduce(couponReduceAmount);
                } else {
                    responseMessage.setCode(OrderConstant.RemoteInvoke.INVOKE_STORE_COUPONS_FAIL);
                    responseMessage.setMessage(OrderConstant.RemoteInvoke.INVOKE_STORE_COUPONS_FAIL_MESSAGE);
                    return responseMessage;
                }
            }

        }

        int singePrice=product.getSalePrice();
        int productNum=submitOrderVo.getNum();
        OrderAmountVo vo=create(isToDoorOr,singePrice,productNum,submitOrderVo.getFreight()==null?0:submitOrderVo.getFreight().intValue(),0,couponReduceAmount);
        Map<String,Integer> map=OrderAmount.calculateOrderAmount(vo);
        int memberCardReduce=map.get("memberCardReduce");
        orderBase.setMemberCardReduce(memberCardReduce);
        orderBase.setAmountTotal(map.get("amountTotal"));
        orderBase.setNeedPay(map.get("needPay"));
        orderBase.setAmountReduce(couponReduceAmount+memberCardReduce);
        responseMessage.setData(orderBase);
        return responseMessage;
    }


    public OrderAmountVo create(boolean isToDoor,int productPrice,int num,int fee,int discount,int couponReduce){
        OrderAmountVo vo=OrderAmountVo.create(OrderAmountVo::new);
        vo.setToDoor(isToDoor);
        vo.setProductPrice(productPrice);
        vo.setNum(num);
        vo.setFee(fee);
        vo.setCouponReduce(couponReduce);
        vo.setDisCount(discount);
        return vo;
    }





    /**
     * 获取订单美容师信息
     *
     * @param storeId
     * @param beauticianId
     * @return
     */
    public OrderBeautician generateOrderBeautician(Integer storeId, Integer formalCom, Integer  partTimeCom, Store store, Integer beauticianId, StoreBeautician storeBeautician) {
        OrderBeautician orderBeautician = new OrderBeautician();
        orderBeautician.setStoreId(storeId);
        orderBeautician.setBeauticianId(beauticianId);
        String selllerPhone=null;
        if(store!=null){
            selllerPhone=store.getSellerPhone()==null?"":store.getSellerPhone();
            orderBeautician.setStoreSellerPhone(selllerPhone);
        }
        if(selllerPhone!=null){
            ResponseMessage<Integer> res=storeBeauticianFeign.queryMemberIdByPhone(selllerPhone);
            if(HttpStatusConstant.OK.getStatus()==res.getCode()){
                Integer sellerMemberId=res.getData();
                orderBeautician.setStoreSellerMemberId(sellerMemberId);
            }
        }
        orderBeautician.setBeauticianImUserId(storeBeautician.getImUserId());
        orderBeautician.setBeauticianImUserName(storeBeautician.getImUsername());
        if (storeBeautician != null) {
            Integer type=storeBeautician.getBeauticianType();
            orderBeautician.setType(type.byteValue());
            orderBeautician.setBeauticianName(storeBeautician.getBeauticianName());
            orderBeautician.setBeauticianNickName(storeBeautician.getBeauticianNickName());
            orderBeautician.setImgUrl(storeBeautician.getHeadImgUrl());
            orderBeautician.setMobile(storeBeautician.getPhone());
            orderBeautician.setBeauticianMemberId(storeBeautician.getMemberId());
        }
        return orderBeautician;
    }

    /**
     * 获取订单商品信息
     *
     * @return
     */
    public OrderProduct generateOrderProduct(Integer storeId, Integer productId, Integer nums, Product product, Integer serverNeedTime) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setStoreId(storeId);
        orderProduct.setProductId(productId);
        orderProduct.setProductName(product.getServerName());
        orderProduct.setProductImg(product.getCoverImg());
        orderProduct.setProductPrice(product.getSalePrice());
        orderProduct.setNums(nums);
        orderProduct.setServerNeedTime(serverNeedTime);
        return orderProduct;
    }


}
