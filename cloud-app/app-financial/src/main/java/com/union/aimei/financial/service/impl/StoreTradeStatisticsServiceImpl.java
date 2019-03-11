package com.union.aimei.financial.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.aimei.common.vo.financial.StoreTradeDetailSumVo;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsAwaitVo;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsVo;
import com.union.aimei.common.vo.store.app.StoreByPersonageReceivingAccountResVo;
import com.union.aimei.financial.mapper.StoreTradeDetailMapper;
import com.union.aimei.financial.mapper.StoreTradeStatisticsMapper;
import com.union.aimei.financial.service.StoreTradeStatisticsService;
import com.union.aimei.financial.service.StoreshipWithdrawalService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.create.CreateTradeNo;
import com.union.common.utils.date.DateUtil;
import com.union.common.utils.exception.ServerException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
@Service
public class StoreTradeStatisticsServiceImpl implements StoreTradeStatisticsService {

    @Autowired
    private StoreFeign storeFeign;

    @Autowired
    private StoreshipWithdrawalService storeshipWithdrawalService;

    @Autowired
    private StoreTradeStatisticsMapper storeTradeStatisticsMapper;

    @Autowired
    private StoreTradeDetailMapper storeTradeDetailMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.storeTradeStatisticsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(StoreTradeStatistics record) {
        return this.storeTradeStatisticsMapper.insertSelective(record);
    }

    @Override
    public StoreTradeStatistics selectByPrimaryKey(Integer id) {
        return this.storeTradeStatisticsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StoreTradeStatistics record) {
        return this.storeTradeStatisticsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<StoreTradeStatistics> selectListByConditions(Integer pageNo, Integer pageSize, StoreTradeStatistics record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(storeTradeStatisticsMapper.selectListByConditions(record));
    }

    @Override
    public ResponseMessage<List<StoreTradeStatistics>> selectListByConditionsV110(StoreTradeStatistics record) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setData(this.storeTradeStatisticsMapper.selectListByConditions(record));
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreTradeStatisticsVo>> selectListByConditionsVoV110(Integer pageNo, Integer pageSize, StoreTradeStatistics record) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreTradeStatistics> list = this.storeTradeStatisticsMapper.selectListByConditions(record);
        List<StoreTradeStatisticsVo> storeTradeStatisticsVoList = new ArrayList<>(10);
        list.forEach(x -> {
            StoreTradeStatisticsVo storeTradeStatisticsVo = new StoreTradeStatisticsVo();
            String[] statisticsYearMonthArray = x.getStatisticsYearMonth().split("-");
            storeTradeStatisticsVo.setMonthAndYearStr(Integer.parseInt(statisticsYearMonthArray[1]) == DateUtil.getCurrentMonth() ? "本月" : statisticsYearMonthArray[1] + "/" + statisticsYearMonthArray[0]);
            storeTradeStatisticsVo.setDateInterregionalStart(DateUtil.getFirstDayOfMonth(Integer.parseInt(statisticsYearMonthArray[0]), Integer.parseInt(statisticsYearMonthArray[1])));
            storeTradeStatisticsVo.setDateInterregionalEnd(DateUtil.getLastDayOfMonth(Integer.parseInt(statisticsYearMonthArray[0]), Integer.parseInt(statisticsYearMonthArray[1])));
            BeanUtils.copyProperties(x, storeTradeStatisticsVo);
            storeTradeStatisticsVoList.add(storeTradeStatisticsVo);
        });
        return new ResponseMessage<>(new PageInfo<>(storeTradeStatisticsVoList));
    }

    @Override
    public ResponseMessage<StoreTradeStatisticsAwaitVo> selectBySettlementAndStoreIdV110(Integer storeId) {
        StoreTradeStatisticsAwaitVo storeTradeStatisticsAwaitVo = new StoreTradeStatisticsAwaitVo();
        StoreTradeDetailSumVo storeTradeDetailSumVo = new StoreTradeDetailSumVo();

        String[] currentYearMonth = DateUtil.getCurrentYearMothDay().split("-");
        String dateInterregionalStart = DateUtil.getFirstDayOfMonth(Integer.parseInt(currentYearMonth[0]), Integer.parseInt(currentYearMonth[1]));
        String dateInterregionalEnd = DateUtil.getCurrentYearMothDay();
        String dateInterregionalStartForMat = dateInterregionalStart.replaceAll("-", ".");
        String dataInterregionalEndForMat = dateInterregionalEnd.split("-")[1] + "." + dateInterregionalEnd.split("-")[2];

        storeTradeDetailSumVo.setStoreId(storeId);
        storeTradeDetailSumVo.setStartTime(dateInterregionalStart + " 00:00:00");
        storeTradeDetailSumVo.setEndTime(DateUtil.getCurrentYearMothDayHms());
        Integer netAmount = this.storeTradeDetailMapper.sumBySettlementAndStoreId(storeTradeDetailSumVo);
        //封装数据
        storeTradeStatisticsAwaitVo.setMonthAndYearStr("本月");
        storeTradeStatisticsAwaitVo.setStatisticsYear(currentYearMonth[0]);
        //获取下个月18号日期
        String[] perMonth = DateUtil.getPerFirstMonth().split("-");
        storeTradeStatisticsAwaitVo.setSettlementDate(perMonth[0] + "." + perMonth[1] + ".18");

        storeTradeStatisticsAwaitVo.setDateInterregionalStart(dateInterregionalStart.replaceAll("-", "."));
        storeTradeStatisticsAwaitVo.setDateInterregionalEnd(dateInterregionalEnd.replaceAll("-", "."));
        storeTradeStatisticsAwaitVo.setBillDate(dateInterregionalStartForMat + "-" + dataInterregionalEndForMat);

        storeTradeStatisticsAwaitVo.setReconciliationAmount(netAmount);
        storeTradeStatisticsAwaitVo.setReconciliationType(0);
        storeTradeStatisticsAwaitVo.setStatisticsYearMonth(DateUtil.getCurrentYearMoth());
        storeTradeStatisticsAwaitVo.setStoreId(storeId);
        return new ResponseMessage<>(storeTradeStatisticsAwaitVo);
    }

    @Override
    public ResponseMessage checkForConfirmationV110(Integer id) {
        ResponseMessage responseMessage = new ResponseMessage();
        //获取统计数据
        StoreTradeStatistics storeTradeStatistics = this.selectByPrimaryKey(id);
        if (null != storeTradeStatistics) {
            //判断是否可以进行对账确认操作
            if (StoreTradeStatistics.RECONCILIATION_TYPE_CONFIRMATION == storeTradeStatistics.getReconciliationType()) {

                //获取店铺银行账户数据
                ResponseMessage<StoreByPersonageReceivingAccountResVo> responseMessage1 = this.storeFeign.findPersonageReceivingAccountByStoreIdV111(storeTradeStatistics.getStoreId());
                if (ResponseUtil.isFail(responseMessage1)) {
                    return responseMessage1;
                }
                StoreByPersonageReceivingAccountResVo storeByPersonageReceivingAccountResVo = responseMessage1.getData();
                //校验有没有设置用户账号
                if (StringUtil.isEmpty(storeByPersonageReceivingAccountResVo.getPraBank()) || StringUtil.isEmpty(storeByPersonageReceivingAccountResVo.getPraBankBranch()) ||
                        StringUtil.isEmpty(storeByPersonageReceivingAccountResVo.getPraAccountName()) || StringUtil.isEmpty(storeByPersonageReceivingAccountResVo.getPraBankCardNumber())
                        || StringUtil.isEmpty(storeByPersonageReceivingAccountResVo.getPraArea())) {
                    throw new ServerException(FinancialConstant.ERROR_CODE, FinancialConstant.Update.BIND_THE_ACCOUNT_OPENING_BANK_FIRST);
                }

                //统计店铺余额
                StoreTradeStatistics selectStoreTradeStatistics = new StoreTradeStatistics();
                selectStoreTradeStatistics.setStoreId(storeTradeStatistics.getStoreId());
                selectStoreTradeStatistics.setPlayStatus(StoreTradeStatistics.YES_PLAY_STATUS);
                selectStoreTradeStatistics.setReconciliationType(StoreTradeStatistics.RECONCILIATION_TYPE_WITHDRAW);
                ResponseMessage<List<StoreTradeStatistics>> responseMessage2 = this.selectListByConditionsV110(selectStoreTradeStatistics);
                if (ResponseUtil.isFail(responseMessage2)) {
                    return responseMessage2;
                }
                Integer remainingAmount = Math.toIntExact(responseMessage2.getData().stream().mapToInt(StoreTradeStatistics::getReconciliationAmount).summaryStatistics().getSum());

                //保存数据到提现表
                StoreshipWithdrawal storeshipWithdrawal = new StoreshipWithdrawal();
                try {
                    storeshipWithdrawal.setNumberBankSlip(new CreateTradeNo(1).createTradeNo());
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new ServerException(FinancialConstant.ERROR_CODE, FinancialConstant.Update.LINE_NUMBER_INITIALIZATION_EXCEPTION);
                }
                storeshipWithdrawal.setStoreId(storeTradeStatistics.getStoreId());
                storeshipWithdrawal.setWithdrawalAmount(storeTradeStatistics.getReconciliationAmount());
                storeshipWithdrawal.setBank(storeByPersonageReceivingAccountResVo.getPraBank() + storeByPersonageReceivingAccountResVo.getPraBankBranch());
                storeshipWithdrawal.setUserName(storeByPersonageReceivingAccountResVo.getPraAccountName());
                storeshipWithdrawal.setAccountNumber(storeByPersonageReceivingAccountResVo.getPraBankCardNumber());
                storeshipWithdrawal.setWithdrawalStatus(StoreshipWithdrawal.WITHDRAWAL_STATUS_NO);
                storeshipWithdrawal.setRemainingAmount(remainingAmount);
                storeshipWithdrawal.setStatisticsYear(storeTradeStatistics.getStatisticsYear());
                storeshipWithdrawal.setStatisticsYearMonth(storeTradeStatistics.getStatisticsYearMonth());
                storeshipWithdrawal.setArriveTime(null);
                storeshipWithdrawal.setCreateTime(new Date());
                this.storeshipWithdrawalService.insertSelective(storeshipWithdrawal);

                //更新数据到店铺流水统计表
                StoreTradeStatistics updateStoreTradeStatistics = new StoreTradeStatistics();
                updateStoreTradeStatistics.setId(storeTradeStatistics.getId());
                updateStoreTradeStatistics.setReconciliationType(StoreTradeStatistics.RECONCILIATION_TYPE_WITHDRAWAL);
                this.updateByPrimaryKeySelective(updateStoreTradeStatistics);
            } else {
                throw new ServerException(FinancialConstant.ERROR_CODE, FinancialConstant.Update.UNABLE_TO_CONFIRM_RECONCILIATION);
            }
        } else {
            throw new ServerException(FinancialConstant.ERROR_CODE, FinancialConstant.Update.ID_ERROR);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreshipWithdrawal> selectStoreshipWithdrawalByStoreTradeIdV110(Integer id) {
        ResponseMessage responseMessage = new ResponseMessage();
        StoreTradeStatistics storeTradeStatistics = this.selectByPrimaryKey(id);
        if (null != storeTradeStatistics) {
            StoreshipWithdrawal storeshipWithdrawal = new StoreshipWithdrawal();
            storeshipWithdrawal.setStoreId(storeTradeStatistics.getStoreId());
            storeshipWithdrawal.setStatisticsYear(storeTradeStatistics.getStatisticsYear());
            storeshipWithdrawal.setStatisticsYearMonth(storeTradeStatistics.getStatisticsYearMonth());
            ResponseMessage<List<StoreshipWithdrawal>> responseMessage1 = this.storeshipWithdrawalService.selectListByConditionsV110(storeshipWithdrawal);
            ResponseUtil.isFailThrowException(responseMessage1);
            StoreshipWithdrawal withdrawalStatus = responseMessage1.getData().get(0);
            if (withdrawalStatus.getWithdrawalStatus() == StoreshipWithdrawal.WITHDRAWAL_STATUS_NO) {
                //判断申请时间是否为18号之前 ，是则 预计时间为单前时间  不是则为下个月18
                String createTimeStr = DateUtil.dateToString(withdrawalStatus.getCreateTime(), "yyyy-MM-dd");
                int i = 18;
                int i1 = 2;
                if (Integer.parseInt(String.valueOf(createTimeStr.substring(createTimeStr.length() - i1, createTimeStr.length()))) <= i) {
                    withdrawalStatus.setArriveTime(monthFirstDate(withdrawalStatus.getCreateTime()));
                } else {
                    withdrawalStatus.setArriveTime(nextMonthFirstDate(withdrawalStatus.getCreateTime()));
                }
            }
            responseMessage.setData(withdrawalStatus);
        }
        return responseMessage;
    }

    public static Date nextMonthFirstDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, 17);
        return calendar.getTime();
    }

    public static Date monthFirstDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 0);
        calendar.add(Calendar.DATE, 17);
        return calendar.getTime();
    }


}