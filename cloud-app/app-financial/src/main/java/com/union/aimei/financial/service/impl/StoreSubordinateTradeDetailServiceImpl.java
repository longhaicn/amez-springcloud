package com.union.aimei.financial.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceResponseVo;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceVo;
import com.union.aimei.common.vo.financial.QueryStorePerformanceResponseVo;
import com.union.aimei.financial.mapper.StoreSubordinateTradeDetailMapper;
import com.union.aimei.financial.service.StoreSubordinateTradeDetailService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.date.DateUtil;
import com.union.common.utils.exception.ServerException;
import org.apache.commons.lang.StringUtils;
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
public class StoreSubordinateTradeDetailServiceImpl implements StoreSubordinateTradeDetailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private StoreSubordinateTradeDetailMapper storeSubordinateTradeDetailMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.storeSubordinateTradeDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage insertSelectiveV110(StoreSubordinateTradeDetail record) {
        //判断是否重复
        StoreSubordinateTradeDetail repeatStoreSubordinateTradeDetail = new StoreSubordinateTradeDetail();
        repeatStoreSubordinateTradeDetail.setOrderNo(record.getOrderNo());
        repeatStoreSubordinateTradeDetail.setTradeType(record.getTradeType());
        List<StoreSubordinateTradeDetail> list = storeSubordinateTradeDetailMapper.selectListByConditions(repeatStoreSubordinateTradeDetail);
        if (list.size() != 0) {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.SAVE_STREAM_ERRORS_DUPLICATE_DATA);
        }
        //保存操作
        record.setStatisticsYear(DateUtil.getCurrentYear());
        record.setStatisticsYearMonth(DateUtil.getCurrentYearMoth());
        record.setCreateTime(new Date());
        this.storeSubordinateTradeDetailMapper.insertSelective(record);
        return new ResponseMessage(record.getId());
    }


    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage updateByPrimaryKeySelectiveV110(StoreSubordinateTradeDetail record) {
        StoreSubordinateTradeDetail repeatStoreSubordinateTradeDetail = new StoreSubordinateTradeDetail();
        repeatStoreSubordinateTradeDetail.setOrderNo(record.getOrderNo());
        repeatStoreSubordinateTradeDetail.setTradeType(record.getTradeType());
        List<StoreSubordinateTradeDetail> list = storeSubordinateTradeDetailMapper.selectListByConditions(repeatStoreSubordinateTradeDetail);
        record.setId(list.get(0).getId());
        record.setUpdateTime(new Date());
        return new ResponseMessage(this.storeSubordinateTradeDetailMapper.updateByPrimaryKeySelective(record));
    }


    @Override
    public StoreSubordinateTradeDetail selectByPrimaryKey(Integer id) {
        return this.storeSubordinateTradeDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<StoreSubordinateTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, StoreSubordinateTradeDetail record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(storeSubordinateTradeDetailMapper.selectListByConditions(record));
    }

    /**
     * app门店端的营业统计-挂靠
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseMessage<QueryStorePerformanceResponseVo> queryStorePerformance(QueryProjectPerformanceVo vo) {
        int i = 10;
        if (StringUtils.isNotEmpty(vo.getStartDate()) && vo.getStartDate().length() == i) {
            vo.setStartDate(vo.getStartDate() + " 00:00:00");
        }
        if (StringUtils.isNotEmpty(vo.getEndDate()) && vo.getEndDate().length() == i) {
            vo.setEndDate(vo.getEndDate() + " 23:59:59");
        }
        return new ResponseMessage<>(storeSubordinateTradeDetailMapper.queryStorePerformance(vo));
    }

    /**
     * app门店端的营业统计中的项目业绩
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<QueryProjectPerformanceResponseVo>> queryProjectPerformance(Integer pageNo, Integer pageSize, QueryProjectPerformanceVo vo) {
        int i = 10;
        if (StringUtils.isNotEmpty(vo.getStartDate()) && vo.getStartDate().length() == i) {
            vo.setStartDate(vo.getStartDate() + " 00:00:00");
        }
        if (StringUtils.isNotEmpty(vo.getEndDate()) && vo.getEndDate().length() == i) {
            vo.setEndDate(vo.getEndDate() + " 23:59:59");
        }
        ResponseMessage responseMessage = new ResponseMessage();
        PageHelper.startPage(pageNo, pageSize);
        List<QueryProjectPerformanceResponseVo> list = this.storeSubordinateTradeDetailMapper.queryProjectPerformance(vo);
        PageInfo<QueryProjectPerformanceResponseVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }
}