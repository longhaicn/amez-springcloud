package com.union.aimei.common.feign.app.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.StoreSubordinateTradeDetailFeign;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceResponseVo;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceVo;
import com.union.aimei.common.vo.financial.QueryStorePerformanceResponseVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author liufeihua
 */
@Component
public class StoreSubordinateTradeDetailHystrix implements StoreSubordinateTradeDetailFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(StoreSubordinateTradeDetail record) {
        return 1;
    }

    @Override
    public StoreSubordinateTradeDetail selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(StoreSubordinateTradeDetail record) {
        return 1;
    }

    @Override
    public PageInfo<StoreSubordinateTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, StoreSubordinateTradeDetail record) {
        return null;
    }

    /**
     * app门店端的营业统计-挂靠
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseMessage<QueryStorePerformanceResponseVo> queryStorePerformance(QueryProjectPerformanceVo vo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<QueryProjectPerformanceResponseVo>> queryProjectPerformance(Integer pageNo, Integer pageSize, QueryProjectPerformanceVo vo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage insertSelectiveV110(StoreSubordinateTradeDetail record) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelectiveV110(StoreSubordinateTradeDetail record) {
        return HystrixResponse.invokeFail();
    }
}