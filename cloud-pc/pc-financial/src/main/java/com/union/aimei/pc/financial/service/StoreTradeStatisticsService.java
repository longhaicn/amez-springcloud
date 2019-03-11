package com.union.aimei.pc.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.common.utils.ResponseMessage;

import java.util.List;
/**
 * @author dell
 */
public interface StoreTradeStatisticsService {
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
    int insertSelective(StoreTradeStatistics record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    StoreTradeStatistics selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(StoreTradeStatistics record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<StoreTradeStatistics> selectListByConditions(Integer pageNo, Integer pageSize, StoreTradeStatistics record);

    /**
     * 批量打款
     *
     * @param ids
     * @return
     */
    ResponseMessage<String> batchMoney(String ids);

    /**
     * 判断统计数据是否存在,如果存在,则更新,否则插入
     *
     * @param list
     * @return
     */
    ResponseMessage<String> saveOrUpdateStoreTradeStatistics(List<StoreTradeStatistics> list);

    /**
     * 批量打款（V1.1.0）
     *
     * @param idList
     * @return
     */
    ResponseMessage batchMoneyV110(List<Integer> idList);

    /**
     * 根据条件获取列表
     *
     * @param storeTradeStatistics
     * @return
     */
    ResponseMessage<List<StoreTradeStatistics>> findListByConditions(StoreTradeStatistics storeTradeStatistics);

    /**
     * 批量更新数据
     *
     * @param list
     * @return
     */
    ResponseMessage updateBatch(List<StoreTradeStatistics> list);

    /**
     * 店铺流水统计调度
     * @return
     */
    ResponseMessage storeTradeStatisticsJobs();

    /**
     * 店铺流水统计允许对账确认调度
     * @return
     */
    ResponseMessage storeTradeStatisticsButtonJobs();
}