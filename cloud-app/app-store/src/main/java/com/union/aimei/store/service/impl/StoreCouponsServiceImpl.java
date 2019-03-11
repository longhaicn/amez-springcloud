package com.union.aimei.store.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.aimei.common.vo.store.app.*;
import com.union.aimei.store.constant.CondConstant;
import com.union.aimei.store.mapper.StoreCouponsMapper;
import com.union.aimei.store.mapper.StoreCouponsProductMapper;
import com.union.aimei.store.service.StoreCouponsService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.constant.ResponseContants;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;

/**
 * 店铺优惠券
 *
 * @author liurenkai
 * @time 2017/12/22 11:00
 */
@Service("storeCouponsService")
public class StoreCouponsServiceImpl implements StoreCouponsService {
    @Resource
    private StoreCouponsMapper storeCouponsMapper;
    @Resource
    private StoreCouponsProductMapper storeCouponsProductMapper;
    @Resource
    private ProductFeign productFeign;

    @Override
    public PageInfo<StoreCoupons> findByPageForFront(Integer pageNo, Integer pageSize, StoreCoupons storeCoupons) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreCoupons> list = this.storeCouponsMapper.selectListByConditions(storeCoupons);
        PageInfo<StoreCoupons> page = new PageInfo<>(list);
        for (StoreCoupons storeCoupons1 : page.getList()) {
            storeCoupons1.setBeginTime(storeCoupons1.getBeginTime().replaceAll("-", "."));
            storeCoupons1.setEndTime(storeCoupons1.getEndTime().replaceAll("-", "."));
        }
        return page;
    }

    @Override
    public ResponseMessage<PageInfo<StoreCoupons>> findByPageForProductId(Integer pageNo, Integer pageSize, CouponsByProductIdVo productIdVo) {
        ResponseMessage<PageInfo<StoreCoupons>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(productIdVo), Map.class);
        Map<String, Object> condMap = CondConstant.couponByProduct(true, true, false);
        condMap.putAll(voMap);
        List<StoreCoupons> list = this.storeCouponsMapper.selectListByProductId(condMap);
        PageInfo<StoreCoupons> page = new PageInfo<>(list);
        responseMessage.setData(page);
        for (StoreCoupons storeCoupons1 : responseMessage.getData().getList()) {
            storeCoupons1.setBeginTime(storeCoupons1.getBeginTime().replaceAll("-", "."));
            storeCoupons1.setEndTime(storeCoupons1.getEndTime().replaceAll("-", "."));
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage add(StoreCouponsVo storeCouponsVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 优惠券
        StoreCoupons storeCoupons = storeCouponsVo.getStoreCoupons();
        storeCoupons.setIsReceived(true);
        // 优惠券状态
        try {
            Date beginTime = DateUtils.parseDate(storeCoupons.getBeginTime(), "yyyy-MM-dd");
            Date currTime = DateUtils.parseDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd");
            if (beginTime.after(currTime)) {
                storeCoupons.setCouponStatus(StoreCoupons.CouponStatus.NOT_START);
            } else {
                storeCoupons.setCouponStatus(StoreCoupons.CouponStatus.ACTIVE);
            }
        } catch (ParseException e) {
            responseMessage.setCode(ResponseContants.PARAMS_ERROR);
            responseMessage.setMessage(ResponseContants.PARAMS_ERROR_MSG);
            return responseMessage;
        }
        this.storeCouponsMapper.insertSelective(storeCoupons);
        // 优惠券支持服务类型
        if (StoreCoupons.SupportServiceType.ALL == storeCoupons.getSupportServiceType()) {
            ResponseMessage<List<Product>> productRes = this.productFeign.findListByStoreId(storeCoupons.getStoreId());
            if (ResponseUtil.isFail(productRes)) {
                return productRes;
            }
            List<Product> productList = productRes.getData();
            if (!productList.isEmpty()) {
                List<StoreCouponsProduct> storeCouponsProductList = new ArrayList<>(10);
                productList.forEach(product -> {
                    StoreCouponsProduct storeCouponsProduct = new StoreCouponsProduct();
                    storeCouponsProduct.setStoreId(product.getStoreId());
                    storeCouponsProduct.setStoreName(product.getStoreName());
                    storeCouponsProduct.setProductId(product.getId());
                    storeCouponsProduct.setProductName(product.getServerName());
                    storeCouponsProductList.add(storeCouponsProduct);
                });
                storeCouponsVo.setStoreCouponsProductList(storeCouponsProductList);
            }
        }
        // 优惠券-商品-关联
        List<StoreCouponsProduct> storeCouponsProductList = storeCouponsVo.getStoreCouponsProductList();
        if (!storeCouponsProductList.isEmpty()) {
            storeCouponsProductList.forEach(storeCouponsProduct -> {
                storeCouponsProduct.setStoreCouponsId(storeCoupons.getId());
            });
            this.storeCouponsProductMapper.addBatch(storeCouponsProductList);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage isEnabled(int id, int isEnabled) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 店铺优惠券
        StoreCoupons storeCoupons = new StoreCoupons();
        storeCoupons.setId(id);
        storeCoupons.setIsEnabled(1 == isEnabled ? true : false);
        this.storeCouponsMapper.updateByPrimaryKeySelective(storeCoupons);
        // 店铺优惠卷-商品关联
        StoreCouponsProduct storeCouponsProduct = new StoreCouponsProduct();
        storeCouponsProduct.setStoreCouponsId(id);
        storeCouponsProduct.setIsEnabled(1 == isEnabled ? true : false);
        this.storeCouponsProductMapper.updateByIsEnabledByStoreCouponsId(storeCouponsProduct);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreCoupons> findById(int id) {
        ResponseMessage<StoreCoupons> responseMessage = new ResponseMessage<>();
        StoreCoupons storeCoupons = this.storeCouponsMapper.selectByPrimaryKey(id);
        responseMessage.setData(storeCoupons);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreCouponsByMemberIdForStoreResultVo>> findByPageForMemberIdForStore(Integer pageNo, Integer pageSize, StoreCouponsByMemberIdForStoreVo storeCouponsByMemberIdForStoreVo) {
        ResponseMessage<PageInfo<StoreCouponsByMemberIdForStoreResultVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(storeCouponsByMemberIdForStoreVo), Map.class);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeState", Store.StoreState.OPEN);
        List<Integer> couponStatusList = new ArrayList<>(10);
        couponStatusList.add(StoreCoupons.CouponStatus.NOT_START);
        couponStatusList.add(StoreCoupons.CouponStatus.ACTIVE);
        condMap.put("couponStatusList", couponStatusList);
        condMap.putAll(voMap);
        List<StoreCouponsByMemberIdForStoreResultVo> list = this.storeCouponsMapper.selectListByMemberIdForStore(condMap);
        PageInfo<StoreCouponsByMemberIdForStoreResultVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        //替换时间的 分隔符 "-" 为 "."
        for (StoreCouponsByMemberIdForStoreResultVo storeCouponsByMemberIdForStoreResultVo : page.getList()) {
            storeCouponsByMemberIdForStoreResultVo.setBeginTime(storeCouponsByMemberIdForStoreResultVo.getBeginTime().replaceAll("-", "."));
            storeCouponsByMemberIdForStoreResultVo.setEndTime(storeCouponsByMemberIdForStoreResultVo.getEndTime().replaceAll("-", "."));
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreCouponsByMemberIdForProductResultVo>> findByPageForMemberIdForProduct(Integer pageNo, Integer pageSize, StoreCouponsByMemberIdForProductVo storeCouponsByMemberIdForProductVo) {
        ResponseMessage<PageInfo<StoreCouponsByMemberIdForProductResultVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(storeCouponsByMemberIdForProductVo), Map.class);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeState", Store.StoreState.OPEN);
        condMap.putAll(voMap);
        List<StoreCouponsByMemberIdForProductResultVo> list = this.storeCouponsMapper.selectListByMemberIdForProduct(condMap);
        PageInfo<StoreCouponsByMemberIdForProductResultVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreCouponsByMemberIdForReceivedResultVo>> findByPageForMemberIdForReceived(Integer pageNo, Integer pageSize, StoreCouponsByMemberIdForReceivedVo storeCouponsByMemberIdForReceivedVo) {
        ResponseMessage<PageInfo<StoreCouponsByMemberIdForReceivedResultVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(storeCouponsByMemberIdForReceivedVo), Map.class);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeState", Store.StoreState.OPEN);
        condMap.putAll(voMap);
        List<StoreCouponsByMemberIdForReceivedResultVo> list;
        if (null == storeCouponsByMemberIdForReceivedVo.getProductId()) {
            list = this.storeCouponsMapper.selectListByMemberIdForReceived(condMap);
        } else {
            list = this.storeCouponsMapper.selectListByMemberIdForReceivedForProduct(condMap);
        }
        for (StoreCouponsByMemberIdForReceivedResultVo vo : list) {
            vo.setBeginTime(vo.getBeginTime().replaceAll("-", "."));
            vo.setEndTime(vo.getEndTime().replaceAll("-", "."));
        }
        PageInfo<StoreCouponsByMemberIdForReceivedResultVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> findCountByMemberIdForReceived(Integer memberId) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeState", Store.StoreState.OPEN);
        condMap.put("memberId", memberId);
        int count = this.storeCouponsMapper.selectCountByMemberIdForReceived(condMap);
        responseMessage.setData(count);
        return responseMessage;
    }

    @Override
    public ResponseMessage<CouponsByProductForOrderResVo> findByProductForBestForOrder(StoreCouponsByProductForBestForOrderVo storeCouponsByProductForBestForOrderVo) {
        ResponseMessage<CouponsByProductForOrderResVo> responseMessage = new ResponseMessage<>();
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(storeCouponsByProductForBestForOrderVo), Map.class);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeState", Store.StoreState.OPEN);
        condMap.put("couponStatus", StoreCoupons.CouponStatus.ACTIVE);
        condMap.putAll(voMap);
        CouponsByProductForOrderResVo resVo = this.storeCouponsMapper.selectByProductForBestForOrder(condMap);
        if (null == resVo) {
            responseMessage.setCode(StoreConstant.Query.COUPONS_NULL);
            responseMessage.setMessage(StoreConstant.Query.COUPONS_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<CouponsByProductForOrderResVo>> findByPageForProductForOrder(Integer pageNo, Integer pageSize, StoreCouponsByProductForBestForOrderVo storeCouponsByProductForBestForOrderVo) {
        ResponseMessage<PageInfo<CouponsByProductForOrderResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(storeCouponsByProductForBestForOrderVo), Map.class);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeState", Store.StoreState.OPEN);
        condMap.put("couponStatus", StoreCoupons.CouponStatus.ACTIVE);
        condMap.putAll(voMap);
        List<CouponsByProductForOrderResVo> list = this.storeCouponsMapper.selectListByProductForOrder(condMap);
        PageInfo<CouponsByProductForOrderResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }
}