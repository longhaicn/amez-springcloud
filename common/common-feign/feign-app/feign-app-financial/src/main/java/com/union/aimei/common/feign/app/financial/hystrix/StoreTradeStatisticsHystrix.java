package com.union.aimei.common.feign.app.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.StoreTradeStatisticsFeign;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsAwaitVo;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author liufeihua
 */
@Component
public class StoreTradeStatisticsHystrix implements StoreTradeStatisticsFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(StoreTradeStatistics record) {
        return 1;
    }

    @Override
    public StoreTradeStatistics selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(StoreTradeStatistics record) {
        return 1;
    }

    @Override
    public PageInfo<StoreTradeStatistics> selectListByConditions(Integer pageNo, Integer pageSize, StoreTradeStatistics record) {
        return null;
    }

    @Override
    public ResponseMessage<List<StoreTradeStatistics>> selectListByConditionsV110(StoreTradeStatistics record) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreTradeStatisticsVo>> selectListByConditionsVoV110(Integer pageNo, Integer pageSize, StoreTradeStatistics record) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreTradeStatisticsAwaitVo> selectBySettlementAndStoreIdV110(Integer storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage checkForConfirmationV110(Integer id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreshipWithdrawal> selectStoreshipWithdrawalByStoreTradeIdV110(Integer id) {
        return HystrixResponse.invokeFail();
    }
}