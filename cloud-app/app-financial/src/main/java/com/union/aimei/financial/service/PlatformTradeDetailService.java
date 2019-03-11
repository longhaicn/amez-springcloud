package com.union.aimei.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.common.utils.ResponseMessage;
/**
 * @author liufeihua
 */
public interface PlatformTradeDetailService {
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    ResponseMessage insertSelectiveV110(PlatformTradeDetail record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    PlatformTradeDetail selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelectiveV110(PlatformTradeDetail record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<PlatformTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, PlatformTradeDetail record);

    /**
     * 根据订单no和交易类型获取数据
     * @param orderNo
     * @param tradeType
     * @return
     */
    ResponseMessage<PlatformTradeDetail> findByOrderNo(String orderNo, Integer tradeType);
}