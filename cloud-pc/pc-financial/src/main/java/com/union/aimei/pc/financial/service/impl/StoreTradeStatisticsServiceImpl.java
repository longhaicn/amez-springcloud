package com.union.aimei.pc.financial.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreFeign;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.pc.financial.async.StoreTradeStatisticsAsyncTask;
import com.union.aimei.pc.financial.mapper.StoreTradeDetailMapper;
import com.union.aimei.pc.financial.mapper.StoreTradeStatisticsMapper;
import com.union.aimei.pc.financial.service.StoreTradeStatisticsService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
/**
 * @author dell
 */
@Service
public class StoreTradeStatisticsServiceImpl implements StoreTradeStatisticsService {

    @Autowired
    private StoreTradeStatisticsMapper storeTradeStatisticsMapper;

    @Autowired
    private StoreTradeStatisticsAsyncTask storeTradeStatisticsAsyncTask;

    @Autowired
    private StoreTradeDetailMapper storeTradeDetailMapper;

    @Autowired
    private StoreFeign storeFeign;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.storeTradeStatisticsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(StoreTradeStatistics record) {
        record.setStatisticsYear(DateUtil.getCurrentYear());
        record.setStatisticsYearMonth(DateUtil.getCurrentYearMoth());
        record.setCreateTime(new Date());
        return this.storeTradeStatisticsMapper.insertSelective(record);
    }

    @Override
    public StoreTradeStatistics selectByPrimaryKey(Integer id) {
        return this.storeTradeStatisticsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StoreTradeStatistics record) {
        record.setUpdateTime(new Date());
        return this.storeTradeStatisticsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<StoreTradeStatistics> selectListByConditions(Integer pageNo, Integer pageSize, StoreTradeStatistics record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(storeTradeStatisticsMapper.selectListByConditions(record));
    }

    /**
     * 批量打款
     *
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage<String> batchMoney(String ids) {
        String[] list = ids.split(",");
        StoreTradeStatistics storeTradeStatistics;
        for (String s : list) {
            storeTradeStatistics = new StoreTradeStatistics();
            storeTradeStatistics.setId(Integer.parseInt(s));
            storeTradeStatistics.setPlayStatus(1);
            storeTradeStatistics.setPlayTime(new Date());
            storeTradeStatisticsMapper.updateByPrimaryKeySelective(storeTradeStatistics);
        }
        return new ResponseMessage<>();
    }

    /**
     * 判断统计数据是否存在,如果存在,则更新,否则插入
     *
     * @param list
     * @return
     */
    @Override
    public ResponseMessage<String> saveOrUpdateStoreTradeStatistics(List<StoreTradeStatistics> list) {
        // 断统计数据是否存在,如果存在,则更新,否则插入
        StoreTradeStatistics statistics;
        for (StoreTradeStatistics storeTradeStatistics : list) {
            if (null != storeTradeStatistics.getStoreId()) {
                statistics = new StoreTradeStatistics();
                statistics.setStoreId(storeTradeStatistics.getStoreId());
                statistics.setStatisticsYearMonth(storeTradeStatistics.getStatisticsYearMonth());
                List<StoreTradeStatistics> storeTradeStatistics1 = storeTradeStatisticsMapper.selectListByConditions(statistics);
                //如果存在
                if (null != storeTradeStatistics1 && storeTradeStatistics1.size() > 0) {
                    storeTradeStatistics.setId(storeTradeStatistics1.get(0).getId());
                    storeTradeStatistics.setUpdateTime(new Date());
                    storeTradeStatisticsMapper.updateByPrimaryKeySelective(storeTradeStatistics);
                } else {
                    //数据不存在数据库里面
                    storeTradeStatistics.setReconciliationType(StoreTradeStatistics.RECONCILIATION_TYPE_INIT);
                    storeTradeStatistics.setPlayStatus(StoreTradeStatistics.NOT_PLAY_STATUS);
                    storeTradeStatistics.setCreateTime(new Date());
                    storeTradeStatisticsMapper.insertSelective(storeTradeStatistics);
                }
            }
        }
        return new ResponseMessage<>();
    }

    @Override
    public ResponseMessage batchMoneyV110(List<Integer> idList) {
        ResponseMessage responseMessage = new ResponseMessage();
        //异步更新数据 和 发送短信 推送信息
        this.storeTradeStatisticsAsyncTask.pushMessageAndSendMessage(idList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreTradeStatistics>> findListByConditions(StoreTradeStatistics storeTradeStatistics) {
        return new ResponseMessage<List<StoreTradeStatistics>>(this.storeTradeStatisticsMapper.selectListByConditions(storeTradeStatistics));
    }

    @Override
    public ResponseMessage updateBatch(List<StoreTradeStatistics> list) {
        list.forEach(x -> {
            this.storeTradeStatisticsMapper.updateByPrimaryKeySelective(x);
        });
        return new ResponseMessage();
    }


    @Override
    public ResponseMessage storeTradeStatisticsJobs() {

        //1.查询数据
        String statisticsYearMonth = DateUtil.getLastMonth();
        List<StoreTradeStatistics> list = this.storeTradeDetailMapper.selectStoreListByConditions();

        if (null != list && list.size() > 0) {
            //2.设置店铺等相关数据
            IdBatchVo idBatchVo = new IdBatchVo();
            idBatchVo.setIdList(list.stream().map(StoreTradeStatistics::getStoreId).collect(Collectors.toList()));
            ResponseMessage<List<Store>> responseMessage = this.storeFeign.findListByIdBatch(idBatchVo);
            if (ResponseUtil.isFail(responseMessage)) {
                return responseMessage;
            }
            Map<Integer, Store> storeMap = responseMessage.getData().stream().collect(Collectors.toMap(Store::getId, Function.identity()));
            for (StoreTradeStatistics storeTradeStatistics : list) {
                if (storeMap.containsKey(storeTradeStatistics.getStoreId())) {
                    Store store = storeMap.get(storeTradeStatistics.getStoreId());
                    storeTradeStatistics.setStoreName(store.getStoreName());
                    storeTradeStatistics.setStorePhone(store.getSellerPhone());
                }
                if (storeTradeStatistics.getOnNetIncome() == null) {
                    storeTradeStatistics.setOnNetIncome(0);
                }
                if (storeTradeStatistics.getRefundOrderAmount() == null) {
                    storeTradeStatistics.setRefundOrderAmount(0);
                }
                //对账金额
                storeTradeStatistics.setReconciliationAmount(storeTradeStatistics.getOnNetIncome());
                //统计时间年份
                storeTradeStatistics.setStatisticsYear(statisticsYearMonth.split("-")[0]);
                //统计时间年份月份
                storeTradeStatistics.setStatisticsYearMonth(statisticsYearMonth);
            }
            //3.判断是否存在,如果存在,则更新,否则插入
            saveOrUpdateStoreTradeStatistics(list);

            //4.批量更新为已结算状态
            StoreTradeDetail storeTradeDetail = new StoreTradeDetail();
            list.forEach(x -> {
                storeTradeDetail.setStoreId(x.getStoreId());
                this.storeTradeDetailMapper.updateBatch(storeTradeDetail);
            });
        }
        return new ResponseMessage();
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getLastMonth());
    }

    @Override
    public ResponseMessage storeTradeStatisticsButtonJobs() {
        StoreTradeStatistics storeTradeStatistics = new StoreTradeStatistics();
        storeTradeStatistics.setReconciliationType(StoreTradeStatistics.RECONCILIATION_TYPE_INIT);
        ResponseMessage<List<StoreTradeStatistics>> responseMessage = findListByConditions(storeTradeStatistics);
        if (ResponseUtil.isFail(responseMessage)) {
            return responseMessage;
        }
        for (StoreTradeStatistics x : responseMessage.getData()) {
            x.setReconciliationType(StoreTradeStatistics.RECONCILIATION_TYPE_CONFIRMATION);
        }
        updateBatch(responseMessage.getData());
        return new ResponseMessage();
    }
}