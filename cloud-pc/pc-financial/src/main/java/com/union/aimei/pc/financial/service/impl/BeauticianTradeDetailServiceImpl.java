package com.union.aimei.pc.financial.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.base.SmsConstant;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.feign.pc.member.MemberWithdrawsFeign;
import com.union.aimei.common.feign.pc.store.StoreBeauticianFeign;
import com.union.aimei.common.feign.pc.system.SendSmsFeign;
import com.union.aimei.common.feign.pc.umeng.BasePushTemplateFeign;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.model.financial.BeauticianTradeDetailExample;
import com.union.aimei.common.model.financial.PlatformTradeDetailExample;
import com.union.aimei.common.model.financial.StoreTradeDetailExample;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.financial.BatchMoneyVo;
import com.union.aimei.common.vo.financial.WithdrawsVo;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.common.vo.umeng.templatecode.SystemPushCodeEnum;
import com.union.aimei.pc.financial.mapper.BeauticianTradeDetailMapper;
import com.union.aimei.pc.financial.mapper.PlatformTradeDetailMapper;
import com.union.aimei.pc.financial.mapper.StoreTradeDetailMapper;
import com.union.aimei.pc.financial.service.BeauticianTradeDetailService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.date.DateUtil;
import com.union.common.utils.exception.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
/**
 * @author dell
 */
@Service
public class BeauticianTradeDetailServiceImpl implements BeauticianTradeDetailService {

    @Autowired
    private MemberWithdrawsFeign memberWithdrawsFeign;

    @Autowired
    private SendSmsFeign sendSmsFeign;

    @Autowired
    private BasePushTemplateFeign basePushTemplateFeign;

    @Autowired
    private StoreBeauticianFeign storeBeauticianFeign;


    @Autowired
    private BeauticianTradeDetailMapper beauticianTradeDetailMapper;

    @Autowired
    private StoreTradeDetailMapper storeTradeDetailMapper;

    @Autowired
    private PlatformTradeDetailMapper platformTradeDetailMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.beauticianTradeDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BeauticianTradeDetail record) {
        record.setStatisticsYear(DateUtil.getCurrentYear());
        record.setStatisticsYearMonth(DateUtil.getCurrentYearMoth());
        record.setCreateTime(new Date());
        return this.beauticianTradeDetailMapper.insertSelective(record);
    }

    @Override
    public BeauticianTradeDetail selectByPrimaryKey(Integer id) {
        return this.beauticianTradeDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BeauticianTradeDetail record) {
        record.setUpdateTime(new Date());
        return this.beauticianTradeDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BeauticianTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, BeauticianTradeDetail record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(beauticianTradeDetailMapper.selectListByConditions(record));
    }

    /**
     * 分页和条件查询提现列表
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @Override
    public PageInfo<BeauticianTradeDetail> withdrawList(Integer pageNo, Integer pageSize, WithdrawsVo record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(beauticianTradeDetailMapper.withdrawList(record));
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
        BeauticianTradeDetail beauticianTradeDetail;
        for (String s : list) {
            beauticianTradeDetail = new BeauticianTradeDetail();
            beauticianTradeDetail.setId(Integer.parseInt(s));
            beauticianTradeDetail.setPlayAmountStatus((byte) 1);
            beauticianTradeDetail.setPlayAmountTime(new Date());
            beauticianTradeDetailMapper.updateByPrimaryKeySelective(beauticianTradeDetail);
        }
        return new ResponseMessage<>();
    }

    /**
     * 根据订单编号删除流水
     *
     * @param orderNo
     * @return
     */
    @Override
    public ResponseMessage<Integer> deleteTradeDetailByOrderNo(String orderNo) {

        //删除美容师表
        BeauticianTradeDetailExample beauticianTradeDetailExample = new BeauticianTradeDetailExample();
        BeauticianTradeDetailExample.Criteria criteria = beauticianTradeDetailExample.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        beauticianTradeDetailMapper.deleteByExample(beauticianTradeDetailExample);

        //删除店铺
        StoreTradeDetailExample storeTradeDetailExample = new StoreTradeDetailExample();
        StoreTradeDetailExample.Criteria storeTradeDetailExampleCriteria = storeTradeDetailExample.createCriteria();
        storeTradeDetailExampleCriteria.andOrderNoEqualTo(orderNo);
        storeTradeDetailMapper.deleteByExample(storeTradeDetailExample);

        //删除平台
        PlatformTradeDetailExample platformTradeDetailExample = new PlatformTradeDetailExample();
        PlatformTradeDetailExample.Criteria platformTradeDetailExampleCriteria = platformTradeDetailExample.createCriteria();
        platformTradeDetailExampleCriteria.andOrderNumberEqualTo(orderNo);
        platformTradeDetailMapper.deleteByExample(platformTradeDetailExample);
        return new ResponseMessage<>();
    }

    /**
     * 日订单数和日收入
     *
     * @param id
     * @return
     */
    @Override
    public ResponseMessage<Map<String, Object>> dayOrderAndAccount(Integer id) {
        List<BeauticianTradeDetail> beauticianTradeDetails = beauticianTradeDetailMapper.selectListByConditions(BeauticianTradeDetail.builder().storeId(id).build());
        Map<String, Object> result = new HashMap<>(2);

        int daySum = 0;
        if (beauticianTradeDetails.size() > 0) {
            for (BeauticianTradeDetail tradeDetail : beauticianTradeDetails) {
                if (tradeDetail.getNetIncome() != null) {
                    daySum = daySum + tradeDetail.getNetIncome();
                }

            }
            result.put("dayCount", beauticianTradeDetails.size());
            result.put("daySum", daySum);
        } else {
            result.put("dayCount", 0);
            result.put("daySum", 0);
        }

        return new ResponseMessage<>(result);
    }

    @Override
    public ResponseMessage<BeauticianTradeDetail> queryByOrderNoAndType(String orderNo, Integer type) {
        BeauticianTradeDetailExample example = new BeauticianTradeDetailExample();
        BeauticianTradeDetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        criteria.andTradeTypeEqualTo(type);
        List<BeauticianTradeDetail> list = beauticianTradeDetailMapper.selectByExample(example);
        BeauticianTradeDetail beauticianTradeDetail = null;
        ResponseMessage<BeauticianTradeDetail> res = new ResponseMessage<>();
        if (!CollectionUtils.isEmpty(list) && null != list.get(0)) {
            beauticianTradeDetail = list.get(0);
            res.setData(beauticianTradeDetail);
        } else {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.SELECT_NULL);
        }
        return res;
    }

    @Override
    public ResponseMessage<String> batchMoneyV111(List<BatchMoneyVo> batchMoneyVos) {
        StringBuilder buffer = new StringBuilder();
        List<SmsMessageVo> list = new ArrayList<>(10);
        List<SendMsgParamVo> sendMsgParamVos = new ArrayList<>(10);
        HashMap<String, Object> map;
        for (BatchMoneyVo s : batchMoneyVos) {
            //组装发送短信的对象
            list.add(SmsMessageVo
                    .builder()
                    .phone(s.getPhones())
                    .smsCode(SmsConstant.MAKE_MONEY_TO_BEAUTICIAN.getSmsCode())
                    .smsContent(s.getSmsContent())
                    .build());

            buffer.append(s.getIds()).append(",");

            //组装推送的参数
            map = new HashMap<>(1);
            //提现详情的id
            map.put("id", s.getIds());
            map.put("type", SendMsgParamVo.MAKE_MONEY_BEAUTICIAN_TYPE);

            //查询会员id
            ResponseMessage<StoreBeautician> byId = storeBeauticianFeign.findById(s.getBeauticianId());
            //组装发送友盟推送的对象
            SendMsgParamVo sendMsgParamVo = new SendMsgParamVo();
            sendMsgParamVo.setMemberId(byId.getData().getMemberId());
            sendMsgParamVo.setTemplateCode(SystemPushCodeEnum
                    .MAKEMONEY_TO_BEAUTICIAN
                    .getValue());
            sendMsgParamVo.setCustoms(map);
            sendMsgParamVos.add(sendMsgParamVo);
        }
        //美容师流水批量更新
        this.batchMoney(buffer.toString());
        //美容师提现申请更新
        this.memberWithdrawsFeign.batchMoney(buffer.toString());
        //发送短信
        sendSmsFeign.sendSmsCodeList(list);

        //推送
        basePushTemplateFeign.sendMessage(sendMsgParamVos);
        return new ResponseMessage<>();
    }
}