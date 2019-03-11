package com.union.aimei.store.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.model.store.StoreCouponsReceived;
import com.union.aimei.common.vo.store.app.StoreCouponsReceivedByUsedVo;
import com.union.aimei.store.mapper.StoreCouponsMapper;
import com.union.aimei.store.mapper.StoreCouponsReceivedMapper;
import com.union.aimei.store.service.StoreCouponsReceivedService;
import com.union.aimei.store.util.StoreCouponNumberUtils;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 店铺优惠券领取service impl
 *
 * @author liurenkai
 * @time 2017/12/22 11:01
 */
@Service("storeCouponsReceivedService")
public class StoreCouponsReceivedServiceImpl implements StoreCouponsReceivedService {
    @Resource
    private StoreCouponsReceivedMapper storeCouponsReceivedMapper;
    @Resource
    private StoreCouponsMapper storeCouponsMapper;

    /**
     * 前端分页查询店铺优惠券领取
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeCouponsReceived 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreCouponsReceived> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsReceived storeCouponsReceived) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreCouponsReceived> list = this.storeCouponsReceivedMapper.selectListByConditions(storeCouponsReceived);
        PageInfo<StoreCouponsReceived> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage add(int storeCouponsId, int memberId) {
        ResponseMessage responseMessage = new ResponseMessage();
        StoreCoupons storeCoupons = this.storeCouponsMapper.selectByPrimaryKey(storeCouponsId);
        // 软删除标记
        if (!storeCoupons.getIsEnabled()) {
            responseMessage.setCode(StoreConstant.Save.STORE_COUPONS_DISABLED);
            responseMessage.setMessage(StoreConstant.Save.STORE_COUPONS_DISABLED_MSG);
            return responseMessage;
        }
        // 优惠券状态
        if (StoreCoupons.CouponStatus.OVER == storeCoupons.getCouponStatus()) {
            responseMessage.setCode(StoreConstant.Save.STORE_COUPONS_OVER);
            responseMessage.setMessage(StoreConstant.Save.STORE_COUPONS_OVER_MSG);
            return responseMessage;
        }
        // 领取标记
        if (!storeCoupons.getIsReceived()) {
            responseMessage.setCode(StoreConstant.Save.STORE_COUPONS_RECEIVED_END);
            responseMessage.setMessage(StoreConstant.Save.STORE_COUPONS_RECEIVED_END_MSG);
            return responseMessage;
        }
        // 每人限领(0:无限制)
        if (storeCoupons.getPerPersonLimit() > 0) {
            StoreCouponsReceived storeCouponsReceived = new StoreCouponsReceived();
            storeCouponsReceived.setStoreCouponsId(storeCouponsId);
            storeCouponsReceived.setCreateMemberId(memberId);
            int receiveCount = this.storeCouponsReceivedMapper.selectByCountByMemberId(storeCouponsReceived);
            if (receiveCount >= storeCoupons.getPerPersonLimit()) {
                responseMessage.setCode(StoreConstant.Save.STORE_COUPONS_RECEIVED_LIMIT);
                responseMessage.setMessage(StoreConstant.Save.STORE_COUPONS_RECEIVED_LIMIT_MSG);
                return responseMessage;
            }
        }
        // 店铺优惠券领取
        StoreCouponsReceived storeCouponsReceived = new StoreCouponsReceived();
        storeCouponsReceived.setStoreCouponsId(storeCouponsId);
        storeCouponsReceived.setCouponNumber(StoreCouponNumberUtils.get());
        storeCouponsReceived.setCreateMemberId(memberId);
        this.storeCouponsReceivedMapper.insertSelective(storeCouponsReceived);
        // 领取总数+1
        storeCoupons.setReceivedTotal(storeCoupons.getReceivedTotal() + 1);
        // 领取标记 已领完
        if (storeCoupons.getIssuedTotal().intValue() == storeCoupons.getReceivedTotal().intValue()) {
            storeCoupons.setIsReceived(false);
        }
        this.storeCouponsMapper.updateByPrimaryKeySelective(storeCoupons);
        responseMessage.setMessage(StoreConstant.Save.STORE_COUPONS_RECEIVED_SUCCESS_MSG);
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage used(StoreCouponsReceivedByUsedVo storeCouponsReceivedByUsedVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 店铺优惠券领取
        StoreCouponsReceived storeCouponsReceived = this.storeCouponsReceivedMapper.selectByPrimaryKey(storeCouponsReceivedByUsedVo.getStoreCouponsId());
        if (storeCouponsReceived == null) {
            responseMessage.setCode(StoreConstant.Save.STORE_COUPONS_RECEIVED_NOT_EXIST);
            responseMessage.setMessage(StoreConstant.Save.STORE_COUPONS_RECEIVED_NOT_EXIST_MSG);
            return responseMessage;
        }
        if (!storeCouponsReceived.getIsUsed()) {
            throw new ResponseException(StoreConstant.Save.STORE_COUPONS_RECEIVED_USED, StoreConstant.Save.STORE_COUPONS_RECEIVED_USED_MSG);
        }
        // 店铺优惠券
        StoreCoupons storeCoupons = this.storeCouponsMapper.selectByPrimaryKey(storeCouponsReceived.getStoreCouponsId());
        // 软删除标记
        if (!storeCoupons.getIsEnabled()) {
            responseMessage.setCode(StoreConstant.Save.STORE_COUPONS_DISABLED);
            responseMessage.setMessage(StoreConstant.Save.STORE_COUPONS_DISABLED_MSG);
            return responseMessage;
        }
        // 优惠券状态
        if (StoreCoupons.CouponStatus.NOT_START == storeCoupons.getCouponStatus()) {
            responseMessage.setCode(StoreConstant.Save.STORE_COUPONS_NOT_STARTED);
            responseMessage.setMessage(StoreConstant.Save.STORE_COUPONS_NOT_STARTED_MSG);
            return responseMessage;
        } else if (StoreCoupons.CouponStatus.OVER == storeCoupons.getCouponStatus()) {
            responseMessage.setCode(StoreConstant.Save.STORE_COUPONS_OVER);
            responseMessage.setMessage(StoreConstant.Save.STORE_COUPONS_OVER_MSG);
            return responseMessage;
        }
        // 店铺优惠券领取更新
        storeCouponsReceived.setOrderNo(storeCouponsReceivedByUsedVo.getOrderNo());
        storeCouponsReceived.setUsedProductId(storeCouponsReceivedByUsedVo.getProductId());
        storeCouponsReceived.setUsedProductName(storeCouponsReceivedByUsedVo.getProductName());
        storeCouponsReceived.setUsedTime(new Date());
        storeCouponsReceived.setIsUsed(false);
        this.storeCouponsReceivedMapper.updateByPrimaryKeySelective(storeCouponsReceived);
        // 使用总数+1
        storeCoupons.setUsedTotal(storeCoupons.getUsedTotal() + 1);
        this.storeCouponsMapper.updateByPrimaryKeySelective(storeCoupons);
        return responseMessage;
    }

    @Override
    public ResponseMessage sendBackByOrderNo(String orderNo) {
        StoreCouponsReceived storeCouponsReceived = new StoreCouponsReceived();
        storeCouponsReceived.setOrderNo(orderNo);
        storeCouponsReceived.setIsUsed(true);
        this.storeCouponsReceivedMapper.updateIsUsedByOrderNo(storeCouponsReceived);
        return new ResponseMessage();
    }

}