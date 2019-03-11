package com.union.aimei.pc.financial.async;

import com.google.gson.JsonObject;
import com.union.aimei.common.constant.base.SmsConstant;
import com.union.aimei.common.feign.pc.store.StoreBeauticianFeign;
import com.union.aimei.common.feign.pc.system.SendSmsFeign;
import com.union.aimei.common.feign.pc.umeng.BasePushTemplateFeign;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.common.vo.umeng.templatecode.SystemPushCodeEnum;
import com.union.aimei.pc.financial.mapper.StoreTradeStatisticsMapper;
import com.union.aimei.pc.financial.mapper.StoreshipWithdrawalMapper;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * 店铺流水异步调度任务
 *
 * @author caizhaoming
 * @create 2018-07-18 1:43
 **/
@Component
@CommonsLog
public class StoreTradeStatisticsAsyncTask {


    @Autowired(required = false)
    private StoreTradeStatisticsMapper storeTradeStatisticsMapper;

    @Autowired(required = false)
    private StoreshipWithdrawalMapper storeshipWithdrawalMapper;

    @Resource
    private SendSmsFeign sendSmsFeign;

    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;

    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;

    /**
     * 异步更新数据 和 发送短信 推送信息
     *
     * @param idList
     */
    @Async
    public void pushMessageAndSendMessage(List<Integer> idList) {

        Date date = new Date();
        //发送短信list
        List<SmsMessageVo> sendSmsList = new ArrayList<>(10);
        //推送信息list
        List<SendMsgParamVo> sendMegList = new ArrayList<>(10);

        idList.forEach(x -> {
            StoreTradeStatistics storeTradeStatistics = this.storeTradeStatisticsMapper.selectByPrimaryKey(x);
            if (null != storeTradeStatistics) {
                //查询店铺的店长memberId
                ResponseMessage<StoreBeautician> responseMessage = this.storeBeauticianFeign.findByStoreIdForManager(storeTradeStatistics.getStoreId());
                try {
                    ResponseUtil.isFailThrowException(responseMessage);
                } catch (Exception e) {
                    log.info("异步打款查询出异常：" + e);
                }

                //更新统计表已打款
                StoreTradeStatistics updateStoreTradeStatistics = new StoreTradeStatistics();
                updateStoreTradeStatistics.setId(x);
                updateStoreTradeStatistics.setReconciliationType(StoreTradeStatistics.RECONCILIATION_TYPE_WITHDRAW);
                updateStoreTradeStatistics.setPlayStatus(StoreTradeStatistics.YES_PLAY_STATUS);
                updateStoreTradeStatistics.setPlayTime(date);
                this.storeTradeStatisticsMapper.updateByPrimaryKeySelective(updateStoreTradeStatistics);
                //更新提现表已打款
                StoreshipWithdrawal updateStoreshipWithdrawal = new StoreshipWithdrawal();
                updateStoreshipWithdrawal.setStoreId(storeTradeStatistics.getStoreId());
                updateStoreshipWithdrawal.setStatisticsYear(storeTradeStatistics.getStatisticsYear());
                updateStoreshipWithdrawal.setStatisticsYearMonth(storeTradeStatistics.getStatisticsYearMonth());
                updateStoreshipWithdrawal.setWithdrawalStatus(StoreshipWithdrawal.WITHDRAWAL_STATUS_YES);
                updateStoreshipWithdrawal.setArriveTime(date);
                this.storeshipWithdrawalMapper.updateByStoreIdAndStatisticsYearMonth(updateStoreshipWithdrawal);
                //封装推送信息数据
                Map<String, Object> customMap = new HashMap<>(2);
                customMap.put("id", x);
                customMap.put("type", SendMsgParamVo.MAKE_MONEY_STORE_TYPE);
                SendMsgParamVo sendMsgParamVo = new SendMsgParamVo();
                sendMsgParamVo.setTemplateCode(SystemPushCodeEnum.MAKEMONEY_TO_STORE.getValue());
                sendMsgParamVo.setCustoms(customMap);
                sendMsgParamVo.setMemberId(responseMessage.getData().getMemberId());
                sendMegList.add(sendMsgParamVo);
                //封装发送信息数据
                JsonObject json = new JsonObject();
                json.addProperty("month", storeTradeStatistics.getStatisticsYearMonth().split("-")[1]);
                BigDecimal refundFee = new BigDecimal((double) storeTradeStatistics.getReconciliationAmount() / 100);
                json.addProperty("account", refundFee.setScale(2, BigDecimal.ROUND_FLOOR));
                SmsMessageVo beauVo = new SmsMessageVo();
                beauVo.setPhone(storeTradeStatistics.getStorePhone());
                beauVo.setSmsCode(SmsConstant.MAKE_MONEY_TO_STORE.getSmsCode());
                beauVo.setSmsContent(json.toString());
                sendSmsList.add(beauVo);
            }
        });
        //发送短信
        this.sendSmsFeign.sendSmsCodeList(sendSmsList);
        //推送信息
        log.info("推送信息参数：" + sendMegList);
        log.debug("debug推送信息参数：" + sendMegList);
        this.basePushTemplateFeign.sendMessage(sendMegList);
    }

}
