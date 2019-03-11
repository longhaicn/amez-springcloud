package com.union.aimei.financial.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.financial.mapper.PlatformTradeDetailMapper;
import com.union.aimei.financial.service.PlatformTradeDetailService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.date.DateUtil;
import com.union.common.utils.exception.ServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
@Service
public class PlatformTradeDetailServiceImpl implements PlatformTradeDetailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private PlatformTradeDetailMapper platformTradeDetailMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.platformTradeDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage insertSelectiveV110(PlatformTradeDetail record) {
        //判断是否重复
        PlatformTradeDetail repeatPlatformTradeDetail = new PlatformTradeDetail();
        repeatPlatformTradeDetail.setOrderNumber(record.getOrderNumber());
        repeatPlatformTradeDetail.setTradeType(record.getTradeType());
        List<PlatformTradeDetail> list = platformTradeDetailMapper.selectListByConditions(repeatPlatformTradeDetail);
        if (list.size() != 0) {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.SAVE_STREAM_ERRORS_DUPLICATE_DATA);
        }
        //保存操作
        record.setStatisticsYear(DateUtil.getCurrentYear());
        record.setStatisticsYearMonth(DateUtil.getCurrentYearMoth());
        record.setCreateTime(new Date());
        this.platformTradeDetailMapper.insertSelective(record);
        return new ResponseMessage(record.getId());
    }

    @Override
    public PlatformTradeDetail selectByPrimaryKey(Integer id) {
        return this.platformTradeDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage updateByPrimaryKeySelectiveV110(PlatformTradeDetail record) {
        PlatformTradeDetail repeatPlatformTradeDetail = new PlatformTradeDetail();
        repeatPlatformTradeDetail.setOrderNumber(record.getOrderNumber());
        repeatPlatformTradeDetail.setTradeType(record.getTradeType());
        List<PlatformTradeDetail> list = platformTradeDetailMapper.selectListByConditions(repeatPlatformTradeDetail);
        record.setId(list.get(0).getId());
        record.setUpdateTime(new Date());
        return new ResponseMessage(this.platformTradeDetailMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public PageInfo<PlatformTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, PlatformTradeDetail record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(platformTradeDetailMapper.selectListByConditions(record));
    }

    @Override
    public ResponseMessage<PlatformTradeDetail> findByOrderNo(String orderNo, Integer tradeType) {
        PlatformTradeDetail repeatPlatformTradeDetail = new PlatformTradeDetail();
        repeatPlatformTradeDetail.setOrderNumber(orderNo);
        repeatPlatformTradeDetail.setTradeType(tradeType);
        List<PlatformTradeDetail> list = platformTradeDetailMapper.selectListByConditions(repeatPlatformTradeDetail);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.SELECT_NULL);
        }
        return new ResponseMessage(list.get(0));
    }
}