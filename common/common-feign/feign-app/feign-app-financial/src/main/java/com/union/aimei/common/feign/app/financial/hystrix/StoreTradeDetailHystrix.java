package com.union.aimei.common.feign.app.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.StoreTradeDetailFeign;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.vo.financial.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * @author liufeihua
 */
@Component
public class StoreTradeDetailHystrix implements StoreTradeDetailFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(StoreTradeDetail record) {
        return 1;
    }

    @Override
    public StoreTradeDetail selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(StoreTradeDetail record) {
        return 1;
    }

    @Override
    public PageInfo<StoreTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, StoreTradeDetail record) {
        return null;
    }

    @Override
    public ResponseMessage<PageInfo<StoreTradeDetail>> selectListBySettlementStatusV110(Integer pageNo, Integer pageSize, StoreTradeDetail record) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 通过店铺ID查询店铺资产信息
     *
     * @param storeId
     * @return
     */
    @Override
    public ResponseMessage<StoreAssertVo> queryStoreAssertInfo(Integer storeId) {
        return null;
    }

    /**
     * 查询店铺年月账单信息
     *
     * @param storeId   门店ID
     * @param yearMonth
     * @return
     */
    @Override
    public ResponseMessage queryStoreMonthBillInfo(Integer storeId, String yearMonth) {

        return null;
    }

    /**
     * app门店端的营业统计中的项目业绩
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<QueryProjectPerformanceResponseVo>> queryProjectPerformance(Integer pageNo, Integer pageSize, QueryProjectPerformanceVo vo) {
        return HystrixResponse.invokeFail();
    }

    /**
     * app门店端的营业统计
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseMessage<QueryStorePerformanceResponseVo> queryStorePerformance(QueryProjectPerformanceVo vo) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 日订单数和日收入
     *
     * @param id
     * @return
     */
    @Override
    public ResponseMessage<Map<String, Object>> dayOrderAndAccount(Integer id) {
        return null;
    }

    @Override
    public ResponseMessage insertSelectiveV110(StoreTradeDetail record) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelectiveV110(StoreTradeDetail record) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<QueryStoreTradeDetailVo> selectByPrimaryKeyV110(int id) {
        return HystrixResponse.invokeFail();
    }
}