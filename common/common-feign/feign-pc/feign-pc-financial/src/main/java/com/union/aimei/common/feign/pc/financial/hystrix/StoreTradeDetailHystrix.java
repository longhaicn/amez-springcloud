package com.union.aimei.common.feign.pc.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.StoreTradeDetailFeign;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "pc-StoreTradeDetailFeign")
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

    /**
     * 统计店铺数据
     *
     * @param statisticsYearMonth
     * @return
     */
    @Override
    public PageInfo<StoreTradeStatistics> selectStoreListByConditions(String statisticsYearMonth) {
        return null;
    }

    @Override
    public ResponseMessage insertSelectiveV110(StoreTradeDetail record) {
        return HystrixResponse.invokeFail();
    }
}