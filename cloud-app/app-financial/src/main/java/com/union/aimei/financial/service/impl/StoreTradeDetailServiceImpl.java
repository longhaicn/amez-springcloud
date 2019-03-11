package com.union.aimei.financial.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.feign.app.financial.PlatformTradeDetailFeign;
import com.union.aimei.common.feign.app.financial.StoreTradeDetailFeign;
import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.feign.app.order.OrderProductFeign;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderProduct;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.vo.financial.*;
import com.union.aimei.common.vo.order.StoreTodayOrderCount;
import com.union.aimei.financial.mapper.StoreTradeDetailMapper;
import com.union.aimei.financial.service.StoreTradeDetailService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.date.DateUtil;
import com.union.common.utils.exception.ServerException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author liufeihua
 */
@Service
public class StoreTradeDetailServiceImpl implements StoreTradeDetailService {

    @Autowired
    private StoreTradeDetailMapper storeTradeDetailMapper;

    @Autowired
    private OrderBaseFeign orderBaseFeign;

    @Autowired
    private StoreTradeDetailFeign storeTradeDetailFeign;

    @Autowired
    private OrderProductFeign orderProductFeign;

    @Autowired
    private ProductFeign productFeign;

    @Autowired
    private PlatformTradeDetailFeign platformTradeDetailFeign;


    private static String getCurrentYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.storeTradeDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage insertSelectiveV110(StoreTradeDetail record) {
        //判断是否重复
        StoreTradeDetail repeatStoreTradeDetail = new StoreTradeDetail();
        repeatStoreTradeDetail.setOrderNo(record.getOrderNo());
        repeatStoreTradeDetail.setTradeType(record.getTradeType());
        List<StoreTradeDetail> list = storeTradeDetailMapper.selectListByConditions(repeatStoreTradeDetail);
        if (list.size() != 0) {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.SAVE_STREAM_ERRORS_DUPLICATE_DATA);
        }
        //保存操作
        record.setStatisticsYear(DateUtil.getCurrentYear());
        record.setStatisticsYearMonth(DateUtil.getCurrentYearMoth());
        record.setCreateTime(new Date());
        this.storeTradeDetailMapper.insertSelective(record);
        return new ResponseMessage(record.getId());
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage updateByPrimaryKeySelectiveV110(StoreTradeDetail record) {
        StoreTradeDetail repeatStoreTradeDetail = new StoreTradeDetail();
        repeatStoreTradeDetail.setOrderNo(record.getOrderNo());
        repeatStoreTradeDetail.setTradeType(record.getTradeType());
        List<StoreTradeDetail> list = storeTradeDetailMapper.selectListByConditions(repeatStoreTradeDetail);
        if (list.size() != 1) {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.THE_ORDER_WAS_NOT_FOUND + record.toString());
        }
        if (record.getTradeStatus() == 1) {
            record.setStatisticsYear(DateUtil.getCurrentYear());
            record.setStatisticsYearMonth(DateUtil.getCurrentYearMoth());
        }
        record.setId(list.get(0).getId());
        record.setUpdateTime(new Date());
        return new ResponseMessage(this.storeTradeDetailMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public StoreTradeDetail selectByPrimaryKey(Integer id) {
        return this.storeTradeDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<StoreTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, StoreTradeDetail record) {
        PageHelper.startPage(pageNo, pageSize);
        record.setTradeType(1);
        record.setTradeStatus(1);
        record.setSettlementStatus(1);
        return new PageInfo<>(storeTradeDetailMapper.selectListByConditions(record));
    }

    /**
     * 店铺资产
     *
     * @param storeId
     * @return
     */
    @Override
    public ResponseMessage<StoreAssertVo> queryStoreAssertInfo(Integer storeId) {
        //查询出所有有退款订单
        StoreTradeDetail tradeDetail = StoreTradeDetail.builder().tradeType(3).storeId(storeId).build();
        List<StoreTradeDetail> list = storeTradeDetailMapper.selectListByConditions(tradeDetail);

        int returnIncome = 0;
        //计算出退款的金额
        for (StoreTradeDetail detail : list) {
            if (detail.getNetAmount() != null) {
                returnIncome = returnIncome + detail.getNetAmount() * 2;
            }
        }
        ResponseMessage res = ResponseMessageFactory.newInstance();
        StoreAssertVo storeAssertVo = new StoreAssertVo();
        storeAssertVo.setStoreId(storeId);
        storeAssertVo.setStatisticsYear(getCurrentYear());
        //查询店铺当年净收入
        Map<String, Object> map = new HashMap<>(1);
        map.put("storeId", storeId);
        map.put("storeYear", getCurrentYear());
        Map<String, Object> storeThisYear = storeTradeDetailMapper.queryStoreThisYearIncome(map);
        if (storeThisYear != null) {
            Integer thisYearIncome = Integer.valueOf(storeThisYear.get("storeNetIncome").toString());
            storeAssertVo.setYearNetIncome(thisYearIncome - returnIncome);
            map.remove("storeYear");
            //查询店铺累计订单数量及净收入
            Map<String, Object> allNetIncomeMap = storeTradeDetailMapper.queryStoreThisYearIncome(map);
            Long allIncome = Long.valueOf(allNetIncomeMap.get("storeNetIncome").toString()) - returnIncome;
            Integer allOrderNum = Integer.valueOf(allNetIncomeMap.get("storeOrderNum").toString());

            //减去退款订单数量
            int orderNumber = list.size() * 2;
            if (orderNumber > 0) {
                allOrderNum = allOrderNum - orderNumber;
            }

            storeAssertVo.setCumulative(allIncome);
            storeAssertVo.setOrderTotalNum(allOrderNum);
            //查询店铺结算列表
            List<StoreMonthSettleVo> settleList = storeTradeDetailMapper.queryStoreSettlement(storeId);
            if (!CollectionUtils.isEmpty(settleList)) {
                for (StoreMonthSettleVo str : settleList) {
                    Date settleTime = str.getSettlementTime();
                    if (settleTime != null) {
                        str.setSettlementStatus(true);
                    }
                    StringBuilder sb = new StringBuilder();
                }
                storeAssertVo.setBillList(settleList);
            } else {
                res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
                res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
                return res;
            }
            res.setData(storeAssertVo);
        } else {
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }

    /**
     * 查询店铺年月账单
     *
     * @param storeId
     * @param yearMonth
     * @return
     */
    @Override
    public ResponseMessage<List<StoreMonthBillVo>> queryStoreMonthBillInfo(Integer storeId, String yearMonth) {
        ResponseMessage res = ResponseMessageFactory.newInstance();
        Map<String, Object> map = new HashMap<>(2);
        map.put("storeId", storeId);
        map.put("yearMonth", yearMonth);
        List<StoreMonthBillVo> list = storeTradeDetailMapper.queryStoreBillInfo(map);
        res.setData(list);
        return res;
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
        ResponseMessage<PageInfo<QueryProjectPerformanceResponseVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<QueryProjectPerformanceResponseVo> list = this.storeTradeDetailMapper.queryProjectPerformance(vo);
        PageInfo<QueryProjectPerformanceResponseVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * app门店端的营业统计
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
        return new ResponseMessage<>(storeTradeDetailMapper.queryStorePerformance(vo));
    }

    /**
     * 日订单数和日收入
     *
     * @param id
     * @return
     */
    @Override
    public ResponseMessage<Map<String, Object>> dayOrderAndAccount(Integer id) {
        Map<String, Object> map = storeTradeDetailMapper.dayOrderAndAccount(id);
        HashMap<String, Object> hashMap = new HashMap<>(2);
        hashMap.put("id", id);
        hashMap.put("statisticsYearMonth", DateUtil.getCurrentYearMoth());
        map.put("statisticsYearMonth", storeTradeDetailMapper.monthAccount(hashMap));
        ResponseMessage<List<StoreTodayOrderCount>> listResponseMessage = orderBaseFeign.queryOrderNumByStoreId(id);
        int size = listResponseMessage.getData().size();
        if (size > 0) {

            for (StoreTodayOrderCount storeTodayOrderCount : listResponseMessage.getData()) {
                if (storeTodayOrderCount.getStatus() == 2) {
                    map.put("waitForService", storeTodayOrderCount.getNum());
                } else if (storeTodayOrderCount.getStatus() == 3) {
                    map.put("ingForService", storeTodayOrderCount.getNum());
                } else if (storeTodayOrderCount.getStatus() == 4) {
                    map.put("waitForSay", storeTodayOrderCount.getNum());
                }
            }
        } else {
            map.put("waitForService", 0);
            map.put("ingForService", 0);
            map.put("waitForSay", 0);
        }
        return new ResponseMessage<>(map);
    }

    @Override
    public ResponseMessage<PageInfo<StoreTradeDetail>> selectListBySettlementStatus(Integer pageNo, Integer pageSize, StoreTradeDetail record) {
        PageHelper.startPage(pageNo, pageSize);
        String[] currentYearMonth = DateUtil.getCurrentYearMoth().split("-");
        StoreTradeDetailDateVo storeTradeDetailDateVo = new StoreTradeDetailDateVo();
        storeTradeDetailDateVo.setSettlementStatus(0);
        storeTradeDetailDateVo.setStartTime(DateUtil.getFirstDayOfMonth(Integer.parseInt(currentYearMonth[0]), Integer.parseInt(currentYearMonth[1])) + " 00:00:00");
        storeTradeDetailDateVo.setEndTime(DateUtil.getCurrentYearMothDayHms());
        storeTradeDetailDateVo.setStoreId(record.getStoreId());
        return new ResponseMessage<>(new PageInfo<>(storeTradeDetailMapper.selectListByConditionsVo(storeTradeDetailDateVo)));
    }

    @Override
    public ResponseMessage<QueryStoreTradeDetailVo> selectByPrimaryKeyV110(Integer id) {
        QueryStoreTradeDetailVo queryStoreTradeDetailVo = new QueryStoreTradeDetailVo();
        StoreTradeDetail storeTradeDetail = this.storeTradeDetailFeign.selectByPrimaryKey(id);
        OrderBase orderBase = this.orderBaseFeign.queryByOrderNo(storeTradeDetail.getOrderNo());
        //查询项目类型
        ResponseMessage<OrderProduct> responseMessage = orderProductFeign.queryByOrderNo(orderBase.getOrderNo());
        if (ResponseUtil.isFail(responseMessage)) {
            return (ResponseMessage) responseMessage;
        }
        ResponseMessage<Product> responseMessage1 = this.productFeign.findById(responseMessage.getData().getProductId());
        if (ResponseUtil.isFail(responseMessage1)) {
            return (ResponseMessage) responseMessage1;
        }
        ResponseMessage<PlatformTradeDetail> responseMessage2 = this.platformTradeDetailFeign.findByOrderNo(storeTradeDetail.getOrderNo(), storeTradeDetail.getTradeType() == 3 ? 4 : storeTradeDetail.getTradeType());
        if (ResponseUtil.isFail(responseMessage2)) {
            return (ResponseMessage) responseMessage2;
        }
        queryStoreTradeDetailVo.setProductType(responseMessage1.getData().getProductType());
        queryStoreTradeDetailVo.setStoreTradeDetail(storeTradeDetail);
        queryStoreTradeDetailVo.setOrderBase(orderBase);
        queryStoreTradeDetailVo.setPlatformCommission(responseMessage2.getData().getPlatformCommission());
        return new ResponseMessage<>(queryStoreTradeDetailVo);
    }
}