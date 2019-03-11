package com.union.aimei.common.feign.pc.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.StoreTradeStatisticsFeign;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author dell
 */
@Component(value = "pc-StoreTradeStatisticsFeign")
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

    /**
     * 批量打款
     *
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage<String> batchMoney(String ids) {
        return null;
    }

    /**
     * 判断统计数据是否存在,如果存在,则更新,否则插入
     *
     * @param list
     */
    @Override
    public ResponseMessage<String> saveOrUpdateStoreTradeStatistics(List<StoreTradeStatistics> list) {
        return null;
    }

    @Override
    public ResponseMessage batchMoneyV110(List<Integer> idList) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<StoreTradeStatistics>> findListByConditions(StoreTradeStatistics storeTradeStatistics) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateBatch(List<StoreTradeStatistics> list) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage storeTradeStatisticsButtonJobs() {
       throw  new ServerException(500,"");
    }

    @Override
    public ResponseMessage storeTradeStatisticsJobs() {
        throw  new ServerException(500,"");
    }
}