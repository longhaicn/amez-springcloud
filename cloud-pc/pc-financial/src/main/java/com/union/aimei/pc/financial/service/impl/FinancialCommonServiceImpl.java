package com.union.aimei.pc.financial.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.util.StringUtil;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.pc.financial.config.Constant;
import com.union.aimei.pc.financial.mapper.BeauticianTradeDetailMapper;
import com.union.aimei.pc.financial.mapper.PlatformTradeDetailMapper;
import com.union.aimei.pc.financial.mapper.StoreSubordinateTradeDetailMapper;
import com.union.aimei.pc.financial.mapper.StoreTradeDetailMapper;
import com.union.aimei.pc.financial.service.FinancialCommonService;
import com.union.common.utils.ResponseException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author dell
 */
@Service
@CommonsLog
public class FinancialCommonServiceImpl implements FinancialCommonService {

    @Autowired
    private BeauticianTradeDetailMapper beauticianTradeDetailMapper;

    @Autowired
    private StoreTradeDetailMapper storeTradeDetailMapper;

    @Autowired
    private PlatformTradeDetailMapper platformTradeDetailMapper;

    @Autowired
    private StoreSubordinateTradeDetailMapper storeSubordinateTradeDetailMapper;

    /**
     * 批量修改美容师,店铺,平台交易流水的订单状态
     *
     * @param list
     */
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateOrderStatus(List<String> list) {
        log.info("list=" + list.toString());
        int total = 0;
        try {
            for (String orderNumber : list) {
                //更新美容师交易流水订单状态
                log.info("订单号：" + orderNumber);
                if (StringUtil.isNotEmpty(orderNumber)) {

                    //美容师流水
                    BeauticianTradeDetail beauticianTradeDetail = new BeauticianTradeDetail();
                    beauticianTradeDetail.setOrderNo(orderNumber);
                    beauticianTradeDetail.setTradeType(1);
                    beauticianTradeDetail = this.beauticianTradeDetailMapper.selectByOrderNoTradeType(beauticianTradeDetail);
                    if (null != beauticianTradeDetail) {
                        BeauticianTradeDetail beauticianTradeDetailUpdate = new BeauticianTradeDetail();
                        beauticianTradeDetailUpdate.setId(beauticianTradeDetail.getId());
                        beauticianTradeDetailUpdate.setTradeStatus(1);
                        beauticianTradeDetailUpdate.setSettlementTime(new Date());
                        this.beauticianTradeDetailMapper.updateByPrimaryKeySelective(beauticianTradeDetailUpdate);
                    }
                    //店铺流水
                    StoreTradeDetail storeTradeDetail = new StoreTradeDetail();
                    storeTradeDetail.setOrderNo(orderNumber);
                    storeTradeDetail.setTradeType(1);
                    storeTradeDetail = this.storeTradeDetailMapper.selectByOrderNoTradeType(storeTradeDetail);
                    if (null != storeTradeDetail) {
                        StoreTradeDetail storeTradeDetailUpdate = new StoreTradeDetail();
                        storeTradeDetailUpdate.setId(storeTradeDetail.getId());
                        storeTradeDetailUpdate.setTradeStatus(1);
                        storeTradeDetailUpdate.setSettlementTime(new Date());
                        this.storeTradeDetailMapper.updateByPrimaryKeySelective(storeTradeDetailUpdate);
                    }
                    //挂靠店铺流水
                    StoreSubordinateTradeDetail storeSubordinateTradeDetail = new StoreSubordinateTradeDetail();
                    storeSubordinateTradeDetail.setOrderNo(orderNumber);
                    storeSubordinateTradeDetail.setTradeType(1);
                    storeSubordinateTradeDetail = this.storeSubordinateTradeDetailMapper.selectByOrderNoTradeType(storeSubordinateTradeDetail);
                    if (null != storeSubordinateTradeDetail) {
                        StoreSubordinateTradeDetail storeSubordinateTradeDetailUpdate = new StoreSubordinateTradeDetail();
                        storeSubordinateTradeDetailUpdate.setId(storeSubordinateTradeDetail.getId());
                        storeSubordinateTradeDetailUpdate.setTradeStatus(1);
                        storeSubordinateTradeDetailUpdate.setSettlementTime(new Date());
                        this.storeSubordinateTradeDetailMapper.updateByPrimaryKeySelective(storeSubordinateTradeDetailUpdate);
                    }
                    //平台流水
                    PlatformTradeDetail platformTradeDetail = new PlatformTradeDetail();
                    platformTradeDetail.setOrderNumber(orderNumber);
                    platformTradeDetail.setTradeType(1);
                    platformTradeDetail = this.platformTradeDetailMapper.selectByOrderNoTradeType(platformTradeDetail);
                    if (null != platformTradeDetail) {
                        PlatformTradeDetail platformTradeDetailUpdate = new PlatformTradeDetail();
                        platformTradeDetailUpdate.setId(platformTradeDetail.getId());
                        platformTradeDetailUpdate.setTradeStatus(1);
                        this.platformTradeDetailMapper.updateByPrimaryKeySelective(platformTradeDetailUpdate);
                    }
                }
            }
        } catch (Exception e) {
            log.info("出异常：1", e.getCause());
            log.info("出异常：2" + e);
            throw new ResponseException("更新订单状态失败", Constant.UPDATE_ORDER_FAIL);
        }
        return total;
    }
}